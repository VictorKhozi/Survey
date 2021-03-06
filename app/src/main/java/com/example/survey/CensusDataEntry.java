package com.example.survey;

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
    ArrayList<String> survey;
    String selected_survey;
    String dateTime;
    Integer code;
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

        Cursor cursor = censusDatabase.getSurveyTopics();
        if (cursor.getCount() == 0){

        }else {
            while (cursor.moveToNext()){
                survey.add(cursor.getString(0).toString()+"|"+cursor.getString(1).toString());
            }
        }
        for (int x = 0; x < survey.size(); x++){
            surveyTopics[x] = survey.get(x).split("|")[1];
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(CensusDataEntry.this, android.R.layout.simple_spinner_item, surveyTopics);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        survey_topics.setAdapter(adapter);
        survey_topics.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected_survey = surveyTopics[position];
                code = position;
                Toast.makeText(getApplicationContext(), selected_survey, Toast.LENGTH_LONG).show();
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

        }else {
            censusDatabase.addCollectedData(code,family,numberOfPeople,numberReachedSec,dateTime);
            Toast.makeText(getApplicationContext(), "Data collected successfully", Toast.LENGTH_LONG).show();
        }
    }
}