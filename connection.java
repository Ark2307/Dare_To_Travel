/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;//this will change accordingly

import com.sun.jdi.connect.spi.Connection;
import java.beans.Statement;

import java.sql.*;

/**
 *
 * @author Asus
 */
//this class sets the connection between our database and the java
public class connection {

    Connection c;
    Statement s;

    public connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///trains", "root", "qwerty12345");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}