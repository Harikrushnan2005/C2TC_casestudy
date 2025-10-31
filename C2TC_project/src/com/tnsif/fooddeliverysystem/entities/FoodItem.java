package com.tnsif.fooddeliverysystem.entities;

import java.util.Objects;

public class FoodItem {
    private int id;
    private String name;
    private double price;

    public FoodItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return String.format("FoodItem{id=%d, name='%s', price=%.2f}", id, name, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FoodItem)) return false;
        FoodItem fi = (FoodItem) o;
        return id == fi.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
