package com.example.census;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SurveyListAdapter extends ArrayAdapter<SurveyData> {
    Context sContext;
    int sResource;
    public SurveyListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<SurveyData> objects) {
        super(context, resource, objects);
        sContext = context;
        sResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).familyNAme;
        Integer numOfPeople = getItem(position).numberInFamily;
        Integer numberReachedSec = getItem(position).numberReachedSec;
        SurveyData surveyData = new SurveyData(name, numOfPeople, numberReachedSec);

        LayoutInflater inflater = LayoutInflater.from(sContext);
        convertView = inflater.inflate(sResource, parent, false);

        TextView family = (TextView) convertView.findViewById(R.id.name_of_family);
        TextView numberIn = (TextView) convertView.findViewById(R.id.number_in_family);
        TextView number_reached_sec = (TextView) convertView.findViewById(R.id.number_reached_sec);

        family.setText(name.toString());
        numberIn.setText(numOfPeople.toString());
        number_reached_sec.setText(numberReachedSec.toString());
        return convertView;
    }
}
