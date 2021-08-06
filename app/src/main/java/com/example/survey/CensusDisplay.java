package com.example.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Currency;

public class CensusDisplay extends AppCompatActivity {
    SurveyData surveyData;
    ListView survey;
    CensusDatabase censusDatabase;
    ArrayList<SurveyData> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_census_display);
        survey = (ListView) findViewById(R.id.survey_list);
//        viewData();

    }
    public void viewData(){

        try (Cursor cursor = censusDatabase.getCensusData()) {
            data = new ArrayList<SurveyData>();

            if (cursor.getCount() == 0) {


            } else {
                while (cursor.moveToNext()) {
                    surveyData = new SurveyData(cursor.getString(1).toString(),
                            cursor.getInt(2), cursor.getInt(3));
                    data.add(surveyData);
                }
            }
        }
        SurveyListAdapter adapter = new SurveyListAdapter(CensusDisplay.this, R.layout.survey_list_layout, data);
        survey.setAdapter(adapter);
    }
}