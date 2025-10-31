package com.tnsif.fooddeliverysystem.entities;


import java.util.*;

public class Cart {
    private Map<FoodItem, Integer> items;

    public Cart() {
        this.items = new LinkedHashMap<>();
    }

    public void addItem(FoodItem foodItem, int quantity) {
        if (quantity <= 0) return;
        items.put(foodItem, items.getOrDefault(foodItem, 0) + quantity);
    }

    public void removeItem(FoodItem foodItem) {
        items.remove(foodItem);
    }

    public Map<FoodItem, Integer> getItems() {
        return items;
    }

    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<FoodItem, Integer> e : items.entrySet()) {
            total += e.getKey().getPrice() * e.getValue();
        }
        return total;
    }

    public void clear() {
        items.clear();
    }

    public void printCart() {
        if (items.isEmpty()) {
            System.out.println("(empty)");
            return;
        }
        for (Map.Entry<FoodItem, Integer> e : items.entrySet()) {
            System.out.printf("Food Item: %s, Quantity: %d, Cost: Rs. %.2f%n",
                    e.getKey().getName(), e.getValue(), e.getKey().getPrice() * e.getValue());
        }
    }

    @Override
    public String toString() {
        return "Cart{" + "items=" + items + '}';
    }
}
