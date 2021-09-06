 package com.example.census;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CensusDataEntry extends AppCompatActivity {
    CensusDatabase censusDatabase;
    Button btn_save_family_details;
    TextInputEditText family_name, num_of_people, num_of_people_reached_sec;
    Spinner survey_topics;
    String[] surveyTopics = {};
    String[] newCo = {"Please return previous to add the survey topic"};
    ArrayList<String> survey;
    String selected_survey;
    String dateTime;
    Integer code = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_census_data_entry);
        censusDatabase = new CensusDatabase(CensusDataEntry.this);
        survey = new ArrayList<String>();
        btn_save_family_details = (Button) findViewById(R.id.btn_save_family_details);
        family_name = (TextInputEditText) findViewById(R.id.family_name);
        num_of_people = (TextInputEditText) findViewById(R.id.num_of_people);
        num_of_people_reached_sec = (TextInputEditText) findViewById(R.id.num_of_people_reached_sec);
        survey_topics = (Spinner) findViewById(R.id.survey_topics);
        surveyData();
        dateTimeConfiguration();

        btn_save_family_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFamilyData();
            }
        });
    }

    public void dateTimeConfiguration(){
        //        setup time to create and a created_at tool for easy identifying the time data was collected
        String day =  DateFormat.getDateInstance().format(new Date());
        String time = DateFormat.getTimeInstance().format(new Date());
        dateTime = day +" | "+time;
        String[] ddd = day.split(" ");
    }

    public void surveyData(){

        ArrayAdapter<String> adapter;
        Cursor cursor = censusDatabase.getSurveyTopics();
        if (cursor.getCount() == 0){
            Toast.makeText(getApplicationContext(), "No data in", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                survey.add(cursor.getString(1));
            }
            surveyTopics = new String[survey.size()];
            for (int x = 0; x < survey.size(); x++){
                surveyTopics[x] = survey.get(x).toString();
            }
        }

        if (surveyTopics.length > 0){
            adapter = new ArrayAdapter<String>(CensusDataEntry.this, android.R.layout.simple_spinner_item, surveyTopics);

        }else {
           adapter = new ArrayAdapter<String>(CensusDataEntry.this, android.R.layout.simple_spinner_item, newCo);
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        survey_topics.setAdapter(adapter);
        survey_topics.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (surveyTopics.length > 0){
                    selected_survey = surveyTopics[position];
                }else {
                    selected_survey = newCo[position];
                }
                code = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void saveFamilyData(){
        String family = family_name.getText().toString();
        String numberOfPeople = num_of_people.getText().toString();
        String numberReachedSec = num_of_people_reached_sec.getText().toString();

        if (family.isEmpty() && numberOfPeople.isEmpty() && numberReachedSec.isEmpty()){
            Toast.makeText(getApplicationContext(), "Please, fill all fields", Toast.LENGTH_LONG).show();

        }else {
            censusDatabase.addCollectedData(code,family,Integer.parseInt(numberOfPeople),Integer.parseInt(numberReachedSec),dateTime);
            Toast.makeText(getApplicationContext(), "Data collected successfully", Toast.LENGTH_LONG).show();
            clear(family_name, num_of_people, num_of_people_reached_sec);
        }
    }

    public void clear(TextInputEditText field, TextInputEditText field2, TextInputEditText field3){
        field.setText("");
        field2.setText("");
        field3.setText("");
    }
}