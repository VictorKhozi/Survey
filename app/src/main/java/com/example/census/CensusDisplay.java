package com.example.census;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_census_display);
        survey = (ListView) findViewById(R.id.survey_list);
        censusDatabase = new CensusDatabase(CensusDisplay.this);
        Cursor cursor = censusDatabase.getCensusData();
        ArrayList<SurveyData> data = new ArrayList<SurveyData>();

        if (cursor.getCount() != 0){

            while (cursor.moveToNext()){
                surveyData = new SurveyData(cursor.getString(2).toString(),
                        cursor.getInt(3), cursor.getInt(4));
                data.add(surveyData);
            }
        }else {

        }
        SurveyListAdapter adapter = new SurveyListAdapter(CensusDisplay.this, R.layout.survey_list_layout, data);
        survey.setAdapter(adapter);
    }

}
