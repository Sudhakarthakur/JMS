/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import Model.Customer;
import java.sql.*;
/**
 *
 * @author kumar
 */
public class CustomerDAO {
    
    public void insertCustomer(Customer c) {
        try {
            Connection con = DBConnection.getConnection();
            String customerCode = GenerateID.generateCode(con,"customer","customer_code","C");
            String sql = "INSERT INTO customer(customerCode ,name,email,phone,address) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, customerCode);
            ps.setString(2, c.getName());
             ps.setString(3, c.getEmail());
            ps.setString(4, c.getPhone());
            ps.setString(4, c.getAddress());
            ps.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
    
    
   
