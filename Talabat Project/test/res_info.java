/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.test;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author mohme
 */
public class res_info extends javax.swing.JFrame {

    int photo_flag=0;
    Connection con=null; 
    PreparedStatement pst=null;
    private String owner_name,path;
    
    public res_info(String owner_name) {
        initComponents();
        transparent();
        this.owner_name=owner_name;
    }

    private void transparent (){
     res_name.setBackground(new Color(0,0,0,45));
     num.setBackground(new Color(0,0,0,20));
     jScrollPane1.setOpaque(false);
     jScrollPane1.getViewport().setOpaque(false);
     jScrollPane1.setBorder(null);
     jScrollPane1.setViewportBorder(null);
     address.setBackground(new Color(0,0,0,26));
     address.setLineWrap(true);   
     
    }
    
     public ImageIcon ResizeImage(String imagePath,byte pic[]){
       ImageIcon myImage =null;
       if(imagePath!=null){
           myImage=new ImageIcon(imagePath);
       }else{
           myImage= new ImageIcon(pic);
       }
       Image img=myImage.getImage();
       Image img2=img.getScaledInstance(img_lbl.getWidth(),img_lbl.getHeight() ,Image.SCALE_SMOOTH);
       ImageIcon image=new ImageIcon(img2);
       return image;
    }
    
     
     
     private void check_if_empty( String ress_namm){
      if(res_name.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(null, "Restaurant Name filed is Empty !!");   
      }
      else if(num.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(null, "Phone Number filed is Empty !!");   
      }
      else if(begin.getSelectedIndex()==-1||end.getSelectedIndex()==-1){
        JOptionPane.showMessageDialog(null, "Please select Working hours of your Restaurant !!");   
      }else if(photo_flag==0){
        JOptionPane.showMessageDialog(null, "Please insert a Photo for your Restaurant !!");   
      }
      else if(address.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(null, "Address filed is Empty !!");   
      }else{
         
            try {
         con =DriverManager.getConnection("jdbc:mysql://localhost/talabat","root","");
         pst=con.prepareStatement("insert into restaurant_info (owner_name,res_name,work_hours_b,work_hours_e,res_phone,res_address,image) Values (?,?,?,?,?,?,?)");
               
                pst.setString(1,owner_name);
                pst.setString(2,res_name.getText());
                pst.setString(3,begin.getSelectedItem().toString());
                pst.setString(4,end.getSelectedItem().toString());
                pst.setInt(5,Integer.parseInt(num.getText().toString()));
                pst.setString(6,address.getText());
                pst.setString(7,path);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, " * Your Resturant info has been saved * ");
                Home owner_page =new Home(ress_namm);
                owner_page.setVisible(true);
                this.setVisible(false);
                res_name.setText("");
                address.setText("");
                num.setText("");
                begin.setSelectedIndex(-1);
                end.setSelectedIndex(-1);
                img_lbl.setIcon(ResizeImage("", null));
                      
            } catch (SQLException ex) {
                Logger.getLogger(register_owner.class.getName()).log(Level.SEVERE, null, ex);
            }  
        
        
      }
      
     } 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        button_lbl = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        address = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        img_lbl = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        num = new javax.swing.JTextField();
        res_name = new javax.swing.JTextField();
        begin = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        end = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button_lbl.setFont(new java.awt.Font("Rockwell Condensed", 0, 17)); // NOI18N
        button_lbl.setForeground(new java.awt.Color(127, 72, 101));
        button_lbl.setText("insert image");
        button_lbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_lblActionPerformed(evt);
            }
        });
        jPanel3.add(button_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, -1, -1));

        Save.setFont(new java.awt.Font("Rockwell Condensed", 1, 30)); // NOI18N
        Save.setForeground(new java.awt.Color(127, 72, 101));
        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        jPanel3.add(Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 660, 160, 40));

        jPanel1.setBackground(new java.awt.Color(235, 168, 111));

        jLabel1.setFont(new java.awt.Font("Rockwell Condensed", 0, 52)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 72, 101));
        jLabel1.setText(" Edit Your Restaurant Info ");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(576, 576, 576)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel1)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 110));

        jLabel2.setFont(new java.awt.Font("Rockwell Condensed", 1, 29)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Restaurant Name : ");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, 44));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        address.setColumns(20);
        address.setFont(new java.awt.Font("Rockwell Condensed", 1, 21)); // NOI18N
        address.setForeground(new java.awt.Color(204, 255, 255));
        address.setRows(5);
        jScrollPane1.setViewportView(address);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 522, 330, 120));

        jLabel3.setFont(new java.awt.Font("Rockwell Condensed", 1, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Address  :");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 120, 48));

        jLabel4.setFont(new java.awt.Font("Rockwell Condensed", 1, 29)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Work Hours : ");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, 46));

        jLabel5.setFont(new java.awt.Font("Rockwell Condensed", 1, 29)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Phone number  :  ");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 220, 43));
        jPanel3.add(img_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 170, 130));

        jLabel6.setFont(new java.awt.Font("Rockwell Condensed", 1, 28)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Image :");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 100, 43));

        num.setBackground(new java.awt.Color(240, 240, 240));
        num.setFont(new java.awt.Font("Rockwell Condensed", 1, 28)); // NOI18N
        num.setForeground(new java.awt.Color(204, 255, 255));
        num.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numActionPerformed(evt);
            }
        });
        jPanel3.add(num, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 267, 210, 35));

        res_name.setFont(new java.awt.Font("Rockwell Condensed", 1, 30)); // NOI18N
        res_name.setForeground(new java.awt.Color(204, 255, 255));
        res_name.setBorder(null);
        res_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                res_nameActionPerformed(evt);
            }
        });
        jPanel3.add(res_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 194, 350, 40));

        begin.setForeground(new java.awt.Color(204, 255, 255));
        begin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "06:00 AM", "07:00 AM", "08:00 AM", "09:00 AM", "10:00 AM", "11:00 AM", "12:00 AM" }));
        begin.setSelectedIndex(-1);
        begin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beginActionPerformed(evt);
            }
        });
        jPanel3.add(begin, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, -1, 30));

        jLabel7.setFont(new java.awt.Font("Poor Richard", 1, 21)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 255));
        jLabel7.setText("From :");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, -1, -1));

        end.setForeground(new java.awt.Color(204, 255, 255));
        end.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01:00 PM", "02:00 PM", "03:00 PM", "04:00 PM", "05:00 PM", "06:00 PM", "07:00 PM", "08:00 PM", "09:00 PM", "10:00 PM", "11:00 PM", "12:00 PM" }));
        end.setSelectedIndex(-1);
        jPanel3.add(end, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, -1, 30));

        jLabel8.setFont(new java.awt.Font("Poor Richard", 1, 21)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 255));
        jLabel8.setText("To : ");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/test/all_images/pexels-karolina-grabowska-4033639 (1).jpg"))); // NOI18N
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 610, 610));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void beginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_beginActionPerformed

    private void numActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numActionPerformed

    private void res_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_res_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_res_nameActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
    System.exit(0);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void button_lblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_lblActionPerformed
        JFileChooser file =new JFileChooser();
        file.showOpenDialog(null);
        File f=file.getSelectedFile();
        if(f!=null){
            path=f.getAbsolutePath();
            img_lbl.setIcon(ResizeImage(path, null));
            photo_flag=1;
        }else{
            System.out.println("No File selcetd");

        }
    }//GEN-LAST:event_button_lblActionPerformed
    
    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
     String savve=res_name.getText();
        check_if_empty(savve);
      
    }//GEN-LAST:event_SaveActionPerformed

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
            java.util.logging.Logger.getLogger(res_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(res_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(res_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(res_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new res_info("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Save;
    private javax.swing.JTextArea address;
    private javax.swing.JComboBox<String> begin;
    private javax.swing.JButton button_lbl;
    private javax.swing.JComboBox<String> end;
    private javax.swing.JLabel img_lbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField num;
    private javax.swing.JTextField res_name;
    // End of variables declaration//GEN-END:variables
}
