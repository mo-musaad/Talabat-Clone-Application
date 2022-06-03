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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class Restaurant_meals extends javax.swing.JFrame {

    private String rest_name,customer_email;
    
    public Restaurant_meals(String rest_name, String customer_email ) {
        initComponents();
        config();
        transparent();
        table_Header_edit(jTable1);
        this.rest_name=rest_name;
        Show_search_list();
        jTable1.changeSelection(0,0,false,false);
        row_selected();
        search.requestFocus();
        this.customer_email=customer_email;
    }

          Connection con=null; 
          PreparedStatement pst=null;
          private int listsize=0;
          private int sort_counter=0;
          private int order_num;
          
         private void transparent ()
         {
         res_name.setBackground(new Color(0,0,0,10));
         search.setBackground(new Color(0,0,0,60));
         price.setBackground(new Color(0,0,0,10));
         time.setBackground(new Color(0,0,0,10));
         category.setBackground(new Color(0,0,0,10));
        }
         
         private void config()
           {
          jTable2.setVisible(false);
          jTable2.getColumnModel().getColumn(3).setPreferredWidth(105);
          jTable2.getColumnModel().getColumn(0).setPreferredWidth(125);
          jTable1.getColumnModel().getColumn(0).setPreferredWidth(125);
          jTable1.getColumnModel().getColumn(3).setPreferredWidth(105);
  
          jScrollPane1.setVisible(false);
          cart_lbl.setVisible(false);
          checkout.setVisible(false);
          remove.setVisible(false);   
         }
         
         private void setBorder(JLabel J){
         Border rasied=BorderFactory.createLineBorder(new Color(235,168,111));
         J.setBorder(rasied);  
    }
    
         private void resetBorder(JLabel J){
      Border empty= BorderFactory.createEmptyBorder();
       J.setBorder(empty);  
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
         
         private void table_Header_edit(JTable J)
         {
          JTableHeader tableHeader = J.getTableHeader();
          Font headerFont = new Font("Rockwell Condensed", Font.HANGING_BASELINE, 20);
          tableHeader.setFont(headerFont);
          J.setBackground(new Color(204,204,204));
          J.setShowGrid(true);
          J.setShowVerticalLines(true);
          tableHeader.setForeground(new Color(153,72,101));    
        }
         
         private ArrayList<Meals> search_list(){
         ArrayList<Meals> mealslist=new ArrayList<>();
         try 
         {
         con =DriverManager.getConnection("jdbc:mysql://localhost/talabat","root","");
         pst=con.prepareStatement("SELECT * FROM restaurant_meals where res_name=? and meal_name like ?");
         pst.setString(1,rest_name);
         pst.setString(2,search.getText().trim()+"%");
        
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
         
         private void Show_search_list()   {
          ArrayList<Meals> list=search_list();
          DefaultTableModel Model=(DefaultTableModel) jTable1.getModel();
          Object [] column=new Object[4];
           Model.setRowCount(0);
           listsize=list.size();
          for(int i=0;i<list.size();i++){
          column[0]=list.get(i).getMeal_name();
          column[1]=list.get(i).getPrice();
          column[2]=list.get(i).getMeal_Type1();
          column[3]=list.get(i).getMeal_Time();
          Model.addRow(column);
          }
      }
     
         private ArrayList<Meals> sort(){
         ArrayList<Meals> mealslist=new ArrayList<>();
         try 
         {
         con =DriverManager.getConnection("jdbc:mysql://localhost/talabat","root","");
         if(sort_counter%2==1){
         pst=con.prepareStatement("SELECT * FROM restaurant_meals where res_name=? ORDER BY meal_name ASC");
         }else{
         pst=con.prepareStatement("SELECT * FROM restaurant_meals where res_name=? ORDER BY meal_name DESC");
         } 
          pst.setString(1,rest_name);
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
         
         private void Show_sort_list()   {
          ArrayList<Meals> list=sort();
          DefaultTableModel Model=(DefaultTableModel) jTable1.getModel();
          Object [] column=new Object[4];
           Model.setRowCount(0);
           listsize=list.size();
          for(int i=0;i<list.size();i++){
          column[0]=list.get(i).getMeal_name();
          column[1]=list.get(i).getPrice();
          column[2]=list.get(i).getMeal_Type1();
          column[3]=list.get(i).getMeal_Time();
          Model.addRow(column);
          }
      }
         
         private void row_selected(){
        int index=jTable1.getSelectedRow();
        if(index>=0&&listsize>0){
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        res_name.setText(model.getValueAt(index,0).toString());
        price.setText(model.getValueAt(index,1).toString());
        category.setText(model.getValueAt(index,2).toString());
        time.setText(model.getValueAt(index,3).toString());
        img_lbl.setIcon(ResizeImage(search_list().get(index).getImg_path(), null));
        }
      }
      
          private void get_row(){    
         int index=jTable1.getSelectedRow();
        if(index>=0&&listsize>0){
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        res_name.setText(model.getValueAt(index,0).toString());
        price.setText(model.getValueAt(index,1).toString());
        category.setText(model.getValueAt(index,2).toString());
        time.setText(model.getValueAt(index,3).toString());
        img_lbl.setIcon(ResizeImage(sort().get(index).getImg_path(), null));
        }
      }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        cart_lbl = new javax.swing.JLabel();
        res_name = new javax.swing.JTextField();
        category = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        time = new javax.swing.JTextField();
        next_ress = new javax.swing.JButton();
        Sortbutton = new javax.swing.JButton();
        previous_ress = new javax.swing.JButton();
        Add_meal = new javax.swing.JButton();
        img_lbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        checkout = new javax.swing.JButton();
        remove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Rockwell Condensed", 1, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 255));
        jLabel9.setText("Category :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 150, 50));

        jLabel10.setFont(new java.awt.Font("Rockwell Condensed", 1, 32)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 255));
        jLabel10.setText("Price :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 90, 60));

        jLabel5.setFont(new java.awt.Font("Rockwell Condensed", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 255));
        jLabel5.setText("Preparing Time :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, 210, 50));

        jLabel7.setFont(new java.awt.Font("Rockwell Condensed", 1, 25)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 255, 255));
        jLabel7.setText("EGY");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 513, -1, 40));

        jLabel8.setFont(new java.awt.Font("Rockwell Condensed", 1, 40)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 255, 204));
        jLabel8.setText("Search :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 230, 140, 60));

        search.setFont(new java.awt.Font("Rockwell Condensed", 1, 25)); // NOI18N
        search.setForeground(new java.awt.Color(255, 255, 204));
        search.setBorder(null);
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchKeyTyped(evt);
            }
        });
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 290, 190, 50));

        cart_lbl.setFont(new java.awt.Font("Rockwell Condensed", 1, 37)); // NOI18N
        cart_lbl.setForeground(new java.awt.Color(0, 153, 153));
        cart_lbl.setText("Cart :");
        jPanel1.add(cart_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 460, 100, 40));

        res_name.setEditable(false);
        res_name.setFont(new java.awt.Font("Rockwell Condensed", 1, 36)); // NOI18N
        res_name.setForeground(new java.awt.Color(153, 255, 255));
        res_name.setBorder(null);
        jPanel1.add(res_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 390, 50));

        category.setEditable(false);
        category.setFont(new java.awt.Font("Rockwell Condensed", 1, 27)); // NOI18N
        category.setForeground(new java.awt.Color(204, 255, 255));
        category.setText(" ");
        category.setBorder(null);
        jPanel1.add(category, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 590, 120, 40));

        price.setEditable(false);
        price.setFont(new java.awt.Font("Rockwell Condensed", 1, 27)); // NOI18N
        price.setForeground(new java.awt.Color(204, 255, 255));
        price.setBorder(null);
        jPanel1.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 513, 40, 40));

        time.setEditable(false);
        time.setFont(new java.awt.Font("Rockwell Condensed", 1, 27)); // NOI18N
        time.setForeground(new java.awt.Color(204, 255, 255));
        time.setBorder(null);
        jPanel1.add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 660, 80, 40));

        next_ress.setBackground(new java.awt.Color(204, 204, 255));
        next_ress.setFont(new java.awt.Font("Rockwell Condensed", 0, 24)); // NOI18N
        next_ress.setText("Next Meal");
        next_ress.setBorder(null);
        next_ress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next_ressActionPerformed(evt);
            }
        });
        jPanel1.add(next_ress, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 630, 120, 40));

        Sortbutton.setBackground(new java.awt.Color(204, 204, 255));
        Sortbutton.setFont(new java.awt.Font("Rockwell Condensed", 0, 28)); // NOI18N
        Sortbutton.setText("Sort");
        Sortbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(Sortbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 730, 110, 40));

        previous_ress.setBackground(new java.awt.Color(204, 204, 255));
        previous_ress.setFont(new java.awt.Font("Rockwell Condensed", 0, 23)); // NOI18N
        previous_ress.setText("Previous Meal");
        previous_ress.setBorder(null);
        previous_ress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previous_ressActionPerformed(evt);
            }
        });
        jPanel1.add(previous_ress, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 680, 120, 40));

        Add_meal.setBackground(new java.awt.Color(204, 204, 255));
        Add_meal.setFont(new java.awt.Font("Rockwell Condensed", 0, 21)); // NOI18N
        Add_meal.setText("ADD TO YOUR CART");
        Add_meal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_mealActionPerformed(evt);
            }
        });
        jPanel1.add(Add_meal, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 730, 180, 40));
        jPanel1.add(img_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 300, 260));

        jTable1.setFont(new java.awt.Font("Rockwell Condensed", 0, 20)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Meal Name", "Meal Price", "Category  ", "Preparing Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
        jTable1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTable1ComponentShown(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 110, 410, 340));

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

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/test/all_images/homepage (1).png"))); // NOI18N
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

        jLabel1.setFont(new java.awt.Font("Rockwell Condensed", 0, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 72, 101));
        jLabel1.setText("  CHOOSE YOUR MEAL ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 510, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 110));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/test/all_images/restaurant-menu-design_890x700.jpg"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 780, -1));

        jTable2.setFont(new java.awt.Font("Rockwell Condensed", 0, 20)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Meal Name", "Meal Price", "Count", "Preparing Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setRowHeight(30);
        jTable2.setRowMargin(10);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 500, 410, 240));

        checkout.setBackground(new java.awt.Color(204, 255, 204));
        checkout.setFont(new java.awt.Font("Rockwell Condensed", 1, 21)); // NOI18N
        checkout.setText("CheckOut");
        checkout.setBorder(null);
        checkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutActionPerformed(evt);
            }
        });
        jPanel1.add(checkout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 750, 130, 40));

        remove.setBackground(new java.awt.Color(204, 255, 204));
        remove.setFont(new java.awt.Font("Rockwell Condensed", 1, 21)); // NOI18N
        remove.setText("Remove");
        remove.setBorder(null);
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel1.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 750, 120, 40));

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void next_ressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next_ressActionPerformed
        if(jTable1.getSelectedRow()<listsize-1){
            jTable1.changeSelection(jTable1.getSelectedRow()+1,0,false,false);
            row_selected();
        }else if(jTable1.getSelectedRow()==listsize-1){
            jTable1.changeSelection(0,0,false,false);
            row_selected();
        }
    }//GEN-LAST:event_next_ressActionPerformed

    private void previous_ressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previous_ressActionPerformed
        if(jTable1.getSelectedRow()>0){
            jTable1.changeSelection(jTable1.getSelectedRow()-1,0,false,false);
            row_selected();
        }

    }//GEN-LAST:event_previous_ressActionPerformed

    private void Add_mealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_mealActionPerformed
     table_Header_edit(jTable2);
     jTable2.setVisible(true);
     cart_lbl.setVisible(true);
     jScrollPane1.setVisible(true);
     checkout.setVisible(true);
     remove.setVisible(true);
     
     int index2=jTable1.getSelectedRow();
     DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
     DefaultTableModel model2=(DefaultTableModel) jTable2.getModel();
     
     if(index2>=0)
     {
     Object[] cart_row=new Object[4];
     int cnt=1,flag=0,carry_index=0;
      
     
     for(int i=0;i<model2.getRowCount();i++)
     {
     if(model.getValueAt(index2,0).toString().equals(model2.getValueAt(i,0))){
     cnt=Integer.parseInt(model2.getValueAt(i,2).toString());
     cnt++;
     flag=1;
     carry_index=i;
     }    
     
     }
     
     if(flag==0)
     {
     cart_row[0]=model.getValueAt(index2,0).toString();     
     cart_row[1]=model.getValueAt(index2,1).toString();
     cart_row[2]=String.valueOf(cnt);      
     cart_row[3]=model.getValueAt(index2,3).toString();
     model2.addRow(cart_row);     
     }
     else
     {
     model2.setValueAt(String.valueOf(cnt),carry_index,2);
     }
     
     }
    }//GEN-LAST:event_Add_mealActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        row_selected();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable1ComponentShown

    }//GEN-LAST:event_jTable1ComponentShown

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        user_type first_page =new user_type();
        first_page.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        setBorder(jLabel2);
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        resetBorder(jLabel2);
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
      Customer_Home hoome =new Customer_Home(customer_email);
       hoome.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        setBorder(jLabel3);
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        resetBorder(jLabel3);
    }//GEN-LAST:event_jLabel3MouseExited

    private void checkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutActionPerformed
     try 
         {
         con =DriverManager.getConnection("jdbc:mysql://localhost/talabat","root","");
         pst=con.prepareStatement("SELECT * FROM order_number WHERE 1");
         ResultSet rs=pst.executeQuery();
         if(rs.next()){
         order_num=rs.getInt("Order_num");
         }
         } 
         catch (SQLException ex) 
         {
          Logger.getLogger(register_owner.class.getName()).log(Level.SEVERE, null, ex);
         } 
     
     
     for(int i=0;i<jTable2.getRowCount();i++){
        try 
         {
         con =DriverManager.getConnection("jdbc:mysql://localhost/talabat","root","");
         pst=con.prepareStatement("INSERT INTO history (Order_num ,email,meal_name,meal_freq,price,res_name) VALUES (?,?,?,?,?,?)");
         pst.setInt(1, order_num);
         pst.setString(2, customer_email);
         pst.setString(3, jTable2.getValueAt(i,0).toString());
         pst.setInt(4,Integer.parseInt(jTable2.getValueAt(i,2).toString()));
         pst.setInt(5,Integer.parseInt(jTable2.getValueAt(i,2).toString())*Integer.parseInt(jTable2.getValueAt(i,1).toString()));
         pst.setString(6, rest_name);
         pst.executeUpdate();
         } 
         catch (SQLException ex) 
         {
          Logger.getLogger(register_owner.class.getName()).log(Level.SEVERE, null, ex);
         } 
         
     }
     
     
     try 
         {
         con =DriverManager.getConnection("jdbc:mysql://localhost/talabat","root","");
         pst=con.prepareStatement("UPDATE order_number SET Order_num=? WHERE 1");
         pst.setInt(1, order_num+1);
         pst.executeUpdate();
         } 
         catch (SQLException ex) 
         {
          Logger.getLogger(register_owner.class.getName()).log(Level.SEVERE, null, ex);
         } 
      
     JOptionPane.showMessageDialog(this,"YOUR ORDER HAS BEEN SUCCESSFULLY COMPLETED ");
     Customer_Home page =new Customer_Home(customer_email);
     page.setVisible(true);
     this.setVisible(false);
    }//GEN-LAST:event_checkoutActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
      int index3=jTable2.getSelectedRow();
      int cnt;
      DefaultTableModel model2=(DefaultTableModel) jTable2.getModel();
      if(index3>=0){
      cnt=Integer.parseInt(model2.getValueAt(index3,2).toString());
      if(cnt>1)
      {
      cnt--;
      model2.setValueAt(String.valueOf(cnt),index3,2);
      }
      else{
      model2.removeRow(index3);
      }
      }else{
        JOptionPane.showMessageDialog(null, "You have to select a meal from your cart first !!");     
      }
      
      if(jTable2.getRowCount()==0){
          config();
      }
    }//GEN-LAST:event_removeActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyPressed

    }//GEN-LAST:event_searchKeyPressed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
   try{
    Show_search_list();
    jTable1.changeSelection(0,0,false,false); 
    row_selected();
    }catch(IndexOutOfBoundsException ex){
      JOptionPane.showMessageDialog(this, "Meal doesnt exist !!!!!!");   
    }
    }//GEN-LAST:event_searchKeyReleased

    private void searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyTyped

    }//GEN-LAST:event_searchKeyTyped

    private void SortbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortbuttonActionPerformed
        search.setText("");
        sort_counter++;
        Show_sort_list();
        jTable1.changeSelection(0,0,false,false);
        get_row();
    }//GEN-LAST:event_SortbuttonActionPerformed

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
            java.util.logging.Logger.getLogger(Restaurant_meals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Restaurant_meals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Restaurant_meals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Restaurant_meals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Restaurant_meals("","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add_meal;
    private javax.swing.JButton Sortbutton;
    private javax.swing.JLabel cart_lbl;
    private javax.swing.JTextField category;
    private javax.swing.JButton checkout;
    private javax.swing.JLabel img_lbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton next_ress;
    private javax.swing.JButton previous_ress;
    private javax.swing.JTextField price;
    private javax.swing.JButton remove;
    private javax.swing.JTextField res_name;
    private javax.swing.JTextField search;
    private javax.swing.JTextField time;
    // End of variables declaration//GEN-END:variables
}
