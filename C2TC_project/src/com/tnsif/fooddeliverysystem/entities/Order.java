package com.tnsif.fooddeliverysystem.entities;

import java.util.*;

public class Order {
    private int orderId;
    private Customer customer;
    private Map<FoodItem, Integer> items;
    private String status;
    private DeliveryPerson deliveryPerson;
    private String deliveryAddress;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new LinkedHashMap<>(customer.getCart().getItems());
        this.status = "Pending";
    }

    public int getOrderId() { return orderId; }
    public Customer getCustomer() { return customer; }
    public Map<FoodItem, Integer> getItems() { return items; }
    public String getStatus() { return status; }
    public void setStatus(String s) { status = s; }
    public DeliveryPerson getDeliveryPerson() { return deliveryPerson; }
    public void setDeliveryPerson(DeliveryPerson dp) { this.deliveryPerson = dp; }
    public String getDeliveryAddress() { return deliveryAddress; }
    public void setDeliveryAddress(String addr) { this.deliveryAddress = addr; }

    public double calculateTotal() {
        double t = 0;
        for (Map.Entry<FoodItem, Integer> e : items.entrySet())
            t += e.getKey().getPrice() * e.getValue();
        return t;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Order{id=%d, customer=%s, status='%s', deliveryPerson=%s}%n",
                orderId, customer.getUsername(), status, 
                deliveryPerson == null ? "Not Assigned" : deliveryPerson.getName()));
        for (Map.Entry<FoodItem, Integer> e : items.entrySet()) {
            sb.append(String.format("  %s x %d -> Rs. %.2f%n",
                    e.getKey().getName(), e.getValue(), e.getKey().getPrice() * e.getValue()));
        }
        sb.append(String.format("Total: Rs. %.2f%n", calculateTotal()));
        return sb.toString();
    }
}
