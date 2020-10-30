/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontPage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

/**
 *
 * @author Hardik
 */
public class Client {
    final static int ServerPort = 5436; 
    static String msg = new String();
    static DataOutputStream dost;
    static DataInputStream dist;
  
    public static void main(String args[]) throws UnknownHostException, IOException  
    { 
        //Scanner scn = new Scanner(System.in);
        
        InetAddress ip = InetAddress.getByName("localhost");
        
        Socket s = new Socket(ip, ServerPort);
        
        DataInputStream dis = new DataInputStream(s.getInputStream()); 
        DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
        
        dost=dos;
        dist=dis;
  
    }
    
    String perm = "NA";
    
    public String LoginInfo(String user, String pass)
    {
        perm = "NA";
        String mess="Login#"+user+"#"+pass+"#server";
        msg=mess;
        
        Thread sendMessage = new Thread(new Runnable()  
        { 
            @Override
            public void run() {
                
                    try { 
                        dost.writeUTF(msg); 
                    } catch (IOException e) { 
                        System.out.println("Error in Message!!!");
                    }
                
            }
        });
        sendMessage.start(); 
    
        
        Thread readMessage = new Thread(new Runnable()  
        { 
            @Override
            public void run() { 
                String msgg;
                while (true) { 
                    try { 
                         
                        msgg = dist.readUTF(); 
                        System.out.println(msgg);
                        StringTokenizer st = new StringTokenizer(msgg," : ");
                        
                        msgg=st.nextToken();
                        String permission=st.nextToken();
                        
                        //confirmation(permission);
                        perm=permission;
                        
                        //System.out.println("this "+perm);
                        
                    } catch (IOException e) { 
                        System.out.println("Server is Offline/Down at this moment. Please try after some time. Thanks for Patience.");
                        break;
                    }
                    
                } 
            } 
        }); 
        readMessage.start();
        //System.out.println("confirming "+permission);
        if(perm.equals("NA"))
        {
            try
            {
                Thread.sleep(1000);
            }catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
                ex.printStackTrace();
            }
            return perm;
        }
        else
        {
            return perm;
        }        
    }
    
    public String AdminInfo(String user, String pass)
    {
        perm = "NA";
        String mess="Admin#"+user+"#"+pass+"#server";
        msg=mess;
        
        Thread sendMessage = new Thread(new Runnable()  
        { 
            @Override
            public void run() {
                
                    try { 
                        dost.writeUTF(msg); 
                    } catch (IOException e) { 
                        System.out.println("Error in Message!!!");
                    }
                
            }
        });
        sendMessage.start(); 
    
        
        Thread readMessage = new Thread(new Runnable()  
        { 
            @Override
            public void run() { 
                String msgg;
                while (true) { 
                    try { 
                         
                        msgg = dist.readUTF(); 
                        System.out.println(msgg);
                        StringTokenizer st = new StringTokenizer(msgg," : ");
                        
                        msgg=st.nextToken();
                        String permission=st.nextToken();
                        
                        //confirmation(permission);
                        perm=permission;
                        
                        //System.out.println("this "+perm);
                        
                    } catch (IOException e) { 
                        System.out.println("Server is Offline/Down at this moment. Please try after some time. Thanks for Patience.");
                        break;
                    }
                    
                } 
            } 
        }); 
        readMessage.start();
        //System.out.println("confirming "+permission);
        if(perm.equals("NA"))
        {
            try
            {
                Thread.sleep(1000);
            }catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
                ex.printStackTrace();
            }
            return perm;
        }
        else
        {
            return perm;
        }        
    }
    
    public String RegInfo(String fName, String lName, String user, String pass, String email, String contact, String gender)
    {
        perm = "NA";
        String mess="Registration#"+fName+"#"+lName+"#"+user+"#"+pass+"#"+email+"#"+contact+"#"+gender+"#server";
        msg=mess;
        
        Thread sendMessage = new Thread(new Runnable()  
        { 
            @Override
            public void run() {
                
                    try { 
                        dost.writeUTF(msg); 
                    } catch (IOException e) { 
                        System.out.println("Error in Message!!!");
                    }
                
            }
        });
        sendMessage.start(); 
    
        try
        {
                Thread.sleep(2000);
            }catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
                ex.printStackTrace();
            }
        
        Thread readMessage = new Thread(new Runnable()  
        { 
            @Override
            public void run() { 
                
                String msgg;
                
                while (true) { 
                    try { 
                         
                        msgg = dist.readUTF(); 
                        System.out.println(msgg);
                        StringTokenizer st = new StringTokenizer(msgg," : ");
                        
                        msgg=st.nextToken();
                        String permission=st.nextToken();
            
                        perm=permission;
                        
                    } catch (IOException e) { 
                        System.out.println("Server is Offline/Down at this moment. Please try after some time. Thanks for Patience.");
                        break;
                    }
                    
                } 
            } 
        }); 
        readMessage.start();
        
        if(perm.equals("NA"))
        {
            try
            {
                Thread.sleep(1000);
            }catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
                ex.printStackTrace();
            }
            return perm;
        }
        else
        {
            return perm;
        }        
    }
    
    public String CheckInfo(String variable, String value)
    {
        perm = "NA";
        String mess="Check#"+variable+"#"+value+"#server";
        msg=mess;
       
        Thread sendMessage = new Thread(new Runnable()  
        { 
            @Override
            public void run() {
                
                    try { 
                        dost.writeUTF(msg); 
                    } catch (IOException e) { 
                        System.out.println("Error in Message!!!");
                    }
                
            }
        });
        sendMessage.start(); 
    
        try
            {
                Thread.sleep(1000);
            }catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
                ex.printStackTrace();
            }
        
        Thread readMessage = new Thread(new Runnable()  
        { 
            @Override
            public void run() { 
                String msgg;
                while (true) { 
                    try { 
                         
                        msgg = dist.readUTF(); 
                        System.out.println(msgg);
                        StringTokenizer st = new StringTokenizer(msgg," : ");
                        
                        msgg=st.nextToken();
                        String permission=st.nextToken();
                        
                        perm=permission;
                        
                    } catch (IOException e) { 
                        System.out.println("Server is Offline/Down at this moment. Please try after some time. Thanks for Patience.");
                        break;
                    }
                    
                } 
            } 
        }); 
        readMessage.start();
        
        if(perm.equals("NA"))
        {
            try
            {
                Thread.sleep(1000);
            }catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
                ex.printStackTrace();
            }
            return perm;
        }
        else
        {
            return perm;
        }        
    }
}
