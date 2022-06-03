/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class register_owner extends javax.swing.JFrame {

    /**
     * Creates new form register_owner
     */
    Connection con=null; 
    PreparedStatement pst=null;
  
    public register_owner() {
        initComponents();
         
      
    }

   
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();
        num = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        con_pass = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jComboBox1 = new javax.swing.JComboBox<>();
        l_1 = new javax.swing.JLabel();
        l_2 = new javax.swing.JLabel();
        l_3 = new javax.swing.JLabel();
        l_4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(223, 158, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/test/spaghetti-logo-1.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 568));

        jLabel2.setFont(new java.awt.Font("Yu Gothic Medium", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("REGISTER");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 23, 447, 66));

        jLabel5.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("USER NAME:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 147, 173, 39));

        jLabel6.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("PASSWORD :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 224, 173, 40));

        jLabel7.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("CONFIRM PASSWORD :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 300, -1, 40));

        jLabel8.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("PHONE NUMBER :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 375, 179, 40));

        Username.setBackground(new java.awt.Color(223, 158, 102));
        Username.setFont(new java.awt.Font("Yu Gothic Medium", 0, 14)); // NOI18N
        Username.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, new java.awt.Color(223, 158, 102)));
        Username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UsernameFocusGained(evt);
            }
        });
        jPanel1.add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(597, 147, 292, 39));

        num.setBackground(new java.awt.Color(223, 158, 102));
        num.setFont(new java.awt.Font("Yu Gothic Medium", 0, 14)); // NOI18N
        num.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, new java.awt.Color(223, 158, 102)));
        num.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                numFocusGained(evt);
            }
        });
        jPanel1.add(num, new org.netbeans.lib.awtextra.AbsoluteConstraints(661, 376, 228, 40));

        pass.setBackground(new java.awt.Color(223, 158, 102));
        pass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, new java.awt.Color(223, 158, 102)));
        pass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passFocusGained(evt);
            }
        });
        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });
        jPanel1.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(597, 224, 292, 40));

        con_pass.setBackground(new java.awt.Color(223, 158, 102));
        con_pass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, new java.awt.Color(223, 158, 102)));
        con_pass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                con_passFocusGained(evt);
            }
        });
        con_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                con_passActionPerformed(evt);
            }
        });
        jPanel1.add(con_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(597, 300, 292, 40));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 96, 447, 11));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "+02", "+03", "+04", "+05", "+06" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 381, 58, 29));

        l_1.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(l_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(597, 195, 292, 16));

        l_2.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(l_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(597, 271, 292, 16));

        l_3.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(l_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(597, 347, 292, 16));

        l_4.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(l_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 420, 220, 13));

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setFont(new java.awt.Font("Rockwell Condensed", 1, 24)); // NOI18N
        jButton1.setText("Register");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 474, 179, 55));

        jLabel11.setBackground(new java.awt.Color(223, 158, 102));
        jLabel11.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("X");
        jLabel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(968, 0, 34, 25));

        jLabel12.setBackground(new java.awt.Color(223, 158, 102));
        jLabel12.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/test/all_images/icons8-arrow-52.png"))); // NOI18N
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 60, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1003, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void con_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_con_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_con_passActionPerformed

    private void con_passFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_con_passFocusGained
        con_pass.setText("");
    }//GEN-LAST:event_con_passFocusGained

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed

    }//GEN-LAST:event_passActionPerformed

    private void passFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passFocusGained
        pass.setText("");
    }//GEN-LAST:event_passFocusGained

    private void numFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numFocusGained
        num.setText("");
    }//GEN-LAST:event_numFocusGained

    private void UsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UsernameFocusGained
        Username.setText("");
    }//GEN-LAST:event_UsernameFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      if (Username.getText().trim().isEmpty()&& pass.getText().trim().isEmpty()&&
            con_pass.getText().trim().isEmpty()&&num.getText().trim().isEmpty())
        {
            l_1.setText("*this filed Is Empty*");
            l_2.setText("*this filed Is Empty*");
            l_3.setText("*this filed Is Empty*");
            l_4.setText("*this filed Is Empty*");
           
        }
        else if (Username.getText().trim().isEmpty())
        {
            l_1.setText("*this filed Is Empty*");
            l_2.setText("");
            l_3.setText("");
            l_4.setText("");
        }
        else if (pass.getText().trim().isEmpty())
        {
            l_2.setText("*this filed Is Empty*");
            l_1.setText("");
            l_3.setText("");
            l_4.setText("");
           
        }
        else if (con_pass.getText().trim().isEmpty())
        {
            l_3.setText("*this filed Is Empty*");   
            l_1.setText("");
            l_2.setText("");
            l_4.setText("");
        }
        else if (num.getText().trim().isEmpty())
        {
            l_4.setText("*this filed Is Empty*");
            l_1.setText("");
            l_2.setText("");
            l_3.setText("");
        }else if(!con_pass.getText().equals(pass.getText())){
           JOptionPane.showMessageDialog(this, "Your password does not match !!");
        }
        else
        {

            try {
                con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost/talabat","root","");
                pst=con.prepareStatement("insert into owner_info (owner_name,pass,phone) Values (?,?,?)");
                
                pst.setString(1,Username.getText());
                pst.setString(2,con_pass.getText());
                pst.setString(3,num.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Congratulation You Have Registered successfully !!");
                res_info res =new res_info(Username.getText());
                this.setVisible(false);
                res.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(register_owner.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        login_owner page =new login_owner();
        page.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel12MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(register_owner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(register_owner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(register_owner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(register_owner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new register_owner().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Username;
    private javax.swing.JPasswordField con_pass;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel l_1;
    private javax.swing.JLabel l_2;
    private javax.swing.JLabel l_3;
    private javax.swing.JLabel l_4;
    private javax.swing.JTextField num;
    private javax.swing.JPasswordField pass;
    // End of variables declaration//GEN-END:variables
}
