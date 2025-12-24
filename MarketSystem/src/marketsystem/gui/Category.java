package marketsystem.gui;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import marketsystem.database.CategoryRepository;
import marketsystem.database.SupplierRepository;

public class Category extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Category.class.getName());
    ImageIcon picture = new ImageIcon("image8.png");
    Image img = picture.getImage();
    Image scaled;
    public MainFrame Frame;

    public Category() {
        initComponents();
        this.setLocationRelativeTo(null);
        scaled = img.getScaledInstance(mainImage.getWidth(), mainImage.getHeight(), Image.SCALE_SMOOTH);
        mainImage.setIcon(new ImageIcon(scaled));
        setTable();
    }

    public Category(MainFrame mf) {
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

        lblCategory = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        mainImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCategory.setBackground(new java.awt.Color(251, 236, 216));
        lblCategory.setFont(new java.awt.Font("Vivaldi", 1, 48)); // NOI18N
        lblCategory.setForeground(new java.awt.Color(58, 46, 27));
        lblCategory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCategory.setText("Category");
        lblCategory.setToolTipText("");
        lblCategory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27), 3));
        lblCategory.setFocusable(false);
        lblCategory.setOpaque(true);
        getContentPane().add(lblCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 310, 90));

        btnDelete.setBackground(new java.awt.Color(251, 236, 216));
        btnDelete.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(58, 46, 27));
        btnDelete.setText("Delete Category");
        btnDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27), 3));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 190, 50));

        btnAdd.setBackground(new java.awt.Color(251, 236, 216));
        btnAdd.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(58, 46, 27));
        btnAdd.setText("Add Category");
        btnAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27), 3));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 190, 50));

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
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 190, 50));

        Table.setAutoCreateRowSorter(true);
        Table.setBackground(new java.awt.Color(251, 236, 216));
        Table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(251, 236, 216), 3));
        Table.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Table.setForeground(new java.awt.Color(58, 46, 27));
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Name", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 790, 410));
        getContentPane().add(mainImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        dispose();;
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        AddCategory addc = new AddCategory(this);
        addc.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String categoryId = JOptionPane.showInputDialog(
                null,
                "Enter the Category ID to delete:",
                "Delete Category",
                JOptionPane.QUESTION_MESSAGE
        );

        if (categoryId == null) {
            return;
        }
        if (categoryId.isBlank()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Please enter a value. The field cannot be empty.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        marketsystem.Category category = CategoryRepository.getCategoryByID(Integer.parseInt(categoryId));

        if (category.getCategoryID() == 0) {
            JOptionPane.showMessageDialog(
                    null,
                    "This Category ID does not exist in the system.",
                    "Not Found",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        CategoryRepository.deleteCategory(category);
        JOptionPane.showMessageDialog(
                null,
                "Category deleted successfully.",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );
        marketsystem.gui.MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnDeleteActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Category().setVisible(true));
    }

    public void setTable() {
        ArrayList<marketsystem.Category> categories = CategoryRepository.getCategories();
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        model.setRowCount(0);
        for (marketsystem.Category category : categories) {
            model.addRow(new Object[]{
                category.getCategoryID(),
                category.getCategoryName(),
                category.getCategoryDescription()
            });
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel mainImage;
    // End of variables declaration//GEN-END:variables
}
