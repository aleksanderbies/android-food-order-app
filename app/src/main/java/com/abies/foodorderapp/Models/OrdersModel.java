package com.abies.foodorderapp.Models;

public class OrdersModel {

    int orderImage;
    String foodOrderName, price, orderNumber;

    public OrdersModel(int orderImage, String foodOrderName, String price, String orderNumber) {
        this.orderImage = orderImage;
        this.foodOrderName = foodOrderName;
        this.price = price;
        this.orderNumber = orderNumber;
    }

    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public String getFoodOrderName() {
        return foodOrderName;
    }

    public void setFoodOrderName(String foodOrderName) {
        this.foodOrderName = foodOrderName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
