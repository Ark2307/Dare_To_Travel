/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import java.sql.SQLException;

/**
 *
 * @author Hardik
 */
public class Server {
    static Vector<ClientHandler> ar = new Vector<>(); 
    static int i = 0;
    
    public static void main(String[] args) throws IOException  
    { 
        ServerSocket ss = new ServerSocket(5436); 
          
        Socket s; 
        
        ServerClient sc = new ServerClient();
        ServerClient.main(null);
        
        while (true)  
        {
            s = ss.accept(); 
  
            System.out.println("New client request received : " + s); 
            
            DataInputStream dis = new DataInputStream(s.getInputStream()); 
            DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
              
            System.out.println("Creating a new handler for this client..."); 
  
            if(i==0)
            {
                ClientHandler mtch = new ClientHandler(s,"server", dis, dos,sc);
                
                Thread t = new Thread(mtch); 
              
                System.out.println("Adding this server to active client list");
            
                ar.add(mtch);
                
                t.start();
            }
            else
            {
                ClientHandler mtch = new ClientHandler(s,"client " + i, dis, dos,sc);
                
                Thread t = new Thread(mtch); 
              
                System.out.println("Adding this client to active client list");
            
                ar.add(mtch);
                
                t.start();
            } 
            
            i++; 
        }
    } 
}

class ClientHandler implements Runnable  
{ 
    Scanner scn = new Scanner(System.in); 
    private String name; 
    final DataInputStream dis; 
    final DataOutputStream dos; 
    Socket s; 
    ServerClient sc;
    boolean isloggedin; 
    
    public ClientHandler(Socket s, String name, DataInputStream dis, DataOutputStream dos, ServerClient sc) { 
        this.dis = dis; 
        this.dos = dos; 
        this.name = name; 
        this.s = s; 
        this.sc=sc;
        this.isloggedin=true; 
    } 
    
    @Override
    public void run() { 
        String received; 
        while (true)  
        { 
            try
            {
                received = dis.readUTF(); 
                  
                System.out.println(received); 
                  
                /*if(received.equals("logout")){ 
                    this.isloggedin=false; 
                    this.s.close(); 
                    break; 
                }*/
                
                StringTokenizer st = new StringTokenizer(received, "#"); 
                String action = st.nextToken();
                String sender = this.name;
                if(action.equals("Login"))
                {
                    String user = st.nextToken();
                    String pass = st.nextToken();                    
                    
                    try{
                        PreparedStatement ps;
                        ResultSet rs;
                        
                        String query = "SELECT * FROM `user_details` WHERE `username` =? AND `password` =?";
                        
                        try {
                            ps = (PreparedStatement) MyConnection.getConnection().prepareStatement(query);
            
                            ps.setString(1, user);
                            ps.setString(2, pass);
            
                            rs = ps.executeQuery();
                            
                            String permission;
                            
                            if(rs.next()){
                                permission="true#"+sender;
                            }
                            else{
                                permission="false#"+sender;
                            }
                            
                            //ServerClient sc = new ServerClient();
                            sc.confirmation(permission);
                            
                        }catch(SQLException se){
                            se.printStackTrace();
                            System.out.println("Error while fetching data from Database. Please Check the Connection.");
                        }
                    }catch(Exception e){
                        System.out.println("Can't fetch data from DataBase.");
                    }
                }
                
                else if(action.equals("Admin"))
                {
                    String user = st.nextToken();
                    String pass = st.nextToken();                    
                    
                    try{
                        PreparedStatement ps;
                        ResultSet rs;
                        
                        String query = "SELECT * FROM `admin_details` WHERE `username` =? AND `password` =?";
                        
                        try {
                            ps = (PreparedStatement) MyConnection.getConnection().prepareStatement(query);
            
                            ps.setString(1, user);
                            ps.setString(2, pass);
            
                            rs = ps.executeQuery();
                            
                            String permission;
                            
                            if(rs.next()){
                                permission="true#"+sender;
                            }
                            else{
                                permission="false#"+sender;
                            }
                            
                            //ServerClient sc = new ServerClient();
                            sc.confirmation(permission);
                            
                        }catch(SQLException se){
                            se.printStackTrace();
                            System.out.println("Error while fetching data from Database. Please Check the Connection.");
                        }
                    }catch(Exception e){
                        System.out.println("Can't fetch data from DataBase.");
                    }
                }
                
                else if(action.equals("Registration"))
                {
                    String fName = st.nextToken();
                    String lName = st.nextToken();
                    String user = st.nextToken();
                    String pass = st.nextToken(); 
                    String email = st.nextToken();
                    String contact = st.nextToken();
                    String gender = st.nextToken();
                    
                    try{
                        
                        String query = "insert into user_details values(null,'"+fName+"','"+lName+"','"+user+"','"+pass+"','"+email+"','"+contact+"','"+gender+"')";
                        
                        Statement stat = (Statement) MyConnection.getConnection().createStatement();
                        
                        int x = stat.executeUpdate(query); 
                        
                        String permission;
                        
                        if(x==1)
                        {
                            permission="true#"+sender;
                        }
                        else
                        {
                            permission="false#"+sender;
                        }
                                              
                        sc.confirmation(permission);
                        
                    }catch(Exception e)
                    {
                        System.out.println("Can't reach DataBase.");
                    }
                }
                
                else if(action.equals("Check"))
                {
                    String variable = st.nextToken();
                    String value = st.nextToken();                    
                    
                    try{
                        PreparedStatement ps;
                        ResultSet rs;
                        
                        String query = "SELECT * FROM `user_details` WHERE `"+variable+"` =?";
                        
                        try {
                            ps = (PreparedStatement) MyConnection.getConnection().prepareStatement(query);
            
                            ps.setString(1, value);
            
                            rs = ps.executeQuery();
                            
                            String permission;
                            
                            if(rs.next()){
                                permission="true#"+sender;
                            }
                            else{
                                permission="false#"+sender;
                            }
                            
                            //ServerClient sc = new ServerClient();
                            sc.confirmation(permission);
                            
                        }catch(SQLException se){
                            se.printStackTrace();
                            System.out.println("Error while fetching data from Database. Please Check the Connection.");
                        }
                    }catch(Exception e){
                        System.out.println("Can't fetch data from DataBase.");
                    }
                }
                
                //String MsgToSend = st.nextToken(); 
                String recipient = st.nextToken();
                
                for (ClientHandler mc : Server.ar)  
                {
                    if (mc.name.equals(recipient) && mc.isloggedin==true)  
                    { 
                        mc.dos.writeUTF(this.name+" : "+action); 
                        break; 
                    } 
                }
            }catch (IOException e) { 
                  System.out.println(this.s + " Disconnected");
                  try{
                  this.isloggedin=false; 
                  this.s.close();
                  }catch(IOException ex)
                  {
                      ex.printStackTrace();
                  }
                  finally{
                  break; 
                  }
                //e.printStackTrace(); 
            } 
        }
        try
        { 
            this.dis.close(); 
            this.dos.close();
        }catch(IOException e){ 
            e.printStackTrace(); 
        } 
    }
}
