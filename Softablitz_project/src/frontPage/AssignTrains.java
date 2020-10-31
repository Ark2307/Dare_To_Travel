/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontPage;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ABHINAV ANAND
 */
public class AssignTrains extends javax.swing.JInternalFrame {

    /**
     * Creates new form AssignTrains
     */
    public AssignTrains() {
        initComponents();
        employeeCBFillData();
        trainCBFillData();
    }
    
    public void employeeCBFillData(){
        try{
            Connection con = null;
                Class.forName("com.mysql.jdbc.Driver");

                String databaseUrl = "jdbc:mysql://localhost:3307/daretotravel";
                try {
                  con = (Connection) DriverManager.getConnection(databaseUrl, "root","anand1234");
                } catch (SQLException ex) {
                    Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
                }
//                String insertQuery = "insert into emp_details values(null,'"+fName+"','"+lName+"','"+phNo+"','"+Desg+"')";

                Statement stat = (Statement) con.createStatement();
                String selectQuery = "select id from emp_details";
                ResultSet rs = stat.executeQuery(selectQuery);
                
                while(rs.next()){
                    empid.addItem(Integer.toString(rs.getInt("id")));
                    
                }
//                int x = stat.executeUpdate(insertQuery);
//                System.out.print(x);
//
//                if(x==1){
//                    NewUser.infoMessage("Added Successfully!", "Alert");
//                }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void trainCBFillData(){
        try{
            Connection con = null;
                Class.forName("com.mysql.jdbc.Driver");

                String databaseUrl = "jdbc:mysql://localhost:3307/daretotravel";
                try {
                  con = (Connection) DriverManager.getConnection(databaseUrl, "root","anand1234");
                } catch (SQLException ex) {
                    Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
                }
//                String insertQuery = "insert into emp_details values(null,'"+fName+"','"+lName+"','"+phNo+"','"+Desg+"')";

                Statement stat = (Statement) con.createStatement();
                String selectQuery = "select train_no from train_details";
                ResultSet rs = stat.executeQuery(selectQuery);
                
                while(rs.next()){
                   trainno.addItem(rs.getString("train_no"));
                    
                }
//                int x = stat.executeUpdate(insertQuery);
//                System.out.print(x);
//
//                if(x==1){
//                    NewUser.infoMessage("Added Successfully!", "Alert");
//                }
        }
        catch(Exception e){
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
        empid = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        trainno = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setText("Assign Trains");

        jLabel2.setText("Employee id");

        jLabel3.setText("Train No.");

        trainno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jButton1.setText("Assign");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Reset");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(180, 180, 180)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(trainno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(empid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)))))
                .addContainerGap(194, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(empid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(trainno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(115, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         String eid = (String) empid.getSelectedItem();
        String tno = (String) trainno.getSelectedItem();
        
         
        if (eid.equals("")) {
            JOptionPane.showMessageDialog(null, "First Field Empty!!");
        }
        else if (tno.equals("")) {
            JOptionPane.showMessageDialog(null, "train number Required!!");
        }
        else if(checktno(tno)){
            JOptionPane.showMessageDialog(null, "this trainno is already assigned!!");
        }

        else{
            try{
                Connection con = null;
                Class.forName("com.mysql.jdbc.Driver");

                String databaseUrl = "jdbc:mysql://localhost:3307/daretotravel";
                try {
                  con = (Connection) DriverManager.getConnection(databaseUrl, "root","anand1234");
                } catch (SQLException ex) {
                    Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
                }
                String insertQuery = "insert into assign_train values(null,'"+eid+"','"+tno+"')";

                Statement stat = (Statement) con.createStatement();
                int x = stat.executeUpdate(insertQuery);
                System.out.print(x);

                if(x==1){
                    Registration.infoMessage("Added Successfully!", "Alert");
                }

            }
            catch(ClassNotFoundException | SQLException e){
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    public boolean checktno(String tno){
        PreparedStatement ps;
        ResultSet rs;
        boolean checktrain = false;
        
        String query = "SELECT * FROM `assign_train` WHERE `train no` =?";
        try {
            ps = (PreparedStatement) MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, tno);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                checktrain = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssignTrains.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return checktrain;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> empid;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<String> trainno;
    // End of variables declaration//GEN-END:variables
}
