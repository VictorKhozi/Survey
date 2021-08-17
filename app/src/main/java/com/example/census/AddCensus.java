package com.example.census;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddCensus extends AppCompatActivity {

    CensusDatabase censusDatabase;
    private Button btn_create_survey, btn_set_start_date, btn_conduct_survey;
    private TextInputEditText survey_title, survey_location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_census);
        censusDatabase = new CensusDatabase(AddCensus.this);
//        survey_location = findViewById(R.id.survey_location);
        survey_title = (TextInputEditText) findViewById(R.id.survey_title);
        survey_location = (TextInputEditText) findViewById(R.id.survey_location);
        btn_create_survey = (Button) findViewById(R.id.btn_create_survey);
        btn_set_start_date = (Button) findViewById(R.id.btn_set_start_date);
        btn_conduct_survey = (Button) findViewById(R.id.btn_conduct_survey);

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        //get date created
        btn_set_start_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(AddCensus.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String datee = "Created on : "+dayOfMonth+"-"+month+"-"+year;
                        btn_set_start_date.setText(datee);
                    }
                },year, month, day);
                datePickerDialog.show();
            }
        });

        //create survey
        btn_create_survey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String topic = survey_title.getText().toString();
                String location = survey_location.getText().toString();
                createSurvey(topic, location, btn_set_start_date.getText().toString());
            }
        });

        btn_conduct_survey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent(AddCensus.this, CensusDataEntry.class);
                startActivity(data);
            }
        });

    }

    public void createSurvey(String name, String location, String date_created){

        if (name.isEmpty() && location.isEmpty()){
            Toast.makeText(getApplicationContext(),"Fill all fields", Toast.LENGTH_LONG).show();
        }else {
            censusDatabase.addSurvey(name,date_created,location);
            Toast.makeText(getApplicationContext(),"Created successfully", Toast.LENGTH_LONG).show();
            clear(survey_title, survey_location);
        }
    }

    public void clear(TextInputEditText field, TextInputEditText field2){
        field.setText("");
        field2.setText("");
    }
}