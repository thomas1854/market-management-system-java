package marketsystem;

import java.util.*;
import java.time.LocalDate;

public class Receipt {

    /** Receipt unique identifier */
    private int receiptId;

    /** Customer who made this receipt */
    private Customer customer;

    /** Products purchased with cash (Product → quantity) */
    private HashMap<Product, Integer> productPurchasedCash;

    /** Products purchased with points (Product → quantity) */
    private HashMap<Product, Integer> productPurchasedPoints;

    /** Year of receipt creation */
    private int year;

    /** Month of receipt creation */
    private int month;

    /** Day of receipt creation */
    private int day;

    /** Total cash cost for this receipt */
    private double totalCost;

    /** Total loyalty points earned from cash purchases */
    private int earnedPoints;

    /** Total loyalty points spent on point purchases */
    private int spentPoints;

    /**
     * @return total cost of the receipt
     */
    public double getTotalCost() {
        return totalCost;
    }

    /**
     * @return total points earned from this receipt
     */
    public int getEarnedPoints() {
        return earnedPoints;
    }

    /**
     * @return points spent for point-based purchases
     */
    public int getSpentPoints() {
        return spentPoints;
    }

    /**
     * @return map of products purchased with cash
     */
    public HashMap<Product, Integer> getProductPurchasedCash() {
        return productPurchasedCash;
    }

    /**
     * Sets the cash-purchased products map.
     * @param productPurchasedCash new map of purchased products
     */
    public void setProductPurchasedCash(HashMap<Product, Integer> productPurchasedCash) {
        this.productPurchasedCash = productPurchasedCash;
    }

    /**
     * @return map of products purchased with loyalty points
     */
    public HashMap<Product, Integer> getProductPurchasedPoints() {
        return productPurchasedPoints;
    }

    /**
     * Sets the point-purchased products map.
     * @param productPurchasedPoints new map of purchased products
     */
    public void setProductPurchasedPoints(HashMap<Product, Integer> productPurchasedPoints) {
        this.productPurchasedPoints = productPurchasedPoints;
    }

    /**
     * Constructor initializes date and purchase lists.
     */
    public Receipt()
    {
        year = LocalDate.now().getYear();
        month = LocalDate.now().getMonthValue();
        day = LocalDate.now().getDayOfMonth();
        productPurchasedCash = new HashMap<>();
        productPurchasedPoints = new HashMap<>();
    }

    /**
     * Sets the receipt ID.
     * @param receiptId ID value (must be non-negative)
     */
    public void setReceiptId(int receiptId)
    {
        if (receiptId < 0)
        {
            System.out.println("ID cannot be less than zero.");
            return;
        }
        this.receiptId = receiptId;
    }

    /**
     * @return receipt ID
     */
    public int getReceiptId() {
        return receiptId;
    }

    /**
     * Adds a product to the cash purchase list.
     * If product exists, increments its quantity.
     * @param product product purchased using cash
     */
    public void addProductCash(Product product) {
        if (productPurchasedCash.containsKey(product)) {
            productPurchasedCash.put(product, productPurchasedCash.get(product) + 1);
        } else {
            productPurchasedCash.put(product, 1);
        }
    }

    /**
     * Adds a product to the points purchase list.
     * If product exists, increments its quantity.
     * @param product product purchased using points
     */
    public void addProductPoints(Product product) {
        if (productPurchasedPoints.containsKey(product)) {
            productPurchasedPoints.put(product, productPurchasedPoints.get(product) + 1);
        } else {
            productPurchasedPoints.put(product, 1);
        }
    }

    /**
     * @return products purchased by cash
     */
    public Map<Product, Integer> getProductsByCash() {
        return productPurchasedCash;
    }

    /**
     * Calculates total cost of cash-purchased products.
     * @return total cost in money
     */
    public double getTotalProductsCashCost() {
        double total = 0;
        for (Product p : productPurchasedCash.keySet()) {
            total += p.getPrice() * productPurchasedCash.get(p);
        }
        return total;
    }

    /**
     * Sets products purchased with points.
     * @param productsByPoints map of products
     */
    public void setProductsPoints(HashMap<Product, Integer> productsByPoints) {
        this.productPurchasedPoints = productsByPoints;
    }

    /**
     * @return products purchased using points
     */
    public Map<Product, Integer> getProductsPoints() {
        return productPurchasedPoints;
    }

    /**
     * Computes total points earned from all cash purchases.
     * @return earned points
     */
    public int getTotalPointsEarned() {
        int total = 0;
        for (Product p : productPurchasedCash.keySet()) {
            total += p.getPurchasingPoints() * productPurchasedCash.get(p);
        }
        return total;
    }

    /**
     * Computes total points spent on point purchases.
     * @return spent points
     */
    public int getTotalPointsSpent() {
        int total = 0;
        for (Product p : productPurchasedPoints.keySet()) {
            total += p.getProductSellingPoints() * productPurchasedPoints.get(p);
        }
        return total;
    }

    /** @return receipt year */
    public int getYear() { return year; }

    /** @return receipt month */
    public int getMonth() { return month; }

    /** @return receipt day */
    public int getDay() { return day; }

    /**
     * Assigns customer to receipt.
     * @param customer customer object (must not be null)
     */
    public void setCustomer(Customer customer)
    {
        if (customer == null)
        {
            System.out.println("Customer cannot be null");
            return;
        }
        this.customer = customer;
    }

    /**
     * @return customer linked to the receipt
     */
    public Customer getCustomer()
    {
        return customer;
    }

    /** @param year sets receipt year */
    public void setYear(int year) { this.year = year; }

    /** @param month sets receipt month */
    public void setMonth(int month) { this.month = month; }

    /** @param day sets receipt day */
    public void setDay(int day) { this.day = day; }

    /** @param totalCost sets total cost of the receipt */
    public void setTotalCost(double totalCost) { this.totalCost = totalCost; }

    /** @param earnedPoints sets earned points */
    public void setEarnedPoints(int earnedPoints) { this.earnedPoints = earnedPoints; }

    /** @param spentPoints sets spent points */
    public void setSpentPoints(int spentPoints) { this.spentPoints = spentPoints; }
}
