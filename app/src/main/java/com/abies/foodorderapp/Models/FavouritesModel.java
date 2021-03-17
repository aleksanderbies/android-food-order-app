package com.abies.foodorderapp.Models;

public class FavouritesModel {

    int favImage;
    String favFoodName, priceFav;

    public FavouritesModel(){}

    public FavouritesModel(int orderImage, String favFoodName, String priceFav) {
        this.favImage = orderImage;
        this.favFoodName = favFoodName;
        this.priceFav = priceFav;
    }

    public int getFavImage() {
        return favImage;
    }

    public void setFavImage(int favImage) {
        this.favImage = favImage;
    }

    public String getFavFoodName() {
        return favFoodName;
    }

    public void setFavFoodName(String foodName) {
        this.favFoodName= foodName;
    }

    public String getPriceFav() {
        return priceFav;
    }

    public void setPriceFav(String price) {
        this.priceFav = price;
    }

}
