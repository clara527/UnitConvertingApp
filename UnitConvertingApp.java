// Unit Converting App - Clara Yalamanchili CSI 2300

import java.util.Scanner;

public class UnitConvertingApp {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        // Welcome print statements and instructions for unit converter
        System.out.println("Welcome to the Unit Converting App!");
        System.out.println("You can use this to convert between metric units.");
        System.out.println("An example is '5 km = mi' which will convert kilometers to miles.");
        System.out.println("Type exit or -1 to exit the app.");

        // While loop designed to ask user for conversion inputs until they say to exit
        while (true) {
            System.out.print("Enter a conversion (ex: 5 km = mi): ");
            String userInput = inputScanner.nextLine().trim();

            // Break out of loop if user wants to exit the program
            if (userInput.equalsIgnoreCase("exit") || userInput.equals("-1")) {
                System.out.println("Goodbye! Thanks for using Unit Converter.");
                break;
            }

            convertingRequest(userInput);
        }

        inputScanner.close();
    }

    // This method is used to process the user's conversion input
    public static void convertingRequest(String userInput) {
        // Check if the input format is valid and split accordingly
        String[] inputParts = userInput.split(" = "); 

        if (inputParts.length != 2) {
            System.out.println("You did not input your conversion properly. Please try again. Example: 5 km = mi");
            return;
        }

        // Split the first part into the numeric value and the unit that is being converted from
        String[] fromUnitParts = inputParts[0].split(" ");
        if (fromUnitParts.length != 2) {
            System.out.println("You did not input your conversion properly. Please try again. Example: 5 km = mi");
            return;
        }

        String numericValueStr = fromUnitParts[0];
        String fromUnit = fromUnitParts[1].toLowerCase();
        String toUnit = inputParts[1].toLowerCase();

        boolean isValidNumber = true;
        for (int i = 0; i < numericValueStr.length(); i++) {
            char c = numericValueStr.charAt(i);
            if (!(c >= '0' && c <= '9' || c == '.')) {
                isValidNumber = false;
                break;
            }
        }

        if (!isValidNumber) {
            System.out.println("The numeric value you entered is not allowed. Please enter a valid number.");
            return;
        }

        // Convert string to number
        double numericValue = Double.valueOf(numericValueStr);

        // Conversion by multiplying the number inputted and printing it out on console
        switch (fromUnit) {
            case "kg":
                if (toUnit.equals("lb")) {
                    System.out.println(numericValue + " kg = " + (numericValue * 2.20462) + " lb");
                } else {
                    System.out.println("This app does not offer converting from kg to " + toUnit);
                }
                break;
            case "g":
                if (toUnit.equals("oz")) {
                    System.out.println(numericValue + " g = " + (numericValue * 0.035274) + " oz");
                } else {
                    System.out.println("This app does not offer converting from g to " + toUnit);
                }
                break;
            case "km":
                if (toUnit.equals("mi")) {
                    System.out.println(numericValue + " km = " + (numericValue * 0.621371) + " mi");
                } else {
                    System.out.println("This app does not offer converting from km to " + toUnit);
                }
                break;
            case "mm":
                if (toUnit.equals("in")) {
                    System.out.println(numericValue + " mm = " + (numericValue * 0.0393701) + "in");
                } else {
                    System.out.println("Sorry, we don't support conversion from mm to " + toUnit);
                }
                break;
            // If none of the inputs the user puts in are not offerred, they either can put one that is oferred (basic on the switch statements) or exit 
            default:
                System.out.println("You can't convert from " + fromUnit + ". Please input a different unit. We offer these conversions: kg to lb, g to oz, km to mi, or mm to in");
        }
    }
}