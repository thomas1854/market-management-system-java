package marketsystem.gui;

import marketsystem.Product;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.*;
import marketsystem.Supplier;
import marketsystem.database.CategoryRepository;
import marketsystem.database.ProductRepository;
import marketsystem.database.SupplierRepository;

public class AddProduct extends javax.swing.JFrame {

    ArrayList<Supplier> suppliers = SupplierRepository.getSuppliers();
    ArrayList<marketsystem.Category> categories = CategoryRepository.getCategories();
    ImageIcon picture = new ImageIcon("Warehouse.png");
    Image img = picture.getImage();
    Image scaled;
    public Products product;

    public AddProduct() {
        initComponents();
        this.setLocationRelativeTo(null);
        scaled = img.getScaledInstance(mainImage.getWidth(), mainImage.getHeight(), Image.SCALE_SMOOTH);
        mainImage.setIcon(new ImageIcon(scaled));
        setChoiceSuppliers();
        setChoiceCategories();
    }

    public AddProduct(Products p) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.product = p;
        scaled = img.getScaledInstance(mainImage.getWidth(), mainImage.getHeight(), Image.SCALE_SMOOTH);
        mainImage.setIcon(new ImageIcon(scaled));
        setChoiceSuppliers();
        setChoiceCategories();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chCategory = new java.awt.Choice();
        chSupplier = new java.awt.Choice();
        txtName = new java.awt.TextField();
        txtPurchasingPoints = new java.awt.TextField();
        txtDescription = new java.awt.TextField();
        txtPrice = new java.awt.TextField();
        txtOverStockLimit = new java.awt.TextField();
        txtSellingProduct = new java.awt.TextField();
        btnBack = new javax.swing.JButton();
        lblDescription = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        lblPurchasingPoints = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        lblSellingProduct = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        lblSupplier = new javax.swing.JLabel();
        lblCategory = new javax.swing.JLabel();
        lblAddProduct = new javax.swing.JLabel();
        lblUnderStockLimit = new javax.swing.JLabel();
        lblOverStockLimit = new javax.swing.JLabel();
        lblName2 = new javax.swing.JLabel();
        txtQuantity = new java.awt.TextField();
        txtUnderStockLimit = new java.awt.TextField();
        mainImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        chCategory.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        chCategory.setForeground(new java.awt.Color(58, 46, 27));
        getContentPane().add(chCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 350, 190, -1));

        chSupplier.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        chSupplier.setForeground(new java.awt.Color(58, 46, 27));
        getContentPane().add(chSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 350, 190, -1));

        txtName.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtName.setForeground(new java.awt.Color(58, 46, 27));
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 190, 40));

        txtPurchasingPoints.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtPurchasingPoints.setForeground(new java.awt.Color(58, 46, 27));
        getContentPane().add(txtPurchasingPoints, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 190, 40));

        txtDescription.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtDescription.setForeground(new java.awt.Color(58, 46, 27));
        getContentPane().add(txtDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 220, 190, 40));

        txtPrice.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtPrice.setForeground(new java.awt.Color(58, 46, 27));
        getContentPane().add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 460, 190, 40));

        txtOverStockLimit.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtOverStockLimit.setForeground(new java.awt.Color(58, 46, 27));
        getContentPane().add(txtOverStockLimit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 490, 190, 40));

        txtSellingProduct.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtSellingProduct.setForeground(new java.awt.Color(58, 46, 27));
        getContentPane().add(txtSellingProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 350, 190, 40));

        btnBack.setBackground(new java.awt.Color(251, 236, 216));
        btnBack.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(58, 46, 27));
        btnBack.setText("Back");
        btnBack.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27), 3));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 630, 420, -1));

        lblDescription.setBackground(new java.awt.Color(251, 236, 216));
        lblDescription.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblDescription.setForeground(new java.awt.Color(58, 46, 27));
        lblDescription.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDescription.setText("Description");
        lblDescription.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27)));
        lblDescription.setFocusable(false);
        lblDescription.setOpaque(true);
        getContentPane().add(lblDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 180, 190, 40));

        btnAdd.setBackground(new java.awt.Color(251, 236, 216));
        btnAdd.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(58, 46, 27));
        btnAdd.setText("Add");
        btnAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27), 3));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 630, 420, -1));

        lblPurchasingPoints.setBackground(new java.awt.Color(251, 236, 216));
        lblPurchasingPoints.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblPurchasingPoints.setForeground(new java.awt.Color(58, 46, 27));
        lblPurchasingPoints.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPurchasingPoints.setText("Purchasing Points");
        lblPurchasingPoints.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27)));
        lblPurchasingPoints.setFocusable(false);
        lblPurchasingPoints.setOpaque(true);
        getContentPane().add(lblPurchasingPoints, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 190, 40));

        lblQuantity.setBackground(new java.awt.Color(251, 236, 216));
        lblQuantity.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblQuantity.setForeground(new java.awt.Color(58, 46, 27));
        lblQuantity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuantity.setText("Quantity");
        lblQuantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27)));
        lblQuantity.setFocusable(false);
        lblQuantity.setOpaque(true);
        getContentPane().add(lblQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 180, 190, 40));

        lblSellingProduct.setBackground(new java.awt.Color(251, 236, 216));
        lblSellingProduct.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblSellingProduct.setForeground(new java.awt.Color(58, 46, 27));
        lblSellingProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSellingProduct.setText("Selling Points");
        lblSellingProduct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27)));
        lblSellingProduct.setFocusable(false);
        lblSellingProduct.setOpaque(true);
        getContentPane().add(lblSellingProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 310, 190, 40));

        lblPrice.setBackground(new java.awt.Color(251, 236, 216));
        lblPrice.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblPrice.setForeground(new java.awt.Color(58, 46, 27));
        lblPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrice.setText("Price");
        lblPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27)));
        lblPrice.setFocusable(false);
        lblPrice.setOpaque(true);
        getContentPane().add(lblPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 420, 190, 40));

        lblSupplier.setBackground(new java.awt.Color(251, 236, 216));
        lblSupplier.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblSupplier.setForeground(new java.awt.Color(58, 46, 27));
        lblSupplier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSupplier.setText("Supplier");
        lblSupplier.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27)));
        lblSupplier.setFocusable(false);
        lblSupplier.setOpaque(true);
        getContentPane().add(lblSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 310, 190, 40));

        lblCategory.setBackground(new java.awt.Color(251, 236, 216));
        lblCategory.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblCategory.setForeground(new java.awt.Color(58, 46, 27));
        lblCategory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCategory.setText("Category");
        lblCategory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27)));
        lblCategory.setFocusable(false);
        lblCategory.setOpaque(true);
        getContentPane().add(lblCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 310, 190, 40));

        lblAddProduct.setBackground(new java.awt.Color(251, 236, 216));
        lblAddProduct.setFont(new java.awt.Font("Vivaldi", 1, 48)); // NOI18N
        lblAddProduct.setForeground(new java.awt.Color(58, 46, 27));
        lblAddProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddProduct.setText("Add Product");
        lblAddProduct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27), 3));
        lblAddProduct.setFocusable(false);
        lblAddProduct.setOpaque(true);
        getContentPane().add(lblAddProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, 310, 90));

        lblUnderStockLimit.setBackground(new java.awt.Color(251, 236, 216));
        lblUnderStockLimit.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblUnderStockLimit.setForeground(new java.awt.Color(58, 46, 27));
        lblUnderStockLimit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUnderStockLimit.setText("Understock Limit");
        lblUnderStockLimit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27)));
        lblUnderStockLimit.setFocusable(false);
        lblUnderStockLimit.setOpaque(true);
        getContentPane().add(lblUnderStockLimit, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 440, 190, 40));

        lblOverStockLimit.setBackground(new java.awt.Color(251, 236, 216));
        lblOverStockLimit.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblOverStockLimit.setForeground(new java.awt.Color(58, 46, 27));
        lblOverStockLimit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOverStockLimit.setText("Overstock Limit");
        lblOverStockLimit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27)));
        lblOverStockLimit.setFocusable(false);
        lblOverStockLimit.setOpaque(true);
        getContentPane().add(lblOverStockLimit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 450, 190, 40));

        lblName2.setBackground(new java.awt.Color(251, 236, 216));
        lblName2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblName2.setForeground(new java.awt.Color(58, 46, 27));
        lblName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblName2.setText("Name");
        lblName2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27)));
        lblName2.setFocusable(false);
        lblName2.setOpaque(true);
        getContentPane().add(lblName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 190, 40));

        txtQuantity.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtQuantity.setForeground(new java.awt.Color(58, 46, 27));
        getContentPane().add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 220, 190, 40));

        txtUnderStockLimit.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtUnderStockLimit.setForeground(new java.awt.Color(58, 46, 27));
        getContentPane().add(txtUnderStockLimit, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 480, 190, 40));
        getContentPane().add(mainImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1810, 790));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        if (txtName.getText().isBlank() || txtDescription.getText().isBlank() || txtOverStockLimit.getText().isBlank() || txtOverStockLimit.getText().isBlank() || txtUnderStockLimit.getText().isBlank() || txtPrice.getText().isBlank() || txtSellingProduct.getText().isBlank() || txtPurchasingPoints.getText().isBlank() || txtQuantity.getText().isBlank()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Please fill in all required fields.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
            );
        } else {
            try {
                Product product = new Product();
                product.setName(txtName.getText());
                product.setProductDescription(txtDescription.getText());
                product.setOverstockLimit(Integer.parseInt(txtOverStockLimit.getText()));
                product.setUnderstockLimit(Integer.parseInt(txtUnderStockLimit.getText()));
                product.setProductPrice(Double.parseDouble(txtPrice.getText()));
                product.setProductSellingPoints(Integer.parseInt(txtSellingProduct.getText()));
                product.setPurchasingPoints(Integer.parseInt(txtPurchasingPoints.getText()));
                product.setSupplier(suppliers.get(chSupplier.getSelectedIndex()));
                product.setCategory(categories.get(chCategory.getSelectedIndex()));
                product.setProductQuantity(Integer.parseInt(txtQuantity.getText()));
                ProductRepository.insertProduct(product);
                JOptionPane.showMessageDialog(
                        null,
                        "Product added successfully.",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);
                dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                        null,
                        "An unexpected error occurred. Please try again.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );

            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new AddProduct().setVisible(true));
    }

    private void setChoiceSuppliers() {

        for (Supplier supplier : suppliers) {
            chSupplier.add(supplier.getSupplierName());
        }
    }

    private void setChoiceCategories() {

        for (marketsystem.Category category : categories) {
            chCategory.add(category.getCategoryName());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private java.awt.Choice chCategory;
    private java.awt.Choice chSupplier;
    private javax.swing.JLabel lblAddProduct;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblName2;
    private javax.swing.JLabel lblOverStockLimit;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblPurchasingPoints;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblSellingProduct;
    private javax.swing.JLabel lblSupplier;
    private javax.swing.JLabel lblUnderStockLimit;
    private javax.swing.JLabel mainImage;
    private java.awt.TextField txtDescription;
    private java.awt.TextField txtName;
    private java.awt.TextField txtOverStockLimit;
    private java.awt.TextField txtPrice;
    private java.awt.TextField txtPurchasingPoints;
    private java.awt.TextField txtQuantity;
    private java.awt.TextField txtSellingProduct;
    private java.awt.TextField txtUnderStockLimit;
    // End of variables declaration//GEN-END:variables
}
