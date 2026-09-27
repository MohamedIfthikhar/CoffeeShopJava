package packages;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private int customerId;
    private String name;
    private String phone;
    private int loyaltyPoints;

    private List<String> orderHistory;

    // Constructor
    public Customer(int customerId, String name, String phone) {

        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.loyaltyPoints = 0;

        orderHistory = new ArrayList<>();
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for phone
    public String getPhone() {
        return phone;
    }

    // Getter for customer ID
    public int getCustomerId() {
        return customerId;
    }

    // Getter for loyalty points
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    // Add loyalty points
    public void addLoyaltyPoints(int points) {
        loyaltyPoints += points;
    }

    // Add an order to order history
    public void addOrder(String order) {
        orderHistory.add(order);
    }

    // Display customer information
    public void displayCustomer() {

        System.out.println("\nCustomer ID: " + customerId);
        System.out.println("Customer Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Loyalty Points: " + loyaltyPoints);
    }

    // Display order history
    public void displayOrderHistory() {

        System.out.println("\n========== ORDER HISTORY ==========");

        if (orderHistory.isEmpty()) {

            System.out.println("No previous orders.");

        } else {

            for (String order : orderHistory) {
                System.out.println("- " + order);
            }
        }
    }
}