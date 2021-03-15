package com.abies.foodorderapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    final static String DBNAME = "database.db";
    final static int DBVERSION = 2;

    public DataBaseHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table favourites " +
                        "(id integer primary key autoincrement," +
                        "price double," +
                        "image int," +
                        "description text," +
                        "foodname text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP table if exists favourites");
        onCreate(db);
    }

    public boolean insertFavourite(double price, int image, String desc, String foodName){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", price);
        values.put("image", image);
        values.put("price", price);
        values.put("description", desc);
        values.put("foodname", foodName);
        long id = database.insert("favourites", null, values);

        if(id <= 0) {
            return false;
        }
        else return true;
    }
}
