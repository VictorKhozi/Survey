package com.example.survey;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DateFormat;
import java.util.Date;

public class AddCensus extends AppCompatActivity {

    CensusDatabase censusDatabase;
    private TextInputEditText survey_title, survey_location;
    private Button btn_create_survey;
    private TextView tv_date_set;
    private Integer code = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_census);
        censusDatabase = new CensusDatabase(AddCensus.this);
        survey_title = findViewById(R.id.survey_title);
        survey_location = findViewById(R.id.survey_location);
//        tv_date_set = (TextView) findViewById(R.id.btn_set_start_date);
        btn_create_survey = (Button) findViewById(R.id.btn_create_survey);

        btn_create_survey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = survey_title.getText().toString();
                String location = survey_location.getText().toString();
                Toast.makeText(getApplicationContext(),name+"\n"+location, Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void data(){
        Cursor cursor = censusDatabase.getSurveyData();
        if (cursor.getCount() == 0){

        }else {
            while (cursor.moveToNext()){

                Toast.makeText(getApplicationContext(), cursor.getString(0).toString()+"\n"+cursor.getString(1).toString()+"\n"+cursor.getString(2).toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}