/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yasenko_402_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Natasha
 */
public class myConnection {
    private String url;
    private String driver;
    private Connection con;
myConnection(String driver,String url)
{
    this.driver=driver;
    this.url=url;
    try {
        Class.forName(this.driver);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(myConnection.class.getName()).log(Level.SEVERE, null, ex);
    }
   System.out.println("Driver loading success!");
    try {
        this.con = DriverManager.getConnection(this.url);
    } catch (SQLException ex) {
        Logger.getLogger(myConnection.class.getName()).log(Level.SEVERE, null, ex);
    }
}
public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
     public static void main(String[] args) {
         
    }
    
}
