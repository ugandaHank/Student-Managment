package Restaurants;

public class ReservedCustomer extends Customer {

    //Instance Fields

    private int reservationTime;

    private int plannedCheckOut;

    private String phoneNumber;

    final int hourlyReservationRate = 8;

    /**
     * Basic Constructor for a reserved customer
     *
     * @param ID              Restaurants.Customer ID to be used for any outside managerial purposes
     * @param lastName        Restaurants.Customer last name
     * @param firstName       Restaurants.Customer first name
     * @param restaurantName  Restaurants.Restaurant name customer is attending
     * @param numberOfGuests  The number of guests excluding the customer
     * @param money           The money the customer has
     * @param tableNumber     The table number for the customer and guests
     * @param reservationTime The time(24 hour format) the customer is planned to enter the restaurant
     * @param plannedCheckout The time(24 hour format) the customer is planned to check out of the restaurant
     * @param phoneNumber The reserved customer's phone number
     */
    public ReservedCustomer(int ID, String lastName, String firstName, String restaurantName, int numberOfGuests, double money, int tableNumber, int reservationTime, int plannedCheckout, String phoneNumber) {
        super(ID, lastName, firstName, restaurantName, numberOfGuests, money, tableNumber);
        this.reservationTime = reservationTime;
        this.plannedCheckOut = plannedCheckout;
        this.phoneNumber = phoneNumber;

    }


    public int getReservationTime() {
        return reservationTime;
    }

    public int getPlannedCheckOut() {
        return plannedCheckOut;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Finds the time spent by a specified Customer
     * @return the time spent by this customer
     */
    public int timeSpent() {
        return plannedCheckOut-reservationTime;
    }

    /**
     * Finds the total money the Customer must pay
     * @return The total money owed to the business
     */
    public int getCustomerBill() {
        return hourlyReservationRate * this.numberOfGuests * this.timeSpent();
    }

    /**
     * Charges a specified Customer with the customer bill
     */
    public void chargeCustomerBill() {
        this.money -= this.getCustomerBill();
    }

    /**
     * Finds and changes the check-in time of a Customer
     * @param newCheckInTime The new check-in time for the Customer
     */
    public void changeCheckInTime(int newCheckInTime) {
        this.reservationTime = newCheckInTime;

    }

    /**
     * Finds and changes the check-out time of a Customer
     * @param newCheckOutTime The new check-out time for the Customer
     */
    public void changeCheckOutTime(int newCheckOutTime) {
        this.plannedCheckOut = newCheckOutTime;
    }

    @Override
    /**
     *
     */
    public String toString() {
        return "Reserved Customer " + ID +": " + lastName + ", " + firstName + ", " + numberOfGuests + ", " + money + ", " + phoneNumber + ", " +  reservationTime + ", " + plannedCheckOut + ", " +  tableNumber;
    }

}
