package marketsystem.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import marketsystem.Customer;

/**
 * @brief Repository class for managing Customer entities in the database
 * 
 * This class provides CRUD operations for the Customers table including
 * creating the table, inserting, updating, deleting, and retrieving customers.
 */
public class CustomerRepository {
    
    /**
     * @brief Creates the Customers table if it doesn't exist
     * 
     * Creates a table with columns: customer_id (auto-increment primary key),
     * customer_name (VARCHAR), customer_phone_number (VARCHAR), 
     * customer_purshased (DOUBLE), and customer_points_balance (INT).
     * 
     * @return true if the statement executed successfully, false otherwise
     */
    static public boolean createCustomersTable() {
        final String QUERY = """
                             CREATE TABLE IF NOT EXISTS Customers (
                                customer_id INT AUTO_INCREMENT NOT NULL,
                                customer_name VARCHAR(255) NOT NULL,
                                customer_phone_number VARCHAR(255) NOT NULL,
                                customer_purshased DOUBLE NOT NULL,
                                customer_points_balance INT NOT NULL,
                             PRIMARY KEY (customer_id)
                             );""";
        
        try (Connection connection = DriverManager.getConnection(
                DatabaseConnection.DB_URL, 
                DatabaseConnection.USER, 
                DatabaseConnection.PASS); 
             Statement stmt = connection.createStatement()) {
            
            boolean res = stmt.execute(QUERY);
            return res;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @brief Inserts a new customer into the database
     * 
     * Ensures the Customers table exists before insertion.
     * 
     * @param customer The Customer object to insert
     * @return true if the statement executed successfully, false otherwise
     */
    static public boolean insertCustomer(Customer customer) {
        createCustomersTable();
        
        final String QUERY = """
                             INSERT INTO Customers (
                             customer_name,
                             customer_phone_number,
                             customer_purshased,
                             customer_points_balance
                             )
                             VALUES(?, ?, ?, ?);
                             """;
        
        try (Connection connection = DriverManager.getConnection(
                DatabaseConnection.DB_URL, 
                DatabaseConnection.USER, 
                DatabaseConnection.PASS); 
             PreparedStatement stmt = connection.prepareStatement(QUERY)) {
            
            stmt.setString(1, customer.getCustomerName());
            stmt.setString(2, customer.getPhoneNumber());
            stmt.setDouble(3, customer.getPurchasedBalance());
            stmt.setInt(4, customer.getPointsBalance());
            boolean res = stmt.execute();
            return res;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @brief Retrieves all customers from the database
     * 
     * @return ArrayList of Customer objects, or null if an error occurs
     */
    static public ArrayList<Customer> getCustomers() {
        final String QUERY = """
                            SELECT 
                            customer_id,
                            customer_name,
                            customer_phone_number,
                            customer_purshased,
                            customer_points_balance
                             FROM Customers;
                             """;
        
        try (Connection connection = DriverManager.getConnection(
                DatabaseConnection.DB_URL, 
                DatabaseConnection.USER, 
                DatabaseConnection.PASS); 
             PreparedStatement stmt = connection.prepareStatement(QUERY)) {
            
            ResultSet customer = stmt.executeQuery();
            ArrayList<Customer> customers = new ArrayList<>();
            
            while (customer.next()) {
                Customer customerObject = new Customer();
                customerObject.setCustomerID(customer.getInt("customer_id"));
                customerObject.setCustomerName(customer.getString("customer_name"));
                customerObject.setPhone(customer.getString("customer_phone_number"));
                customerObject.setPurchasedBalance(customer.getDouble("customer_purshased"));
                customerObject.setPointsBalance(customer.getInt("customer_points_balance"));
                customers.add(customerObject);
            }
            
            return customers;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @brief Retrieves a specific customer by their ID
     * 
     * @param customer_id The ID of the customer to retrieve
     * @return Customer object with the specified ID, or null if an error occurs
     * @note Returns an empty Customer object if no matching ID is found
     */
    static public Customer getCustomerByID(int customer_id) {
        final String QUERY = """
                        SELECT 
                        customer_id,
                        customer_name,
                        customer_phone_number,
                        customer_purshased,
                        customer_points_balance
                        FROM Customers WHERE customer_id = ?;
                        """;
        
        try (Connection connection = DriverManager.getConnection(
                DatabaseConnection.DB_URL, 
                DatabaseConnection.USER, 
                DatabaseConnection.PASS); 
             PreparedStatement stmt = connection.prepareStatement(QUERY)) {
            
            stmt.setInt(1, customer_id);
            ResultSet customer = stmt.executeQuery();
            Customer customerObject = new Customer();
            
            if (customer.next()) {
                customerObject.setCustomerID(customer.getInt("customer_id"));
                customerObject.setCustomerName(customer.getString("customer_name"));
                customerObject.setPhone(customer.getString("customer_phone_number"));
                customerObject.setPurchasedBalance(customer.getDouble("customer_purshased"));
                customerObject.setPointsBalance(customer.getInt("customer_points_balance"));
            }
            
            return customerObject;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @brief Deletes a customer from the database
     * 
     * @param customer The Customer object to delete (uses customer_id)
     * @return true if deletion was successful, false otherwise
     */
    static public boolean deleteCustomer(Customer customer) {
        final String QUERY = """
                             DELETE FROM Customers WHERE customer_id = ?;
                             """;
        
        try (Connection connection = DriverManager.getConnection(
                DatabaseConnection.DB_URL, 
                DatabaseConnection.USER, 
                DatabaseConnection.PASS); 
             PreparedStatement stmt = connection.prepareStatement(QUERY)) {
            
            stmt.setInt(1, customer.getCustomerID());
            int executeQuery = stmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @brief Updates an existing customer in the database
     * 
     * Updates all customer fields (name, phone number, purchased balance, 
     * and points balance) for the customer matching the provided customer_id.
     * 
     * @param customer The Customer object with updated information
     * @return true if update was successful, false otherwise
     */
    static public boolean updateCustomer(Customer customer) {
        final String QUERY = """
                             UPDATE Customers 
                             SET customer_name = ?,
                             customer_phone_number = ?,
                             customer_purshased = ?,
                             customer_points_balance = ?
                             WHERE customer_id = ?;
                             """;
        
        try (Connection connection = DriverManager.getConnection(
                DatabaseConnection.DB_URL, 
                DatabaseConnection.USER, 
                DatabaseConnection.PASS); 
             PreparedStatement stmt = connection.prepareStatement(QUERY)) {
            
            stmt.setString(1, customer.getCustomerName());
            stmt.setString(2, customer.getPhoneNumber());
            stmt.setDouble(3, customer.getPurchasedBalance());
            stmt.setInt(4, customer.getPointsBalance());
            stmt.setInt(5, customer.getCustomerID());
            boolean res = stmt.execute();
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}