/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lsilva
 */
public class OracleConnection {
    public static final String DBURL = "jdbc:oracle:thin:@(DESCRIPTION = (ADDRESS_LIST = (ADDRESS = (PROTOCOL = TCP)(HOST = o07.kmm.dev.br)(PORT = 1521)))(CONNECT_DATA =(SID = O07B10)))";
    public static final String DBUSER = "sys as SYSDBA";
    public static final String DBPASS = "ConectionTesteLPOO2021";
    
    public static void main(String[] args)throws SQLException{
              DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
              
                      // Connect to Oracle Database
        Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
 
        Statement statement = con.createStatement();
 
        // Execute a SELECT query on Oracle Dummy DUAL Table. Useful for retrieving system values
        // Enables us to retrieve values as if querying from a table
        ResultSet rs = statement.executeQuery("SELECT SYSDATE FROM DUAL");
         
         
        if (rs.next()) {
            Date currentDate = rs.getDate(1); // get first column returned
            System.out.println("Current Date from Oracle is : "+currentDate);
        }
        rs.close();
        statement.close();
        con.close();
    }
         
    }
    
