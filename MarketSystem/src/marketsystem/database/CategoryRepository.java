package marketsystem.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import marketsystem.Category;

/**
 * @brief Repository class for managing Category entities in the database
 * 
 * This class provides CRUD operations for the Categories table including
 * creating the table, inserting, updating, deleting, and retrieving categories.
 */
public class CategoryRepository {
    
    /**
     * @brief Creates the Categories table if it doesn't exist
     * 
     * Creates a table with columns: category_id (auto-increment primary key),
     * category_name (VARCHAR), and category_description (TEXT).
     * 
     * @return true if the statement executed successfully, false otherwise
     */
    static public boolean createCategoriesTable() {
        final String QUERY = """
                             CREATE TABLE IF NOT EXISTS Categories (
                                category_id INT AUTO_INCREMENT NOT NULL,
                                category_name VARCHAR(255) NOT NULL,
                                category_description TEXT,
                             PRIMARY KEY (category_id)
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
     * @brief Inserts a new category into the database
     * 
     * Ensures the Categories table exists before insertion.
     * 
     * @param category The Category object to insert
     * @return true if the statement executed successfully, false otherwise
     */
    static public boolean insertCategory(Category category) {
        createCategoriesTable();
        
        final String QUERY = """
                             INSERT INTO Categories (
                             category_name,
                             category_description)
                             VALUES(?, ?);
                             """;
        
        try (Connection connection = DriverManager.getConnection(
                DatabaseConnection.DB_URL, 
                DatabaseConnection.USER, 
                DatabaseConnection.PASS); 
             PreparedStatement stmt = connection.prepareStatement(QUERY)) {
            
            stmt.setString(1, category.getCategoryName());
            stmt.setString(2, category.getCategoryDescription());
            boolean res = stmt.execute();
            return res;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @brief Retrieves all categories from the database
     * 
     * @return ArrayList of Category objects, or null if an error occurs
     */
    static public ArrayList<Category> getCategories() {
        final String QUERY = """
                             SELECT 
                             category_id,
                             category_name,
                             category_description
                             FROM Categories;
                             """;
        
        try (Connection connection = DriverManager.getConnection(
                DatabaseConnection.DB_URL, 
                DatabaseConnection.USER, 
                DatabaseConnection.PASS); 
             PreparedStatement stmt = connection.prepareStatement(QUERY)) {
            
            ResultSet category = stmt.executeQuery();
            ArrayList<Category> categories = new ArrayList<>();
            
            while (category.next()) {
                Category categoryObject = new Category();
                categoryObject.setCategoryID(category.getInt("category_id"));
                categoryObject.setCategoryName(category.getString("category_name"));
                categoryObject.setCategoryDescription(category.getString("category_description"));
                categories.add(categoryObject);
            }
            
            return categories;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @brief Retrieves a specific category by its ID
     * 
     * @param category_id The ID of the category to retrieve
     * @return Category object with the specified ID, or null if an error occurs
     * @note Returns an empty Category object if no matching ID is found
     */
    static public Category getCategoryByID(int category_id) {
        final String QUERY = """
                            SELECT 
                            category_id,
                            category_name,
                            category_description
                            FROM categories WHERE category_id = ?;
                            """;
        
        try (Connection connection = DriverManager.getConnection(
                DatabaseConnection.DB_URL, 
                DatabaseConnection.USER, 
                DatabaseConnection.PASS); 
             PreparedStatement stmt = connection.prepareStatement(QUERY)) {
            
            stmt.setInt(1, category_id);
            ResultSet category = stmt.executeQuery();
            Category categoryObject = new Category();
            
            if (category.next()) {
                categoryObject.setCategoryID(category.getInt("category_id"));
                categoryObject.setCategoryName(category.getString("category_name"));
                categoryObject.setCategoryDescription(category.getString("category_description"));
            }
            
            return categoryObject;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @brief Deletes a category from the database
     * 
     * @param category The Category object to delete (uses category_id)
     * @return true if deletion was successful, false otherwise
     */
    static public boolean deleteCategory(Category category) {
        final String QUERY = """
                             DELETE FROM Categories WHERE category_id = ?;
                             """;
        
        try (Connection connection = DriverManager.getConnection(
                DatabaseConnection.DB_URL, 
                DatabaseConnection.USER, 
                DatabaseConnection.PASS); 
             PreparedStatement stmt = connection.prepareStatement(QUERY)) {
            
            stmt.setInt(1, category.getCategoryID());
            int executeQuery = stmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @brief Updates an existing category in the database
     * 
     * Updates the category_name and category_description for the category
     * matching the provided category_id.
     * 
     * @param category The Category object with updated information
     * @return true if update was successful, false otherwise
     */
    static public boolean updateCategory(Category category) {
        final String QUERY = """
                             UPDATE Categories 
                             SET category_name = ?,
                             category_description = ?
                             WHERE category_id = ?;
                             """;
        
        try (Connection connection = DriverManager.getConnection(
                DatabaseConnection.DB_URL, 
                DatabaseConnection.USER, 
                DatabaseConnection.PASS); 
             PreparedStatement stmt = connection.prepareStatement(QUERY)) {
            
            stmt.setString(1, category.getCategoryName());
            stmt.setString(2, category.getCategoryDescription());
            stmt.setInt(3, category.getCategoryID());
            boolean res = stmt.execute();
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}