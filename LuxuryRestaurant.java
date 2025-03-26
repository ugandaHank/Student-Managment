package Restaurants;

import java.util.ArrayList;

public class LuxuryRestaurant extends Restaurant {
    //Instance Fields

    private int luxurySurcharge;

    private int profit = 0;

    /**
     * Constructor for luxury restaurant
     * @param restaurantName The name given to the restaurant
     * @param bankBalance The money for the restaurant
     * @param customerList The list of patrons at the restaurant
     * @param luxurySurcharge The money to be charged extra for luxury restaurants
     */

    public LuxuryRestaurant(String restaurantName, int bankBalance, ArrayList<Customer> customerList, int luxurySurcharge) {
        super(restaurantName, bankBalance,  customerList);
        this.luxurySurcharge = luxurySurcharge;
    }

    public int getLuxurySurcharge() {
        return luxurySurcharge;
    }

    public int getProfit(){
        return profit;
    }

    public int getBankBalance() {
        return super.getBankBalance();
    }

    public String getRestaurantName() {
        return super.getRestaurantName();
    }

    public void changeBankBalance(int amount) {
        super.changeBankBalance(amount);
    }

    public void eliminateNonPatrons() {
        super.eliminateNonPatrons();
    }

    public void printOccupancyAtSpecificTime() {
        super.printOccupancyAtSpecificTime();
    }

    public boolean removeCustomer(String ID) {
        return super.removeCustomer(ID);
    }


    public void printProfit() {
        super.printProfit();
    }

    public Customer getCustomer(String ID) {
        return super.getCustomer(ID);
    }
    @Override
    public void chargeAllCustomers(){
        for (int i = 0; i < customerList.size(); i++) {
            customerList.get(i).chargeCustomerBill();
            profit += customerList.get(i).getCustomerBill();
            customerList.get(i).chargeExtra(luxurySurcharge);
            profit+=luxurySurcharge;
        }
        System.out.println("Done");
    }
}
