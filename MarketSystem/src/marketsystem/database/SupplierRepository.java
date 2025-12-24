package marketsystem.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import marketsystem.Supplier;

/**
 * @brief Repository class for managing Supplier entities in the database
 * 
 * This class provides CRUD operations for the Suppliers table including
 * creating the table, inserting, updating, deleting, and retrieving suppliers.
 */
public class SupplierRepository {
    
    /**
     * @brief Creates the Suppliers table if it doesn't exist
     * 
     * Creates a table with columns: supplier_id (auto-increment primary key),
     * supplier_name (VARCHAR), and supplier_contact (VARCHAR).
     * 
     * @return true if the statement executed successfully, false otherwise
     */
    static public boolean createSuppliersTable() {
        final String QUERY = """
                             CREATE TABLE IF NOT EXISTS Suppliers (
                                supplier_id INT AUTO_INCREMENT NOT NULL,
                                supplier_name VARCHAR(255),
                                supplier_contact VARCHAR(255),
                             PRIMARY KEY (supplier_id)
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
     * @brief Inserts a new supplier into the database
     * 
     * Ensures the Suppliers table exists before insertion.
     * 
     * @param supplier The Supplier object to insert
     * @return true if the statement executed successfully, false otherwise
     */
    static public boolean insertSupplier(Supplier supplier) {
        createSuppliersTable();
        
        final String QUERY = """
                             INSERT INTO Suppliers (
                             supplier_name,
                             supplier_contact)
                             VALUES(?, ?);
                             """;
        
        try (Connection connection = DriverManager.getConnection(
                DatabaseConnection.DB_URL, 
                DatabaseConnection.USER, 
                DatabaseConnection.PASS); 
             PreparedStatement stmt = connection.prepareStatement(QUERY)) {
            
            stmt.setString(1, supplier.getSupplierName());
            stmt.setString(2, supplier.getSupplierContact());
            boolean res = stmt.execute();
            return res;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @brief Retrieves all suppliers from the database
     * 
     * @return ArrayList of Supplier objects, or null if an error occurs
     */
    static public ArrayList<Supplier> getSuppliers() {
        final String QUERY = """
                             SELECT 
                             supplier_id,
                             supplier_name,
                             supplier_contact
                             FROM Suppliers;
                             """;
        
        try (Connection connection = DriverManager.getConnection(
                DatabaseConnection.DB_URL, 
                DatabaseConnection.USER, 
                DatabaseConnection.PASS); 
             PreparedStatement stmt = connection.prepareStatement(QUERY)) {
            
            ResultSet supplier = stmt.executeQuery();
            ArrayList<Supplier> suppliers = new ArrayList<>();
            
            while (supplier.next()) {
                Supplier supplierObject = new Supplier();
                supplierObject.setSupplierID(supplier.getInt("supplier_id"));
                supplierObject.setName(supplier.getString("supplier_name"));
                supplierObject.setSupplierContact(supplier.getString("supplier_contact"));
                suppliers.add(supplierObject);
            }
            
            return suppliers;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @brief Retrieves a specific supplier by their ID
     * 
     * @param supplier_id The ID of the supplier to retrieve
     * @return Supplier object with the specified ID, or null if an error occurs
     * @note Returns an empty Supplier object if no matching ID is found
     */
    static public Supplier getSupplierByID(int supplier_id) {
        final String QUERY = """
                            SELECT 
                            supplier_id,
                            supplier_name,
                            supplier_contact
                            FROM Suppliers WHERE supplier_id = ?;
                            """;
        
        try (Connection connection = DriverManager.getConnection(
                DatabaseConnection.DB_URL, 
                DatabaseConnection.USER, 
                DatabaseConnection.PASS); 
             PreparedStatement stmt = connection.prepareStatement(QUERY)) {
            
            stmt.setInt(1, supplier_id);
            Supplier supplierObject = new Supplier();
            ResultSet supplier = stmt.executeQuery();
            
            if (supplier.next()) {
                supplierObject.setSupplierID(supplier.getInt("supplier_id"));
                supplierObject.setName(supplier.getString("supplier_name"));
                supplierObject.setSupplierContact(supplier.getString("supplier_contact"));
            }
            
            return supplierObject;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @brief Deletes a supplier from the database
     * 
     * @param supplier The Supplier object to delete (uses supplier_id)
     * @return true if deletion was successful, false otherwise
     */
    static public boolean deleteSupplier(Supplier supplier) {
        final String QUERY = """
                             DELETE FROM Suppliers WHERE supplier_id = ?;
                             """;
        
        try (Connection connection = DriverManager.getConnection(
                DatabaseConnection.DB_URL, 
                DatabaseConnection.USER, 
                DatabaseConnection.PASS); 
             PreparedStatement stmt = connection.prepareStatement(QUERY)) {
            
            stmt.setInt(1, supplier.getSupplierID());
            int executeQuery = stmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @brief Updates an existing supplier in the database
     * 
     * Updates the supplier_name and supplier_contact for the supplier
     * matching the provided supplier_id.
     * 
     * @param supplier The Supplier object with updated information
     * @return true if update was successful, false otherwise
     */
    static public boolean updateSupplier(Supplier supplier) {
        final String QUERY = """
                             UPDATE Suppliers 
                             SET supplier_name = ?,
                             supplier_contact = ?
                             WHERE supplier_id = ?;
                             """;
        
        try (Connection connection = DriverManager.getConnection(
                DatabaseConnection.DB_URL, 
                DatabaseConnection.USER, 
                DatabaseConnection.PASS); 
             PreparedStatement stmt = connection.prepareStatement(QUERY)) {
            
            stmt.setString(1, supplier.getSupplierName());
            stmt.setString(2, supplier.getSupplierContact());
            stmt.setInt(3, supplier.getSupplierID());
            boolean res = stmt.execute();
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}