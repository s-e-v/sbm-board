package com.sev;

public class Order {
    private int userId;
    private int quantity;
    private double price;
    private String type;

    public Order(int id, int qty, double price, String type) {
        this.userId = id;
        this.quantity = qty;
        this.price = price;
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
