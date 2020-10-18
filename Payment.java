package Trains;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Payment extends JFrame{

    JTextField textField;
    JTable table;
    JLabel Sector;
    JLabel TrainCode, Capacity, Classcode, Classname, label;

    public static void main(String[] args) {
        new Payment();
    }

    public Payment(){
	initialize();
    }

    private void initialize(){
        setTitle("PAYMENT_INFO");
	getContentPane().setBackground(Color.WHITE);
	setSize(860,486);
	setLayout(null);
		
	JLabel id = new JLabel("PNR NO");
	id.setFont(new Font("Tahoma", Font.PLAIN, 17));
	id.setBounds(60, 160, 150, 26);
	add(id);
		
	textField = new JTextField();
	textField.setBounds(200, 160, 150, 26);
	add(textField);
	
        table = new JTable();
	table.setBounds(45, 329, 766, 87);
	add(table);
		
	JButton Show = new JButton("SHOW");
	Show.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Show.setBackground(Color.BLACK);
        Show.setForeground(Color.WHITE);
	Show.setBounds(200, 210, 150, 26);
	add(Show);
		
	Sector = new JLabel("PAYMENT DETAILS");
	Sector.setForeground(Color.BLUE);
	Sector.setFont(new Font("Tahoma", Font.PLAIN, 31));
	Sector.setBounds(51, 17, 300, 39);
	add(Sector);
		
	TrainCode = new JLabel("PNR_NO");
	TrainCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
	TrainCode.setBounds(84, 292, 108, 26);
	add(TrainCode);
		
	Capacity = new JLabel("PAID_AMOUNT");
	Capacity.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Capacity.setBounds(183, 298, 92, 14);
	add(Capacity);
		
	Classcode = new JLabel("PAY_DATE");
	Classcode.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Classcode.setBounds(322, 294, 101, 24);
	add(Classcode);
		
	Classname = new JLabel("CHEQUE_NO");
	Classname.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Classname.setBounds(455, 298, 114, 14);
	add(Classname);
		
	label = new JLabel("");
	//label.setIcon(new ImageIcon(ClassLoader.getSystemResource("")));
	label.setBounds(425, 15, 239, 272);
	add(label);
		
	JLabel Cardno = new JLabel("CARD_NO");
	Cardno.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Cardno.setBounds(602, 299, 101, 19);
	add(Cardno);
		
	JLabel Phoneno = new JLabel("PHONE_NO");
	Phoneno.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Phoneno.setBounds(712, 294, 86, 24);
	add(Phoneno);
	
        setVisible(true);
		
	Show.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
		
                try {
                    String code  = textField.getText();
                    
                    connection c = new connection();
                    String str = "select pnr_no,paid_amt,pay_date,cheque_no,card_no,ph_no from payment where pnr_no = '"+code+"'";
					
                    ResultSet rs = c.s.executeQuery(str);
		
                    table.setModel(DbUtils.resultSetToTableModel(rs));
					
		}catch(SQLException e) {
                    e.printStackTrace();
                }
            }
	});
		
	setSize(960,590);
        setLocation(400,200);
	setVisible(true);

    }
}
