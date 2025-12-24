package marketsystem;

import marketsystem.gui.LogIn;

public class MarketSystem {
    public static void main(String[] args) {
        marketsystem.gui.LogIn login = new LogIn();
        login.setVisible(true);
        marketsystem.database.CategoryRepository.createCategoriesTable();
        marketsystem.database.CustomerRepository.createCustomersTable();
        marketsystem.database.SupplierRepository.createSuppliersTable();
        marketsystem.database.ProductRepository.createProductsTable();
        marketsystem.database.ReceiptRepository.createReceiptsTable();
        marketsystem.database.ReceiptItemsRepository.createReceiptItemsTable();
    }
}
