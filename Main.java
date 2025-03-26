package Restaurants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    final static int maxRestaurants = 3;

    public static int currentRestaurantCount = 0;

    public static ArrayList<Customer> totalCustomerList = new ArrayList<>();

    public static ArrayList<Restaurant> totalRestaurantList = new ArrayList<>();

    public static String fileName = "";


    public static void main(String[] args) {
        boolean ifFinished = false;
        while (ifFinished == false) {
            ifFinished = mainMenu();
        }
    }

    /**
     * The main menu which directs users to the further menus or the program's finishing
     *
     * @return True if the user expressed a desire to exit. False otherwise.
     */
    public static boolean mainMenu() {
        boolean ifFinished = false;
        System.out.println("Yakoub and Amish's Restaurant Management System");
        System.out.println("Main Menu");
        System.out.println("---");
        int choice;
        while (ifFinished == false) {
            try {
                System.out.println("1. Load/Save Customer Files");
                System.out.println("2. Create Restaurant");
                System.out.println("3. Edit/Search Restaurant");
                System.out.println("4. Delete Restaurant");
                System.out.println("5. Restaurant status/information");
                System.out.println("6. Manage Restaurant");
                System.out.println("7. Charge Customers");
                System.out.println("8. Sort Customers");
                System.out.println("9. Edit/Search Customer");
                System.out.println("0. Exit Program");
                System.out.print("->");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        fileMenu();
                        ifFinished = true;
                        break;
                    case 2:
                        RestaurantCreationMenu();
                        ifFinished = true;
                        break;
                    case 3:
                        ifFinished = true;
                        break;
                    case 4:
                        ifFinished = true;
                        break;
                    case 5:
                        restaurantStatusMenu();
                        ifFinished = true;
                        break;
                    case 6:
                        ifFinished = true;
                        break;
                    case 7:
                        chargeAllCustomers();
                        ifFinished = true;
                        break;
                    case 8:
                        ifFinished = true;
                        break;
                    case 9:
                        ifFinished = true;
                        break;
                    case 0:
                        System.out.println("Program is closing...");
                        pressEnter();
                        return true;
                    default:
                        System.out.println(choice + " is not an option.");
                }

            } catch (NumberFormatException num) {
                System.out.println("Enter a number from 0-7");
                return false;
            }
        }
        return false;
    }


    /**
     * Menu for loading and saving files. Managers may pick between 0-2 to perform their preferred task.
     */
    public static void fileMenu() {
        boolean ifFinished = false;
        System.out.println("Yakoub and Amish's Restaurant Management System");
        System.out.println("File Menu");
        System.out.println("---");
        int choice;
        while (ifFinished == false) {
            try {
                System.out.println("1. Load File");
                System.out.println("2. Save File");
                System.out.println("0. Exit");
                System.out.print("->");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        loadFile();
                        ifFinished = true;
                        break;
                    case 2:
                        saveFile();
                        ifFinished = true;
                        break;
                    case 0:
                        System.out.println("Exiting to main menu...");
                        pressEnter();
                        ifFinished = true;
                        break;
                    default:
                        System.out.println(choice + " is not an option.");
                }
            } catch (NumberFormatException num) {
                System.out.println("Enter a number from 0-2");
            }
        }
    }

    /**
     * Handles the user interface aspect of loading files
     */
    public static void loadFile(){
        boolean ifFinished = false;
        System.out.print("Enter the file name: ");
        while (ifFinished == false) {
            fileName = scanner.nextLine();
            ifFinished = loadCustomerList("src/Restaurants/" + fileName);
            if (ifFinished == false) {
                System.out.print(fileName + " does not exist, enter a real file: ");
            }
        }
        System.out.println("Finished");
        pressEnter();
    }

    public static void putCustomersInRestaurant(){

    }

    /**
     * Handles the user interface aspect of saving files
     */
    public static void saveFile(){
        System.out.print("Do you want to create a new file?(yes/no): ");
        String input = scanner.nextLine();
        if (input.equals("yes")){
            System.out.print("Enter the new file name: ");
            fileName = scanner.nextLine();
        }
        saveCustomerList("src/Restaurants/" + fileName);
        System.out.println("Saved");
        pressEnter();
    }

    /**
     * Loads Customers into the general customer list(i.e. Not into specified restaurants)
     * @param fileName The name of the file being loaded
     * @return Returns true if process if successful. False otherwise.
     */
    public static boolean loadCustomerList(String fileName) {
        String line;
        int count;
        BufferedReader lineReader;
        Scanner tokenScanner;

        int ID = 0;
        String lastName = "";
        String firstName = "";
        String restaurantName = "";
        int numberOfGuests = 0;
        double money = 0;
        int tableNumber = 0;
        int checkIn = 0;
        int checkOut = 0;
        String phoneNumber = "";

        try {
            lineReader = new BufferedReader(new FileReader(fileName));
            line = lineReader.readLine();

            while (line != null) {
                count = 0;
                tokenScanner = new Scanner(line);
                tokenScanner.useDelimiter(",");

                while (tokenScanner.hasNext()) {

                    if (count == 0) {
                        ID = Integer.parseInt(tokenScanner.next());
                    }
                    else if (count == 1) {
                        lastName = tokenScanner.next();
                    }
                    else if (count == 2) {
                        firstName  = tokenScanner.next();
                    }
                    else if (count == 3) {
                        restaurantName = tokenScanner.next();
                    }
                    else if (count == 4) {
                        numberOfGuests = Integer.parseInt(tokenScanner.next());
                    }
                    else if (count == 5) {
                        money = Double.parseDouble(tokenScanner.next());
                    }
                    else if (count == 6) {
                        tableNumber = Integer.parseInt(tokenScanner.next());
                    }
                    else if (count == 7) {
                        checkIn = Integer.parseInt(tokenScanner.next());
                    }
                    else if (count == 8) {
                        checkOut = Integer.parseInt(tokenScanner.next());
                    }
                    else if (count == 9) {
                        phoneNumber = tokenScanner.next();
                    }
                    count+=1;
                }

                if (phoneNumber.isEmpty()) {
                    totalCustomerList.add(new NonReservedCustomer(ID, lastName, firstName, restaurantName, numberOfGuests, money, tableNumber, checkIn, checkOut));
                }
                else if (phoneNumber.length() == 10) {
                    totalCustomerList.add(new ReservedCustomer(ID, lastName, firstName, restaurantName, numberOfGuests, money, tableNumber, checkIn, checkOut, phoneNumber));
                }

                //Close the tokenScanner after iteration
                tokenScanner.close();
                line = lineReader.readLine();
            }
            //Close the lineReader after completion
            lineReader.close();
            return true;
        }
        catch (IOException iox) {
            System.out.println("An error occurred");
            return false;
        }
    }

    /**
     * Saves the customer file. Option to create a duplicate.
     * @param fileName The name of the file being saved
     * @return Returns true if successful. False otherwise.
     */
    public static boolean saveCustomerList(String fileName) {
        int maxNumParameters = 10;
        try {
            FileWriter fileWriter = new FileWriter(fileName, false);

            for (int i = 0; i < totalCustomerList.size(); i++) {

                for (int j = 0; j <= maxNumParameters; j++) {
                    if (j == 0) {
                        fileWriter.write(totalCustomerList.get(i).getID() + ",");
                    }
                    else if (j == 1) {
                        fileWriter.write(totalCustomerList.get(i).getLastName()  + ",");
                    }
                    else if (j == 2) {
                        fileWriter.write(totalCustomerList.get(i).getFirstName()  + ",");
                    }
                    else if (j == 3) {
                        fileWriter.write(totalCustomerList.get(i).getRestaurantName()  + ",");
                    }
                    else if (j == 4) {
                        fileWriter.write(totalCustomerList.get(i).getNumberOfGuests()  + ",");
                    }
                    else if (j == 5) {
                        fileWriter.write(totalCustomerList.get(i).getTableNumber() + ",");
                    }
                    else if (j == 6) {
                        fileWriter.write(totalCustomerList.get(i).getMoney()  + ",");
                    }
                    else if (j == 7) {
                        if (totalCustomerList.get(i) instanceof ReservedCustomer) {
                            fileWriter.write(((ReservedCustomer) totalCustomerList.get(i)).getReservationTime() + ",");
                        } else if(totalCustomerList.get(i) instanceof NonReservedCustomer){
                            fileWriter.write(((NonReservedCustomer) totalCustomerList.get(i)).getCheckInTime() + ",");
                        }
                    }
                    else if (j == 8) {
                        if (totalCustomerList.get(i) instanceof ReservedCustomer) {
                            fileWriter.write(((ReservedCustomer) totalCustomerList.get(i)).getPlannedCheckOut() + ",");
                        } else if(totalCustomerList.get(i) instanceof NonReservedCustomer){
                            fileWriter.write(((NonReservedCustomer) totalCustomerList.get(i)).getCheckOutTime() + ",");
                        }
                    }
                    else if (j == 9) {
                        if (totalCustomerList.get(i) instanceof ReservedCustomer) {
                            fileWriter.write(((ReservedCustomer) totalCustomerList.get(i)).getPhoneNumber() + "\n");
                        } else if(totalCustomerList.get(i) instanceof NonReservedCustomer){
                            fileWriter.write("\n");
                        }
                    }
                }
            }
            //Close the fileWriter and finish the method
            fileWriter.close();
            return true;
        }
        catch (IOException iox) {
            return false;
        }
    }


    /**
     * Menu for creating restaurants within the system. Allows managers to choose between luxury restaurants and regular restaurants.
     */
    public static void RestaurantCreationMenu(){
        if (currentRestaurantCount < maxRestaurants) {
            boolean ifFinished = false;
            System.out.println("Yakoub and Amish's Restaurant Management System");
            System.out.println("Restaurant Creation Menu");
            System.out.println("---");
            int choice;
            while (ifFinished == false) {
                try {
                    System.out.println("1. Create Regular Restaurant");
                    System.out.println("2. Create Luxury Restaurant");
                    System.out.println("0. Exit");
                    System.out.print("->");
                    choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            createRegularRestaurant();
                            currentRestaurantCount += 1;
                            ifFinished = true;
                            break;
                        case 2:
                            createLuxuryRestaurant();
                            currentRestaurantCount += 1;
                            ifFinished = true;
                            break;
                        case 0:
                            System.out.println("Exiting to main menu...");
                            pressEnter();
                            ifFinished = true;
                            break;
                        default:
                            System.out.println(choice + " is not an option.");
                    }

                } catch (NumberFormatException num) {
                    System.out.println("Enter a number from 0-2");
                }
            }
        } else{
            System.out.println("You currently have 3 restaurants, the max number allowed!");
        }
    }

    /**
     * Creates a regular restaurant with the restaurant name and capital to be inputted by the manger. Will also display the patrons' information.
     */
    public static void createRegularRestaurant(){
        boolean ifFinished = false;
        int capital = 0;
        System.out.println("---Create Regular Restaurant---");
        System.out.print("Enter the name of your restaurant: ");
        String restaurantName = scanner.nextLine();
        while (ifFinished != true) {
            ifFinished = true;
            try {
                System.out.print("Enter the total capital(Bank balance) of your restaurant: ");
                capital = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException num) {
                System.out.println("Enter a decimal value");
                ifFinished = false;
            }
        }
        regularRestaurantAdmission(restaurantName, capital);
        System.out.println("Done!");

    }

    public static void regularRestaurantAdmission(String name, int capital){
        totalRestaurantList.add(new Restaurant(name,capital,totalCustomerList));
        for (int i = 0; i < totalRestaurantList.size(); i++) {
            if (totalRestaurantList.get(i).getRestaurantName().equals(name)){
                totalRestaurantList.get(i).eliminateNonPatrons();
            }
        }
    }

    /**
     * Creates a luxury restaurant with the restaurant name and capital to be inputted by the manager. Will also display the patrons' information.
     */
    public static void createLuxuryRestaurant(){
        boolean ifFinished = false;
        int capital = 0;
        System.out.println("---Create Luxury Restaurant---");
        System.out.print("Enter the name of your restaurant: ");
        String restaurantName = scanner.nextLine();
        while (ifFinished != true) {
            ifFinished = true;
            try {
                System.out.print("Enter the total capital(Bank balance) of your restaurant: " );
                capital = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException num) {
                System.out.println("Enter a decimal value");
                ifFinished = false;
            }
        }
        luxuryRestaurantAdmission(restaurantName, capital);
        System.out.println("Done!");

    }

    /**
     * Continues the luxury restaurant creation process with the luxury surcharge
     * @param name The name of the restaurant
     * @param capital The bank balance of the restaurant
     */
    public static void luxuryRestaurantAdmission(String name, int capital){
        int charge = 0;
        boolean ifFinished = false;
        while (ifFinished != true) {
            ifFinished = true;
            try {
                System.out.print("Enter the luxury surcharge: ");
                charge = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException num) {
                System.out.println("Enter an integer value");
                ifFinished = false;
            }
        }
        totalRestaurantList.add(new LuxuryRestaurant(name,capital,totalCustomerList,charge));
        for (int i = 0; i < totalRestaurantList.size(); i++) {
            if (totalRestaurantList.get(i).getRestaurantName().equals(name)){
                totalRestaurantList.get(i).eliminateNonPatrons();
            }
        }
    }


    /**
     * Menu for Restaurant activities. Includes occupancy and capital
     */
    public static void restaurantStatusMenu() {
        boolean ifFinished = false;
        System.out.println("Yakoub and Amish's Restaurant Management System");
        System.out.println("Restaurant Status Menu");
        System.out.println("---");
        int choice;
        while (ifFinished == false) {
            try {
                System.out.println("1. Restaurant Occupancy");
                System.out.println("2. Restaurant Profit");
                System.out.println("0. Exit");
                System.out.print("->");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        currentRestaurantOccupancy();
                        ifFinished = true;
                        break;
                    case 2:
                        currentRestaurantProfit();
                        ifFinished = true;
                        break;
                    case 0:
                        System.out.println("Exiting to main menu...");
                        pressEnter();
                        ifFinished = true;
                        break;
                    default:
                        System.out.println(choice + " is not an option.");
                }
            } catch (NumberFormatException num) {
                System.out.println("Enter a number from 0-2");
            }
        }
    }

    /**
     * Allows the manager to monitor the capacity of a specified restaurant
     */
    public static void currentRestaurantOccupancy(){
        System.out.println("---Restaurant Occupancy---");
        boolean ifFinished = false;
        String name;
        while (ifFinished == false){
            System.out.print("Enter the Restaurant to monitor: ");
            name = scanner.nextLine();
            for (int i = 0; i < totalRestaurantList.size(); i++) {
                if (totalRestaurantList.get(i).getRestaurantName().equals(name)){
                    totalRestaurantList.get(i).printOccupancyAtSpecificTime();
                    ifFinished = true;
                }
            }
        }
    }

    /**
     * Finds the capital of the restaurant
     */
    public static void currentRestaurantProfit(){
        System.out.println("---Restaurant Profit---");
        boolean ifFinished = false;
        String name;
        while (ifFinished == false){
            System.out.print("Enter the Restaurant you wish find the profit of: ");
            name = scanner.nextLine();
            for (int i = 0; i < totalRestaurantList.size(); i++) {
                if (totalRestaurantList.get(i).getRestaurantName().equals(name)){
                    totalRestaurantList.get(i).printProfit();
                    ifFinished = true;
                }
            }
        }
    }

    /**
     * Charges the customers when needed
     */
    public static void chargeAllCustomers(){
        boolean ifFinished = false;
        String name;
        while (ifFinished == false){
            System.out.print("Enter the Restaurant to charge customers: ");
            name = scanner.nextLine();
            for (int i = 0; i < totalRestaurantList.size(); i++) {
                if (totalRestaurantList.get(i).getRestaurantName().equals(name)){
                    totalRestaurantList.get(i).chargeAllCustomers();
                    ifFinished = true;
                }
            }
        }
    }


    /**
     * Pauses the program momentarily until the user presses 'enter'
     */
    public static void pressEnter(){
        System.out.println("Press 'enter' to continue...");
        String pressEnter = scanner.nextLine();
    }
}