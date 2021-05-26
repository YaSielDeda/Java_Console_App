package service;

import java.sql.*;

public class ConnectionObject {
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=UNIVERMAG";
    private static final String user = "univermag";
    private static final String pass = "password";
    private static final String DB_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    private static Connection con = null;

    public Connection getConnection(){
        try {
            Class.forName(DB_DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(DB_URL, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    public void closeConnection(){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
