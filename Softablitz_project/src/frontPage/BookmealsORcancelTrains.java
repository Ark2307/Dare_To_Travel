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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ABHINAV ANAND
 */
public class BookmealsORcancelTrains extends javax.swing.JInternalFrame {

    /**
     * Creates new form BookmealsORcancelTrains
     */
    public BookmealsORcancelTrains() {
        initComponents();
    }

    int sno, id, train_no, nseats, amtp;
    String train_name, source, dest, route, coach, time, status, uname, tstatus, meals, fname, lname;
    Date date;
    public BookmealsORcancelTrains(int sno, int id, int train_no, String train_name, String source, String dest, String route, String coach, String time, String status, String fname, String lname, Date date, String uname, int nseats, int amtp, String tstatus, String meals){
        initComponents();
        this.sno = sno;
        this.id = id;
        this.train_no = train_no;
        this.train_name = train_name;
        this.source = source;
        this.dest = dest;
        this.route = route;
//        this.ac_II_S = ac_II_S;
//        this.ac_II_P = ac_II_P;
//        this.sleeper_S = sleeper_S;
//        this.sleeper_P = sleeper_P;
        this.coach = coach;
        this.time = time;
        this.status = status;
        this.fname = fname;
        this.lname = lname;
        this.date = date;
        this.uname = uname;
        this.nseats = nseats;
        this.amtp = amtp;
        
        this.tstatus = tstatus;
        this.meals = meals;
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jButton1.setText("Book Meals");

        jButton2.setText("Cancel Tickets");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(110, 110, 110))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(133, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        tstatus = "cancelled";
        if(tstatus == "confirmed"){
            try{
                Connection con = null;
                Class.forName("com.mysql.jdbc.Driver");

                String databaseUrl = "jdbc:mysql://localhost:3307/daretotravel";
                try {
                  con = (Connection) DriverManager.getConnection(databaseUrl, "root","anand1234");
                } catch (SQLException ex) {
                    Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
                }
                
//                Statement stat = (Statement) con.createStatement();
                String sql = "SELECT * FROM train_details WHERE id = ?";
                PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
                st.setInt(0, id);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    String avl_ac_II_seats = rs.getString(13);
                    
                    String avl_sleeper_seats = rs.getString(14); 
                    
                    System.out.println("ac"+avl_ac_II_seats);
                    System.out.println("sleeper"+avl_sleeper_seats);
                }
                
                
                
//                Statement stat1 = (Statement) con.createStatement();
//                Statement stat2 = (Statement) con.createStatement();
//                int x = stat1.executeUpdate(insertQuery1);
//                int y = stat2.executeUpdate(insertQueryS);
//                System.out.print(x);
//                System.out.print(y);
//
//                if(x==1&&y==1){
//                    NewUser.infoMessage("Added Successfully!", "Alert");
//                    
//                }

            }
            catch(ClassNotFoundException | SQLException e){
                System.out.println(e);
            }
        }
        else if(tstatus == "waiting"){
            
        }  
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Home_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookmealsORcancelTrains().setVisible(true);
            }
        });
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
