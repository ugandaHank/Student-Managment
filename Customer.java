package Restaurants;

public abstract class Customer
{

    //Instance Fields
    protected int ID;

    protected String lastName;

    protected String firstName;

    protected String restaurantName;

    protected int numberOfGuests;

    protected double money;

    protected int tableNumber;

    //Constructor

    /**
     * Basic Constructor for an abstract customer
     * @param ID Restaurants.Customer ID to be used for any outside managerial purposes
     * @param lastName Restaurants.Customer last name
     * @param firstName Restaurants.Customer first name
     * @param restaurantName Restaurants.Restaurant name customer is attending
     * @param numberOfGuests The number of guests excluding the customer
     * @param money The money the customer has
     * @param tableNumber The table number for the customer and guests
     */
    public Customer(int ID, String lastName, String firstName, String restaurantName, int numberOfGuests, double money, int tableNumber)
    {
        this.ID = ID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.restaurantName = restaurantName;
        this.numberOfGuests = numberOfGuests;
        this.money = money;
        this.tableNumber = tableNumber;
    }



    /**
     * Gets the ID of the customer
     * @return the customer's ID variable
     */
    public int getID() {
        return ID;
    }

    /**
     * Gets the last name of the customer
     * @return the customer's last name variable
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the first name of the customer
     * @return the customer's last name variable
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the restaurantName the customer is attending
     * @return the customer's restaurant name variable
     */
    public String getRestaurantName() {
        return restaurantName;
    }

    /**
     * Gets the number of guests excluding the customer
     * @return the customer's additional guests variable
     */
    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    /**
     * Gets the money/capital of the customer
     * @return the customer's money variable
     */
    public double getMoney() {
        return money;
    }

    /**
     * Gets the table number of the customer
     * @return the customer's table variable
     */
    public int getTableNumber() {
        return tableNumber;
    }

    /**
     * Change the previous table number to the 'newTableNumber' value
     */
    public void changeTable(int newTableNumber) {
        this.tableNumber = newTableNumber;
    }

    abstract int timeSpent();

    abstract int getCustomerBill();

    abstract void chargeCustomerBill();

    abstract void changeCheckInTime(int newCheckInTime);

    abstract void changeCheckOutTime(int newCheckOutTime);

    public void chargeExtra(double amount){
        this.money-=amount;
    }

    public boolean equals(int ID){
        if (this.getID() == ID){
            return true;
        } else{
            return false;
        }
    }

    /**
     * Returns the customer's ID, last name, first name, number of additional guests, money, and table number.
     * @return The customer's information
     */
    public String toString() {
        return "Restaurants.Customer " + ID +": " + lastName + ", " + firstName + ", " + numberOfGuests + ", " + money + ", " + tableNumber;
    }

}
