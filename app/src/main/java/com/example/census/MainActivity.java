package com.example.census;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    ExtendedFloatingActionButton create, viewSurveys, conduct_surveys, analysis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        create = findViewById(R.id.create);
        viewSurveys = findViewById(R.id.surveys);
        conduct_surveys = findViewById(R.id.conduct_surveys);
        analysis = findViewById(R.id.analysis);



        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addCensus = new Intent(MainActivity.this, AddCensus.class);
                startActivity(addCensus);
            }
        });

        viewSurveys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view = new Intent(MainActivity.this, CensusDisplay.class);
                startActivity(view);
            }
        });

        conduct_surveys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent(MainActivity.this, CensusDataEntry.class);
                startActivity(data);
            }
        });

        analysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent analysis = new Intent(MainActivity.this, Analysis.class);
                startActivity(analysis);
            }
        });
    }
}