package com.tnsif.fooddeliverysystem.services;

import com.tnsif.fooddeliverysystem.entities.*;
import java.util.*;

public class FoodService {
    private List<Restaurant> restaurants = new ArrayList<>();
    private List<DeliveryPerson> deliveryPersons = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    public void addRestaurant(Restaurant r) { restaurants.add(r); }
    public List<Restaurant> getRestaurants() { return restaurants; }

    public void addFoodItemToRestaurant(int restId, FoodItem foodItem) {
        for (Restaurant r : restaurants) {
            if (r.getId() == restId) {
                r.addFoodItem(foodItem);
                return;
            }
        }
    }

    public void removeFoodItemFromRestaurant(int restId, int foodItemId) {
        for (Restaurant r : restaurants) {
            if (r.getId() == restId) {
                r.removeFoodItem(foodItemId);
                return;
            }
        }
    }

    public void viewRestaurants() {
        for (Restaurant r : restaurants) {
            System.out.println("Restaurant ID: " + r.getId() + ", Name: " + r.getName());
            for (FoodItem f : r.getMenu()) {
                System.out.println("- " + f);
            }
        }
    }

    public void addDeliveryPerson(DeliveryPerson dp) {
        deliveryPersons.add(dp);
    }

    public void assignDeliveryPersonToOrder(int orderId, int deliveryPersonId) {
        for (Order o : orders) {
            if (o.getOrderId() == orderId) {
                for (DeliveryPerson dp : deliveryPersons) {
                    if (dp.getDeliveryPersonId() == deliveryPersonId) {
                        o.setDeliveryPerson(dp);
                        return;
                    }
                }
            }
        }
    }

    public void addOrder(Order order) { orders.add(order); }

    public void viewOrders() {
        for (Order o : orders) {
            System.out.println(o);
        }
    }
}

