package marketsystem.gui;

import java.awt.Image;
import javax.swing.*;
import marketsystem.database.CategoryRepository;

public class AddCategory extends javax.swing.JFrame {

    ImageIcon picture = new ImageIcon("image8.png");
    Image img = picture.getImage();
    Image scaled;
    public Category category;

    public AddCategory() {
        initComponents();
        this.setLocationRelativeTo(null);
        scaled = img.getScaledInstance(mainImage.getWidth(), mainImage.getHeight(), Image.SCALE_SMOOTH);
        mainImage.setIcon(new ImageIcon(scaled));
    }

    public AddCategory(Category c) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.category = c;
        scaled = img.getScaledInstance(mainImage.getWidth(), mainImage.getHeight(), Image.SCALE_SMOOTH);
        mainImage.setIcon(new ImageIcon(scaled));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblName = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        txtName = new java.awt.TextField();
        lblAddCategory = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        mainImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblName.setBackground(new java.awt.Color(251, 236, 216));
        lblName.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblName.setForeground(new java.awt.Color(58, 46, 27));
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblName.setText("Name");
        lblName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27)));
        lblName.setFocusable(false);
        lblName.setOpaque(true);
        getContentPane().add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 190, 40));

        lblDescription.setBackground(new java.awt.Color(251, 236, 216));
        lblDescription.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblDescription.setForeground(new java.awt.Color(58, 46, 27));
        lblDescription.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDescription.setText("Description");
        lblDescription.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27)));
        lblDescription.setFocusable(false);
        lblDescription.setOpaque(true);
        getContentPane().add(lblDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 190, 40));
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 190, 40));

        lblAddCategory.setBackground(new java.awt.Color(251, 236, 216));
        lblAddCategory.setFont(new java.awt.Font("Vivaldi", 1, 48)); // NOI18N
        lblAddCategory.setForeground(new java.awt.Color(58, 46, 27));
        lblAddCategory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddCategory.setText("Add Category");
        lblAddCategory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27), 3));
        lblAddCategory.setFocusable(false);
        lblAddCategory.setOpaque(true);
        getContentPane().add(lblAddCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 310, 90));

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
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 100, -1));

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
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 540, 100, -1));

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 370, 150));
        getContentPane().add(mainImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1, 1280, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed


    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        marketsystem.Category category = new marketsystem.Category();
        if (txtDescription.getText().isBlank() || txtName.getText().isBlank())
            JOptionPane.showMessageDialog(
                    null,
                    "Please fill in all required fields.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
            );

        else {
            category.setCategoryName(txtName.getText());
            category.setCategoryDescription(txtDescription.getText());
            CategoryRepository.insertCategory(category);
            JOptionPane.showMessageDialog(
                    null,
                    "Category added successfully.",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );

            MainFrame main = new MainFrame();
            main.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new AddCategory().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddCategory;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel mainImage;
    private javax.swing.JTextArea txtDescription;
    private java.awt.TextField txtName;
    // End of variables declaration//GEN-END:variables
}
