package marketsystem.gui;

import java.awt.Image;
import javax.swing.*;

public class MainFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainFrame.class.getName());
    ImageIcon picture = new ImageIcon("image5.jpg");
    Image img = picture.getImage();
    Image scaled;
    public MainFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        scaled = img.getScaledInstance(mainImage.getWidth(), mainImage.getHeight(), Image.SCALE_SMOOTH);
        mainImage.setIcon(new ImageIcon(scaled));
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AllButtons = new javax.swing.JPanel();
        btnProducts = new javax.swing.JButton();
        btnCustomers = new javax.swing.JButton();
        btnSuppliers = new javax.swing.JButton();
        btnCategories = new javax.swing.JButton();
        btnReceipts = new javax.swing.JButton();
        Welcome = new javax.swing.JLabel();
        mainImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AllButtons.setBackground(new java.awt.Color(251, 241, 221));
        AllButtons.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27), 5));

        btnProducts.setBackground(new java.awt.Color(251, 236, 216));
        btnProducts.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnProducts.setForeground(new java.awt.Color(58, 46, 27));
        btnProducts.setText("Products");
        btnProducts.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27), 3));
        btnProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductsActionPerformed(evt);
            }
        });

        btnCustomers.setBackground(new java.awt.Color(251, 236, 216));
        btnCustomers.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnCustomers.setForeground(new java.awt.Color(58, 46, 27));
        btnCustomers.setText("Customers");
        btnCustomers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27), 3));
        btnCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomersActionPerformed(evt);
            }
        });

        btnSuppliers.setBackground(new java.awt.Color(251, 236, 216));
        btnSuppliers.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnSuppliers.setForeground(new java.awt.Color(58, 46, 27));
        btnSuppliers.setText("Suppliers");
        btnSuppliers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27), 3));
        btnSuppliers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuppliersActionPerformed(evt);
            }
        });

        btnCategories.setBackground(new java.awt.Color(251, 236, 216));
        btnCategories.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnCategories.setForeground(new java.awt.Color(58, 46, 27));
        btnCategories.setText("Categories");
        btnCategories.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27), 3));
        btnCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriesActionPerformed(evt);
            }
        });

        btnReceipts.setBackground(new java.awt.Color(251, 236, 216));
        btnReceipts.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnReceipts.setForeground(new java.awt.Color(58, 46, 27));
        btnReceipts.setText("Receipts");
        btnReceipts.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27), 3));
        btnReceipts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReceiptsActionPerformed(evt);
            }
        });

        Welcome.setFont(new java.awt.Font("Vivaldi", 1, 48)); // NOI18N
        Welcome.setForeground(new java.awt.Color(58, 46, 27));
        Welcome.setText("Welcome To Our Mangement System");

        javax.swing.GroupLayout AllButtonsLayout = new javax.swing.GroupLayout(AllButtons);
        AllButtons.setLayout(AllButtonsLayout);
        AllButtonsLayout.setHorizontalGroup(
            AllButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AllButtonsLayout.createSequentialGroup()
                .addGroup(AllButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AllButtonsLayout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addGroup(AllButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReceipts, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(AllButtonsLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(Welcome)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        AllButtonsLayout.setVerticalGroup(
            AllButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AllButtonsLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(Welcome)
                .addGap(142, 142, 142)
                .addComponent(btnProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReceipts, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        getContentPane().add(AllButtons, new org.netbeans.lib.awtextra.AbsoluteConstraints(641, 0, 760, 770));
        getContentPane().add(mainImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 650, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductsActionPerformed
        Products p = new Products(this);
        p.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnProductsActionPerformed

    private void btnCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriesActionPerformed
        Category c = new Category(this);
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCategoriesActionPerformed

    private void btnCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomersActionPerformed
        Customers p = new Customers(this);
        p.setVisible(true);
        this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_btnCustomersActionPerformed

    private void btnSuppliersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuppliersActionPerformed
        SupplierFrame p = new SupplierFrame(this);
        p.setVisible(true);
        this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_btnSuppliersActionPerformed

    private void btnReceiptsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReceiptsActionPerformed
        Sales p = new Sales(this);
        p.setVisible(true);
        this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_btnReceiptsActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AllButtons;
    private javax.swing.JLabel Welcome;
    private javax.swing.JButton btnCategories;
    private javax.swing.JButton btnCustomers;
    private javax.swing.JButton btnProducts;
    private javax.swing.JButton btnReceipts;
    private javax.swing.JButton btnSuppliers;
    private javax.swing.JLabel mainImage;
    // End of variables declaration//GEN-END:variables
}
