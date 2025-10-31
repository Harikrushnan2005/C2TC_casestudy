package com.tnsif.fooddeliverysystem.entities;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private int id;
    private String name;
    private List<FoodItem> menu;

    public Restaurant(int id, String name) {
        this.id = id;
        this.name = name;
        this.menu = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public List<FoodItem> getMenu() { return menu; }

    public boolean addFoodItem(FoodItem fi) {
        if (getFoodItemById(fi.getId()) != null) return false;
        menu.add(fi);
        return true;
    }

    public boolean removeFoodItem(int foodItemId) {
        FoodItem fi = getFoodItemById(foodItemId);
        if (fi == null) return false;
        menu.remove(fi);
        return true;
    }

    public FoodItem getFoodItemById(int id) {
        for (FoodItem f : menu) if (f.getId() == id) return f;
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Restaurant ID: %d, Name: %s%n", id, name));
        for (FoodItem f : menu) {
            sb.append(String.format("- Food Item ID: %d, Name: %s, Price: Rs. %.2f%n",
                    f.getId(), f.getName(), f.getPrice()));
        }
        return sb.toString();
    }
}
