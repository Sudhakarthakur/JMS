/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import java.sql.*;
import java.sql.Connection;

/**
 *
 * @author kumar
 */
public class DBConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jewelrymanagement?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
                "root",
                "Sudhakar@90"
            );
            return con;
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException ex) {
            System.getLogger(DBConnection.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return null;
        }
    }

    PreparedStatement prepareStatement(String SQLQuery) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
    
