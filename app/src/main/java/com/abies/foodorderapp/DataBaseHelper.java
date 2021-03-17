package com.abies.foodorderapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    final static String DBNAME = "database.db";
    final static int DBVERSION = 4;

    public DataBaseHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table favourites " +
                        "(foodname text primary key," +
                        "price text," +
                        "image int);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP table if exists favourites;");
        onCreate(db);
    }

    public boolean insertFavourite(String foodName, String price, int image){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("foodname", foodName);
        values.put("image", image);
        values.put("price", price);
        long id = database.insert("favourites", null, values);
        if(id <= 0) {
            return false;
        }
        else return true;
    }
}
