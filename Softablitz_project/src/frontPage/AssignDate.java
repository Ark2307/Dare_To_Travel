/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontPage;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ABHINAV ANAND
 */
public class AssignDate extends javax.swing.JInternalFrame {

    /**
     * Creates new form AssignDate
     */
    public AssignDate() {
        initComponents();
        trainCBFillData();
        idCBFillData();
    }

    public void trainCBFillData() {
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");

            String databaseUrl = "jdbc:mysql://localhost:3307/daretotravel";
            try {
                con = (Connection) DriverManager.getConnection(databaseUrl, "root", "anand1234");
            } catch (SQLException ex) {
                Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            }
//                String insertQuery = "insert into emp_details values(null,'"+fName+"','"+lName+"','"+phNo+"','"+Desg+"')";

            Statement stat = (Statement) con.createStatement();
            String selectQuery = "select distinct train_no from train_details";
            ResultSet rs = stat.executeQuery(selectQuery);

            while (rs.next()) {
                trainno.addItem(rs.getString("train_no"));
                  

            }
//                int x = stat.executeUpdate(insertQuery);
//                System.out.print(x);
//
//                if(x==1){
//                    NewUser.infoMessage("Added Successfully!", "Alert");
//                }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void idCBFillData() {
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");

            String databaseUrl = "jdbc:mysql://localhost:3307/daretotravel";
            try {
                con = (Connection) DriverManager.getConnection(databaseUrl, "root", "anand1234");
            } catch (SQLException ex) {
                Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            }
//                String insertQuery = "insert into emp_details values(null,'"+fName+"','"+lName+"','"+phNo+"','"+Desg+"')";

            Statement stat = (Statement) con.createStatement();
            String selectQuery = "select id from train_details";
            ResultSet rs = stat.executeQuery(selectQuery);

            while (rs.next()) {
                trainid.addItem(rs.getString("id"));

            }
//                int x = stat.executeUpdate(insertQuery);
//                System.out.print(x);
//
//                if(x==1){
//                    NewUser.infoMessage("Added Successfully!", "Alert");
//                }
        } catch (Exception e) {
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
        trainno = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        trainDate = new org.jdesktop.swingx.JXDatePicker();
        jLabel4 = new javax.swing.JLabel();
        trainid = new javax.swing.JComboBox<>();
        addprevt = new javax.swing.JButton();

        jLabel1.setText("Assign Date");

        jLabel2.setText("Train no");

        jLabel3.setText("Date");

        jButton1.setText("Assign");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("ID");

        addprevt.setText("Add prev Train");
        addprevt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addprevtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addprevt))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(96, 96, 96)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(trainDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(trainno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(trainid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(trainno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(trainDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(trainid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(addprevt))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        String tno = (String) trainno.getSelectedItem();
        Date tdateD = (Date) trainDate.getDate();
        SimpleDateFormat oDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String tdate = oDateFormat.format(tdateD);
        String tid =  (String) trainid.getSelectedItem();

        if (tno.equals("")) {
            JOptionPane.showMessageDialog(null, "First Name Field Empty!!");
        } else if (tdate.equals("")) {
            JOptionPane.showMessageDialog(null, "Last Name Field Empty!!");
        } else {
            try {
                Connection con = null;
                Class.forName("com.mysql.jdbc.Driver");

                String databaseUrl = "jdbc:mysql://localhost:3307/daretotravel";
                try {
                    con = (Connection) DriverManager.getConnection(databaseUrl, "root", "anand1234");
                } catch (SQLException ex) {
                    Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
                }

//                String insertQuery = "INSERT INTO `train_details`(`train_no`, `train_name`, `train_source`, `train_dest`, `train_route`, `train_time`, `train_status`, `ACII_Seats`, `ACII_Price`, `Sleeper_Seats`, `Sleeper_Price`) SELECT `train_no`, `train_name`, `train_source`, `train_dest`, `train_route`, `train_time`, `train_status`, `ACII_Seats`, `ACII_Price`, `Sleeper_Seats`, `Sleeper_Price`  FROM `train_details` WHERE `train_no` = '" + tno + "'";

                String insertQuery = "UPDATE `train_details` SET `train_date` = '" + tdate + "', `avl_acII_seats` = `ACII_Seats`,`avl_sleeper_seats` = `Sleeper_Seats` WHERE `train_no` = '" + tno + "' AND `id` = '"+ tid +"'";

//                String insertQuery = "CREATE TEMPORARY TABLE `train_detailstemp` AS SELECT * FROM `train_details` WHERE `train_no` = '" + tno + "' AND `id` = '"+ tid +"' UNION UPDATE `train_detailstemp` SET `id`=NULL, `train_date`='"+ tdate +"' UNION INSERT INTO `train_details` SELECT * FROM `train_detailstemp`";
                
                Statement stat = (Statement) con.createStatement();
                int x = stat.executeUpdate(insertQuery);
                System.out.print(x);

                if (x == 1) {
                    Registration.infoMessage("Added Successfully!", "Alert");
                }

            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addprevtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addprevtActionPerformed
        // TODO add your handling code here:
        String tno = (String) trainno.getSelectedItem();
//        Date tdateD = (Date) trainDate.getDate();
//        SimpleDateFormat oDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String tdate = oDateFormat.format(tdateD);
//        String tid =  (String) trainid.getSelectedItem();
        
        if (tno.equals("")) {
            JOptionPane.showMessageDialog(null, "First Name Field Empty!!");
        
        } else {
            try {
                Connection con = null;
                Class.forName("com.mysql.jdbc.Driver");

                String databaseUrl = "jdbc:mysql://localhost:3307/daretotravel";
                try {
                    con = (Connection) DriverManager.getConnection(databaseUrl, "root", "anand1234");
                } catch (SQLException ex) {
                    Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
                }
                String insertQuery = "INSERT INTO `train_details`(`train_no`, `train_name`, `train_source`, `train_dest`, `train_route`, `train_time`, `train_status`, `ACII_Seats`, `ACII_Price`, `Sleeper_Seats`, `Sleeper_Price`) SELECT `train_no`, `train_name`, `train_source`, `train_dest`, `train_route`, `train_time`, `train_status`, `ACII_Seats`, `ACII_Price`, `Sleeper_Seats`, `Sleeper_Price`  FROM `train_details` WHERE `train_no` = '" + tno + "'";
                
                Statement stat = (Statement) con.createStatement();
                int x = stat.executeUpdate(insertQuery);
                System.out.print(x);

                if (x == 1) {
                    Registration.infoMessage("Added Successfully!", "Alert");
                }

            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e);
            }
        }
                
    }//GEN-LAST:event_addprevtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addprevt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private org.jdesktop.swingx.JXDatePicker trainDate;
    private javax.swing.JComboBox<String> trainid;
    private javax.swing.JComboBox<String> trainno;
    // End of variables declaration//GEN-END:variables

}
