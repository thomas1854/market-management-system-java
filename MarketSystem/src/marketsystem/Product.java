package marketsystem;

import javax.swing.JOptionPane;

/**
 * Represents a product in the market system.
 * Encapsulates product identity, pricing, stock limits,
 * points system, supplier and category relationships.
 */
public class Product {

    // --------------------------------------------------------------
    // Fields
    // --------------------------------------------------------------

    /** Name of the product (e.g., "Milk", "Laptop"). */
    private String name;

    /** Detailed description of the product. */
    private String productDescription;

    /** Supplier that provides this product. */
    private Supplier supplier;

    /** Category to which this product belongs. */
    private Category category;

    /** Price of a single unit of the product. */
    private double productPrice;

    /** Quantity available in stock. */
    private int productQuantity;

    /** Unique identifier for the product. */
    private int productID;

    /** Points awarded to customer when purchasing this product. */
    private int sellingPoints;

    /** Points required to redeem this product (if applicable). */
    private int purchasingPoints;

    /** Upper stock limit before the product is considered overstocked. */
    private int overStockLimit;

    /** Lower stock limit before the product is considered understocked. */
    private int underStockLimit;

    // --------------------------------------------------------------
    // Constructor
    // --------------------------------------------------------------

    /**
     * Initializes a product with default values.
     * This prevents null issues when creating products in UI forms.
     */
    public Product() {
        this.name = "";
        this.productDescription = "";
        this.category = null;
        this.productPrice = 0.0;
        this.productQuantity = 0;
        this.productID = 0;
        this.sellingPoints = 0;
        this.purchasingPoints = 0;
        this.overStockLimit = 0;
        this.underStockLimit = 0;
    }

    // --------------------------------------------------------------
    // Getters and Setters
    // --------------------------------------------------------------

    /** @return the product ID */
    public int getProductID() {
        return productID;
    }

    /**
     * Sets the product ID if non-negative.
     *
     * @param productID unique product identifier
     */
    public void setProductID(int productID) {
        if (productID < 0) {
            JOptionPane.showMessageDialog(null, "ID cannot be negative.");
            return;
        }
        this.productID = productID;
    }

    /** @return current stock quantity */
    public int getProductQuantity() {
        return productQuantity;
    }

    /**
     * Updates stock quantity ensuring it is not negative.
     *
     * @param productQuantity available product count
     */
    public void setProductQuantity(int productQuantity) {
        if (productQuantity < 0) {
            JOptionPane.showMessageDialog(null, "Quantity cannot be negative.");
            return;
        }
        this.productQuantity = productQuantity;
    }

    /** @return product price */
    public double getPrice() {
        return productPrice;
    }

    /**
     * Sets the product price ensuring it is not negative.
     *
     * @param productPrice unit price
     */
    public void setProductPrice(double productPrice) {
        if (productPrice < 0) {
            JOptionPane.showMessageDialog(null, "Price cannot be negative.");
            return;
        }
        this.productPrice = productPrice;
    }

    /** @return the selling points value */
    public int getProductSellingPoints() {
        return sellingPoints;
    }

    /**
     * Sets the selling points ensuring valid value.
     *
     * @param sellingPoints points needed to buy
     */
    public void setProductSellingPoints(int sellingPoints) {
        if (sellingPoints < 0) {
            JOptionPane.showMessageDialog(null, "Points Price cannot be negative.");
            return;
        }
        this.sellingPoints = sellingPoints;
    }

    /** @return points earned on purchase */
    public int getPurchasingPoints() {
        return purchasingPoints;
    }

    /**
     * Sets the points earned when buying this product.
     *
     * @param purchasingPoints earned points
     */
    public void setPurchasingPoints(int purchasingPoints) {
        if (purchasingPoints < 0) {
            JOptionPane.showMessageDialog(null, "Giving Points cannot be negative.");
            return;
        }
        this.purchasingPoints = purchasingPoints;
    }

    /** @return overstock limit */
    public int getOverstockLimit() {
        return overStockLimit;
    }

    /**
     * Sets limit beyond which stock is considered excessive.
     *
     * @param overStockLimit limit value
     */
    public void setOverstockLimit(int overStockLimit) {
        if (overStockLimit < 0) {
            JOptionPane.showMessageDialog(null, "Overstock Limit cannot be negative.");
            return;
        }
        this.overStockLimit = overStockLimit;
    }

    /** @return understock limit */
    public int getUnderstockLimit() {
        return underStockLimit;
    }

    /**
     * Sets lower stock threshold before shortage alert.
     *
     * @param underStockLimit limit value
     */
    public void setUnderstockLimit(int underStockLimit) {
        if (underStockLimit < 0) {
            JOptionPane.showMessageDialog(null, "Understock Limit cannot be negative.");
            return;
        }
        this.underStockLimit = underStockLimit;
    }

    /** @return product name */
    public String getName() {
        return name;
    }

    /**
     * Sets product name ensuring non-empty value.
     *
     * @param name product name
     */
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Name cannot be empty.");
            return;
        }
        this.name = name;
    }

    /** @return supplier object */
    public Supplier getSupplier() {
        return supplier;
    }

    /**
     * Assigns supplier ensuring it is not null.
     *
     * @param supplier supplier entity
     */
    public void setSupplier(Supplier supplier) {
        if (supplier == null) {
            JOptionPane.showMessageDialog(null, "Supplier cannot be empty.");
            return;
        }
        this.supplier = supplier;
    }

    /** @return product description */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * Sets product description ensuring non-empty value.
     *
     * @param productDescription description details
     */
    public void setProductDescription(String productDescription) {
        if (productDescription == null || productDescription.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Description cannot be empty.");
            return;
        }
        this.productDescription = productDescription;
    }

    /** Assigns a category ensuring it is not null
     * @param category */
    public void setCategory(Category category) {
        
        if (category == null) {
            JOptionPane.showMessageDialog(null, "Category cannot be empty.");
            return;
        }
        this.category = category;
    }

    /** @return assigned category or null */
    public Category getCategory() {
        return category;
    }

    // --------------------------------------------------------------
    // Equality & Hashing
    // --------------------------------------------------------------

    /**
     * Products are considered equal if they share the same ID.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Product product = (Product) obj;
        return productID == product.productID;
    }

    /**
     * Hash code based solely on the product ID.
     * @return hash code 
     */
    @Override
    public int hashCode() {
        return Integer.hashCode(productID);
    }
}
