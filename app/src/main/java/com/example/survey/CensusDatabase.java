package com.example.survey;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CensusDatabase extends SQLiteOpenHelper {

    public static final String DBName = "census_db";
    public static final String SurveyTableName = "survey_table";
    public static final String CensusTableName = "census_table";

    public CensusDatabase(@Nullable Context context) {
        super(context, DBName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table "+ SurveyTableName +"(code text primary key not null, name text,start_date text,end_date text,location text)"
        );

        db.execSQL(
                "create table "+ CensusTableName +"(id integer primary key autoincrement not null, survey_code text not null, family_name text,num_of_people text,num_reached_sec text,date_collected text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+SurveyTableName);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS "+CensusTableName);
        onCreate(db);
    }

    public boolean addSurvey(String code, String name, String startDate, String location){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("code", code); //s0001,s0002
        contentValues.put("name", name);
        contentValues.put("start_date", startDate);
        contentValues.put("location", location);
        database.insert(SurveyTableName, null, contentValues);
        return true;
    }

    public boolean addCollectedData(String survey_code, String family_name, String num_of_people, String num_reached_sec, String date_collected){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("survey_code", survey_code);
        contentValues.put("family_name", family_name);
        contentValues.put("num_of_people", num_of_people);
        contentValues.put("num_reached_sec", num_reached_sec);
        contentValues.put("date_collected", date_collected); //auto generated
        database.insert(CensusTableName, null, contentValues);
        return true;
    }

    public Cursor getSurveyData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor response = db.rawQuery("select * from "+SurveyTableName, null);
        return response;
    }

    public Cursor getCensusData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor response = db.rawQuery("select * from "+CensusTableName, null);
        return response;
    }
}
