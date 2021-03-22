package com.abies.foodorderapp.Models;

public class FavouritesModel {

    int favImage;
    String favFoodName, priceFav, descriptionFav;

    public FavouritesModel(){}

    public FavouritesModel(int orderImage, String favFoodName, String priceFav, String descriptionFav) {
        this.favImage = orderImage;
        this.favFoodName = favFoodName;
        this.priceFav = priceFav;
        this.descriptionFav = descriptionFav ;
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

    public String getDescriptionFav() {
        return descriptionFav;
    }

    public void setDescriptionFav(String descriptionFav) {
        this.descriptionFav = descriptionFav;
    }

}
