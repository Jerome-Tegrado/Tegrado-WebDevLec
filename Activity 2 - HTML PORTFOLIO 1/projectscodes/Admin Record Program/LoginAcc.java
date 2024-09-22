package package1;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class LoginAcc extends javax.swing.JFrame {

    public LoginAcc() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelA = new javax.swing.JLabel();
        userText = new javax.swing.JTextField();
        labelPass = new javax.swing.JLabel();
        userPass = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelA.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        labelA.setText("User-ID:");

        userText.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        userText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTextActionPerformed(evt);
            }
        });

        labelPass.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        labelPass.setText("Password:");

        userPass.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        userPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userPassActionPerformed(evt);
            }
        });

        loginButton.setBackground(new java.awt.Color(0, 153, 51));
        loginButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("L O G - I N");
        loginButton.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        loginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel1.setText("L O G I N | A D M I N");

        jCheckBox1.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        jCheckBox1.setText("View Password");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPass)
                    .addComponent(labelA))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(userText, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                                    .addComponent(userPass))
                                .addGap(72, 72, 72))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(209, 209, 209))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelA)
                    .addComponent(userText, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPass)
                    .addComponent(userPass, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTextActionPerformed
        labelA.setForeground(Color.black);
        labelPass.setForeground(Color.black);
    String userID = userText.getText();
    if (userID.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Username cannot be empty", "System Message", JOptionPane.ERROR_MESSAGE);
        labelA.setForeground(Color.red);
        return;
    }
    userPass.requestFocus();
    }//GEN-LAST:event_userTextActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
         String adminID = userText.getText();
    String adminPass = userPass.getText();

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conDB = DriverManager.getConnection("jdbc:mysql://localhost:3306/bsisdb_final", "root", "12345");

        String query = "SELECT * FROM logintable WHERE id = ? AND password = ?";
        try (PreparedStatement preparedStatement = conDB.prepareStatement(query)) {
            preparedStatement.setString(1, adminID);
            preparedStatement.setString(2, adminPass);

            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                NewJFrame1 insertPage = new NewJFrame1();
                insertPage.setVisible(true);
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid ID or password", "Error", JOptionPane.ERROR_MESSAGE);
                userText.setText("");
                userPass.setText("");
            }
        }
    } catch (SQLException | ClassNotFoundException e) {
        JOptionPane.showMessageDialog(null, "Error connecting to the database", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void userPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userPassActionPerformed
         labelA.setForeground(Color.black);
    labelPass.setForeground(Color.black);
    String userPassword = new String(userPass.getPassword());
    if (userPassword.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Password cannot be empty", "System Message", JOptionPane.ERROR_MESSAGE);
        labelPass.setForeground(Color.red);
    }

    }//GEN-LAST:event_userPassActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
      if (jCheckBox1.isSelected()) {
        userPass.setEchoChar((char) 0); 
    } else {
        userPass.setEchoChar('\u2022'); 
    }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new LoginAcc().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelA;
    private javax.swing.JLabel labelPass;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField userPass;
    private javax.swing.JTextField userText;
    // End of variables declaration//GEN-END:variables
}
