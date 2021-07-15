package com.example.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class MainActivity extends AppCompatActivity {
    ExtendedFloatingActionButton createSurvey, surveys;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createSurvey = (ExtendedFloatingActionButton) findViewById(R.id.create);
        surveys = (ExtendedFloatingActionButton) findViewById(R.id.surveys);
        createSurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent create = new Intent(MainActivity.this, AddCensus.class);
                startActivity(create);
            }
        });

        surveys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent surveyIntent = new Intent(MainActivity.this, CensusDisplay.class);
                startActivity(surveyIntent);
            }
        });
    }
}