package com.abies.foodorderapp.Models;

public class BasketModel {
    int basketFoodImage, id;
    String basketFoodName, basketPrice, basketQuantity;

    public BasketModel(){ }

    public BasketModel(int basketFoodImage, String basketFoodName, String basketPrice, String basketQuantity, int id) {
        this.basketFoodImage = basketFoodImage;
        this.basketFoodName = basketFoodName;
        this.basketPrice = basketPrice;
        this.basketQuantity = basketQuantity;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
