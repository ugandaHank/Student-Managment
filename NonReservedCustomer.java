package Restaurants;

public class NonReservedCustomer extends Customer {

    //Instance Fields

    private int checkInTime;

    private int checkOutTime;

    final int hourlyNonReservationRate = 40;

    /**
     * Basic Constructor for an abstract customer
     *
     * @param ID             Customer ID to be used for any outside managerial purposes
     * @param lastName       Customer last name
     * @param firstName      Customer first name
     * @param restaurantName Restaurant name customer is attending
     * @param numberOfGuests The number of guests excluding the customer
     * @param money          The money the customer has
     * @param tableNumber    The table number for the customer and guests
     * @param checkInTime    The time(24 hour format) in which the customer enter the restaurant
     * @param checkOutTime   The time(24 hour format) in which the customer exits the restaurant
     */
    public NonReservedCustomer(int ID, String lastName, String firstName, String restaurantName, int numberOfGuests, double money, int tableNumber, int checkInTime, int checkOutTime) {
        super(ID, lastName, firstName, restaurantName, numberOfGuests, money, tableNumber);
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
    }


    public int getCheckInTime() {
        return checkInTime;
    }

    public int getCheckOutTime() {
        return checkOutTime;
    }

    /**
     * Finds the time spent by the NonReservedCustomer
     * @return The time spent by this specified customer
     */
    public int timeSpent() {
        return checkOutTime - checkInTime;
    }

    /**
     * Finds the money owed to the business by the NonReservedCustomer
     * @return The bill owed by the NonReservedBusiness
     */
    public int getCustomerBill() {
        return this.timeSpent() * hourlyNonReservationRate;
    }

    /**
     * Charges a specified NonReservedCustomer with the customer bill
     */
    public void chargeCustomerBill() {
        this.money -= this.getCustomerBill();
    }

    /**
     * Finds and changes the check-in time of a NonReservedCustomer
     * @param newCheckInTime The new check-in time for the NonReservedCustomer
     */
    public void changeCheckInTime(int newCheckInTime) {
        this.checkInTime = newCheckInTime;
    }

    /**
     * Finds and changes the check-out time of a NonReservedCustomer
     * @param newCheckOutTime The new check-out time for the NonReservedCustomer
     */
    public void changeCheckOutTime(int newCheckOutTime) {
        this.checkOutTime = newCheckOutTime;
    }

    @Override
    /**
     *
     */
    public String toString() {
        return "Reserved Customer " + ID +": " + lastName + ", " + firstName + ", " + numberOfGuests + ", " + money + ", " +  checkInTime + ", " + checkOutTime + ", " +  tableNumber;
    }
}
