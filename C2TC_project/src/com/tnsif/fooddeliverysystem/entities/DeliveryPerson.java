package com.tnsif.fooddeliverysystem.entities;

public class DeliveryPerson {
    private int deliveryPersonId;
    private String name;
    private long contactNo;

    public DeliveryPerson(int id, String name, long contactNo) {
        this.deliveryPersonId = id;
        this.name = name;
        this.contactNo = contactNo;
    }

    public int getDeliveryPersonId() { return deliveryPersonId; }
    public String getName() { return name; }
    public long getContactNo() { return contactNo; }

    @Override
    public String toString() {
        return String.format("DeliveryPerson{id=%d, name='%s'}", deliveryPersonId, name);
    }
}
