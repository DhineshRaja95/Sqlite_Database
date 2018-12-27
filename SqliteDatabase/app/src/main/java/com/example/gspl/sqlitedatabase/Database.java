package com.example.gspl.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    SQLiteDatabase sqLiteDatabase;


    public Database(Context context) {
        super(context, "Student", null, 1);
        sqLiteDatabase = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table details(name text,location text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long saves(String s1, String s2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", s1);
        contentValues.put("location", s2);
        long k = sqLiteDatabase.insert("details", null, contentValues);
        return k;

    }

    public String gett(String s3) {
        Cursor cursor;
        cursor = sqLiteDatabase.query("details", null, "name=?", new String[]{s3}, null, null, null);

        if (cursor.getCount() < 1) {
            return "User Name Invalid";
        }

        cursor.moveToFirst();
        String obj = cursor.getString(cursor.getColumnIndex("location"));
        return obj;
    }

    public boolean updateit(String s1,String s2){
        ContentValues contentValues=new ContentValues();
        contentValues.put("location",s2);
        sqLiteDatabase.update("details",contentValues,"name=?",new String[]{s1});
        return true;


    }

    public Integer deleteData (String s1) {

        return sqLiteDatabase.delete("details","name=?",new String[]{s1});
    }

}

