import java.util.InputMismatchException;
import java.util.Scanner;

import packages.Customer;
import packages.CoffeeSection;
import packages.SnacksSection;
import packages.BillCounter;

public class CoffeeShop {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("       ☕ LEO'S COFFEE SHOP ☕");
        System.out.println("        Smart Ordering System");
        System.out.println("========================================");

        // Customer details
        System.out.println("\nEnter Customer Details");

        System.out.print("Enter Customer ID: ");
        int customerId = readInt(scanner);

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();

        Customer customer = new Customer(customerId, name, phone);

        CoffeeSection coffeeSection = new CoffeeSection();
        SnacksSection snacksSection = new SnacksSection();
        BillCounter billCounter = new BillCounter();


        // Coffee selection
        System.out.println("\n========== COFFEE ==========");
        coffeeSection.displayCoffeeMenu();

        int coffeeChoice;

        while (true) {
            System.out.print("\nChoose a coffee (1-5): ");
            coffeeChoice = readInt(scanner);

            if (coffeeSection.isValidChoice(coffeeChoice)) {
                break;
            }

            System.out.println("Invalid choice. Please choose between 1 and 5.");
        }

        String coffeeName = coffeeSection.selectCoffee(coffeeChoice);
        double coffeePrice = coffeeSection.getCoffeePrice(coffeeChoice);

        billCounter.addItem(coffeeName, coffeePrice, "Coffee");

        // Recommendation
        String recommendation = billCounter.recommendItem(coffeeName);

        if (!recommendation.equals("None")) {

            System.out.println("\n========================================");
            System.out.println("       ☕ LEO'S RECOMMENDATION");
            System.out.println("========================================");
            System.out.println("Since you selected " + coffeeName + ",");
            System.out.println("we recommend: " + recommendation);

            System.out.print("Would you like to add it? (Y/N): ");
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("Y")) {

                double recommendationPrice =
                        snacksSection.getSnackPriceByName(recommendation);

                billCounter.addItem(
                        recommendation,
                        recommendationPrice,
                        "Snacks"
                );

                System.out.println(recommendation + " added to your order!");

            } else {
                System.out.println("Recommendation rejected.");
            }
        }

        // Snack selection
        System.out.println("\n========== SNACKS ==========");

        String continueOrdering = "Y";

        while (continueOrdering.equalsIgnoreCase("Y")) {

            snacksSection.displaySnackMenu();

            System.out.print("\nChoose a snack (1-5): ");
            int snackChoice = readInt(scanner);

            if (snacksSection.isValidChoice(snackChoice)) {

                String snackName = snacksSection.selectSnack(snackChoice);
                double snackPrice = snacksSection.getSnackPrice(snackChoice);

                billCounter.addItem(
                        snackName,
                        snackPrice,
                        "Snacks"
                );

                System.out.println(snackName + " added to your order.");

            } else {
                System.out.println("Invalid snack choice.");
            }

            System.out.print("\nAdd another snack? (Y/N): ");
            continueOrdering = scanner.nextLine();
        }

        // Review order
        System.out.println("\n========================================");
        System.out.println("             ORDER REVIEW");
        System.out.println("========================================");

        billCounter.displayBill();

        System.out.print("\nProceed to generate bill? (Y/N): ");
        String proceed = scanner.nextLine();

        if (!proceed.equalsIgnoreCase("Y")) {
            System.out.println("\nOrder cancelled. Thank you for visiting LEO's!");
            scanner.close();
            return;
        }

        // Calculate subtotal
        double subtotal = billCounter.calculateSubtotal();

        // Calculate discount
        double discount = billCounter.calculateDiscount(
                customer.getLoyaltyPoints(),
                subtotal
        );
        
        //Calculate tax
        double tax = billCounter.calculateTax(subtotal);

        // Loyalty points
        int earnedPoints = billCounter.calculateLoyaltyPoints(subtotal);

        customer.addLoyaltyPoints(earnedPoints);

        // Save order in customer history
        customer.addOrder(
                "Order Total: ₹" + String.format("%.2f", subtotal - discount)
        );

        // Final receipt
        billCounter.displayReceipt(
                customer,
                subtotal,
                discount,
                tax,
                earnedPoints
        );

        System.out.println("\nThank you, " + customer.getName()
                + "! Visit LEO'S again. ☕");

        scanner.close();
    }


    // Handles invalid numerical input
    public static int readInt(Scanner scanner) {

        while (true) {

            try {

                int value = scanner.nextInt();
                scanner.nextLine();

                return value;

            } catch (InputMismatchException e) {

                System.out.println(
                        "Invalid input. Please enter a valid number."
                );

                scanner.nextLine();
            }
        }
    }
}