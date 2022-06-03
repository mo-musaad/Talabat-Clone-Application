/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author mohme
 */

public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    private String ress_name;
    
    public Home(String ress_name) {
        initComponents();
        transparent();
        table_Header_edit();
        meal_type2.setVisible(false);
        meal_name.requestFocus();
        this.ress_name=ress_name;
        Show_meal_list();
    }
    
    
    
      Connection con=null; 
      PreparedStatement pst=null;
      private int photo_flag=0; 
      private String owner_name,path; 
      DefaultComboBoxModel ComboBox_model1;
     
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        meal_price = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        meal_name = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        meal_type1 = new javax.swing.JComboBox<>();
        Meal_Time_box = new javax.swing.JComboBox<>();
        meal_type2 = new javax.swing.JComboBox<>();
        img_lbl = new javax.swing.JLabel();
        button_lbl = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(Table1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        meal_price.setFont(new java.awt.Font("Rockwell Condensed", 1, 28)); // NOI18N
        meal_price.setForeground(new java.awt.Color(204, 255, 255));
        meal_price.setBorder(null);
        meal_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meal_priceActionPerformed(evt);
            }
        });
        jPanel1.add(meal_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 140, 40));

        jLabel9.setFont(new java.awt.Font("Rockwell Condensed", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(9, 91, 91));
        jLabel9.setText("Meal Time :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 520, 190, 50));

        meal_name.setFont(new java.awt.Font("Rockwell Condensed", 1, 28)); // NOI18N
        meal_name.setForeground(new java.awt.Color(204, 255, 255));
        meal_name.setBorder(null);
        meal_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meal_nameActionPerformed(evt);
            }
        });
        jPanel1.add(meal_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 240, 40));

        save.setFont(new java.awt.Font("Rockwell Condensed", 0, 21)); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel1.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 620, 90, 40));

        update.setFont(new java.awt.Font("Rockwell Condensed", 0, 21)); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 620, 90, 40));

        delete.setFont(new java.awt.Font("Rockwell Condensed", 0, 21)); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel1.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 620, 90, 40));

        meal_type1.setFont(new java.awt.Font("Rockwell Condensed", 0, 20)); // NOI18N
        meal_type1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Breakfast", "Dinner", "Dessert", "Drinks" }));
        meal_type1.setSelectedIndex(-1);
        meal_type1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meal_type1ActionPerformed(evt);
            }
        });
        jPanel1.add(meal_type1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 140, 40));

        Meal_Time_box.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        Meal_Time_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 m", "2 m", "3 m", "4 m", "5 m", "6 m", "7 m", "8 m", "9 m", "10 m", "11 m", "12 m", "13 m", "14 m", "15 m", "16 m", "17 m", "18 m", "19 m", "20 m", "21 m", "22 m", "23 m", "24 m", "20 m", "21 m", "22 m", "23 m", "24 m", "25 m", "26 m", "27 m", "28 m", "29 m", "30 m", "31 m", "32 m", "33 m", "34 m", "35 m", "36 m", "37 m", "38 m", "39 m", "40 m ", "41 m", "42 m", "43 m", "44 m", "45 m", "46 m", "47 m", "48 m", "49 m", "50 m", "51 m", "52 m", "53 m", "54 m", "55 m", "56 m", "57 m", "58 m", "59 m", "60 m" }));
        Meal_Time_box.setSelectedIndex(-1);
        jPanel1.add(Meal_Time_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 530, -1, 40));

        meal_type2.setFont(new java.awt.Font("Rockwell Condensed", 0, 20)); // NOI18N
        jPanel1.add(meal_type2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 130, 40));
        jPanel1.add(img_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 400, 170, 130));

        button_lbl.setFont(new java.awt.Font("Rockwell Condensed", 0, 17)); // NOI18N
        button_lbl.setForeground(new java.awt.Color(127, 72, 101));
        button_lbl.setText("insert image");
        button_lbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_lblActionPerformed(evt);
            }
        });
        jPanel1.add(button_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, 110, 40));

        jLabel8.setFont(new java.awt.Font("Rockwell Condensed", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(9, 91, 91));
        jLabel8.setText("Meal Photo :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, 190, 50));

        jLabel5.setFont(new java.awt.Font("Rockwell Condensed", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(9, 91, 91));
        jLabel5.setText("Meal Price :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 180, 50));

        jLabel7.setFont(new java.awt.Font("Rockwell Condensed", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(9, 91, 91));
        jLabel7.setText("Meal Type :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 180, 50));

        jTable1.setFont(new java.awt.Font("Rockwell Condensed", 0, 20)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Meal Name", "Meal Price", "Meal Type 1", "Meal Type 2", "Meal Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(30);
        jTable1.setRowMargin(10);
        jTable1.setSurrendersFocusOnKeystroke(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 610, 620));

        jLabel6.setFont(new java.awt.Font("Rockwell Condensed", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(9, 91, 91));
        jLabel6.setText("Meal Name :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 200, 50));

        jPanel2.setBackground(new java.awt.Color(235, 168, 111));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/test/all_images/Webp.net-resizeimage.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 30, -1, -1));

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
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 0, 40, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/test/all_images/history.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        jLabel1.setFont(new java.awt.Font("Rockwell Condensed", 0, 55)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 72, 101));
        jLabel1.setText("Edit Your Resturant Meals");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 110));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/test/all_images/pexels-karolina-grabowska-4038661.jpg"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 580, 620));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel11MouseClicked
    
    
     private void transparent ()
          {
     meal_name.setBackground(new Color(0,0,0,20));
     meal_price.setBackground(new Color(0,0,0,20));
     }
     
     private void table_Header_edit()
          {
     JTableHeader tableHeader = jTable1.getTableHeader();
     Font headerFont = new Font("Rockwell Condensed", Font.HANGING_BASELINE, 25);
     tableHeader.setFont(headerFont);
     jTable1.setBackground(new Color(204,204,204));
     jTable1.setShowGrid(true);
     jTable1.setShowVerticalLines(true);
     tableHeader.setForeground(new Color(153,72,101));    
     }
    
     
      public ArrayList<Meals> Get_meal_list(){
         ArrayList<Meals> mealslist=new ArrayList<>();
         try 
         {
         con =DriverManager.getConnection("jdbc:mysql://localhost/talabat","root","");
         pst=con.prepareStatement("SELECT * FROM restaurant_meals where res_name=?");
         pst.setString(1,ress_name);
         ResultSet rs=pst.executeQuery();
         Meals meal;
          
         while(rs.next()){   
         meal=new Meals(rs.getString("meal_name"),rs.getString("meal_type1"),rs.getString("meal_type2"),rs.getString("meal_time"),rs.getInt("price"),rs.getString("image"));    
         mealslist.add(meal);
         }
         } 
         catch (SQLException ex) 
         {
          Logger.getLogger(register_owner.class.getName()).log(Level.SEVERE, null, ex);
         }  
         
          return mealslist;
      }
     
      public void Show_meal_list()   {
          ArrayList<Meals> list=Get_meal_list();
          DefaultTableModel Model=(DefaultTableModel) jTable1.getModel();
          Object [] column=new Object[5];
           Model.setRowCount(0);
          for(int i=0;i<list.size();i++){
          column[0]=list.get(i).getMeal_name();
          column[1]=list.get(i).getPrice();
          column[2]=list.get(i).getMeal_Type1();
          column[3]=list.get(i).getMeal_Type2();
          column[4]=list.get(i).getMeal_Time();
          Model.addRow(column);
          }
      }
     
      public ImageIcon ResizeImage(String imagePath,byte pic[])
                                     {
       ImageIcon myImage =null;
       if(imagePath!=null)
       {
           myImage=new ImageIcon(imagePath);
       }else
       {
           myImage= new ImageIcon(pic);
       }
       
       Image img=myImage.getImage();
       Image img2=img.getScaledInstance(img_lbl.getWidth(),img_lbl.getHeight() ,Image.SCALE_SMOOTH);
       ImageIcon image=new ImageIcon(img2);
       return image;
    }
   
      public void setBorder(JLabel J){
      Border rasied=BorderFactory.createLineBorder(new Color(235,168,111));
      J.setBorder(rasied);  
    }
    
      public void resetBorder(JLabel J){
      Border empty= BorderFactory.createEmptyBorder();
       J.setBorder(empty);  
    }
       

      private void Breakfast(){
     
     String[] breakfast = new String[]{"Eggs","Foll","T3mea","Cereal","Toast","Juice","Salad","Chips","Tea","Others"}; 
     ComboBox_model1 = new DefaultComboBoxModel(breakfast);
     meal_type2.setModel(ComboBox_model1);
      meal_type2.setSelectedIndex(-1);
    }
                         
    
      private void Dinner()
            {
     String[] dinner = new String[]{"Chicken","Fish","Pizza","Burger","Rice","Steak","Fried Chips","Pasta","Others"}; 
     ComboBox_model1 = new DefaultComboBoxModel(dinner);
     meal_type2.setModel(ComboBox_model1);
     meal_type2.setSelectedIndex(-1);
    }
    
      private void Dessert()
            {
     String[] dessert = new String[]{"Ice Cream","Cake","Candy","Cookie","Fruit","Others"}; 
     ComboBox_model1 = new DefaultComboBoxModel(dessert);
     meal_type2.setModel(ComboBox_model1);
     meal_type2.setSelectedIndex(-1);
    }
    
      private void Drinks()
            {
     String[] drinks = new String[]{"Coffee","Juice","Hot Chocolate","Cookie","Milkshake","Water","Others"}; 
     ComboBox_model1 = new DefaultComboBoxModel(drinks);
     meal_type2.setModel(ComboBox_model1);
     meal_type2.setSelectedIndex(-1);
    }
     
    
    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
      setBorder(jLabel2);
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
       resetBorder(jLabel2);
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        setBorder(jLabel3);
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
     resetBorder(jLabel3);
    }//GEN-LAST:event_jLabel3MouseExited

    private void meal_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meal_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meal_priceActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
      user_type first_page =new user_type();
        first_page.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void meal_type1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meal_type1ActionPerformed
     String carry=null;
     carry=(String) meal_type1.getSelectedItem();
     
     if(carry!=null){
         
         switch (carry) {
             case "Breakfast":
                 Breakfast();
                 break;
             case "Dinner":
                 Dinner();
                 break;
             case "Dessert":
                 Dessert();
                 break;
             case "Drinks":
                 Drinks();
                 break;
             default:
                 break;
         }
      
         meal_type2.setVisible(true); 
     
     }
     
    }//GEN-LAST:event_meal_type1ActionPerformed

    private void meal_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meal_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meal_nameActionPerformed

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

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
      
        if(meal_name.getText().trim().isEmpty())
        {
        JOptionPane.showMessageDialog(null, "Meal Name filed is Empty !!");   
        }
        else if(meal_type1.getSelectedIndex()==-1||meal_type2.getSelectedIndex()==-1)
        {
        JOptionPane.showMessageDialog(null, "Please select the Meal type !!");   
        }
        else if(meal_price.getText().trim().isEmpty())
        {
        JOptionPane.showMessageDialog(null, "Please write the Meal Price !!");   
        }
        else if(photo_flag==0)
        {
        JOptionPane.showMessageDialog(null, "Please insert a Photo for your Meal !!");   
        }
        else if(Meal_Time_box.getSelectedIndex()==-1)
        {
        JOptionPane.showMessageDialog(null, "Please select the Preparing time for the Meal !!");   
        }
        else
        {
         
            try 
            {
                con =DriverManager.getConnection("jdbc:mysql://localhost/talabat","root","");
                pst=con.prepareStatement("insert into restaurant_meals(res_name,meal_name,meal_type1,meal_type2,meal_time,price,image) Values (?,?,?,?,?,?,?)");
               
                pst.setString(1,ress_name);
                pst.setString(2,meal_name.getText());
                pst.setString(3,meal_type1.getSelectedItem().toString());
                pst.setString(4,meal_type2.getSelectedItem().toString());
                pst.setString(5,Meal_Time_box.getSelectedItem().toString());
                pst.setInt(6,Integer.parseInt(meal_price.getText()));
                 pst.setString(7,path);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, " * Your Meal has been saved * ");
                meal_name.setText("");
                meal_price.setText("");
                photo_flag=0;
                meal_type1.setSelectedIndex(-1);
                meal_type2.setSelectedIndex(-1);
                Meal_Time_box.setSelectedIndex(-1);
                img_lbl.setIcon(ResizeImage("", null));
                Show_meal_list();      
            } catch (SQLException ex) {
                Logger.getLogger(register_owner.class.getName()).log(Level.SEVERE, null, ex);
            }  
         }
    }//GEN-LAST:event_saveActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
         DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
         int index=jTable1.getSelectedRow();
         
         if(index<0)
         {
         JOptionPane.showMessageDialog(null, "Please select first a meal from the table !!");     
         }else{
            try 
            {
                con =DriverManager.getConnection("jdbc:mysql://localhost/talabat","root","");
                pst=con.prepareStatement("DELETE  from restaurant_meals where res_name=? and  meal_name=?" );
                pst.setString(1,ress_name);
                pst.setString(2,model.getValueAt(index,0).toString());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, " * Your Meal has been Deleted * ");
                meal_name.setText("");
                meal_price.setText("");
                meal_type1.setSelectedIndex(-1);
                meal_type2.setSelectedIndex(-1);
                Meal_Time_box.setSelectedIndex(-1);
                img_lbl.setIcon(ResizeImage("", null));
                Show_meal_list();      
            } catch (SQLException ex) {
                Logger.getLogger(register_owner.class.getName()).log(Level.SEVERE, null, ex);
            } 
         }
         
         
    }//GEN-LAST:event_deleteActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
     Restaurant_History page =new Restaurant_History(ress_name);
     page.setVisible(true);
     this.setVisible(false);         
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    int index=jTable1.getSelectedRow();
    DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
    meal_name.setText(model.getValueAt(index,0).toString());
    meal_price.setText(model.getValueAt(index,1).toString());
    img_lbl.setIcon(ResizeImage(Get_meal_list().get(index).getImg_path(), null));  
    for(int i=0;i<=3;i++)
    {
    if(meal_type1.getItemAt(i).equals(model.getValueAt(index,2).toString())){
    meal_type1.setSelectedIndex(i);
    break;
    }
    }
    for(int i=0;i<meal_type2.getItemCount();i++)
    {
    if(meal_type2.getItemAt(i).equals(model.getValueAt(index,3).toString()))
    {
    meal_type2.setSelectedIndex(i);
    break;
    }  
    }
    for(int i=0;i<Meal_Time_box.getItemCount();i++){
    if(Meal_Time_box.getItemAt(i).equals(model.getValueAt(index,4).toString()))
    {
    Meal_Time_box.setSelectedIndex(i);
    break;
    }   
    }
    
    }//GEN-LAST:event_jTable1MouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        int index=jTable1.getSelectedRow();
        if(photo_flag==0&&index>=0)
        {
        path=Get_meal_list().get(index).getImg_path();
        photo_flag=1;
        }
        
        if(index<0)
        {
         JOptionPane.showMessageDialog(null, "Please select first a meal from the table !!");     
        }
        else if(meal_name.getText().trim().isEmpty())
        {
        JOptionPane.showMessageDialog(null, "Meal Name filed is Empty !!");   
        }
        else if(meal_type1.getSelectedIndex()==-1||meal_type2.getSelectedIndex()==-1)
        {
        JOptionPane.showMessageDialog(null, "Please select the Meal type !!");   
        }
        else if(meal_price.getText().trim().isEmpty())
        {
        JOptionPane.showMessageDialog(null, "Please write the Meal Price !!");   
        }
        else if(photo_flag==0)
        {
        JOptionPane.showMessageDialog(null, "Please insert a Photo for your Meal !!");   
        }
        else if(Meal_Time_box.getSelectedIndex()==-1)
        {
        JOptionPane.showMessageDialog(null, "Please select the Preparing time for the Meal !!");   
        }
        else
        {
         
            try 
            {
                con =DriverManager.getConnection("jdbc:mysql://localhost/talabat","root","");
                pst=con.prepareStatement("update restaurant_meals Set res_name=? ,meal_name=? ,meal_type1=?,meal_type2=?,meal_time=?,price=?,image=? where res_name=? and  meal_name=?" );
  
                pst.setString(1,ress_name);
                pst.setString(2,meal_name.getText());
                pst.setString(3,meal_type1.getSelectedItem().toString());
                pst.setString(4,meal_type2.getSelectedItem().toString());
                pst.setString(5,Meal_Time_box.getSelectedItem().toString());
                pst.setInt(6,Integer.parseInt(meal_price.getText()));
                 pst.setString(7,path);
                pst.setString(8,ress_name);
                pst.setString(9,model.getValueAt(index,0).toString());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, " * Your Meal has been Updated * ");
                meal_name.setText("");
                meal_price.setText("");
                photo_flag=0;
                meal_type1.setSelectedIndex(-1);
                meal_type2.setSelectedIndex(-1);
                Meal_Time_box.setSelectedIndex(-1);
                img_lbl.setIcon(ResizeImage("", null));
                Show_meal_list();      
            } catch (SQLException ex) {
                Logger.getLogger(register_owner.class.getName()).log(Level.SEVERE, null, ex);
            }  
         }
    }//GEN-LAST:event_updateActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home("default user").setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Meal_Time_box;
    private javax.swing.JTable Table1;
    private javax.swing.JButton button_lbl;
    private javax.swing.JButton delete;
    private javax.swing.JLabel img_lbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField meal_name;
    private javax.swing.JTextField meal_price;
    private javax.swing.JComboBox<String> meal_type1;
    private javax.swing.JComboBox<String> meal_type2;
    private javax.swing.JButton save;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}                                                                                                       