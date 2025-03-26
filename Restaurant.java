package Restaurants;

import java.util.ArrayList;

public class Restaurant {
    //Instance Fields

    private String restaurantName;

    private int bankBalance;

    protected ArrayList<Customer> customerList;

    private int profit = 0;


    /**
     * Constructor for a restaurant
     * @param restaurantName The name of the restaurant
     * @param bankBalance The capital of the restaurant
     * @param customerList The of customers in attendance at the restaurant
     */
    public Restaurant(String restaurantName, int bankBalance, ArrayList<Customer> customerList) {
        this.restaurantName = restaurantName;
        this.bankBalance = bankBalance;
        this.customerList = customerList;
    }

    /**
     * Gets the name of a specified restaurant
     * @return The name of the restaurant
     */
    public String getRestaurantName() {
        return restaurantName;
    }

    /**
     * Gets the capital of the restaurant
     * @return The capital value
     */
    public int getBankBalance() {
        return bankBalance;
    }

    public int getProfit() {
        return profit;
    }

    /**
     * Gets a specified customer with the ID
     * @param ID The ID of the patron/customer
     * @return The customer object
     */
    public Customer getCustomer(String ID) {
        boolean ifFound = false;
        int index = -1;
        int count = 0;
        for (Customer c: customerList){
            if (c.equals(ID)){
                ifFound = true;
                index = count;
                break;
            }
            count +=1;
        }
        if (ifFound == false){
            return null;
        } else{
            return customerList.get(index);
        }
    }

    /**
     * Removes a specified customer from the list
     * @param ID The ID of the customer in question
     * @return True if successful. False if not.
     */
    public boolean removeCustomer(String ID){
        if (getCustomer(ID) == null){
            return false;
        } else{
            customerList.remove(this.getCustomer(ID));
            return true;
        }
    }

    /**
     * Changes the capital/bank balance by a specified amount.
     * @param amount The amount the balance changes by
     */
    public void changeBankBalance(int amount){
        bankBalance += amount;
    }

    /**
     * Sorts the customer by ID in the customer list
     */
    public void sortCustomersByID(){
        Customer valueAtFirstIndex;
        int count = -1;
        int forCount = customerList.size();
        while (count!=0) {
            count = 0;
            for (int i = 1; i < forCount; i++) {
                while (customerList.get(i-1).getID() > customerList.get(i).getID()){
                    valueAtFirstIndex = customerList.get(i);
                    customerList.remove(i);
                    customerList.add(i,customerList.get(i-1));
                    customerList.remove(i-1);
                    customerList.add(i-1, valueAtFirstIndex);
                    count += 1;
                }
            }
            forCount -= 1;
        }
    }

    /**
     * Charges the customers by the hourly rate dependent on customer class
     */
    public void chargeAllCustomers(){
        for (int i = 0; i < customerList.size(); i++) {
            customerList.get(i).chargeCustomerBill();
            profit += customerList.get(i).getCustomerBill();
        }
        System.out.println("Done");
    }

    /**
     * Eliminates all customers that have a restaurant listed in the parameter.
     */
    public void eliminateNonPatrons(){
        for (int i = 0; i < customerList.size(); i++) {
            if (!(customerList.get(i).getRestaurantName().equals(this.restaurantName))){
                customerList.remove(customerList.get(i));
            }
        }
    }

    /**
     * Prints the restaurant occupancy at a specified time
     */
    public void printOccupancyAtSpecificTime(){
        boolean ifFinished = false;
        int time = 0;
        int customerCount = 0;
        System.out.print("Enter a time(24 hour format): ");
        while (ifFinished == false) {
            try {
                time = Integer.parseInt(Main.scanner.nextLine());
                if (time>100 && time<2460 && time/100){
                    ifFinished = true;
                } else{
                    System.out.print("Enter a time with 100 and 2460 exclusive: ");
                }

            } catch (NumberFormatException num) {
                System.out.print("Enter a real time(24 hour format): ");
            }
        }

        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i) instanceof ReservedCustomer){
                if ((((ReservedCustomer) customerList.get(i)).getReservationTime() < time) && (((ReservedCustomer) customerList.get(i)).getPlannedCheckOut() > time)){
                   customerCount +=1;
                }
            }
            if (customerList.get(i) instanceof NonReservedCustomer) {
                if ((((NonReservedCustomer) customerList.get(i)).getCheckInTime() < time) && (((NonReservedCustomer) customerList.get(i)).getCheckOutTime() > time)) {
                    customerCount += 1;
                }
            }
        }
        System.out.println("The total occupancy at " + time + " of "  + this.getRestaurantName() + " is " + customerCount);
        Main.pressEnter();
    }

    /**
     * Prints the total capital of a specified restaurant
     */
    public void printProfit(){
        System.out.println("The profit for " + this.getRestaurantName() + ": " + this.getProfit());
        Main.pressEnter();
    }


}