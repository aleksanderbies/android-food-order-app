package com.abies.foodorderapp.Models;

public class BasketModel {
    int basketFoodImage;
    String basketFoodName, basketPrice, basketQuantity;

    public BasketModel(int basketFoodImage, String basketFoodName, String basketPrice, String basketQuantity) {
        this.basketFoodImage = basketFoodImage;
        this.basketFoodName = basketFoodName;
        this.basketPrice = basketPrice;
        this.basketQuantity = basketQuantity;
    }

    public int getBasketFoodImage() {
        return basketFoodImage;
    }

    public void setBasketFoodImage(int basketFoodImage) {
        this.basketFoodImage = basketFoodImage;
    }

    public String getBasketFoodName() {
        return basketFoodName;
    }

    public void setBasketFoodName(String basketFoodName) {
        this.basketFoodName = basketFoodName;
    }

    public String getBasketPrice() {
        return basketPrice;
    }

    public void setBasketPrice(String basketPrice) {
        this.basketPrice = basketPrice;
    }

    public String getBasketQuantity() {
        return basketQuantity;
    }

    public void setBasketQuantity(String basketQuantity) {
        this.basketQuantity = basketQuantity;
    }
}
