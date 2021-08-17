package com.example.census;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class Analysis extends AppCompatActivity {

    LineGraphSeries<DataPoint> lineGraphSeries;
    GraphView graph_analysis;
    CensusDatabase censusDatabase;
    DataPoint dataPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);
        censusDatabase = new CensusDatabase(Analysis.this);
        graph_analysis = (GraphView) findViewById(R.id.graph_analysis);
        plottingGraph();
    }

    public void plottingGraph(){

        Cursor data = censusDatabase.getCensusData();
        if (data.getCount() == 0){
            Toast.makeText(getApplicationContext(), "No data available", Toast.LENGTH_SHORT).show();
        }else {
            while (data.moveToNext()){
//                data = new DataPoint(data.getInt(3), data.getInt(4));
            }

                lineGraphSeries = new LineGraphSeries<DataPoint>(new DataPoint[] {

                        new DataPoint(1, 4),
                        new DataPoint(2, 5),
                        new DataPoint(3, 4),
                        new DataPoint(4, 15),
                        new DataPoint(5, 7),
                        new DataPoint(6, 5),
                        new DataPoint(7, 4),
                        new DataPoint(8, 5),


                });

            graph_analysis.addSeries(lineGraphSeries);


        }


    }
}