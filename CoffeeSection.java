package packages;

import java.util.HashMap;
import java.util.Map;

public class CoffeeSection {

    private String[] coffeeNames = {
            "Espresso",
            "Cappuccino",
            "Latte",
            "Cold Coffee",
            "Mocha"
    };

    private double[] coffeePrices = {
            80,
            120,
            130,
            110,
            140
    };

    private Map<Integer, Double> coffeePriceMap;

    // Constructor
    public CoffeeSection() {

        coffeePriceMap = new HashMap<>();

        coffeePriceMap.put(101, 80.0);
        coffeePriceMap.put(102, 120.0);
        coffeePriceMap.put(103, 130.0);
        coffeePriceMap.put(104, 110.0);
        coffeePriceMap.put(105, 140.0);
    }

    // Display coffee menu
    public void displayCoffeeMenu() {

        for (int i = 0; i < coffeeNames.length; i++) {

            System.out.printf(
                    "%d. %-20s ₹%.2f\n",
                    i + 1,
                    coffeeNames[i],
                    coffeePrices[i]
            );
        }
    }

    // Check whether choice is valid
    public boolean isValidChoice(int choice) {

        return choice >= 1 && choice <= coffeeNames.length;
    }

    // Get coffee name using switch
    public String getCoffeeName(int choice) {

        switch (choice) {

            case 1:
                return coffeeNames[0];

            case 2:
                return coffeeNames[1];

            case 3:
                return coffeeNames[2];

            case 4:
                return coffeeNames[3];

            case 5:
                return coffeeNames[4];

            default:
                return "Invalid Coffee";
        }
    }

    // Select coffee
    public String selectCoffee(int choice) {

        return getCoffeeName(choice);
    }

    // Get coffee price
    public double getCoffeePrice(int choice) {

        int coffeeId;

        switch (choice) {

            case 1:
                coffeeId = 101;
                break;

            case 2:
                coffeeId = 102;
                break;

            case 3:
                coffeeId = 103;
                break;

            case 4:
                coffeeId = 104;
                break;

            case 5:
                coffeeId = 105;
                break;

            default:
                return 0;
        }

        return coffeePriceMap.get(coffeeId);
    }

    // Return coffee names for combined menu
   
}