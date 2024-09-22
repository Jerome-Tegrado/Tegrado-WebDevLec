package package1;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Upd_Del extends javax.swing.JFrame {
    Connection con;
    PreparedStatement pst;

    public Upd_Del() {
       initComponents();
        Connect();
        textUserName.setText("");
        textUserName.setEnabled(true);
        textLastName.setText("");
        textLastName.setEnabled(true);
        textMiddleName.setText("");
        textMiddleName.setEnabled(true);
        jDateChooser1.setDate(null);
        jDateChooser1.setEnabled(true);
        textUserAddress.setText("");
        textUserAddress.setEnabled(true);
        textContactNumber.setText("");
        textContactNumber.setEnabled(true);
        textEmailAddress.setText("");
        textEmailAddress.setEnabled(true);
        textPassword.setText("");
        textPassword.setEnabled(true);
 
        updateButton.setEnabled(false);
        
        Upd_Del.this.setLocation(330,140);

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchId = new javax.swing.JTextField();
        textContactNumber = new javax.swing.JTextField();
        viewerPassword = new javax.swing.JCheckBox();
        textLastName = new javax.swing.JTextField();
        textUserName = new javax.swing.JTextField();
        textUserAddress = new javax.swing.JTextField();
        textEmailAddress = new javax.swing.JTextField();
        labelID = new javax.swing.JLabel();
        labellname = new javax.swing.JLabel();
        labeladdress = new javax.swing.JLabel();
        textPassword = new javax.swing.JPasswordField();
        labelmobileno = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        labelemail = new javax.swing.JLabel();
        labelbday = new javax.swing.JLabel();
        labelpass = new javax.swing.JLabel();
        labelfname = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        labellname1 = new javax.swing.JLabel();
        textMiddleName = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        showData = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        searchId.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        searchId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchIdActionPerformed(evt);
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
        labelID.setText("ID:");

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
        jLabel8.setText("S E A R C H  |  U P D A T E  |  D E L E T E  |  S T U D E N T - D A T A");

        labelemail.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        labelemail.setText("E-mail:");

        labelbday.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        labelbday.setText("Birthday:");

        labelpass.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        labelpass.setText("Password:");

        labelfname.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        labelfname.setText("First Name:");

        searchButton.setBackground(new java.awt.Color(204, 0, 0));
        searchButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("SEARCH");
        searchButton.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        searchButton.setBorderPainted(false);
        searchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        updateButton.setBackground(new java.awt.Color(0, 153, 51));
        updateButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setText("UPDATE");
        updateButton.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        updateButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(0, 51, 102));
        deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("DELETE");
        deleteButton.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        deleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        labellname1.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        labellname1.setText("Middle Name:");

        textMiddleName.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        textMiddleName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMiddleNameActionPerformed(evt);
            }
        });

        showData.setBackground(new java.awt.Color(0, 0, 0));
        showData.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        showData.setForeground(new java.awt.Color(255, 255, 255));
        showData.setText("SHOW DATA");
        showData.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelmobileno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(370, 370, 370))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelbday)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(603, 603, 603))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(showData, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchId, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelfname)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labellname1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labellname)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(labelpass)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(viewerPassword)
                                .addComponent(textPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(40, 40, 40)
                                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(labeladdress)
                            .addGap(18, 18, 18)
                            .addComponent(textUserAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(536, 536, 536)
                        .addComponent(labelemail)
                        .addGap(18, 18, 18)
                        .addComponent(textEmailAddress)
                        .addGap(22, 22, 22)))
                .addGap(74, 74, 74))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(showData, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelID)
                    .addComponent(searchId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textUserName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labellname1)
                        .addComponent(textMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labellname)
                        .addComponent(textLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelfname)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(labelbday))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textUserAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labeladdress))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelmobileno)
                    .addComponent(textEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelemail)
                    .addComponent(textContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelpass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewerPassword)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textContactNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textContactNumberActionPerformed
       
    }//GEN-LAST:event_textContactNumberActionPerformed

    private void viewerPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewerPasswordActionPerformed
    if (viewerPassword.isSelected()) {
        textPassword.setEchoChar((char) 0);
    } else {
        textPassword.setEchoChar('*');
    }
    }//GEN-LAST:event_viewerPasswordActionPerformed

    private void textLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textLastNameActionPerformed
       
    }//GEN-LAST:event_textLastNameActionPerformed

    private void textUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textUserNameActionPerformed
       
    }//GEN-LAST:event_textUserNameActionPerformed

    private void textUserAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textUserAddressActionPerformed
     
    }//GEN-LAST:event_textUserAddressActionPerformed

    private void textEmailAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEmailAddressActionPerformed
       
    }//GEN-LAST:event_textEmailAddressActionPerformed

    private void textPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPasswordActionPerformed
       
    }//GEN-LAST:event_textPasswordActionPerformed


    public final void Connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/bsisdb_final","root","12345");
            
        } catch (ClassNotFoundException | SQLException ex) {
          
        }
    }
    
    private void clearFields() {
    textUserName.setText("");
    textMiddleName.setText("");
    textLastName.setText("");
    jDateChooser1.setDate(null);
    textUserAddress.setText("");
    textContactNumber.setText("");
    textEmailAddress.setText("");
    textPassword.setText("");
}

    
    private void displayData(ResultSet rs) throws SQLException {
    textUserName.setText(rs.getString("fname"));
    textMiddleName.setText(rs.getString("mname"));
    textLastName.setText(rs.getString("lname"));
    jDateChooser1.setDate(rs.getDate("birthday"));
    textUserAddress.setText(rs.getString("address"));
    textContactNumber.setText(rs.getString("mobileno"));
    textEmailAddress.setText(rs.getString("email"));
    textPassword.setText(rs.getString("password"));
}

    
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
     try {
        Connect();
        pst = con.prepareStatement("select id,fname,mname,lname,birthday,address,mobileno,email,password from regtable where id=? ");
        int id = Integer.parseInt(searchId.getText());
        pst.setInt(1, id);
        ResultSet rs1 = pst.executeQuery();
        if (rs1.next() == false) {
            JOptionPane.showMessageDialog(this, "Sorry Record Not Found");
            clearFields();
            searchId.requestFocus();
        } else {
            displayData(rs1);
            updateButton.setEnabled(true);
        }
    } catch (SQLException ex) {
    }
    }//GEN-LAST:event_searchButtonActionPerformed
    
    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
       int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to update this record?", "System Message", JOptionPane.YES_NO_OPTION);
    if (answer == JOptionPane.YES_OPTION) {
        try {
            deleteButton.setEnabled(true);
            Connection cn;
            Statement st;
            String url = "jdbc:mysql://localhost:3306/bsisdb_final";
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(url, "root", "12345");
            st = cn.createStatement();
            java.util.Date selectedDate = jDateChooser1.getDate();
            java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
            st.executeUpdate("UPDATE regtable SET fname= '"
                    + textUserName.getText() + "', mname= '"
                    + textMiddleName.getText() + "', lname= '"
                    + textLastName.getText() + "', birthday= '"
                    + sqlDate + "', address= '"
                    + textUserAddress.getText() + "', mobileno= '"
                    + textContactNumber.getText() + "', email = '"
                    + textEmailAddress.getText() + "', password='"
                    + textPassword.getText()
                    + "' WHERE id = '"
                    + searchId.getText() + "'");
            JOptionPane.showMessageDialog(null, "Record Updated", "System Message", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        } catch (ClassNotFoundException | SQLException ex) {
        }
    }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
     int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "System Message", JOptionPane.YES_NO_OPTION);
    if (answer == JOptionPane.YES_OPTION) {
        try {
            deleteButton.setEnabled(true);
            Connection cn;
            Statement st;
            String url = "jdbc:mysql://localhost:3306/bsisdb_final";
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(url, "root", "12345");
            st = cn.createStatement();

            st.executeUpdate("DELETE FROM regtable WHERE id = '" + searchId.getText() + "'");
            JOptionPane.showMessageDialog(null, "Record Deleted", "System Message", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        } catch (ClassNotFoundException | SQLException ex) {
        }
    }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void searchIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchIdActionPerformed
try {   
        Connect();
        pst = con.prepareStatement("select id,fname,mname,lname,birthday,address,mobileno,email,password from regtable where id=? ");
        int id = Integer.parseInt(searchId.getText());
        pst.setInt(1, id);
        ResultSet rs1 = pst.executeQuery();
        if(rs1.next() == false) {
            JOptionPane.showMessageDialog(this, "Sorry Record Not Found");
            textUserName.setText("");
            textLastName.setText("");
            textMiddleName.setText("");
            jDateChooser1.setDate(null);
            textUserAddress.setText("");
            textContactNumber.setText("");
            textEmailAddress.setText("");
            textPassword.setText("");
            searchId.requestFocus();
        } else {
            textUserName.setText(rs1.getString("fname"));
            textMiddleName.setText(rs1.getString("mname"));
            textLastName.setText(rs1.getString("lname"));
            jDateChooser1.setDate(rs1.getDate("birthday"));
            textUserAddress.setText(rs1.getString("address"));
            textContactNumber.setText(rs1.getString("mobileno"));
            textEmailAddress.setText(rs1.getString("email"));
            textPassword.setText(rs1.getString("password"));
            updateButton.setEnabled(true);
        }   
    } catch (SQLException ex) {
    }                  
    }//GEN-LAST:event_searchIdActionPerformed

    private void textMiddleNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMiddleNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textMiddleNameActionPerformed

    private void showDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showDataActionPerformed
        DisplayTable updateFrame = new DisplayTable();
        updateFrame.setVisible(true);
        Upd_Del.this.setVisible(false);
    }//GEN-LAST:event_showDataActionPerformed

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Upd_Del.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
  
        java.awt.EventQueue.invokeLater(() -> {
            new Upd_Del().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel labelID;
    private javax.swing.JLabel labeladdress;
    private javax.swing.JLabel labelbday;
    private javax.swing.JLabel labelemail;
    private javax.swing.JLabel labelfname;
    private javax.swing.JLabel labellname;
    private javax.swing.JLabel labellname1;
    private javax.swing.JLabel labelmobileno;
    private javax.swing.JLabel labelpass;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchId;
    private javax.swing.JButton showData;
    private javax.swing.JTextField textContactNumber;
    private javax.swing.JTextField textEmailAddress;
    private javax.swing.JTextField textLastName;
    private javax.swing.JTextField textMiddleName;
    private javax.swing.JPasswordField textPassword;
    private javax.swing.JTextField textUserAddress;
    private javax.swing.JTextField textUserName;
    private javax.swing.JButton updateButton;
    private javax.swing.JCheckBox viewerPassword;
    // End of variables declaration//GEN-END:variables
}
