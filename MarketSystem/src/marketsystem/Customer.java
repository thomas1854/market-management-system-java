package marketsystem;

import javax.swing.JOptionPane;

/**
 * Represents a customer in the market system.
 * Manages customer identity, contact information, loyalty points,
 * and total purchase balance with basic validation.
 */
public class Customer {

    // --------------------------------------------------------------
    // Fields
    // --------------------------------------------------------------

    /** Unique identifier assigned to the customer. */
    private int customerID;

    /** Full name of the customer. */
    private String customerName;

    /** Contact phone number of the customer. */
    private String customerPhone;

    /** Accumulated loyalty points of the customer. */
    private int pointsBalance;

    /** Total monetary amount spent by the customer. */
    private double purchasedBalance;

    // --------------------------------------------------------------
    // Setters
    // --------------------------------------------------------------

    /**
     * Sets the customer ID after validating that it is non-negative.
     *
     * @param customerID the unique customer identifier
     */
    public void setCustomerID(int customerID) {
        if (customerID < 0) {
            JOptionPane.showMessageDialog(null, "ID cannot be negative.");
            return;
        }
        this.customerID = customerID;
    }

    /**
     * Assigns a name to the customer after validating that it is not empty.
     *
     * @param customerName the name to assign
     */
    public void setCustomerName(String customerName) {
        if (customerName == null || customerName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Name cannot be empty.");
            return;
        }
        this.customerName = customerName;
    }

    /**
     * Assigns a phone number to the customer after validating that it is not empty.
     *
     * @param phoneNumber the phone number to assign
     */
    public void setPhone(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Phone number cannot be empty.");
            return;
        }
        this.customerPhone = phoneNumber;
    }

    /**
     * Updates the total purchased balance, ensuring the value is non-negative.
     *
     * @param purchasedBalance the updated purchase total
     */
    public void setPurchasedBalance(double purchasedBalance) {
        if (purchasedBalance < 0) {
            JOptionPane.showMessageDialog(null, "Purchased balance cannot be negative.");
            return;
        }
        this.purchasedBalance = purchasedBalance;
    }

    /**
     * Updates the loyalty points balance, ensuring the value is non-negative.
     *
     * @param pointsBalance the updated points balance
     */
    public void setPointsBalance(int pointsBalance) {
        if (pointsBalance < 0) {
            JOptionPane.showMessageDialog(null, "Points balance cannot be negative.");
            return;
        }
        this.pointsBalance = pointsBalance;
    }

    // --------------------------------------------------------------
    // Getters
    // --------------------------------------------------------------

    /**
     * @return the unique customer ID
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * @return the customer's full name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @return the customer's phone number
     */
    public String getPhoneNumber() {
        return customerPhone;
    }

    /**
     * @return the customer's loyalty points balance
     */
    public int getPointsBalance() {
        return pointsBalance;
    }

    /**
     * @return the total purchased balance made by the customer
     */
    public double getPurchasedBalance() {
        return purchasedBalance;
    }
}
