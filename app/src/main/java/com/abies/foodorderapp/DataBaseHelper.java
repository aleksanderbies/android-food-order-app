package com.abies.foodorderapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.abies.foodorderapp.Models.FavouritesModel;

import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {

    final static String DBNAME = "database.db";
    final static int DBVERSION = 5;

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

    public ArrayList<FavouritesModel> getFavourites(){
        ArrayList<FavouritesModel> favouritesFood = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select foodname, price, image from favourites;", null);
        if(cursor.moveToFirst()){
            while (cursor.moveToNext()){
                FavouritesModel model = new FavouritesModel();
                model.setFavFoodName(cursor.getString(0));
                model.setPriceFav(cursor.getString(1));
                model.setFavImage(cursor.getInt(2));
                favouritesFood.add(model);
            }
        }
        cursor.close();
        database.close();
        return favouritesFood;
    }

    public Cursor getFavByName(String name){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select foodname, price, image from favourites where foodname=?", new String[] {name});
        if(cursor!=null){
            cursor.moveToFirst();
        }
        return cursor;
    }

    public Cursor ifExists(String name){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select foodname from favourites where foodname=?", new String[] {name});
        if(cursor!=null){
            cursor.moveToFirst();
        }
        return cursor;
    }
}
