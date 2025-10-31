package com.tnsif.fooddeliverysystem.application;

import com.tnsif.fooddeliverysystem.entities.*;
import com.tnsif.fooddeliverysystem.services.*;
import java.util.*;

public class FoodDeliverySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FoodService foodService = new FoodService();
        CustomerService customerService = new CustomerService();
        OrderService orderService = new OrderService();

        while (true) {
            System.out.println("1. Admin Menu");
            System.out.println("2. Customer Menu");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> runAdminMenu(sc, foodService);
                case 2 -> runCustomerMenu(sc, foodService, customerService, orderService);
                case 3 -> {
                    System.out.println("Exiting Application...");
                    return;
                }
            }
        }
    }

    private static void runAdminMenu(Scanner sc, FoodService foodService) {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Restaurant");
            System.out.println("2. Add Food Item to Restaurant");
            System.out.println("3. Remove Food Item from Restaurant");
            System.out.println("4. View Restaurants and Menus");
            System.out.println("5. View Orders");
            System.out.println("6. Add Delivery Person");
            System.out.println("7. Assign Delivery Person to Order");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.print("Enter Restaurant ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Restaurant Name: ");
                    String name = sc.nextLine();
                    foodService.addRestaurant(new Restaurant(id, name));
                    System.out.println("Restaurant added successfully!");
                }
                case 2 -> {
                    System.out.print("Enter Restaurant ID: ");
                    int restId = sc.nextInt();
                    System.out.print("Enter Food Item ID: ");
                    int fid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Food Item Name: ");
                    String fname = sc.nextLine();
                    System.out.print("Enter Food Item Price: ");
                    double price = sc.nextDouble();
                    foodService.addFoodItemToRestaurant(restId, new FoodItem(fid, fname, price));
                    System.out.println("Food item added successfully!");
                }
                case 3 -> {
                    System.out.print("Enter Restaurant ID: ");
                    int restId = sc.nextInt();
                    System.out.print("Enter Food Item ID: ");
                    int fid = sc.nextInt();
                    foodService.removeFoodItemFromRestaurant(restId, fid);
                    System.out.println("Food item removed successfully!");
                }
                case 4 -> foodService.viewRestaurants();
                case 5 -> foodService.viewOrders();
                case 6 -> {
                    System.out.print("Enter Delivery Person ID: ");
                    int did = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Delivery Person Name: ");
                    String dname = sc.nextLine();
                    System.out.print("Enter Contact No.: ");
                    long cno = sc.nextLong();
                    foodService.addDeliveryPerson(new DeliveryPerson(did, dname, cno));
                    System.out.println("Delivery person added successfully!");
                }
                case 7 -> {
                    System.out.print("Enter Order ID: ");
                    int oid = sc.nextInt();
                    System.out.print("Enter Delivery Person ID: ");
                    int did = sc.nextInt();
                    foodService.assignDeliveryPersonToOrder(oid, did);
                    System.out.println("Delivery person assigned to order successfully!");
                }
                case 8 -> {
                    System.out.println("Exiting Admin Module...");
                    return;
                }
            }
        }
    }

    private static void runCustomerMenu(Scanner sc, FoodService foodService,
                                        CustomerService customerService, OrderService orderService) {
        while (true) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Add Customer");
            System.out.println("2. View Food Items");
            System.out.println("3. Add Food to Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Place Order");
            System.out.println("6. View Orders");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.print("Enter User ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Username: ");
                    String uname = sc.nextLine();
                    System.out.print("Enter Contact No.: ");
                    long cno = sc.nextLong();
                    customerService.addCustomer(new Customer(uid, uname, cno));
                    System.out.println("Customer created successfully!");
                }
                case 2 -> foodService.viewRestaurants();
                case 3 -> {
                    System.out.print("Enter Customer ID: ");
                    int cid = sc.nextInt();
                    System.out.print("Enter Restaurant ID: ");
                    int rid = sc.nextInt();
                    System.out.print("Enter Food Item ID: ");
                    int fid = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    Customer customer = customerService.getCustomerById(cid);
                    for (Restaurant r : foodService.getRestaurants()) {
                        if (r.getId() == rid) {
                            for (FoodItem item : r.getMenu()) {
                                if (item.getId() == fid) {
                                    customer.getCart().addItem(item, qty);
                                    System.out.println("Food item added to cart!");
                                    break;
                                }
                            }
                        }
                    }
                }
                case 4 -> {
                    System.out.print("Enter Customer ID: ");
                    int cid = sc.nextInt();
                    Customer c = customerService.getCustomerById(cid);
                    System.out.println(c.getCart());
                }
                case 5 -> {
                    System.out.print("Enter Customer ID: ");
                    int cid = sc.nextInt();
                    Customer c = customerService.getCustomerById(cid);
                    Order o = orderService.placeOrder(c);
                    System.out.println("Order placed successfully! Your order ID is: " + o.getOrderId());
                }
                case 6 -> {
                    for (Order o : orderService.getOrders()) {
                        System.out.println(o);
                    }
                }
                case 7 -> {
                    System.out.println("Exiting Customer Module...");
                    return;
                }
            }
        }
    }
}

