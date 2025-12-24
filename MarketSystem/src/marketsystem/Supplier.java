package marketsystem;

import javax.swing.JOptionPane;

public class Supplier {

    /** Unique identifier for the supplier */
    private int supplierID;

    /** Name of the supplier */
    private String supplierName;

    /** Contact information of the supplier  */
    private String supplierContact;

    /**
     * Sets the supplier ID.
     * @param id Supplier ID (must be non-negative)
     */
    public void setSupplierID(int id) {
        if (id < 0) {
            JOptionPane.showMessageDialog(null, "ID cannot be negative.");
            return;
        }
        this.supplierID = id;
    }

    /**
     * Sets the supplier name.
     * @param name Supplier name (must not be empty or null)
     */
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Name cannot be empty.");
            return;
        }
        this.supplierName = name;
    }

    /**
     * Sets the supplier contact.
     * @param supplierContact Contact information (must not be empty or null)
     */
    public void setSupplierContact(String supplierContact) {
        if (supplierContact == null || supplierContact.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Supplier contact cannot be empty.");
            return;
        }
        this.supplierContact = supplierContact;
    }

    /**
     * @return Supplier ID
     */
    public int getSupplierID() {
        return supplierID;
    }

    /**
     * @return Supplier name
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * @return Supplier contact information  
     * (Note: returned from the misspelled field 'supplierConatact')
     */
    public String getSupplierContact() {
        return supplierContact;
    }
}
