package com.example.survey;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.Time;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public class CensusDataEntry extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_census_data_entry);

    }

    public void dateTimeConfiguration(){
        //        setup time to create and a created_at tool for easy identifying the time data was collected
        String day =  DateFormat.getDateInstance().format(new Date());
        String time = DateFormat.getTimeInstance().format(new Date());
        String dateTime = day +" | "+time;
        Toast.makeText(getApplicationContext(), dateTime.toString(),Toast.LENGTH_LONG).show();

    }

    
}