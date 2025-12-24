package marketsystem.gui;

import java.awt.Image;
import javax.swing.*;

public class LogIn extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LogIn.class.getName());
    ImageIcon picture = new ImageIcon("image5.jpg");
    Image img = picture.getImage();
    Image scaled;

    public LogIn() {
        initComponents();
        this.setLocationRelativeTo(null);
        scaled = img.getScaledInstance(mainImage.getWidth(), mainImage.getHeight(), Image.SCALE_SMOOTH);
        mainImage.setIcon(new ImageIcon(scaled));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AllButtons = new javax.swing.JPanel();
        btnCategories = new javax.swing.JButton();
        Welcome = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        mainImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AllButtons.setBackground(new java.awt.Color(251, 241, 221));
        AllButtons.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27), 5));

        btnCategories.setBackground(new java.awt.Color(251, 236, 216));
        btnCategories.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnCategories.setForeground(new java.awt.Color(58, 46, 27));
        btnCategories.setText("Enter");
        btnCategories.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 46, 27), 3));
        btnCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriesActionPerformed(evt);
            }
        });

        Welcome.setFont(new java.awt.Font("Vivaldi", 1, 48)); // NOI18N
        Welcome.setForeground(new java.awt.Color(58, 46, 27));
        Welcome.setText("Welcome To Our Mangement System");

        username.setBackground(new java.awt.Color(58, 46, 27));
        username.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        username.setForeground(new java.awt.Color(251, 236, 216));
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(58, 46, 27));
        jLabel1.setText("Username");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(58, 46, 27));
        jLabel2.setText("Password");

        password.setBackground(new java.awt.Color(58, 46, 27));
        password.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        password.setForeground(new java.awt.Color(251, 236, 216));

        javax.swing.GroupLayout AllButtonsLayout = new javax.swing.GroupLayout(AllButtons);
        AllButtons.setLayout(AllButtonsLayout);
        AllButtonsLayout.setHorizontalGroup(
            AllButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AllButtonsLayout.createSequentialGroup()
                .addGroup(AllButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AllButtonsLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(Welcome))
                    .addGroup(AllButtonsLayout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addGroup(AllButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(password)))
                    .addGroup(AllButtonsLayout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(btnCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        AllButtonsLayout.setVerticalGroup(
            AllButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AllButtonsLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(Welcome)
                .addGap(80, 80, 80)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(253, Short.MAX_VALUE))
        );

        getContentPane().add(AllButtons, new org.netbeans.lib.awtextra.AbsoluteConstraints(641, 0, 760, 770));
        getContentPane().add(mainImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 650, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriesActionPerformed
        final String usernam_auth = "admin";
        final String password_auth = "admin";
        if (username.getText().equals(usernam_auth) && password_auth.equals(password.getText())) {
            marketsystem.gui.MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Invalid username and password.",
                    "Log in",
                    JOptionPane.WARNING_MESSAGE
            );

        }
    }//GEN-LAST:event_btnCategoriesActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new LogIn().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AllButtons;
    private javax.swing.JLabel Welcome;
    private javax.swing.JButton btnCategories;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel mainImage;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
