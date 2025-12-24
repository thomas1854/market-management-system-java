package marketsystem.gui;

import java.awt.Image;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import marketsystem.Customer;
import marketsystem.Product;
import marketsystem.database.CustomerRepository;
import marketsystem.database.ProductRepository;

public class Customers extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Customers.class.getName());
    ImageIcon picture = new ImageIcon("image7.jpg");
    Image img = picture.getImage();
    Image scaled;
    public MainFrame Frame;

    public Customers() {
        initComponents();
        this.setLocationRelativeTo(null);
        scaled = img.getScaledInstance(mainImage.getWidth(), mainImage.getHeight(), Image.SCALE_SMOOTH);
        mainImage.setIcon(new ImageIcon(scaled));
        setTable();
    }

    public Customers(MainFrame mf) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.Frame = mf;
        scaled = img.getScaledInstance(mainImage.getWidth(), mainImage.getHeight(), Image.SCALE_SMOOTH);
        mainImage.setIcon(new ImageIcon(scaled));
        setTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDeleteProduct = new javax.swing.JButton();
        btnAddProduct = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        lblProduct = new javax.swing.JLabel();
        mainImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(975, 675));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDeleteProduct.setBackground(new java.awt.Color(251, 236, 216));
        btnDeleteProduct.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnDeleteProduct.setForeground(new java.awt.Color(58, 46, 27));
        btnDeleteProduct.setText("Delete Customer");
        btnDeleteProduct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27), 3));
        btnDeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProductActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeleteProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 600, 190, 50));

        btnAddProduct.setBackground(new java.awt.Color(251, 236, 216));
        btnAddProduct.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnAddProduct.setForeground(new java.awt.Color(58, 46, 27));
        btnAddProduct.setText("Add Customer");
        btnAddProduct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27), 3));
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 600, 190, 50));

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
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 600, 190, 50));

        Table.setAutoCreateRowSorter(true);
        Table.setBackground(new java.awt.Color(251, 236, 216));
        Table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(251, 236, 216), 3));
        Table.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Table.setForeground(new java.awt.Color(58, 46, 27));
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Phone Number", "Points Balance", "Purchased Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
        lblProduct.setText("Customers");
        lblProduct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27), 3));
        lblProduct.setFocusable(false);
        lblProduct.setOpaque(true);
        getContentPane().add(lblProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 310, 90));
        getContentPane().add(mainImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProductActionPerformed
        // TODO add your handling code here:
        String customerID = JOptionPane.showInputDialog(
                null,
                "Enter the Customer ID to delete:",
                "Delete Customer",
                JOptionPane.QUESTION_MESSAGE
        );
        if (customerID == null) {
            return;
        }
        if (customerID.isBlank()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Please enter a value. The field cannot be empty.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        marketsystem.Customer customer = CustomerRepository.getCustomerByID(Integer.parseInt(customerID));

        if (customer.getCustomerID() == 0) {
            JOptionPane.showMessageDialog(
                    null,
                    "This Customer ID does not exist in the system.",
                    "Not Found",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        CustomerRepository.deleteCustomer(customer);
        JOptionPane.showMessageDialog(
                null,
                "Customer deleted successfully.",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnDeleteProductActionPerformed

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        AddCustomer add = new AddCustomer();
        add.setVisible(true);
    }//GEN-LAST:event_btnAddProductActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Customers().setVisible(true));
    }

    private void setTable() {
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        ArrayList<Customer> customers = CustomerRepository.getCustomers();
        model.setRowCount(0);
        for (Customer customer : customers) {
            model.addRow(new Object[]{
                customer.getCustomerID(),
                customer.getCustomerName(),
                customer.getPhoneNumber(),
                customer.getPointsBalance(),
                customer.getPurchasedBalance()
            });
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeleteProduct;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblProduct;
    private javax.swing.JLabel mainImage;
    // End of variables declaration//GEN-END:variables
}
