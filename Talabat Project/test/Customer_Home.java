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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;



public class Customer_Home extends javax.swing.JFrame {

    /**
     * Creates new form Customer_Home
     */
    String customer_email;
    public Customer_Home(String customer_email) {
        initComponents();
        transparent();
        table_Header_edit();
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
      
    @SuppressWarnings("unchecked")
       
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Searchlbl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Sortbutton = new javax.swing.JButton();
        res_name = new javax.swing.JTextField();
        work_time2 = new javax.swing.JTextField();
        work_time1 = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        address = new javax.swing.JTextArea();
        next_ress = new javax.swing.JButton();
        previous_ress = new javax.swing.JButton();
        enter_ress = new javax.swing.JButton();
        img_lbl = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Rockwell Condensed", 1, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 255));
        jLabel9.setText("Phone :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 540, 100, 50));

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
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 313, 150, 40));

        jLabel10.setFont(new java.awt.Font("Rockwell Condensed", 1, 30)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 255));
        jLabel10.setText("Address :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 592, 120, 50));

        Searchlbl.setFont(new java.awt.Font("Rockwell Condensed", 1, 40)); // NOI18N
        Searchlbl.setForeground(new java.awt.Color(127, 72, 101));
        Searchlbl.setText("Search :");
        jPanel1.add(Searchlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 300, 140, 60));

        jLabel5.setFont(new java.awt.Font("Sitka Subheading", 1, 23)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 255));
        jLabel5.setText("To");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 498, 30, 20));

        Sortbutton.setBackground(new java.awt.Color(204, 204, 255));
        Sortbutton.setFont(new java.awt.Font("Rockwell Condensed", 0, 22)); // NOI18N
        Sortbutton.setText("Sort");
        Sortbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(Sortbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 400, 90, -1));

        res_name.setEditable(false);
        res_name.setFont(new java.awt.Font("Rockwell Condensed", 1, 36)); // NOI18N
        res_name.setForeground(new java.awt.Color(102, 204, 0));
        res_name.setBorder(null);
        jPanel1.add(res_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 310, 40));

        work_time2.setEditable(false);
        work_time2.setFont(new java.awt.Font("Rockwell Condensed", 1, 21)); // NOI18N
        work_time2.setForeground(new java.awt.Color(255, 153, 153));
        work_time2.setBorder(null);
        jPanel1.add(work_time2, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 495, 80, -1));

        work_time1.setEditable(false);
        work_time1.setFont(new java.awt.Font("Rockwell Condensed", 1, 21)); // NOI18N
        work_time1.setForeground(new java.awt.Color(255, 153, 153));
        work_time1.setBorder(null);
        jPanel1.add(work_time1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 495, 80, -1));

        phone.setEditable(false);
        phone.setFont(new java.awt.Font("Rockwell Condensed", 1, 26)); // NOI18N
        phone.setForeground(new java.awt.Color(255, 153, 153));
        phone.setBorder(null);
        jPanel1.add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 547, 190, 40));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        address.setEditable(false);
        address.setColumns(20);
        address.setFont(new java.awt.Font("Rockwell Condensed", 1, 24)); // NOI18N
        address.setForeground(new java.awt.Color(255, 153, 153));
        address.setRows(5);
        address.setWrapStyleWord(true);
        address.setAutoscrolls(false);
        address.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(address);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 600, 220, 90));

        next_ress.setBackground(new java.awt.Color(204, 204, 255));
        next_ress.setFont(new java.awt.Font("Rockwell Condensed", 0, 21)); // NOI18N
        next_ress.setText("Next Restaurant");
        next_ress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next_ressActionPerformed(evt);
            }
        });
        jPanel1.add(next_ress, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 620, 160, 40));

        previous_ress.setBackground(new java.awt.Color(204, 204, 255));
        previous_ress.setFont(new java.awt.Font("Rockwell Condensed", 0, 21)); // NOI18N
        previous_ress.setText("Previous Restaurant");
        previous_ress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previous_ressActionPerformed(evt);
            }
        });
        jPanel1.add(previous_ress, new org.netbeans.lib.awtextra.AbsoluteConstraints(609, 570, 170, 40));

        enter_ress.setBackground(new java.awt.Color(204, 204, 255));
        enter_ress.setFont(new java.awt.Font("Rockwell Condensed", 0, 24)); // NOI18N
        enter_ress.setText("Enter Restaurant");
        enter_ress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enter_ressActionPerformed(evt);
            }
        });
        jPanel1.add(enter_ress, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 670, 170, 40));
        jPanel1.add(img_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 230, 140));

        jLabel8.setFont(new java.awt.Font("Rockwell Condensed", 1, 25)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 255));
        jLabel8.setText("Work Time:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 482, 130, 50));

        jTable1.setFont(new java.awt.Font("Rockwell Condensed", 0, 20)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Retaurant ", "Open Time", "Close Time", "Phone"
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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 110, 400, 620));

        jLabel6.setFont(new java.awt.Font("Rockwell Condensed", 1, 45)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 255, 204));
        jLabel6.setText("Restaurant Name ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 330, 50));

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

        jLabel1.setFont(new java.awt.Font("Rockwell Condensed", 0, 55)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 72, 101));
        jLabel1.setText("  CHOOSE A RESTAURANT ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 530, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 110));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/test/all_images/Webp.net-resizeimage (3).jpg"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 790, 620));

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

        private void transparent ()
           {
     res_name.setBackground(new Color(0,0,0,20));
     search.setBackground(new Color(0,0,0,21));
     work_time1.setBackground(new Color(0,0,0,20));
     work_time2.setBackground(new Color(0,0,0,20));
     phone.setBackground(new Color(0,0,0,20));
     jScrollPane1.getViewport().setOpaque(false);
     jScrollPane1.setBorder(null);
     jScrollPane1.setViewportBorder(null);
     address.setBackground(new Color(0,0,0,40));
     address.setLineWrap(true); 
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
        
        public void Show_search_list(){
        
          ArrayList<Restaurants> list2=search_list();
          DefaultTableModel Model=(DefaultTableModel) jTable1.getModel();
          Object [] column=new Object[4];
           Model.setRowCount(0);
           listsize=list2.size();
          for(int i=0;i<list2.size();i++){
          column[0]=list2.get(i).getRes_name();
          column[1]=list2.get(i).getWorkHours_b();
          column[2]=list2.get(i).getWorkHours_e();
          column[3]=list2.get(i).getPhone();
          Model.addRow(column);
          }
      }
        
        
        private  ArrayList<Restaurants> sort(){
         ArrayList<Restaurants> restaurantlist=new ArrayList<>(); 
        
         try 
         {
         con =DriverManager.getConnection("jdbc:mysql://localhost/talabat","root","");
         if(sort_counter%2==1){
         pst=con.prepareStatement("SELECT * FROM restaurant_info ORDER BY res_name ASC ");
         }else{
         pst=con.prepareStatement("SELECT * FROM restaurant_info ORDER BY res_name DESC ");   
         }
         ResultSet rs=pst.executeQuery();
         Restaurants restaurant;
         while(rs.next()){ 
         restaurant=new Restaurants(rs.getString("res_name"),rs.getString("work_hours_b"),rs.getString("work_hours_e"),rs.getString("res_address"),rs.getString("image"),rs.getInt("res_phone"));    
         restaurantlist.add(restaurant);
         }
         } 
         catch (SQLException ex) 
         {
          Logger.getLogger(register_owner.class.getName()).log(Level.SEVERE, null, ex);
         }
        return restaurantlist;    
        }
        
        private  void Show_sort_list(){
        
          ArrayList<Restaurants> list2=sort();
          DefaultTableModel Model=(DefaultTableModel) jTable1.getModel();
          Object [] column=new Object[4];
           Model.setRowCount(0);
           listsize=list2.size();
          for(int i=0;i<list2.size();i++){
          column[0]=list2.get(i).getRes_name();
          column[1]=list2.get(i).getWorkHours_b();
          column[2]=list2.get(i).getWorkHours_e();
          column[3]=list2.get(i).getPhone();
          Model.addRow(column);
          }
      }
        
        public  ArrayList<Restaurants> search_list(){
          ArrayList<Restaurants> restaurantlist=new ArrayList<>();
        try 
         {
         con =DriverManager.getConnection("jdbc:mysql://localhost/talabat","root","");
         pst=con.prepareStatement("SELECT * FROM restaurant_info WHERE res_name Like ? ");
         pst.setString(1,search.getText().trim()+"%");
         ResultSet rs=pst.executeQuery();
         Restaurants restaurant;
         
         while(rs.next())
         { 
         restaurant=new Restaurants(rs.getString("res_name"),rs.getString("work_hours_b"),rs.getString("work_hours_e"),rs.getString("res_address"),rs.getString("image"),rs.getInt("res_phone"));    
         restaurantlist.add(restaurant);
         }
         
         } 
         catch (SQLException ex) 
         {
          Logger.getLogger(register_owner.class.getName()).log(Level.SEVERE, null, ex);
         }
        return restaurantlist;
        }
        
        
        private void row_selected(){     
        int index=jTable1.getSelectedRow();
        if(index>=0&&listsize>0){
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        res_name.setText(model.getValueAt(index,0).toString());
        work_time1.setText(model.getValueAt(index,1).toString());
        work_time2.setText(model.getValueAt(index,2).toString());
        phone.setText(model.getValueAt(index,3).toString());
        img_lbl.setIcon(ResizeImage(search_list().get(index).getImg(), null));
        address.setText(search_list().get(index).getAddress());
        }
        }
        
        private void get_row(){    
        int index=jTable1.getSelectedRow();
        if(index>=0&&listsize>0){
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        res_name.setText(model.getValueAt(index,0).toString());
        work_time1.setText(model.getValueAt(index,1).toString());
        work_time2.setText(model.getValueAt(index,2).toString());
        phone.setText(model.getValueAt(index,3).toString());
        img_lbl.setIcon(ResizeImage(sort().get(index).getImg(), null));
        address.setText(sort().get(index).getAddress());
        }
      }
      
      
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

    private void enter_ressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enter_ressActionPerformed
        if(jTable1.getSelectedRow()<0 )
        {
        JOptionPane.showMessageDialog(null, "Please Select a Restaurant first !!");   
        }
        else
        {
          try 
         {
         con =DriverManager.getConnection("jdbc:mysql://localhost/talabat","root","");
         pst=con.prepareStatement("SELECT * FROM restaurant_meals where res_name=? ");
         pst.setString(1, res_name.getText());
         ResultSet rs=pst.executeQuery();
         if(rs.next())
         {
           Restaurant_meals meals =new Restaurant_meals(res_name.getText(),customer_email);
           this.setVisible(false);
           meals.setVisible(true); 
         }
         else
         {
          JOptionPane.showMessageDialog(null, "Sorry this Restaurant has no meals yet !!");    
         }
         
         } 
         catch (SQLException ex) 
         {
          Logger.getLogger(register_owner.class.getName()).log(Level.SEVERE, null, ex);
         } 
        } 
    }//GEN-LAST:event_enter_ressActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        row_selected();
    }//GEN-LAST:event_jTable1MouseClicked

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
     Choosing_page hoome =new Choosing_page(customer_email);
        hoome.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        setBorder(jLabel3);
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        resetBorder(jLabel3);
    }//GEN-LAST:event_jLabel3MouseExited

    private void jTable1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable1ComponentShown
        
    }//GEN-LAST:event_jTable1ComponentShown

    private void searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyTyped
 
    }//GEN-LAST:event_searchKeyTyped

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
      JOptionPane.showMessageDialog(this, "Restaurant doesnt exist !!!!!!");   
    }
    }//GEN-LAST:event_searchKeyReleased

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
            java.util.logging.Logger.getLogger(Customer_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer_Home("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Searchlbl;
    private javax.swing.JButton Sortbutton;
    private javax.swing.JTextArea address;
    private javax.swing.JButton enter_ress;
    private javax.swing.JLabel img_lbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton next_ress;
    private javax.swing.JTextField phone;
    private javax.swing.JButton previous_ress;
    private javax.swing.JTextField res_name;
    private javax.swing.JTextField search;
    private javax.swing.JTextField work_time1;
    private javax.swing.JTextField work_time2;
    // End of variables declaration//GEN-END:variables
}
