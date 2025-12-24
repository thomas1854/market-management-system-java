package marketsystem.gui;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import marketsystem.Supplier;
import marketsystem.database.SupplierRepository;

public class AddSupplier extends javax.swing.JFrame {

    ImageIcon picture = new ImageIcon("image6.jpg");
    Image img = picture.getImage();
    Image scaled;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AddSupplier.class.getName());
    SupplierFrame maf;

    public AddSupplier(SupplierFrame f) {
        initComponents();
        this.maf = f;
        this.setLocationRelativeTo(null);
        scaled = img.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
        jLabel1.setIcon(new ImageIcon(scaled));
    }

    public AddSupplier() {
        initComponents();
        this.setLocationRelativeTo(null);
        scaled = img.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
        jLabel1.setIcon(new ImageIcon(scaled));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_addsup = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_con = new javax.swing.JTextField();
        btn_addsup = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panel_addsup.setBackground(new java.awt.Color(129, 98, 76));
        panel_addsup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(251, 236, 216));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(58, 46, 27));
        jLabel2.setText("Supplier Name");
        jLabel2.setOpaque(true);
        panel_addsup.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 331, 40));
        panel_addsup.add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 331, 31));

        jLabel3.setBackground(new java.awt.Color(251, 236, 216));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(58, 46, 27));
        jLabel3.setText("Supplier Contact");
        jLabel3.setOpaque(true);
        panel_addsup.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 331, 40));

        txt_con.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_conActionPerformed(evt);
            }
        });
        panel_addsup.add(txt_con, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 331, 31));

        btn_addsup.setBackground(new java.awt.Color(251, 236, 216));
        btn_addsup.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_addsup.setForeground(new java.awt.Color(58, 50, 27));
        btn_addsup.setText("Add");
        btn_addsup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addsupActionPerformed(evt);
            }
        });
        panel_addsup.add(btn_addsup, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 310, 49));

        jButton1.setBackground(new java.awt.Color(251, 236, 216));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(58, 46, 27));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel_addsup.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 390, 310, 50));

        jLabel4.setBackground(new java.awt.Color(251, 236, 216));
        jLabel4.setFont(new java.awt.Font("Vivaldi", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(58, 46, 27));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Add Supplier");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27), 3));
        jLabel4.setOpaque(true);
        panel_addsup.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 320, -1));
        panel_addsup.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 930, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_addsup, javax.swing.GroupLayout.PREFERRED_SIZE, 926, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_addsup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_conActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_conActionPerformed

    }//GEN-LAST:event_txt_conActionPerformed

    private void btn_addsupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addsupActionPerformed
        if (txt_name.getText().isBlank() || txt_con.getText().isBlank()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Please fill in all required fields.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
            );
        } else {
            Supplier supplier = new Supplier();
            supplier.setName(txt_name.getText());
            supplier.setSupplierContact(txt_con.getText());
            SupplierRepository.insertSupplier(supplier);
            JOptionPane.showMessageDialog(
                    null,
                    "Supplier added successfully.",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );
            marketsystem.gui.MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btn_addsupActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new AddSupplier().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addsup;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel panel_addsup;
    private javax.swing.JTextField txt_con;
    private javax.swing.JTextField txt_name;
    // End of variables declaration//GEN-END:variables
}
