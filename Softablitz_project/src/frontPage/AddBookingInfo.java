/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontPage;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import static java.awt.image.ImageObserver.HEIGHT;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ABHINAV ANAND
 */
public class AddBookingInfo extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddBookingInfo
     */
    String uname;
    public AddBookingInfo(String uname) {
        this.uname = uname;
        initComponents();
        sourceCBFillData();
        destCBFillData();
    }

     public void sourceCBFillData(){
         
         /*try{
            Client c = new Client();
            Client.main(null);
            
            String station = null;
            
            do{
                
                station = c.StationInfo("train_source");
                
                System.out.println(station);
                
                source.addItem(station);
                
                station=null;
            }while(station.equals(null));
         }catch(IOException e)
         {
             e.printStackTrace();
         }*/
         
        try{
            Connection con = null;
                Class.forName("com.mysql.jdbc.Driver");

                String databaseUrl = "jdbc:mysql://localhost:3306/daretotravel";
                try {
                  con = (Connection) DriverManager.getConnection(databaseUrl, "hardik","1234");
                } catch (SQLException ex) {
                    Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
                }

                Statement stat = (Statement) con.createStatement();
                String selectQuery = "select distinct train_source from train_details";
                ResultSet rs = stat.executeQuery(selectQuery);
                
                while(rs.next()){
                   source.addItem(rs.getString("train_source"));
                    
                }

        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
    }
    
    public void destCBFillData(){
        
        /*try{
            Client c = new Client();
            Client.main(null);
            
            String station = null;
            
            do{
                
                station = c.StationInfo("train_dest");
                
                System.out.println(station);
                
                dest.addItem(station);
                
                station=null;
            }while(station.equals(null));
         }catch(IOException e)
         {
             e.printStackTrace();
         }*/
        
        try{
            Connection con = null;
                Class.forName("com.mysql.jdbc.Driver");

                String databaseUrl = "jdbc:mysql://localhost:3306/daretotravel";
                try {
                  con = (Connection) DriverManager.getConnection(databaseUrl, "hardik","1234");
                } catch (SQLException ex) {
                    Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
                }

                Statement stat = (Statement) con.createStatement();
                String selectQuery = "select distinct train_dest from train_details";
                ResultSet rs = stat.executeQuery(selectQuery);
                
                while(rs.next()){
                   dest.addItem(rs.getString("train_dest"));
                    
                }

        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
    } 
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        date = new org.jdesktop.swingx.JXDatePicker();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        source = new javax.swing.JComboBox<>();
        search = new javax.swing.JButton();
        dest = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Add Booking info");

        jLabel2.setText("Source");

        jLabel3.setText("Destination");

        jLabel4.setText("Date");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel5.setText("Search Results");

        jLabel6.setText("Booking Details");

        source.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sourceActionPerformed(evt);
            }
        });

        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(368, 368, 368)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(source, 0, 76, Short.MAX_VALUE)
                                    .addComponent(dest, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(27, 27, 27)
                                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(jLabel5)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addGap(188, 188, 188)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(source, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(search)
                            .addComponent(dest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        String tsource = (String) source.getSelectedItem();
        String tdest = (String) dest.getSelectedItem();
        Date tdateD = (Date) date.getDate();
        SimpleDateFormat oDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String tdate = oDateFormat.format(tdateD);
        if(String.valueOf(tdate) == ""){
            JOptionPane.showMessageDialog(null, "Select a Date", "Date!", HEIGHT);
        }
        else{
        try{
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");

            String databaseUrl = "jdbc:mysql://localhost:3306/daretotravel";
            try {
            con = (Connection) DriverManager.getConnection(databaseUrl, "hardik","1234");
            } catch (SQLException ex) {
                Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            }

            Statement stat = (Statement) con.createStatement();
            String selectQuery = "SELECT * FROM `train_details` WHERE `train_source` ='"+tsource+"' AND `train_dest` ='"+tdest+"' AND `train_date` ='"+tdate+"'";
            ResultSet rs = stat.executeQuery(selectQuery);
            
            Statement stat2 = (Statement) con.createStatement();
            String selectQuery2 = "SELECT * FROM `booking_details` WHERE `user_booked` ='"+uname+"'";
            ResultSet rs2 = stat2.executeQuery(selectQuery2);
//            while(rs.next()){
//                
//                   dest.addItem(rs.getString("train_dest"));
//                   if
//                    
//                }
            
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            
            jTable2.setModel(DbUtils.resultSetToTableModel(rs2));
            jTable2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        }
        catch(Exception e){
            System.out.println(e);
        }
        }
    }//GEN-LAST:event_searchActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int index = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        int id = Integer.parseInt(model.getValueAt(index, 0).toString());
        String train_name = (String) model.getValueAt(index, 2);
        int train_no = Integer.parseInt(model.getValueAt(index, 1).toString());
        String train_source = (String) model.getValueAt(index, 3);
        String train_dest = (String) model.getValueAt(index, 4);
        String train_route = (String) model.getValueAt(index, 5);
        int ac_II_S = Integer.parseInt(model.getValueAt(index, 8).toString());
        int ac_II_P = Integer.parseInt(model.getValueAt(index, 9).toString());
        int sleeper_S = Integer.parseInt(model.getValueAt(index, 10).toString());
        int sleeper_P = Integer.parseInt(model.getValueAt(index, 11).toString());
        
        String departTime = (String) model.getValueAt(index, 6);
        String status = (String) model.getValueAt(index, 7);
        Date train_date = (Date) model.getValueAt(index, 12);
        
        int avl_ac_II_S = Integer.parseInt(model.getValueAt(index, 13).toString());
        int avl_sleeper_S = Integer.parseInt(model.getValueAt(index, 14).toString());
        
        
        if(status.equals("Running")){
        BookForm bof = new BookForm(id, train_no, train_name, train_source, train_dest, train_route, ac_II_S, ac_II_P, sleeper_S, sleeper_P, departTime, status, train_date, uname, avl_ac_II_S, avl_sleeper_S);
        bof.setVisible(true);
        bof.pack();
        }
        else{
            JOptionPane.showMessageDialog(null, "Train Cancelled", "You Cannot Book this Train!", HEIGHT);
        }
//        bof.
        
//         JOptionPane.showMessageDialog(null, "Clicked", "Clicked!", HEIGHT);
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void sourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sourceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sourceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker date;
    private javax.swing.JComboBox<String> dest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton search;
    private javax.swing.JComboBox<String> source;
    // End of variables declaration//GEN-END:variables
}
