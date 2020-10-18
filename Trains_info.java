package Trains;

import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Trains_info extends JFrame{

    private JTable table;
    private JTextField textField;
    
    public static void main(String[] args){		 
	new Trains_info().setVisible(true);    
    }
    
    public Trains_info(){
        
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(860,523);
	setLayout(null);
	setVisible(true);
		
	JLabel id = new JLabel("Train Number");
	id.setFont(new Font("Tahoma", Font.PLAIN, 17));
        id.setBounds(50, 100, 200, 30);
	add(id);
	
		
	JLabel TrainDetails = new JLabel("TRAIN INFORMATION");
	TrainDetails.setFont(new Font("Comic Sans MS", Font.PLAIN, 44));
	TrainDetails.setForeground(new Color(100, 149, 237));
	TrainDetails.setBounds(50, 20, 570, 35);
	add(TrainDetails);
		
	JButton Show = new JButton("SHOW");
	Show.setFont(new Font("Tahoma", Font.PLAIN, 20));
	
        Show.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
	
                String code = textField.getText();
                
                try {
                    connection c = new connection();//object of connection class to set connection between our db and code; 
                    String str = "select id,name,src,dst,capacity,class_code,class_name from trains ,classes where id = '"+code+"'";//calling data from our database named as trains and classes
      
                    ResultSet rs = c.s.executeQuery(str);
                    table.setModel(DbUtils.resultSetToTableModel(rs));	
                    
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        });

        Show.setBounds(220, 150, 120, 30);
	add(Show);
		
        table = new JTable();
        table.setBackground(Color.WHITE);
	table.setBounds(23, 250, 800, 300);
        
        JScrollPane pane = new JScrollPane(table);
	pane.setBounds(23, 250, 800, 300);
        pane.setBackground(Color.WHITE);
        add(pane);
		
	textField = new JTextField();
        textField.setBounds(220, 100, 200, 30);
	add(textField);
		
	JLabel Id = new JLabel("Train Number");
	Id.setFont(new Font("Tahoma", Font.PLAIN, 13));
        Id.setBounds(23, 220, 126, 14);
	add(Id);
		
	JLabel Name = new JLabel("Train NAME");
        Name.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Name.setBounds(145, 220, 120, 14);
	add(Name);
		
	JLabel Source = new JLabel("SOURCE");
	Source.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Source.setBounds(275, 220, 104, 14);
	add(Source);
		
	JLabel Destination = new JLabel("DESTINATION");
	Destination.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Destination.setBounds(367, 220, 120, 14);
	add(Destination);
		
		
	JLabel Capacity = new JLabel("CAPACITY");
	Capacity.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Capacity.setBounds(497, 220, 111, 14);
	add(Capacity);
		
	JLabel ClassCode = new JLabel("CLASS CODE");
	ClassCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
	ClassCode.setBounds(587, 220, 120, 14);
	add(ClassCode);
		
	JLabel ClassName = new JLabel("CLASS NAME");
	ClassName.setFont(new Font("Tahoma", Font.PLAIN, 13));
	ClassName.setBounds(700, 220, 111, 14);
	add(ClassName);
		
	
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	setSize(900,650);
        setVisible(true);
        setLocation(400,200);
		
    }
}
