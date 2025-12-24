package marketsystem.gui;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import marketsystem.database.SupplierRepository;

public class SupplierFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SupplierFrame.class.getName());
    ImageIcon picture = new ImageIcon("image6.jpg");
    Image img = picture.getImage();
    Image scaled;
    MainFrame mainf;

    public SupplierFrame(MainFrame mf) {
        initComponents();
        this.mainf = mf;
        this.setLocationRelativeTo(null);
        scaled = img.getScaledInstance(lbl_supframe.getWidth(), lbl_supframe.getHeight(), Image.SCALE_SMOOTH);
        lbl_supframe.setIcon(new ImageIcon(scaled));
        setTable();
    }

    public SupplierFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        scaled = img.getScaledInstance(lbl_supframe.getWidth(), lbl_supframe.getHeight(), Image.SCALE_SMOOTH);
        lbl_supframe.setIcon(new ImageIcon(scaled));
        setTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_supframe = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        suppliersTable = new javax.swing.JTable();
        lbl_supframe = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(pnl_supframe, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, -1, -1));

        jLabel1.setBackground(new java.awt.Color(251, 236, 216));
        jLabel1.setFont(new java.awt.Font("Vivaldi", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(58, 46, 27));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Suppliers");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27), 3));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 240, 70));

        jButton1.setBackground(new java.awt.Color(251, 236, 216));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(58, 46, 27));
        jButton1.setText("Delete Supplier");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 590, 200, 50));

        jButton2.setBackground(new java.awt.Color(251, 236, 216));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(58, 46, 27));
        jButton2.setText("Add supplier");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 590, 200, 50));

        jButton4.setBackground(new java.awt.Color(251, 236, 216));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(58, 46, 27));
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 590, 200, 50));

        suppliersTable.setAutoCreateRowSorter(true);
        suppliersTable.setBackground(new java.awt.Color(251, 236, 216));
        suppliersTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27)));
        suppliersTable.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        suppliersTable.setForeground(new java.awt.Color(58, 46, 27));
        suppliersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Supplier Name", "Contact"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        suppliersTable.setDragEnabled(true);
        suppliersTable.setGridColor(new java.awt.Color(58, 46, 27));
        suppliersTable.setRowHeight(25);
        suppliersTable.setSelectionBackground(new java.awt.Color(251, 236, 216));
        suppliersTable.setSelectionForeground(new java.awt.Color(58, 46, 27));
        suppliersTable.setShowGrid(true);
        jScrollPane1.setViewportView(suppliersTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 870, -1));
        getContentPane().add(lbl_supframe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed
private void setTable() {
        DefaultTableModel model = (DefaultTableModel) suppliersTable.getModel();
        ArrayList<marketsystem.Supplier> suppliers = SupplierRepository.getSuppliers();
        model.setRowCount(0);
        for (marketsystem.Supplier supplier : suppliers) {
            model.addRow(new Object[]{
                supplier.getSupplierID(),
                supplier.getSupplierName(),
                supplier.getSupplierContact()
            });
        }
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AddSupplier p = new AddSupplier(this);
        p.setVisible(true);
        this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String supplierID = JOptionPane.showInputDialog(
                null,
                "Enter the Supplier ID to delete:",
                "Delete Supplier",
                JOptionPane.QUESTION_MESSAGE
        );
        if (supplierID == null) {
            return;
        }
        if (supplierID.isBlank()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Please enter a value. This field cannot be empty.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        marketsystem.Supplier supplier = SupplierRepository.getSupplierByID(Integer.valueOf(supplierID));
        if (supplier.getSupplierID() == 0) {
            JOptionPane.showMessageDialog(
                    null,
                    "This Supplier ID does not exist in the system.",
                    "Not Found",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        SupplierRepository.deleteSupplier(supplier);
        JOptionPane.showMessageDialog(
                null,
                "Supplier deleted successfully.",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );
        MainFrame mf=new MainFrame();
        mf.setVisible(true);
        dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> new SupplierFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_supframe;
    private javax.swing.JPanel pnl_supframe;
    private javax.swing.JTable suppliersTable;
    // End of variables declaration//GEN-END:variables
}
