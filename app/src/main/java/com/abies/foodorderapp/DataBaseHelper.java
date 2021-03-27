package com.abies.foodorderapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.abies.foodorderapp.Models.BasketModel;
import com.abies.foodorderapp.Models.FavouritesModel;

import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {

    final static String DBNAME = "database.db";
    final static int DBVERSION = 7;

    public DataBaseHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table favourites " +
                        "(foodname text primary key," +
                        "price text," +
                        "description text," +
                        "image int);"

        );
        db.execSQL(
                "create table basket " +
                        "(id integer primary key autoincrement," +
                        "foodname text," +
                        "price text," +
                        "quantity text," +
                        "image int);"

        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP table if exists favourites;");
        db.execSQL("DROP table if exists basket;");
        onCreate(db);
    }

    public boolean insertFavourite(String foodName, String price, int image, String description){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("foodname", foodName);
        values.put("image", image);
        values.put("price", price);
        values.put("description", description);
        long id = database.insert("favourites", null, values);
        if(id <= 0) {
            return false;
        }
        else return true;
    }

    public boolean insertToBasket(String foodName, String price, int image, String quantity){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("foodname", foodName);
        values.put("image", image);
        values.put("price", price);
        values.put("quantity", quantity);
        long id = database.insert("basket", null, values);
        if(id <= 0) {
            return false;
        }
        else return true;
    }

    public ArrayList<FavouritesModel> getFavourites(){
        ArrayList<FavouritesModel> favouritesFood = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select foodname, price, image, description from favourites;", null);
        if(cursor!=null){
            while (cursor.moveToNext()){
                FavouritesModel model = new FavouritesModel();
                model.setFavFoodName(cursor.getString(0));
                model.setPriceFav(cursor.getString(1));
                model.setFavImage(cursor.getInt(2));
                model.setDescriptionFav(cursor.getString(3));
                favouritesFood.add(model);
            }
        }
        cursor.close();
        database.close();
        return favouritesFood;
    }

    public ArrayList<BasketModel> getProductsFromBasket(){
        ArrayList<BasketModel> insideBasket = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select foodname, price, image, quantity from basket;", null);
        if(cursor!=null){
            while (cursor.moveToNext()){
                BasketModel model = new BasketModel();
                model.setBasketFoodImage(cursor.getInt(2));
                model.setBasketFoodName(cursor.getString(0));
                model.setBasketPrice(cursor.getString(1));
                model.setBasketQuantity(cursor.getString(3));
                insideBasket.add(model);
            }
        }
        cursor.close();
        database.close();
        return insideBasket;
    }

    public Cursor getFavByName(String name){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select foodname, price, image, description from favourites where foodname=?", new String[] {name});
        if(cursor!=null){
            cursor.moveToFirst();
        }
        return cursor;
    }

    public boolean inDB(String name){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select foodname, price, image, description from favourites where foodname=?", new String[] {name});
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        else {
            cursor.close();
            return true;
        }
    }

    public int deleteFav(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("favourites", "foodname=?", new String[] {name});
    }
}
