package marketsystem;

import javax.swing.JOptionPane;

/**
 * Represents a product category in the market system.
 * Provides controlled access to category attributes with basic validation.
 */
public class Category {

    // --------------------------------------------------------------
    // Fields
    // --------------------------------------------------------------

    /** Unique identifier for the category. */
    private int categoryID;

    /** Name of the category (e.g., "Electronics"). */
    private String categoryName;

    /** Description explaining the category purpose. */
    private String categoryDescription;

    // --------------------------------------------------------------
    // Setters
    // --------------------------------------------------------------

    /**
     * Updates the category name after validating it is not empty.
     *
     * @param categoryName name to assign
     */
    public void setCategoryName(String categoryName) {
        if (categoryName == null || categoryName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Category name cannot be empty.");
            return;
        }
        this.categoryName = categoryName;
    }

    /**
     * Updates the category description after validating it is not empty.
     *
     * @param categoryDescription description to assign
     */
    public void setCategoryDescription(String categoryDescription) {
        if (categoryDescription == null || categoryDescription.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Category description cannot be empty.");
            return;
        }
        this.categoryDescription = categoryDescription;
    }

    /**
     * Updates the category ID only if it is non-negative.
     *
     * @param categoryID the unique identifier
     */
    public void setCategoryID(int categoryID) {
        if (categoryID < 0) {
            JOptionPane.showMessageDialog(null, "ID cannot be negative.");
            return;
        }
        this.categoryID = categoryID;
    }

    // --------------------------------------------------------------
    // Getters
    // --------------------------------------------------------------

    /**
     * @return the category name
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @return the category description
     */
    public String getCategoryDescription() {
        return categoryDescription;
    }

    /**
     * @return the unique category ID
     */
    public int getCategoryID() {
        return categoryID;
    }
}
