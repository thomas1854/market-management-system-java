package marketsystem.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import marketsystem.Customer;
import marketsystem.Product;
import marketsystem.Receipt;

/**
 * @brief Repository class for managing Receipt entities in the database
 *
 * This class provides CRUD operations for the Receipts table including creating
 * the table, inserting, deleting, and retrieving receipts. Handles complex
 * receipt transactions including receipt items and customer updates.
 */
public class ReceiptRepository {

    /**
     * @brief Creates the Receipts table if it doesn't exist
     *
     * Creates a table with columns: receipt_id (auto-increment primary key),
     * customer_id, total_price, expended_points, earned_points, year, month,
     * and day.
     *
     * @return true if the statement executed successfully, false otherwise
     */
    static public boolean createReceiptsTable() {
        final String QUERY = """
                             CREATE TABLE IF NOT EXISTS Receipts (
                                receipt_id INT AUTO_INCREMENT NOT NULL,
                                customer_id INT NOT NULL,
                                total_price DOUBLE NOT NULL,
                                expended_points INT NOT NULL,
                                earned_points INT NOT NULL,
                                year INT NOT NULL,
                                month INT NOT NULL,
                                day INT NOT NULL,
                             PRIMARY KEY (receipt_id),
                             FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
                             );""";

        try (Connection connection = DriverManager.getConnection(
                DatabaseConnection.DB_URL,
                DatabaseConnection.USER,
                DatabaseConnection.PASS); Statement stmt = connection.createStatement()) {

            boolean res = stmt.execute(QUERY);
            return res;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @brief Inserts a new receipt into the database with associated items
     *
     * Ensures the Receipts table exists before insertion. Also inserts
     * associated receipt items (products purchased with cash and points) and
     * updates the customer's points balance and purchase history.
     *
     * @param receipt The Receipt object to insert
     * @return true if insertion was successful, false otherwise
     */
    static public boolean insertReceipt(Receipt receipt) {
        createReceiptsTable();

        final String QUERY = """
                             INSERT INTO Receipts(
                             customer_id,
                             total_price,
                             expended_points,
                             earned_points,
                             year,
                             month,
                             day
                             )
                             VALUES(?, ?, ?, ?, ?, ?, ?);
                             """;

        try (Connection connection = DriverManager.getConnection(
                DatabaseConnection.DB_URL,
                DatabaseConnection.USER,
                DatabaseConnection.PASS); PreparedStatement stmt = connection.prepareStatement(QUERY, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, receipt.getCustomer().getCustomerID());
            stmt.setDouble(2, receipt.getTotalProductsCashCost());
            stmt.setInt(3, receipt.getTotalPointsSpent());
            stmt.setInt(4, receipt.getTotalPointsEarned());
            stmt.setInt(5, receipt.getYear());
            stmt.setInt(6, receipt.getMonth());
            stmt.setInt(7, receipt.getDay());

            int res = stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                ReceiptItemsRepository.createReceiptItemsTable();

                // Insert products purchased with cash
                for (Product product : receipt.getProductsByCash().keySet()) {
                    ReceiptItemsRepository.insertReceiptItem(
                            rs.getInt(1),
                            product.getProductID(),
                            product.getPrice(),
                            0,
                            receipt.getProductPurchasedCash().get(product)
                    );
                }

                // Insert products purchased with points
                for (Product product : receipt.getProductsPoints().keySet()) {
                    ReceiptItemsRepository.insertReceiptItem(
                            rs.getInt(1),
                            product.getProductID(),
                            0,
                            product.getProductSellingPoints(),
                            receipt.getProductsPoints().get(product)
                    );
                }
            }

            // Update customer balance and purchase history
            Customer modifiedCustomer = CustomerRepository.getCustomerByID(receipt.getCustomer().getCustomerID());
            modifiedCustomer.setPointsBalance(modifiedCustomer.getPointsBalance() + receipt.getTotalPointsEarned());
            modifiedCustomer.setPointsBalance(modifiedCustomer.getPointsBalance() - receipt.getTotalPointsSpent());
            modifiedCustomer.setPurchasedBalance(modifiedCustomer.getPurchasedBalance() + receipt.getTotalProductsCashCost());
            CustomerRepository.updateCustomer(modifiedCustomer);

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @brief Retrieves all receipts from the database
     *
     * Fetches complete receipt information including associated customer and
     * receipt items via foreign key lookups.
     *
     * @return ArrayList of Receipt objects, or null if an error occurs
     */
    static public ArrayList<Receipt> getReceipts() {
        final String QUERY = """
                            SELECT * FROM Receipts, Customers WHERE customers.customer_id = receipts.customer_id;
                            """;

        try (Connection connection = DriverManager.getConnection(
                DatabaseConnection.DB_URL,
                DatabaseConnection.USER,
                DatabaseConnection.PASS); PreparedStatement stmt = connection.prepareStatement(QUERY)) {

            ResultSet receipt = stmt.executeQuery();
            ArrayList<Receipt> receipts = new ArrayList<>();

            while (receipt.next()) {
                Receipt receiptObject = new Receipt();
                receiptObject.setReceiptId(receipt.getInt("receipt_id"));
                Customer customer = new Customer();
                customer.setCustomerID(receipt.getInt("customer_id"));
                customer.setCustomerName(receipt.getString("customer_name"));
                customer.setPhone(receipt.getString("customer_phone_number"));
                receiptObject.setCustomer(customer);
                receiptObject.setTotalCost(receipt.getDouble("total_price"));
                receiptObject.setSpentPoints(receipt.getInt("expended_points"));
                receiptObject.setEarnedPoints(receipt.getInt("earned_points"));
                receiptObject.setYear(receipt.getInt("year"));
                receiptObject.setMonth(receipt.getInt("month"));
                receiptObject.setDay(receipt.getInt("day"));
                receipts.add(receiptObject);
            }

            return receipts;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @brief Retrieves a specific receipt by its ID
     *
     * Fetches complete receipt information including associated customer and
     * receipt items via foreign key lookups.
     *
     * @param receipt_id The ID of the receipt to retrieve
     * @return Receipt object with the specified ID, or null if an error occurs
     * @note Returns an empty Receipt object if no matching ID is found
     */
    static public Receipt getReceiptByID(int receipt_id) {
        final String QUERY = """
                    SELECT 
                    receipt_id,
                    customer_id,
                    total_price,
                    expended_points,
                    earned_points,
                    year,
                    month,
                    day
                    FROM Receipts WHERE receipt_id = ?;
                        """;

        try (Connection connection = DriverManager.getConnection(
                DatabaseConnection.DB_URL,
                DatabaseConnection.USER,
                DatabaseConnection.PASS); PreparedStatement stmt = connection.prepareStatement(QUERY)) {

            stmt.setInt(1, receipt_id);
            ResultSet receipt = stmt.executeQuery();
            Receipt receiptObject = new Receipt();

            if (receipt.next()) {
                receiptObject.setReceiptId(receipt.getInt("receipt_id"));
                receiptObject.setCustomer(CustomerRepository.getCustomerByID(receipt.getInt("customer_id")));
                receiptObject.setTotalCost(receipt.getDouble("total_price"));
                receiptObject.setSpentPoints(receipt.getInt("expended_points"));
                receiptObject.setEarnedPoints(receipt.getInt("earned_points"));
                receiptObject.setYear(receipt.getInt("year"));
                receiptObject.setMonth(receipt.getInt("month"));
                receiptObject.setDay(receipt.getInt("day"));
                receiptObject.setProductPurchasedCash(ReceiptItemsRepository.getRecieptCashPurchasedProducts(receipt.getInt("receipt_id")));
                receiptObject.setProductPurchasedPoints(ReceiptItemsRepository.getRecieptPointsPurchasedProducts(receipt.getInt("receipt_id")));
            }

            return receiptObject;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @brief Deletes a receipt from the database
     *
     * @param receipt The Receipt object to delete (uses receipt_id)
     * @return true if deletion was successful, false otherwise
     * @warning Does not cascade delete associated receipt items or revert
     * customer balances
     */
    static public boolean deleteReceipt(Receipt receipt) {
        final String QUERY = """
                             DELETE FROM Receipts WHERE receipt_id = ?;
                             """;

        try (Connection connection = DriverManager.getConnection(
                DatabaseConnection.DB_URL,
                DatabaseConnection.USER,
                DatabaseConnection.PASS); PreparedStatement stmt = connection.prepareStatement(QUERY)) {

            stmt.setInt(1, receipt.getReceiptId());
            int executeQuery = stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
