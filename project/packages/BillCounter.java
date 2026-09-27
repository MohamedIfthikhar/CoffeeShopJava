package packages;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BillCounter {

    private List<String> itemNames;
    private List<Double> itemPrices;

    // Stores only unique categories
    private Set<String> categories;

    // Constructor
    public BillCounter() {

        itemNames = new ArrayList<>();
        itemPrices = new ArrayList<>();
        categories = new HashSet<>();
    }

    // Add an item to the current order
    public void addItem(
            String itemName,
            double price,
            String category) {

        itemNames.add(itemName);
        itemPrices.add(price);

        categories.add(category);
    }

    // Calculate subtotal
    public double calculateSubtotal() {

        double subtotal = 0;

        for (double price : itemPrices) {
            subtotal += price;
        }

        return subtotal;
    }

    // Recommendation system
    public String recommendItem(String coffeeName) {

        if (coffeeName.equalsIgnoreCase("Cappuccino")) {

            return "Brownie";

        } else if (coffeeName.equalsIgnoreCase("Espresso")) {

            return "Croissant";

        } else if (coffeeName.equalsIgnoreCase("Cold Coffee")) {

            return "Sandwich";

        } else if (coffeeName.equalsIgnoreCase("Latte")) {

            return "Muffin";

        } else if (coffeeName.equalsIgnoreCase("Mocha")) {

            return "Garlic Bread";
        }

        return "None";
    }

    // Calculate discount
    public double calculateDiscount(
            int existingLoyaltyPoints,
            double subtotal) {

        /*
         * Customers with 10 or more existing loyalty points
         * receive a 5% discount.
         */
        if (existingLoyaltyPoints >= 10) {

            return subtotal * 0.05;
        }

        return 0;
    }

    //calculate tax
    public double calculateTax(double subtotal){
            final double salesTaxPercent = 0.02;
            final double gstTaxPercent = 0.015;

            double tax = (subtotal*salesTaxPercent) + (subtotal*gstTaxPercent);

            return tax;
    }

    // Calculate loyalty points
    public int calculateLoyaltyPoints(double subtotal) {

        return (int) (subtotal / 100);
    }

    // Display current bill
    public void displayBill() {

        System.out.println("\n--------------- ORDER -----------------");

        if (itemNames.isEmpty()) {

            System.out.println("No items in the order.");

        } else {

            for (int i = 0; i < itemNames.size(); i++) {

                System.out.printf(
                        "%-25s ₹%.2f%n",
                        itemNames.get(i),
                        itemPrices.get(i)
                );
            }
        }

        System.out.println("----------------------------------------");

        System.out.printf(
                "Subtotal:                  ₹%.2f%n",
                calculateSubtotal()
        );

        System.out.println("\nCategories Ordered:");

        for (String category : categories) {
            System.out.println("- " + category);
        }
    }

    // Display final receipt
    public void displayReceipt(
            Customer customer,
            double subtotal,
            double discount,
            double tax,
            int earnedPoints) {

        double total = (subtotal - discount) + tax;

        System.out.println("\n");
        System.out.println("========================================");
        System.out.println("          LEO'S COFFEE SHOP");
        System.out.println("========================================");

        System.out.println("Customer: " + customer.getName());
        System.out.println("Customer ID: " + customer.getCustomerId());
        System.out.println("Phone: " + customer.getPhone());

        System.out.println("\n--------------- ORDER -----------------");

        for (int i = 0; i < itemNames.size(); i++) {

            System.out.printf(
                    "%-25s ₹%.2f%n",
                    itemNames.get(i),
                    itemPrices.get(i)
            );
        }

        System.out.println("----------------------------------------");

        System.out.printf(
                "Subtotal                   +₹%.2f\n",
                subtotal
        );
        System.out.println("----------------------------------------");

        System.out.printf(
                "Taxes                   +₹%.2f\n",
                tax
        );
        System.out.printf(
                "Discount                   -₹%.2f\n",
                discount
        );

        System.out.println("----------------------------------------");

        System.out.printf(
                "TOTAL                      ₹%.2f\n",
                total
        );

        System.out.println("----------------------------------------");

        System.out.println(
                "Loyalty Points Earned: " + earnedPoints
        );

        System.out.println(
                "Total Loyalty Points: "
                        + customer.getLoyaltyPoints()
        );

        System.out.println("\nCategories Ordered:");

        for (String category : categories) {
            System.out.println("- " + category);
        }

        System.out.println("========================================");
        System.out.println("       Thank you for visiting!");
        System.out.println("========================================");
    }
}