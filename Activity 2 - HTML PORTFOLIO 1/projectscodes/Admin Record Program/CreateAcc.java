package package1;
import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.PreparedStatement; 

public class CreateAcc extends javax.swing.JFrame {
    public CreateAcc() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textUserName = new javax.swing.JTextField();
        textEmailAddress = new javax.swing.JTextField();
        createButton = new javax.swing.JButton();
        labeluserName = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        labelPass = new javax.swing.JLabel();
        textPassword = new javax.swing.JPasswordField();
        textPasswordConfirm = new javax.swing.JPasswordField();
        labelconfirmPass = new javax.swing.JLabel();
        passwordViewer = new javax.swing.JCheckBox();
        loginButton = new javax.swing.JButton();
        canvas1 = new java.awt.Canvas();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jToolBar1 = new javax.swing.JToolBar();
        labelCA = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        labelAHO = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textUserName.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        textUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textUserNameActionPerformed(evt);
            }
        });

        textEmailAddress.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        textEmailAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEmailAddressActionPerformed(evt);
            }
        });

        createButton.setBackground(new java.awt.Color(0, 51, 102));
        createButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        createButton.setForeground(new java.awt.Color(255, 255, 255));
        createButton.setText("C R E A T E");
        createButton.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        createButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        labeluserName.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        labeluserName.setText("Username:");

        labelEmail.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        labelEmail.setText("E-mail:");

        labelPass.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        labelPass.setText("Password:");

        textPassword.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        textPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPasswordActionPerformed(evt);
            }
        });

        textPasswordConfirm.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        textPasswordConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPasswordConfirmActionPerformed(evt);
            }
        });

        labelconfirmPass.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        labelconfirmPass.setText("Confirm Password:");

        passwordViewer.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        passwordViewer.setText("View Password");
        passwordViewer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordViewerActionPerformed(evt);
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

        jToolBar1.setRollover(true);

        labelCA.setBackground(new java.awt.Color(204, 204, 255));
        labelCA.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        labelCA.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelCA.setText("C R E A T E | A C C O U N T | A D M I N");
        jToolBar1.add(labelCA);

        jDesktopPane1.setLayer(jToolBar1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        labelAHO.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        labelAHO.setText("ALREADY HAVE ONE?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labeluserName)
                                    .addComponent(labelPass)
                                    .addComponent(labelEmail))
                                .addGap(73, 73, 73))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(labelconfirmPass)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordViewer)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textPasswordConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                                    .addComponent(textUserName)
                                    .addComponent(textEmailAddress)
                                    .addComponent(textPassword))
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelAHO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labeluserName))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelEmail))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPass)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(labelAHO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textPasswordConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelconfirmPass))
                .addGap(18, 18, 18)
                .addComponent(passwordViewer)
                .addGap(28, 28, 28)
                .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(233, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {labelPass, labelconfirmPass, labeluserName});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textUserNameActionPerformed
    labeluserName.setForeground(Color.black);
    labelEmail.setForeground(Color.black);
    labelPass.setForeground(Color.black);

    String userName = textUserName.getText();
    if (userName.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Username cannot be empty", "System Message", JOptionPane.ERROR_MESSAGE);
        labeluserName.setForeground(Color.red);
        return;
    }
    
    if (!userName.matches("^[a-zA-Z]+$")) {
        JOptionPane.showMessageDialog(null, "Username should contain only letters", "System Message", JOptionPane.ERROR_MESSAGE);
        labeluserName.setForeground(Color.red);
        textUserName.setForeground(Color.red);
        return; 
    }

    try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    String url = "jdbc:mysql://localhost:3306/bsisdb_final";
        try (Connection connection = DriverManager.getConnection(url, "root", "12345"); Statement st = connection.createStatement(); ResultSet rs = st.executeQuery("SELECT username FROM logintable")) {
            while (rs.next()) {
                String existingUsername = rs.getString("username");
                if (existingUsername.equalsIgnoreCase(userName)) {
                    JOptionPane.showMessageDialog(null, "Username already in use", "System Message", JOptionPane.ERROR_MESSAGE);
                    labeluserName.setForeground(Color.red);
                    textUserName.setForeground(Color.red);
                    rs.close();
                    st.close();
                    connection.close();
                    return;
                }
            }
            if (userName.matches("0123456789")) {
                JOptionPane.showMessageDialog(null, "Username should not contain numbers", "System Message", JOptionPane.ERROR_MESSAGE);
                labeluserName.setForeground(Color.red);
                textUserName.setForeground(Color.red);
                rs.close();
                st.close();
                connection.close();
                return;
            }
            labeluserName.setForeground(Color.green);
            textUserName.setForeground(Color.green);
            
            JOptionPane.showMessageDialog(null, "Username Finalized", "System Message", JOptionPane.INFORMATION_MESSAGE);
            textUserName.setEditable(false);
            textEmailAddress.requestFocus();
            
        }

        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "System Message", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_textUserNameActionPerformed

    
    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
    labeluserName.setForeground(Color.black);
    labelEmail.setForeground(Color.black);
    labelPass.setForeground(Color.black);


    String userName = textUserName.getText().trim();
    String userEmail = textEmailAddress.getText().trim();
    String password = new String(textPassword.getPassword()).trim();
    String confirmPassword = new String(textPasswordConfirm.getPassword()).trim();


    if (userName.isEmpty() || userEmail.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please fill in all fields", "System Message", JOptionPane.ERROR_MESSAGE);
        return; 
    }

    if (!password.equals(confirmPassword)) {
        JOptionPane.showMessageDialog(null, "Passwords do not match", "System Message", JOptionPane.ERROR_MESSAGE);
        return; 
    }
    String userId = generateUniqueID();

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/bsisdb_final";
        try (Connection connection = DriverManager.getConnection(url, "root", "12345")) {
            String insertQuery = "INSERT INTO logintable (id, username, email, password) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, userId);
                preparedStatement.setString(2, userName);
                preparedStatement.setString(3, userEmail);
                preparedStatement.setString(4, password);
                
                int rowsAffected = preparedStatement.executeUpdate();
                
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Account Created with ID: " + userId, "System Message", JOptionPane.INFORMATION_MESSAGE);
                    LoginAcc page = new LoginAcc();
                    page.setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to create account", "System Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    } catch (SQLException | ClassNotFoundException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "System Message", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_createButtonActionPerformed

    private void textEmailAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEmailAddressActionPerformed
    labeluserName.setForeground(Color.black);
    labelEmail.setForeground(Color.black);
    labelPass.setForeground(Color.black);
    String userEmail = textEmailAddress.getText();
    String emailRegex = "^[A-Za-z0-9_+&*-]+(?:\\.[A-Za-z0-9_+&*-]+)*@(?:[A-Za-z0-9-]+\\.)+[A-Za-z]{2,7}$";
    if (!userEmail.matches(emailRegex)) {
        JOptionPane.showMessageDialog(null, "Invalid email format", "System Message", JOptionPane.ERROR_MESSAGE);
        labelEmail.setForeground(Color.red);
        return;
    }

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/bsisdb_final";
        try (Connection connection = DriverManager.getConnection(url, "root", "12345"); PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM logintable WHERE BINARY email = ?")) {
            preparedStatement.setString(1, userEmail);
            
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Email already has an account", "System Message", JOptionPane.ERROR_MESSAGE);
                    labelEmail.setForeground(Color.red);
                    textEmailAddress.setForeground(Color.red);
                    return;
                }
                labelEmail.setForeground(Color.green);
                textEmailAddress.setForeground(Color.green);
                
                textEmailAddress.setEditable(false);
                
                JOptionPane.showMessageDialog(null, "Email verification code sent.", "System Message", JOptionPane.INFORMATION_MESSAGE);
                
                textPassword.requestFocus();
            }
        }

    } catch (SQLException | ClassNotFoundException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "System Message", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_textEmailAddressActionPerformed

    private void textPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPasswordActionPerformed
     labeluserName.setForeground(Color.black);
    labelEmail.setForeground(Color.black);
    labelPass.setForeground(Color.black);

    String userPassword = new String(textPassword.getPassword());

    if (checkPasswordStrength(userPassword)) {
        JOptionPane.showMessageDialog(null, "Strong Password. You may proceed.", "Password Strength", JOptionPane.INFORMATION_MESSAGE);
       
        labelPass.setForeground(Color.green);
    } else {
        JOptionPane.showMessageDialog(null, "The password is weak. Please choose a stronger password.", "Password Strength", JOptionPane.WARNING_MESSAGE);
        labelPass.setForeground(Color.red);
        textPassword.setText(""); 

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/bsisdb_final";
        try (Connection connection = DriverManager.getConnection(url, "root", "12345")) {
            Statement st = connection.createStatement();
            st.close();
        }

    } catch (SQLException | ClassNotFoundException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "System Message", JOptionPane.ERROR_MESSAGE);
    }
    }
    }//GEN-LAST:event_textPasswordActionPerformed

    private void passwordViewerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordViewerActionPerformed
           if (passwordViewer.isSelected()) {
        textPassword.setEchoChar((char) 0); 
        textPasswordConfirm.setEchoChar((char) 0);
    } else {
        textPassword.setEchoChar('\u2022');
        textPasswordConfirm.setEchoChar('\u2022');
    }
    }//GEN-LAST:event_passwordViewerActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
         
            LoginAcc page = new LoginAcc();
            page.setVisible(true);
            setVisible(false);
    }//GEN-LAST:event_loginButtonActionPerformed

    private void textPasswordConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPasswordConfirmActionPerformed
    labeluserName.setForeground(Color.black);
    labelEmail.setForeground(Color.black);
    labelPass.setForeground(Color.black);
    String password = new String(textPassword.getPassword());
    String confirmPassword = new String(textPasswordConfirm.getPassword());
    if (!password.equals(confirmPassword)) {
        JOptionPane.showMessageDialog(null, "Passwords do not match. Please enter matching passwords.", "System Message", JOptionPane.ERROR_MESSAGE);
        labelPass.setForeground(Color.red);
        return;
    }
    labelPass.setForeground(Color.green);
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/bsisdb_final";
        try (Connection connection = DriverManager.getConnection(url, "root", "12345")) {
            Statement st = connection.createStatement();
            st.close();
        }

    } catch (SQLException | ClassNotFoundException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "System Message", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_textPasswordConfirmActionPerformed
    
    private boolean checkPasswordStrength(String password) {
            return password.length() >= 8
            && password.matches(".*[A-Z].*")
            && password.matches(".*[a-z].*")
            && password.matches(".*\\d.*")
            && password.matches(".*[!@#$%^&*()-_=+{};:,<.>/?\\[\\]_`~].*");
}
   
    private String generateUniqueID() {
    return String.format("%06d", new java.util.Random().nextInt(1000000));
}

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new CreateAcc().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas canvas1;
    private javax.swing.JButton createButton;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel labelAHO;
    private javax.swing.JLabel labelCA;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelPass;
    private javax.swing.JLabel labelconfirmPass;
    private javax.swing.JLabel labeluserName;
    private javax.swing.JButton loginButton;
    private javax.swing.JCheckBox passwordViewer;
    private javax.swing.JTextField textEmailAddress;
    private javax.swing.JPasswordField textPassword;
    private javax.swing.JPasswordField textPasswordConfirm;
    private javax.swing.JTextField textUserName;
    // End of variables declaration//GEN-END:variables

}
