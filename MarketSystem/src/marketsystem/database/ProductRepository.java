package marketsystem.database;

import java.sql.*;
import java.util.ArrayList;

import marketsystem.Product;

/**
 * @brief Repository class for managing Product entities in the database
 * 
 * This class provides CRUD operations for the Products table including
 * creating the table, inserting, updating, deleting, and retrieving products.
 * Products are linked to suppliers and categories via foreign keys.
 */
public class ProductRepository {

    /**
     * @brief Creates the Products table if it doesn't exist
     * 
     * Creates a table with columns: product_id (auto-increment primary key),
     * product_name, product_supplier_id, product_price, product_category_id,
     * product_quantity, product_purchase_points, product_selling_points,
     * overstock_limit, understock_limit, and product_description.
     * 
     * @return true if the statement executed successfully, false otherwise
     */
    static public boolean createProductsTable() {
        final String QUERY = """
                             CREATE TABLE IF NOT EXISTS Products (
                                product_id INT AUTO_INCREMENT NOT NULL,
                                product_name VARCHAR(255) NOT NULL,
                                product_supplier_id INT NOT NULL,
                                product_price DOUBLE NOT NULL,
                                product_category_id INT NOT NULL,
                                product_quantity INT NOT NULL,
                                product_purchase_points INT NOT NULL,
                                product_selling_points INT NOT NULL,
                                overstock_limit INT NOT NULL,
                                understock_limit INT NOT NULL,
                                product_description TEXT,
                             PRIMARY KEY(product_id),
                             FOREIGN KEY (product_supplier_id) REFERENCES Suppliers(supplier_id),
                             FOREIGN KEY (product_category_id) REFERENCES Categories(category_id)
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
     * @brief Inserts a new product into the database
     * 
     * Ensures the Products table exists before insertion.
     * 
     * @param product The Product object to insert
     * @return true if the statement executed successfully, false otherwise
     */
    static public boolean insertProduct(Product product) {
        createProductsTable();
        
        final String QUERY = """
                             INSERT INTO Products (
                             product_name,
                             product_supplier_id,
                             product_price,
                             product_category_id,
                             product_quantity,
                             product_purchase_points,
                             product_selling_points,
                             overstock_limit,
                             understock_limit,
                             product_description)
                             VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
                             """;
        
        try (Connection connection = DriverManager.getConnection(
                DatabaseConnection.DB_URL, 
                DatabaseConnection.USER, 
                DatabaseConnection.PASS); 
             PreparedStatement stmt = connection.prepareStatement(QUERY)) {
            
            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getSupplier().getSupplierID());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getCategory().getCategoryID());
            stmt.setInt(5, product.getProductQuantity());
            stmt.setInt(6, product.getPurchasingPoints());
            stmt.setInt(7, product.getProductSellingPoints());
            stmt.setInt(8, product.getOverstockLimit());
            stmt.setInt(9, product.getUnderstockLimit());
            stmt.setString(10, product.getProductDescription());
            boolean res = stmt.execute();
            return res;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @brief Retrieves all products from the database
     * 
     * Fetches complete product information including associated supplier
     * and category objects via foreign key lookups.
     * 
     * @return ArrayList of Product objects, or null if an error occurs
     */
    static public ArrayList<Product> getProducts() {
        final String QUERY = """
                             SELECT 
                             product_id,
                             product_name,
                             product_supplier_id,
                             product_price,
                             product_category_id,
                             product_quantity,
                             product_purchase_points,
                             product_selling_points,
                             overstock_limit,
                             understock_limit,
                             product_description 
                             FROM Products;
                             """;
        
        try (Connection connection = DriverManager.getConnection(
                DatabaseConnection.DB_URL, 
                DatabaseConnection.USER, 
                DatabaseConnection.PASS); 
             PreparedStatement stmt = connection.prepareStatement(QUERY)) {
            
            ResultSet product = stmt.executeQuery();
            ArrayList<Product> products = new ArrayList<>();
            
            while (product.next()) {
                Product productObject = new Product();
                productObject.setProductID(product.getInt("product_id"));
                productObject.setName(product.getString("product_name"));
                productObject.setSupplier(SupplierRepository.getSupplierByID(product.getInt("product_supplier_id")));
                productObject.setProductPrice(product.getDouble("product_price"));
                productObject.setCategory(CategoryRepository.getCategoryByID(product.getInt("product_category_id")));
                productObject.setProductQuantity(product.getInt("product_quantity"));
                productObject.setPurchasingPoints(product.getInt("product_purchase_points"));
                productObject.setProductSellingPoints(product.getInt("product_selling_points"));
                productObject.setOverstockLimit(product.getInt("overstock_limit"));
                productObject.setUnderstockLimit(product.getInt("understock_limit"));
                productObject.setProductDescription(product.getString("product_description"));
                products.add(productObject);
            }

            return products;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @brief Retrieves a specific product by its ID
     * 
     * Fetches complete product information including associated supplier
     * and category objects via foreign key lookups.
     * 
     * @param product_id The ID of the product to retrieve
     * @return Product object with the specified ID, or null if an error occurs
     * @note Returns an empty Product object if no matching ID is found
     */
    static public Product getProductByID(int product_id) {
        final String QUERY = """
                             SELECT 
                             product_id,
                             product_name,
                             product_supplier_id,
                             product_price,
                             product_category_id,
                             product_quantity,
                             product_purchase_points,
                             product_selling_points,
                             overstock_limit,
                             understock_limit,
                             product_description 
                             FROM Products WHERE product_id = ?;
                             """;
        
        try (Connection connection = DriverManager.getConnection(
                DatabaseConnection.DB_URL, 
                DatabaseConnection.USER, 
                DatabaseConnection.PASS); 
             PreparedStatement stmt = connection.prepareStatement(QUERY)) {
            
            stmt.setInt(1, product_id);
            ResultSet product = stmt.executeQuery();
            Product productObject = new Product();
            
            if (product.next()) {
                productObject.setProductID(product.getInt("product_id"));
                productObject.setName(product.getString("product_name"));
                productObject.setSupplier(SupplierRepository.getSupplierByID(product.getInt("product_supplier_id")));
                productObject.setProductPrice(product.getDouble("product_price"));
                productObject.setCategory(CategoryRepository.getCategoryByID(product.getInt("product_category_id")));
                productObject.setProductQuantity(product.getInt("product_quantity"));
                productObject.setPurchasingPoints(product.getInt("product_purchase_points"));
                productObject.setProductSellingPoints(product.getInt("product_selling_points"));
                productObject.setOverstockLimit(product.getInt("overstock_limit"));
                productObject.setUnderstockLimit(product.getInt("understock_limit"));
                productObject.setProductDescription(product.getString("product_description"));
            }
            
            return productObject;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @brief Deletes a product from the database
     * 
     * @param product The Product object to delete (uses product_id)
     * @return true if deletion was successful, false otherwise
     */
    static public boolean deleteProduct(Product product) {
        final String QUERY = """
                             DELETE FROM Products WHERE product_id = ?;
                             """;
        
        try (Connection connection = DriverManager.getConnection(
                DatabaseConnection.DB_URL, 
                DatabaseConnection.USER, 
                DatabaseConnection.PASS); 
             PreparedStatement stmt = connection.prepareStatement(QUERY)) {
            
            stmt.setInt(1, product.getProductID());
            int executeQuery = stmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @brief Updates an existing product in the database
     * 
     * Updates all product fields including name, supplier, price, category,
     * quantity, points, limits, and description for the product matching 
     * the provided product_id.
     * 
     * @param product The Product object with updated information
     * @return true if update was successful, false otherwise
     */
    static public boolean updateProduct(Product product) {
        final String QUERY = """
                             UPDATE Products 
                             SET product_name = ?,
                             product_supplier_id = ?,
                             product_price = ?,
                             product_category_id = ?,
                             product_quantity = ?,
                             product_purchase_points = ?,
                             product_selling_points = ?,
                             overstock_limit = ?,
                             understock_limit = ?,
                             product_description = ?
                             WHERE product_id = ?;
                             """;
        
        try (Connection connection = DriverManager.getConnection(
                DatabaseConnection.DB_URL, 
                DatabaseConnection.USER, 
                DatabaseConnection.PASS); 
             PreparedStatement stmt = connection.prepareStatement(QUERY)) {
            
            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getSupplier().getSupplierID());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getCategory().getCategoryID());
            stmt.setInt(5, product.getProductQuantity());
            stmt.setInt(6, product.getPurchasingPoints());
            stmt.setInt(7, product.getProductSellingPoints());
            stmt.setInt(8, product.getOverstockLimit());
            stmt.setInt(9, product.getUnderstockLimit());
            stmt.setString(10, product.getProductDescription());
            stmt.setInt(11, product.getProductID());
            boolean res = stmt.execute();
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}