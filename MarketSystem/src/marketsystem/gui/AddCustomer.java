package marketsystem.gui;

import java.awt.Image;
import javax.swing.*;
import javax.swing.JOptionPane;
import marketsystem.Customer;
import marketsystem.database.CustomerRepository;

public class AddCustomer extends javax.swing.JFrame {

    ImageIcon picture = new ImageIcon("image7.jpg");
    Image img = picture.getImage();
    Image scaled;
    public MainFrame mainf;

    public AddCustomer(MainFrame mf) {
        initComponents();
        this.setLocationRelativeTo(null);
        scaled = img.getScaledInstance(img_addCust.getWidth(), img_addCust.getHeight(), Image.SCALE_SMOOTH);
        img_addCust.setIcon(new ImageIcon(scaled));
    }

    public AddCustomer() {
        initComponents();
        this.setLocationRelativeTo(null);
        scaled = img.getScaledInstance(img_addCust.getWidth(), img_addCust.getHeight(), Image.SCALE_SMOOTH);
        img_addCust.setIcon(new ImageIcon(scaled));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_addCust = new javax.swing.JPanel();
        lbl_phone = new javax.swing.JLabel();
        lbl_points = new javax.swing.JLabel();
        img_addCust = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        txt_phone = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lbl_phone.setBackground(new java.awt.Color(251, 236, 216));
        lbl_phone.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lbl_phone.setForeground(new java.awt.Color(58, 46, 27));
        lbl_phone.setText("Name");
        lbl_phone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27), 3));
        lbl_phone.setOpaque(true);

        lbl_points.setBackground(new java.awt.Color(251, 236, 216));
        lbl_points.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lbl_points.setForeground(new java.awt.Color(58, 46, 26));
        lbl_points.setText("Phone");
        lbl_points.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27), 3));
        lbl_points.setOpaque(true);

        img_addCust.setForeground(new java.awt.Color(129, 98, 76));

        txt_name.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txt_name.setForeground(new java.awt.Color(58, 46, 27));

        txt_phone.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txt_phone.setForeground(new java.awt.Color(58, 46, 27));

        jLabel1.setBackground(new java.awt.Color(251, 236, 216));
        jLabel1.setFont(new java.awt.Font("Vivaldi", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(58, 46, 27));
        jLabel1.setText("Add Customer");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27), 3));
        jLabel1.setOpaque(true);

        jButton1.setBackground(new java.awt.Color(58, 46, 27));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(251, 236, 216));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_add.setBackground(new java.awt.Color(58, 46, 27));
        btn_add.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_add.setForeground(new java.awt.Color(251, 236, 216));
        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_addCustLayout = new javax.swing.GroupLayout(pnl_addCust);
        pnl_addCust.setLayout(pnl_addCustLayout);
        pnl_addCustLayout.setHorizontalGroup(
            pnl_addCustLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_addCustLayout.createSequentialGroup()
                .addGroup(pnl_addCustLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_addCustLayout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(jLabel1))
                    .addGroup(pnl_addCustLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbl_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_addCustLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbl_points, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txt_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_addCustLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_addCustLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(img_addCust, javax.swing.GroupLayout.PREFERRED_SIZE, 1044, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_addCustLayout.setVerticalGroup(
            pnl_addCustLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_addCustLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addGroup(pnl_addCustLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnl_addCustLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_points, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnl_addCustLayout.createSequentialGroup()
                .addComponent(img_addCust, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(pnl_addCust, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        if (txt_name.getText().isBlank() || txt_phone.getText().isBlank()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Please fill in all required fields.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
            );
        } else {
            Customer customer = new Customer();
            customer.setCustomerName(txt_name.getText());
            customer.setPhone(txt_phone.getText());
            CustomerRepository.insertCustomer(customer);
            JOptionPane.showMessageDialog(
                    null,
                    "Customer added successfully.",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );
            marketsystem.gui.MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
            dispose();
        }

    }//GEN-LAST:event_btn_addActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        dispose();  // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new AddCustomer().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JLabel img_addCust;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_phone;
    private javax.swing.JLabel lbl_points;
    private javax.swing.JPanel pnl_addCust;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_phone;
    // End of variables declaration//GEN-END:variables
}
