package marketsystem.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import marketsystem.Category;
import marketsystem.Receipt;
import marketsystem.Product;
import marketsystem.Supplier;

/**
 * @brief Repository class for managing ReceiptItem entities in the database
 *
 * This class provides operations for the ReceiptItems table including creating
 * the table, inserting receipt items, and retrieving items by receipt ID
 * (filtered by cash or points purchases).
 */
public class ReceiptItemsRepository {

    /**
     * @brief Creates the ReceiptItems table if it doesn't exist
     *
     * Creates a table with columns: item_id (auto-increment primary key),
     * receipt_id, product_id, unit_price, unit_points, and quantity.
     *
     * @return true if the statement executed successfully, false otherwise
     */
    static public boolean createReceiptItemsTable() {
        final String QUERY = """
                             CREATE TABLE IF NOT EXISTS ReceiptItems (
                                item_id INT AUTO_INCREMENT NOT NULL,
                                receipt_id INT NOT NULL,
                                product_id INT NOT NULL,
                                unit_price DOUBLE NOT NULL,
                                unit_points INT NOT NULL,
                                quantity INT NOT NULL,
                             PRIMARY KEY (item_id),
                             FOREIGN KEY (receipt_id) REFERENCES Receipts(receipt_id),
                             FOREIGN KEY (product_id) REFERENCES Products(product_id)
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
     * @brief Inserts a new receipt item into the database
     *
     * Ensures the ReceiptItems table exists before insertion. Also updates the
     * product inventory by reducing the quantity by the purchased amount.
     *
     * @param receipt_id The ID of the receipt this item belongs to
     * @param product_id The ID of the product being purchased
     * @param unit_price The price per unit (0 if purchased with points)
     * @param unit_points The points per unit (0 if purchased with cash)
     * @param quantity The number of units purchased
     * @return true if the statement executed successfully, false otherwise
     */
    static public boolean insertReceiptItem(int receipt_id, int product_id, double unit_price, int unit_points, int quantity) {
        createReceiptItemsTable();

        final String QUERY = """
                             INSERT INTO ReceiptItems(
                             receipt_id,
                             product_id,
                             unit_price,
                             unit_points,
                             quantity
                             )
                             VALUES(?, ?, ?, ?, ?);
                             """;

        try (Connection connection = DriverManager.getConnection(
                DatabaseConnection.DB_URL,
                DatabaseConnection.USER,
                DatabaseConnection.PASS); PreparedStatement stmt = connection.prepareStatement(QUERY)) {

            stmt.setInt(1, receipt_id);
            stmt.setInt(2, product_id);
            stmt.setDouble(3, unit_price);
            stmt.setInt(4, unit_points);
            stmt.setInt(5, quantity);
            boolean res = stmt.execute();

            // Update product inventory
            Product modifiedProduct = ProductRepository.getProductByID(product_id);
            modifiedProduct.setProductQuantity(modifiedProduct.getProductQuantity() - quantity);
            ProductRepository.updateProduct(modifiedProduct);

            return res;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @brief Retrieves all products purchased with cash for a specific receipt
     *
     * Fetches receipt items where unit_points = 0, indicating cash purchase.
     * Reconstructs complete Product objects for each item.
     *
     * @param receipt_id The ID of the receipt to retrieve items for
     * @return HashMap mapping Product objects to their quantities, or null if
     * an error occurs
     */
    static public HashMap<Product, Integer> getRecieptCashPurchasedProducts(int receipt_id) {
//        final String QUERY = """
//                             SELECT 
//                             receipt_id,
//                             product_id,
//                             unit_price,
//                             unit_points,
//                             quantity
//                             FROM ReceiptItems
//                             WHERE receipt_id = ? AND unit_points = 0;
//                             """;
//        
//        try (Connection connection = DriverManager.getConnection(
//                DatabaseConnection.DB_URL, 
//                DatabaseConnection.USER, 
//                DatabaseConnection.PASS); 
//             PreparedStatement stmt = connection.prepareStatement(QUERY)) {
//            
//            stmt.setInt(1, receipt_id);
//            ResultSet receiptItems = stmt.executeQuery();
//            HashMap<Product, Integer> cashProducts = new HashMap<>();
//            
//            while (receiptItems.next()) {
//                Product productObject = new Product();
//                productObject.setProductID(receiptItems.getInt("product_id"));
//                productObject.setName(ProductRepository.getProductByID(receiptItems.getInt("product_id")).getName());
//                productObject.setSupplier(SupplierRepository.getSupplierByID(ProductRepository.getProductByID(receiptItems.getInt("product_id")).getSupplier().getSupplierID()));
//                productObject.setProductPrice(receiptItems.getDouble("unit_price"));
//                productObject.setCategory(ProductRepository.getProductByID(receiptItems.getInt("product_id")).getCategory());
//                productObject.setProductQuantity(receiptItems.getInt("quantity"));
//                productObject.setPurchasingPoints(receiptItems.getInt("unit_points"));
//                productObject.setProductSellingPoints(ProductRepository.getProductByID(receiptItems.getInt("product_id")).getProductSellingPoints());
//                productObject.setOverstockLimit(ProductRepository.getProductByID(receiptItems.getInt("product_id")).getOverstockLimit());
//                productObject.setUnderstockLimit(ProductRepository.getProductByID(receiptItems.getInt("product_id")).getUnderstockLimit());
//                productObject.setProductDescription(ProductRepository.getProductByID(receiptItems.getInt("product_id")).getProductDescription());
//                cashProducts.put(productObject, receiptItems.getInt("quantity"));
//            }
        final String QUERY = """
                            SELECT 
                            *
                            FROM ReceiptItems,
                            Products,
                            Suppliers,
                            Categories
                            WHERE receipt_id = ? AND unit_points = 0 AND Products.product_id = ReceiptItems.product_id AND Products.product_supplier_id = Suppliers.supplier_id AND Categories.category_id = Products.product_category_id;
                             """;

        try (Connection connection = DriverManager.getConnection(
                DatabaseConnection.DB_URL,
                DatabaseConnection.USER,
                DatabaseConnection.PASS); PreparedStatement stmt = connection.prepareStatement(QUERY)) {

            stmt.setInt(1, receipt_id);
            ResultSet receiptItems = stmt.executeQuery();
            HashMap<Product, Integer> cashProducts = new HashMap<>();

            while (receiptItems.next()) {
                Product productObject = new Product();
                productObject.setProductID(receiptItems.getInt("product_id"));
                productObject.setName(receiptItems.getString("product_name"));
                Supplier supplier = new Supplier();
                supplier.setSupplierID(receiptItems.getInt("supplier_id"));
                supplier.setSupplierContact(receiptItems.getString("supplier_contact"));
                supplier.setName(receiptItems.getString("supplier_name"));
                productObject.setSupplier(supplier);
                productObject.setProductPrice(receiptItems.getDouble("unit_price"));
                Category category = new Category();
                category.setCategoryName(receiptItems.getString("category_name"));
                category.setCategoryID(receiptItems.getInt("category_id"));
                category.setCategoryDescription(receiptItems.getString("category_description"));
                productObject.setCategory(category);
                productObject.setProductQuantity(receiptItems.getInt("quantity"));
                productObject.setPurchasingPoints(receiptItems.getInt("unit_points"));
                productObject.setProductSellingPoints(receiptItems.getInt("product_selling_points"));
                productObject.setOverstockLimit(receiptItems.getInt("overstock_limit"));
                productObject.setUnderstockLimit(receiptItems.getInt("understock_limit"));
                productObject.setProductDescription(receiptItems.getString("product_description"));
                cashProducts.put(productObject, receiptItems.getInt("quantity"));
            }
            return cashProducts;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @brief Retrieves all products purchased with points for a specific
     * receipt
     *
     * Fetches receipt items where unit_price = 0, indicating points purchase.
     * Reconstructs complete Product objects for each item.
     *
     * @param receipt_id The ID of the receipt to retrieve items for
     * @return HashMap mapping Product objects to their quantities, or null if
     * an error occurs
     */
    static public HashMap<Product, Integer> getRecieptPointsPurchasedProducts(int receipt_id) {
        final String QUERY = """
                             SELECT 
                             receipt_id,
                             product_id,
                             unit_price,
                             unit_points,
                             quantity
                             FROM ReceiptItems
                             WHERE receipt_id = ? AND unit_price = 0;
                             """;

        try (Connection connection = DriverManager.getConnection(
                DatabaseConnection.DB_URL,
                DatabaseConnection.USER,
                DatabaseConnection.PASS); PreparedStatement stmt = connection.prepareStatement(QUERY)) {

            stmt.setInt(1, receipt_id);
            ResultSet receiptItems = stmt.executeQuery();
            HashMap<Product, Integer> pointProducts = new HashMap<>();

            while (receiptItems.next()) {
                Product productObject = new Product();
                productObject.setProductID(receiptItems.getInt("product_id"));
                productObject.setName(ProductRepository.getProductByID(receiptItems.getInt("product_id")).getName());
                productObject.setSupplier(SupplierRepository.getSupplierByID(ProductRepository.getProductByID(receiptItems.getInt("product_id")).getSupplier().getSupplierID()));
                productObject.setProductPrice(receiptItems.getDouble("unit_price"));
                productObject.setCategory(ProductRepository.getProductByID(receiptItems.getInt("product_id")).getCategory());
                productObject.setProductQuantity(receiptItems.getInt("quantity"));
                productObject.setPurchasingPoints(receiptItems.getInt("unit_points"));
                productObject.setProductSellingPoints(ProductRepository.getProductByID(receiptItems.getInt("product_id")).getProductSellingPoints());
                productObject.setOverstockLimit(ProductRepository.getProductByID(receiptItems.getInt("product_id")).getOverstockLimit());
                productObject.setUnderstockLimit(ProductRepository.getProductByID(receiptItems.getInt("product_id")).getUnderstockLimit());
                productObject.setProductDescription(ProductRepository.getProductByID(receiptItems.getInt("product_id")).getProductDescription());
                pointProducts.put(productObject, receiptItems.getInt("quantity"));
            }

            return pointProducts;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
