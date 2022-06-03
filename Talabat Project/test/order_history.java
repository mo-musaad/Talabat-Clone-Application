/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author mohme
 */
public class order_history extends javax.swing.JFrame {

    /**
     * Creates new form order_history
     */
      private String customer_email;
      private int pervious_orders_exist=0;
    
    public order_history(String customer_email) {
        initComponents();
        this.customer_email=customer_email;
        table_Header_edit(jTable1);
        table2_Header_edit(jTable2);
        config();
        transparent();
        order_table();
        if(pervious_orders_exist==1){
        jTable1.changeSelection(0,0,false,false);
        Show_order_details(Integer.parseInt(jTable1.getValueAt(0,0).toString()));
        jTable2.changeSelection(0,0,false,false);
        Meal_details();
        }
    }
    
    
    
          Connection con=null; 
          PreparedStatement pst=null;
          private int listsize=0;
          
        private void Close_page(){
          JOptionPane.showMessageDialog(this,"Sorry You Have No Pervious Orders !!");
          Choosing_page page=new Choosing_page(customer_email);
          page.setVisible(true);
          this.setVisible(false); 
         }
        
        private void transparent ()
         {
         Meal_name.setBackground(new Color(0,0,0,5));
         m_Price.setBackground(new Color(0,0,0,5));
        }     
     
        private void order_table(){
         DefaultTableModel Model=(DefaultTableModel) jTable1.getModel();
        Set<Integer> order_number = new HashSet<Integer>();
        Iterator<Integer> i = order_number.iterator();
        Object arr[]=new Object[2];
        try 
         {
         con =DriverManager.getConnection("jdbc:mysql://localhost/talabat","root","");
         pst=con.prepareStatement("SELECT * FROM history where email=?");
         pst.setString(1,customer_email);
         ResultSet rs=pst.executeQuery();
         
         while(rs.next()){   
         order_number.add(rs.getInt("Order_num"));
         pervious_orders_exist=1;
         }
         } 
         catch (SQLException ex) 
         {
          Logger.getLogger(register_owner.class.getName()).log(Level.SEVERE, null, ex);
         }
        
       for(int j:order_number){
        arr[0]=j;
        Model.addRow(arr);
        }
      
         
        
    }
     
        private void table_Header_edit(JTable J)
         {
          JTableHeader tableHeader = J.getTableHeader();
          Font headerFont = new Font("Rockwell Condensed", Font.CENTER_BASELINE, 30);
          tableHeader.setFont(headerFont);
          J.setBackground(new Color(204,204,204));
          J.setShowGrid(true);
          J.setShowVerticalLines(true);
          tableHeader.setForeground(new Color(153,72,101));    
        }
         
        private void setBorder(JLabel J){
         Border rasied=BorderFactory.createLineBorder(new Color(235,168,111));
         J.setBorder(rasied);  
    }
    
        private void resetBorder(JLabel J){
         Border empty= BorderFactory.createEmptyBorder();
         J.setBorder(empty);  
    }
         
        private void table2_Header_edit(JTable J)
         {
          JTableHeader tableHeader = J.getTableHeader();
          Font headerFont = new Font("Rockwell Condensed", Font.CENTER_BASELINE, 17);
          tableHeader.setFont(headerFont);
          J.setBackground(new Color(204,204,204));
          J.setShowGrid(true);
          J.setShowVerticalLines(true);
          tableHeader.setForeground(new Color(153,72,101));    
        }
        
        private void config()
         {
          DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
          centerRenderer.setHorizontalAlignment( JLabel.CENTER );
          jTable1.getColumnModel().getColumn(0).setPreferredWidth(125);
          jTable1.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
          jTable2.getColumnModel().getColumn(0).setPreferredWidth(125);
          jTable2.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
           
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
        
        private void Meal_details(){
         try 
         {
         con =DriverManager.getConnection("jdbc:mysql://localhost/talabat","root","");
         pst=con.prepareStatement("SELECT * FROM restaurant_meals where meal_name=? AND res_name=?");
         pst.setString(1,jTable2.getValueAt(jTable2.getSelectedRow(),0).toString());
         pst.setString(2,jTable2.getValueAt(jTable2.getSelectedRow(),3).toString());
         ResultSet rs=pst.executeQuery();
         String meal_image,meal_price;
         if(rs.next()){
          Meal_name.setText(jTable2.getValueAt(jTable2.getSelectedRow(),0).toString());
          meal_price=rs.getString("price");
          meal_image=rs.getString("image");
          m_Price.setText(meal_price);
          img_lbl.setIcon(ResizeImage(meal_image, null));
         }
         
         } 
         catch (SQLException ex) 
         {
          Logger.getLogger(register_owner.class.getName()).log(Level.SEVERE, null, ex);
         }  
      }
      
        private ArrayList<pervious_orders> Get_order_details(int index){
          ArrayList<pervious_orders> list=new ArrayList<>();
          try 
         {
         con =DriverManager.getConnection("jdbc:mysql://localhost/talabat","root","");
         pst=con.prepareStatement("SELECT * FROM history where Order_num=? ");
         pst.setInt(1,index);
         ResultSet rs=pst.executeQuery();
         pervious_orders order;
         while(rs.next()){   
         order=new pervious_orders(rs.getInt("meal_freq"),rs.getInt("price"),rs.getString("meal_name"),rs.getString("res_name"));
         list.add(order);
         
         }
         } 
         catch (SQLException ex) 
         {
          Logger.getLogger(register_owner.class.getName()).log(Level.SEVERE, null, ex);
         }
          return list;
     }    
     
        private void Show_order_details(int index)   {
          ArrayList<pervious_orders> list=Get_order_details(index);
          DefaultTableModel Model=(DefaultTableModel) jTable2.getModel();
          Object [] column=new Object[4];
           Model.setRowCount(0);
           listsize=list.size();
          for(int i=0;i<list.size();i++){
          column[0]=list.get(i).getMeal_name();
          column[1]=list.get(i).getMeal_freq();
          column[2]=list.get(i).getPrice();
          column[3]=list.get(i).getRes_name();
          Model.addRow(column);
          }
      }
     
     
     
     
     private void row_selected(){
        int index=jTable1.getSelectedRow();
 //       if(index>=0&&listsize>0){
//        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
//        res_name.setText(model.getValueAt(index,0).toString());
//        price.setText(model.getValueAt(index,1).toString());
//        category.setText(model.getValueAt(index,2).toString());
//         time.setText(model.getValueAt(index,3).toString());
//        img_lbl.setIcon(ResizeImage(search_list().get(index).getImg_path(), null));
//        }
      
        }
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        img_lbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Meal_name = new javax.swing.JTextField();
        m_Price = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(img_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 330, 260));

        jLabel3.setFont(new java.awt.Font("Rockwell Condensed", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 255));
        jLabel3.setText("Price :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 499, 90, 90));

        Meal_name.setEditable(false);
        Meal_name.setFont(new java.awt.Font("Rockwell Condensed", 1, 40)); // NOI18N
        Meal_name.setForeground(new java.awt.Color(204, 255, 204));
        Meal_name.setBorder(null);
        Meal_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Meal_nameActionPerformed(evt);
            }
        });
        jPanel1.add(Meal_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 330, 50));

        m_Price.setEditable(false);
        m_Price.setFont(new java.awt.Font("Rockwell Condensed", 1, 25)); // NOI18N
        m_Price.setForeground(new java.awt.Color(204, 255, 255));
        m_Price.setBorder(null);
        jPanel1.add(m_Price, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 524, 100, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/test/all_images/restaurant-menu-design_890x700.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 100, 540, 570));

        jTable1.setFont(new java.awt.Font("Rockwell Condensed", 0, 25)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "           Order Code"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(30);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 390, 280));

        jTable2.setFont(new java.awt.Font("Rockwell Condensed", 0, 25)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Meal Name", "Count", "Price", "Restaurant"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setRowHeight(24);
        jTable2.setRowMargin(2);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 420, 390, 250));

        jLabel2.setFont(new java.awt.Font("Rockwell Condensed", 1, 26)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(127, 72, 101));
        jLabel2.setText("Order Details :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 390, 170, 30));

        jPanel2.setBackground(new java.awt.Color(235, 168, 111));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/test/all_images/Webp.net-resizeimage.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, -1, -1));

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
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 40, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/test/all_images/homepage (1).png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Rockwell Condensed", 0, 55)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(127, 72, 101));
        jLabel6.setText(" PERVIOUS ORDERS ");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 380, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 100));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
    Meal_details() ;      
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
      int row=jTable1.getSelectedRow();
      Show_order_details(Integer.parseInt(jTable1.getValueAt(row,0).toString())); 
      jTable2.changeSelection(0,0,false,false);
      Meal_details(); 
    }//GEN-LAST:event_jTable1MouseClicked

    private void Meal_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Meal_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Meal_nameActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
      if(pervious_orders_exist==0){
          Close_page();
      }
    }//GEN-LAST:event_formWindowActivated

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        user_type first_page =new user_type();
        first_page.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        setBorder(jLabel4);
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        resetBorder(jLabel4);
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        Customer_Home hoome =new Customer_Home(customer_email);
        hoome.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        setBorder(jLabel5);
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        resetBorder(jLabel5);
    }//GEN-LAST:event_jLabel5MouseExited

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
            java.util.logging.Logger.getLogger(order_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(order_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(order_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(order_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new order_history("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Meal_name;
    private javax.swing.JLabel img_lbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField m_Price;
    // End of variables declaration//GEN-END:variables
}
