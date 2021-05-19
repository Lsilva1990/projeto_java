/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.OracleConnection.DBPASS;
import static Model.OracleConnection.DBURL;
import static Model.OracleConnection.DBUSER;
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
public class ConexaoOracle {

    private String dbUrl, dbUser, dbPass;
    Connection con;

    public ConexaoOracle(String dbUrl, String dbUser, String dbPass) {
        this.dbUrl = dbUrl;
        this.dbUser = dbUser;
        this.dbPass = dbPass;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPass() {
        return dbPass;
    }

    public void setDbPass(String dbPass) {
        this.dbPass = dbPass;
    }

    public boolean ConectarOracle(String dbUser, String dbPass, String dbUrl) throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("SELECT SYSDATE FROM DUAL");
        if (rs.next()) {
            Date currentDate = rs.getDate(1); // get first column returned
            //System.out.println("Current Date from Oracle is : "+currentDate);
            rs.close();
            statement.close();
            return true;

        } else {
            return false;
        }
    }

    public boolean DesconectarOracle() throws SQLException {
        con.close();
        return true;
    }
}
