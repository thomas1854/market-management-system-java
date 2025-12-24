package marketsystem.gui;

import static com.sun.java.accessibility.util.SwingEventMonitor.addListSelectionListener;
import java.awt.Image;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import marketsystem.Product;
import marketsystem.database.ProductRepository;

public class Products extends javax.swing.JFrame {

    ArrayList<Product> products = ProductRepository.getProducts();
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Products.class.getName());
    ImageIcon picture = new ImageIcon("Warehouse.png");
    Image img = picture.getImage();
    Image scaled;
    public MainFrame Frame;

    public Products() {
        initComponents();
        this.setLocationRelativeTo(null);
        scaled = img.getScaledInstance(mainImage.getWidth(), mainImage.getHeight(), Image.SCALE_SMOOTH);
        mainImage.setIcon(new ImageIcon(scaled));
        setTable();
        Table.getSelectionModel().addListSelectionListener(e -> {
            int row = Table.getSelectedRow();

            if (row == -1) {
                return; // no row selected
            }
            int id = Integer.parseInt(Table.getValueAt(row, 0).toString());

            String newQuantity = JOptionPane.showInputDialog(
                    null,
                    "Enter the new quantity for the product:",
                    "Update Product Quantity",
                    JOptionPane.QUESTION_MESSAGE
            );
            if (newQuantity == null) {
                return;
            }

            if (newQuantity.isBlank()) {
                JOptionPane.showMessageDialog(
                        null,
                        "Please enter a value. The field cannot be empty.",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            try {
                Product product = ProductRepository.getProductByID(id);
                product.setProductQuantity(Integer.parseInt(newQuantity));
                ProductRepository.updateProduct(product);
                Table.setValueAt(newQuantity, row, 5);
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(
                        null,
                        "Please enter a numeric value.",
                        "Invalid Input",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }
        });
        all.setSelected(true);
    }

    public Products(MainFrame mf) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.Frame = mf;
        scaled = img.getScaledInstance(mainImage.getWidth(), mainImage.getHeight(), Image.SCALE_SMOOTH);
        mainImage.setIcon(new ImageIcon(scaled));
        setTable();
        Table.getSelectionModel().addListSelectionListener(e -> {
            int row = Table.getSelectedRow();

            if (row == -1) {
                return; // no row selected
            }
            int id = Integer.parseInt(Table.getValueAt(row, 0).toString());

            String newQuantity = JOptionPane.showInputDialog(
                    null,
                    "Enter the new quantity for the product:",
                    "Update Product Quantity",
                    JOptionPane.QUESTION_MESSAGE
            );
            if (newQuantity == null) {
                return;
            }

            if (newQuantity.isBlank()) {
                JOptionPane.showMessageDialog(
                        null,
                        "Please enter a value. The field cannot be empty.",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            try {
                Product product = ProductRepository.getProductByID(id);
                product.setProductQuantity(Integer.parseInt(newQuantity));
                ProductRepository.updateProduct(product);
                Table.setValueAt(newQuantity, row, 5);
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(
                        null,
                        "Please enter a numeric value.",
                        "Invalid Input",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }
        });
        all.setSelected(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnDeleteProduct = new javax.swing.JButton();
        btnAddProduct = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        lblProduct = new javax.swing.JLabel();
        under = new javax.swing.JRadioButton();
        all = new javax.swing.JRadioButton();
        over = new javax.swing.JRadioButton();
        mainImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(975, 675));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDeleteProduct.setBackground(new java.awt.Color(251, 236, 216));
        btnDeleteProduct.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnDeleteProduct.setForeground(new java.awt.Color(58, 46, 27));
        btnDeleteProduct.setText("Delete Product");
        btnDeleteProduct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27), 3));
        btnDeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProductActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeleteProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 600, 190, 50));

        btnAddProduct.setBackground(new java.awt.Color(251, 236, 216));
        btnAddProduct.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnAddProduct.setForeground(new java.awt.Color(58, 46, 27));
        btnAddProduct.setText("Add Product");
        btnAddProduct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27), 3));
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 600, 190, 50));

        btnBack.setBackground(new java.awt.Color(251, 236, 216));
        btnBack.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(58, 46, 27));
        btnBack.setText("Back To Menu");
        btnBack.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27), 3));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 600, 190, 50));

        Table.setAutoCreateRowSorter(true);
        Table.setBackground(new java.awt.Color(251, 236, 216));
        Table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(251, 236, 216), 3));
        Table.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Table.setForeground(new java.awt.Color(58, 46, 27));
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Supplier", "Category", "Price", "Quantity", "Selling Points", "Purchasing Point", "Overstock Limit", "Understock Limit"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Table.setDragEnabled(true);
        Table.setDropMode(javax.swing.DropMode.INSERT_ROWS);
        Table.setGridColor(new java.awt.Color(58, 46, 27));
        Table.setRowHeight(25);
        Table.setSelectionBackground(new java.awt.Color(251, 236, 216));
        Table.setSelectionForeground(new java.awt.Color(58, 46, 27));
        Table.setShowGrid(true);
        jScrollPane1.setViewportView(Table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 1140, 410));

        lblProduct.setBackground(new java.awt.Color(251, 236, 216));
        lblProduct.setFont(new java.awt.Font("Vivaldi", 1, 48)); // NOI18N
        lblProduct.setForeground(new java.awt.Color(58, 46, 27));
        lblProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProduct.setText("Products");
        lblProduct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27), 3));
        lblProduct.setFocusable(false);
        lblProduct.setOpaque(true);
        getContentPane().add(lblProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 310, 90));

        under.setBackground(new java.awt.Color(251, 236, 216));
        buttonGroup1.add(under);
        under.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        under.setForeground(new java.awt.Color(58, 46, 27));
        under.setText("Understock");
        under.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27), 2));
        under.setBorderPainted(true);
        under.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                underActionPerformed(evt);
            }
        });
        getContentPane().add(under, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 620, 120, -1));

        all.setBackground(new java.awt.Color(251, 236, 216));
        buttonGroup1.add(all);
        all.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        all.setForeground(new java.awt.Color(58, 46, 27));
        all.setText("All");
        all.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27), 2));
        all.setBorderPainted(true);
        all.setOpaque(true);
        all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allActionPerformed(evt);
            }
        });
        getContentPane().add(all, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 620, 80, -1));

        over.setBackground(new java.awt.Color(251, 236, 216));
        buttonGroup1.add(over);
        over.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        over.setForeground(new java.awt.Color(58, 46, 27));
        over.setText("Overstock");
        over.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27), 2));
        over.setBorderPainted(true);
        over.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                overActionPerformed(evt);
            }
        });
        getContentPane().add(over, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 620, 100, -1));
        getContentPane().add(mainImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProductActionPerformed

        String productID = JOptionPane.showInputDialog(
                null,
                "Enter the Product ID to delete:",
                "Delete Product",
                JOptionPane.QUESTION_MESSAGE
        );
        if (productID == null) {
            return;
        }
        if (productID.isBlank()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Please enter a value. This field cannot be empty.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        marketsystem.Product product = ProductRepository.getProductByID(Integer.parseInt(productID));

        if (product.getProductID() == 0) {
            JOptionPane.showMessageDialog(
                    null,
                    "This Product ID does not exist in the system.",
                    "Not Found",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        ProductRepository.deleteProduct(product);
        JOptionPane.showMessageDialog(null, "Done");
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnDeleteProductActionPerformed

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        AddProduct addp = new AddProduct(this);
        addp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAddProductActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        dispose();     // TODO add your handling code here:
    }//GEN-LAST:event_btnBackActionPerformed

    private void allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allActionPerformed
        // TODO add your handling code here:
        setTable();
    }//GEN-LAST:event_allActionPerformed

    private void underActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_underActionPerformed
        // TODO add your handling code here:
        setTableUnder();
    }//GEN-LAST:event_underActionPerformed

    private void overActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_overActionPerformed
        // TODO add your handling code here:
        setTableOver();
    }//GEN-LAST:event_overActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Products().setVisible(true));
    }

    private void setTable() {
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        model.setRowCount(0);
        for (Product product : products) {
            model.addRow(new Object[]{
                product.getProductID(),
                product.getName(),
                product.getSupplier().getSupplierName(),
                product.getCategory().getCategoryName(),
                product.getPrice(),
                product.getProductQuantity(),
                product.getProductSellingPoints(),
                product.getPurchasingPoints(),
                product.getOverstockLimit(),
                product.getUnderstockLimit()
            });
        }
    }

    private void setTableOver() {
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        model.setRowCount(0);
        for (Product product : products) {
            if (product.getProductQuantity() >= product.getOverstockLimit()) {
                model.addRow(new Object[]{
                    product.getProductID(),
                    product.getName(),
                    product.getSupplier().getSupplierName(),
                    product.getCategory().getCategoryName(),
                    product.getPrice(),
                    product.getProductQuantity(),
                    product.getProductSellingPoints(),
                    product.getPurchasingPoints(),
                    product.getOverstockLimit(),
                    product.getUnderstockLimit()
                });
            }
        }
    }

    private void setTableUnder() {
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        model.setRowCount(0);
        for (Product product : products) {
            if (product.getProductQuantity() <= product.getUnderstockLimit()) {
                model.addRow(new Object[]{
                    product.getProductID(),
                    product.getName(),
                    product.getSupplier().getSupplierName(),
                    product.getCategory().getCategoryName(),
                    product.getPrice(),
                    product.getProductQuantity(),
                    product.getProductSellingPoints(),
                    product.getPurchasingPoints(),
                    product.getOverstockLimit(),
                    product.getUnderstockLimit()
                });
            }
        }
    }

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {

        int row = Table.getSelectedRow();

        if (row == -1) {
            return; // no row selected
        }
        int id = Integer.parseInt(Table.getValueAt(row, 0).toString());

        String newQuantity = JOptionPane.showInputDialog(null, "Enter new quantity");
        if (newQuantity == null) {
            return;
        }
        if (newQuantity.isBlank()) {
            JOptionPane.showMessageDialog(null, "Enter value");
            return;
        }

        try {
            products.get(row).setProductQuantity(Integer.parseInt(newQuantity));
            ProductRepository.updateProduct(products.get(row));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Enter a numeric value");
            return;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JRadioButton all;
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeleteProduct;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblProduct;
    private javax.swing.JLabel mainImage;
    private javax.swing.JRadioButton over;
    private javax.swing.JRadioButton under;
    // End of variables declaration//GEN-END:variables
}
