package package1;

import java.awt.Color;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JTextField;

public class NewJFrame1 extends javax.swing.JFrame {

    static Connection connection;
    static String url;
    static Statement st;
    static ResultSet rs;
 public int search(String id, String name) throws SQLException, ClassNotFoundException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    url = "jdbc:mysql://localhost:3306/bsisdb_final";
    connection = DriverManager.getConnection(url, "root", "12345");
    st = connection.createStatement();
    rs = st.executeQuery("SELECT * FROM regtable WHERE id= '" + id + "'");

    if (rs.next()) {
        return 1;
    } else {
        return 0;
    }
}
 
    public NewJFrame1() {
        initComponents();
        NewJFrame1.this.setLocation(400,180);
       jDateChooser1.getDateEditor().addPropertyChangeListener((var evt) -> {
            if ("date".equals(evt.getPropertyName())) {
                jDateChooser1.setForeground(Color.GREEN);
                textUserAddress.requestFocus();
            }
        });
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            url = "jdbc:mysql://localhost:3306/bsisdb_final";
            connection = DriverManager.getConnection(url, "root", "12345");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(NewJFrame1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labellname = new javax.swing.JLabel();
        labeladdress = new javax.swing.JLabel();
        textPassword = new javax.swing.JPasswordField();
        labelmobileno = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        labelemail = new javax.swing.JLabel();
        labelbday = new javax.swing.JLabel();
        labelpass = new javax.swing.JLabel();
        labelconfirmpass = new javax.swing.JLabel();
        textUserId = new javax.swing.JTextField();
        textConfirmPassword = new javax.swing.JPasswordField();
        textContactNumber = new javax.swing.JTextField();
        viewerPassword = new javax.swing.JCheckBox();
        textLastName = new javax.swing.JTextField();
        textUserName = new javax.swing.JTextField();
        textUserAddress = new javax.swing.JTextField();
        textEmailAddress = new javax.swing.JTextField();
        labelID = new javax.swing.JLabel();
        labelfname = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        labelmname = new javax.swing.JLabel();
        textMiddleName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        updateButton = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        showData = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labellname.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        labellname.setText("Last Name:");

        labeladdress.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        labeladdress.setText("Address:");

        textPassword.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        textPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPasswordActionPerformed(evt);
            }
        });

        labelmobileno.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        labelmobileno.setText("Mobile Number (e.g 09*********):");

        jLabel8.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel8.setText("I N S E R T  |  S T U D E N T - D A T A | ");

        labelemail.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        labelemail.setText("E-mail:");

        labelbday.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        labelbday.setText("Birthday:");

        labelpass.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        labelpass.setText("Password:");

        labelconfirmpass.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        labelconfirmpass.setText("Confirm Password:");

        textUserId.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        textUserId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textUserIdActionPerformed(evt);
            }
        });

        textConfirmPassword.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        textConfirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textConfirmPasswordActionPerformed(evt);
            }
        });

        textContactNumber.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        textContactNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textContactNumberActionPerformed(evt);
            }
        });

        viewerPassword.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        viewerPassword.setText("View Password");
        viewerPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewerPasswordActionPerformed(evt);
            }
        });

        textLastName.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        textLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textLastNameActionPerformed(evt);
            }
        });

        textUserName.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        textUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textUserNameActionPerformed(evt);
            }
        });

        textUserAddress.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        textUserAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textUserAddressActionPerformed(evt);
            }
        });

        textEmailAddress.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        textEmailAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEmailAddressActionPerformed(evt);
            }
        });

        labelID.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        labelID.setText("Enter ID:");

        labelfname.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        labelfname.setText("First Name:");

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SAVE DATA");
        jButton1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        jLabel1.setText("MM/DD/YYYY");

        labelmname.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        labelmname.setText("Middle Name: ");

        textMiddleName.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        textMiddleName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMiddleNameActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel9.setText("_________________________________________________________________________________________");

        updateButton.setBackground(new java.awt.Color(0, 51, 153));
        updateButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setText("UPDATE DATA");
        updateButton.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        updateButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        exit.setBackground(new java.awt.Color(255, 102, 0));
        exit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setText("EXIT");
        exit.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        showData.setBackground(new java.awt.Color(0, 0, 0));
        showData.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        showData.setForeground(new java.awt.Color(255, 255, 255));
        showData.setText("SHOW DATA");
        showData.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        showData.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(showData, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelpass)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(viewerPassword)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(47, 47, 47)
                                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelfname)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelmname)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labellname)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(labeladdress)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(textUserAddress))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(labelconfirmpass)
                                    .addGap(18, 18, 18)
                                    .addComponent(textConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelbday)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelmobileno, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(55, 55, 55)
                                        .addComponent(labelemail)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(textEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textUserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showData, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(labelID, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(textMiddleName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labellname)
                            .addComponent(textLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelmname)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelfname)
                        .addComponent(textUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(labelbday)
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(29, 29, 29)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textUserAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labeladdress))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelemail, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelmobileno)
                        .addComponent(textContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(labelpass)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelconfirmpass))
                    .addComponent(textPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(viewerPassword)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPasswordActionPerformed
    if (textPassword.getPassword() == null || new String(textPassword.getPassword()).isEmpty()) {
        JOptionPane.showMessageDialog(this, "Password must not be empty. Please enter a valid password.", "Password Error", JOptionPane.ERROR_MESSAGE);
        textPassword.setForeground(Color.RED);
        textPassword.setText("");
    } else {
        textPassword.setForeground(Color.GREEN);
        textConfirmPassword.requestFocus();
    }
    }//GEN-LAST:event_textPasswordActionPerformed

    private void textUserIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textUserIdActionPerformed
    String userId = textUserId.getText().trim();
    
    if (!userId.matches("\\d{6}")) {
        JOptionPane.showMessageDialog(this, "User ID must be a 6-digit number", "User ID Error", JOptionPane.ERROR_MESSAGE);
        textUserId.setText(""); 
    } else {
        int check = 0;
        try {
            check = search(userId, "");
        } catch (SQLException | ClassNotFoundException ex) {
        }

        if (check == 1) {
            JOptionPane.showMessageDialog(this, "User ID already exists", "User ID Error", JOptionPane.ERROR_MESSAGE);
            textUserId.setText(""); 
             textUserId.setForeground(Color.RED);
        } else {
        textUserId.setForeground(Color.GREEN);
        labelID.setForeground(Color.BLACK); 
        textUserName.requestFocus(); 
        }
    }
    }//GEN-LAST:event_textUserIdActionPerformed

    private void textConfirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textConfirmPasswordActionPerformed
    String confirmPassword = new String(textConfirmPassword.getPassword());
    String password = new String(textPassword.getPassword());

    if (confirmPassword.equals(password)) {
        textConfirmPassword.setForeground(Color.GREEN);
    } else {
        textConfirmPassword.setForeground(Color.RED);
        JOptionPane.showMessageDialog(this, "Passwords do not match", "Password Error", JOptionPane.ERROR_MESSAGE);
        textConfirmPassword.setText(""); 
    }
    }//GEN-LAST:event_textConfirmPasswordActionPerformed

    private void textContactNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textContactNumberActionPerformed

    String enteredContactNumber = textContactNumber.getText().trim();

    if (enteredContactNumber.matches("\\d{11}")) {
        if (isMobileNumberExists(enteredContactNumber)) {
            JOptionPane.showMessageDialog(this, "Mobile Number already exists. Please enter a different number.", "Duplicate Number Error", JOptionPane.ERROR_MESSAGE);
            textContactNumber.setForeground(Color.RED);
            textContactNumber.setText("");
        } else {
            textContactNumber.setForeground(Color.GREEN);
            textEmailAddress.requestFocus();
        }
    } else {
        JOptionPane.showMessageDialog(this, "Invalid contact number. Please enter a 11-digit number.", "Contact Number Error", JOptionPane.ERROR_MESSAGE);
        textContactNumber.setForeground(Color.RED);
        textContactNumber.setText("");
    }
    }//GEN-LAST:event_textContactNumberActionPerformed

    private boolean isMobileNumberExists(String mobileNumber) {
    try {
        String query = "SELECT * FROM regtable WHERE mobileno=?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, mobileNumber);
            ResultSet resultSet = pst.executeQuery();
            return resultSet.next();
        }
    } catch (SQLException ex) {
                return false;
    }
}
    
    private void viewerPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewerPasswordActionPerformed
    if (viewerPassword.isSelected()) {
        textPassword.setEchoChar((char) 0);
        textConfirmPassword.setEchoChar((char) 0);
    } else {
        textPassword.setEchoChar('*');
        textConfirmPassword.setEchoChar('*');
    }
    }//GEN-LAST:event_viewerPasswordActionPerformed

    private void textLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textLastNameActionPerformed
    String lastName = textLastName.getText().trim();

    if (!lastName.matches("[a-zA-Z]+")) {
        JOptionPane.showMessageDialog(this, "Last Name must contain only letters", "Last Name Error", JOptionPane.ERROR_MESSAGE);
        textLastName.setText(""); 
        textLastName.setForeground(Color.RED); 
    } else {
        textLastName.setForeground(Color.GREEN);
        jDateChooser1.requestFocusInWindow();
    }
    }//GEN-LAST:event_textLastNameActionPerformed

    private void textUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textUserNameActionPerformed
      String userName = textUserName.getText().trim();
    if (!userName.matches("[a-zA-Z\\s]+")) {
        JOptionPane.showMessageDialog(this, "User Name must contain only letters and spaces", "User Name Error", JOptionPane.ERROR_MESSAGE);
        textUserName.setText(""); 
        textUserName.setForeground(Color.RED);
    } else {
        int check = 0;
        try {
            check = search("", userName);
        } catch (SQLException | ClassNotFoundException ex) {
        }

        if (check == 1) {
            JOptionPane.showMessageDialog(this, "User Name already exists", "User Name Error", JOptionPane.ERROR_MESSAGE);
            textUserName.setText(""); 
            textUserName.setForeground(Color.RED); 
        } else {
            textUserName.setForeground(Color.GREEN);
            textMiddleName.requestFocus();
        }
    }
    }//GEN-LAST:event_textUserNameActionPerformed

    private void textUserAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textUserAddressActionPerformed
      String enteredAddress = textUserAddress.getText().trim();
    if (!enteredAddress.isEmpty()) {
        textUserAddress.setForeground(Color.GREEN);
        textContactNumber.requestFocus();
    } else {
        JOptionPane.showMessageDialog(this, "Address cannot be empty. Please enter a valid address.", "Address Error", JOptionPane.ERROR_MESSAGE);
        textUserAddress.setForeground(Color.RED);
        textUserAddress.requestFocus();
    }
    }//GEN-LAST:event_textUserAddressActionPerformed

    private void textEmailAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEmailAddressActionPerformed
    String enteredEmail = textEmailAddress.getText().trim();
    if (isValidEmail(enteredEmail)) {
        if (isEmailExists(enteredEmail)) {
            JOptionPane.showMessageDialog(this, "Email already exists. Please enter a different email.", "Email Error", JOptionPane.ERROR_MESSAGE);
            textEmailAddress.setForeground(Color.RED);
            textEmailAddress.setText("");
        } else {
            textEmailAddress.setForeground(Color.GREEN);
            textPassword.requestFocus();
        }
    } else {
        JOptionPane.showMessageDialog(this, "Invalid email format. Please enter a valid email address.", "Email Error", JOptionPane.ERROR_MESSAGE);
        textEmailAddress.setForeground(Color.RED);
        textEmailAddress.setText("");
    }
    }//GEN-LAST:event_textEmailAddressActionPerformed

    
    private boolean isValidEmail(String email) {
    return email.matches("^[\\w.-]+@([\\w-]+\\.)+[\\w]{2,4}$");
}

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try {
        int check = search(textUserId.getText(), textUserName.getText());

        if (check == 1) {
            JOptionPane.showMessageDialog(null, "User ID or User Name already exists", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try (Connection connection = DriverManager.getConnection(url, "root", "12345");
                 Statement st = connection.createStatement()) {
                java.util.Date selectedDate = jDateChooser1.getDate();
                java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
                
                st.executeUpdate("INSERT INTO regtable (Id, fname, mname, lname, birthday, address, mobileno, email, password) VALUES ('"
                        + textUserId.getText() + "','"
                        + textUserName.getText() + "','"
                        + textMiddleName.getText() + "','"
                        + textLastName.getText() + "','"
                        + sqlDate + "','"
                        + textUserAddress.getText() + "','"
                        + textContactNumber.getText() + "','"
                        + textEmailAddress.getText() + "','"
                        + textPassword.getText() + "')");

                JOptionPane.showMessageDialog(null, "Record Created", "Success", JOptionPane.INFORMATION_MESSAGE);
                
                textUserId.setText("");
                textUserName.setText("");
                textMiddleName.setText("");
                textLastName.setText("");
                jDateChooser1.setDate(null);
                textUserAddress.setText("");
                textContactNumber.setText("");
                textEmailAddress.setText("");
                textPassword.setText("");
                textConfirmPassword.setText("");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error inserting record into the database", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (SQLException | ClassNotFoundException ex) {
        JOptionPane.showMessageDialog(null, "Error processing the request", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void textMiddleNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMiddleNameActionPerformed
          String middleName = textMiddleName.getText().trim();

    if (!middleName.matches("[a-zA-Z]*")) {
        JOptionPane.showMessageDialog(this, "Middle Name must contain only letters", "Middle Name Error", JOptionPane.ERROR_MESSAGE);
        textMiddleName.setText("");
        textMiddleName.setForeground(Color.RED);
    } else {
        textMiddleName.setForeground(Color.GREEN);
        textLastName.requestFocusInWindow();
    }
    }//GEN-LAST:event_textMiddleNameActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        Upd_Del updateFrame = new Upd_Del();
        updateFrame.setVisible(true);
        NewJFrame1.this.setVisible(false);
    }//GEN-LAST:event_updateButtonActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void showDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showDataActionPerformed
        DisplayTable updateFrame = new DisplayTable();
        updateFrame.setVisible(true);
        NewJFrame1.this.setVisible(false);
    }//GEN-LAST:event_showDataActionPerformed
       
   public static void main(String args[]) {
       java.awt.EventQueue.invokeLater(() -> {
        new NewJFrame1().setVisible(true);
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel labelID;
    private javax.swing.JLabel labeladdress;
    private javax.swing.JLabel labelbday;
    private javax.swing.JLabel labelconfirmpass;
    private javax.swing.JLabel labelemail;
    private javax.swing.JLabel labelfname;
    private javax.swing.JLabel labellname;
    private javax.swing.JLabel labelmname;
    private javax.swing.JLabel labelmobileno;
    private javax.swing.JLabel labelpass;
    private javax.swing.JButton showData;
    private javax.swing.JPasswordField textConfirmPassword;
    private javax.swing.JTextField textContactNumber;
    private javax.swing.JTextField textEmailAddress;
    private javax.swing.JTextField textLastName;
    private javax.swing.JTextField textMiddleName;
    private javax.swing.JPasswordField textPassword;
    private javax.swing.JTextField textUserAddress;
    private javax.swing.JTextField textUserId;
    private javax.swing.JTextField textUserName;
    private javax.swing.JButton updateButton;
    private javax.swing.JCheckBox viewerPassword;
    // End of variables declaration//GEN-END:variables

   private boolean isEmailExists(String enteredEmail) {
    try {
        String query = "SELECT * FROM regtable WHERE email=?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, enteredEmail);
            ResultSet resultSet = pst.executeQuery();
            return resultSet.next();
        }
    } catch (SQLException ex) { 
        return false;
    }
}
}