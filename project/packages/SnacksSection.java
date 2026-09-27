package packages;

import java.util.HashMap;
import java.util.Map;

public class SnacksSection {

    private String[] snackNames = {
            "Croissant",
            "Brownie",
            "Sandwich",
            "Muffin",
            "Garlic Bread"
    };

    private double[] snackPrices = {
            90,
            70,
            120,
            80,
            100
    };

    private Map<Integer, Double> snackPriceMap;

    // Constructor
    public SnacksSection() {

        snackPriceMap = new HashMap<>();

        snackPriceMap.put(201, 90.0);
        snackPriceMap.put(202, 70.0);
        snackPriceMap.put(203, 120.0);
        snackPriceMap.put(204, 80.0);
        snackPriceMap.put(205, 100.0);
    }

    // Display snack menu
    public void displaySnackMenu() {

        for (int i = 0; i < snackNames.length; i++) {

            System.out.printf(
                    "%d. %-20s ₹%.2f\n",
                    i + 1,
                    snackNames[i],
                    snackPrices[i]
            );
        }
    }

    // Check valid choice
    public boolean isValidChoice(int choice) {

        return choice >= 1 && choice <= snackNames.length;
    }

    // Get snack name
    public String getSnackName(int choice) {

        switch (choice) {

            case 1:
                return snackNames[0];

            case 2:
                return snackNames[1];

            case 3:
                return snackNames[2];

            case 4:
                return snackNames[3];

            case 5:
                return snackNames[4];

            default:
                return "Invalid Snack";
        }
    }

    // Select snack
    public String selectSnack(int choice) {

        return getSnackName(choice);
    }

    // Get snack price
    public double getSnackPrice(int choice) {

        int snackId;

        switch (choice) {

            case 1:
                snackId = 201;
                break;

            case 2:
                snackId = 202;
                break;

            case 3:
                snackId = 203;
                break;

            case 4:
                snackId = 204;
                break;

            case 5:
                snackId = 205;
                break;

            default:
                return 0;
        }

        return snackPriceMap.get(snackId);
    }

    // Find snack price using its name
    public double getSnackPriceByName(String name) {

        for (int i = 0; i < snackNames.length; i++) {

            if (snackNames[i].equalsIgnoreCase(name)) {
                return snackPrices[i];
            }
        }

        return 0;
    }

}