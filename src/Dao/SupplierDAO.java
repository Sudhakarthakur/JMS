/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.purchase.Supplier;
//import com.sun.jdi.connect.spi.Connection;
import java.sql.*;

/**
 *
 * @author kumar
 */
public class SupplierDAO {

    public boolean ExistSupplierOrNot(Supplier sup) {
        try {
            Connection con = DBConnection.getConnection();
            String Query = "SELECT 1 FROM supplier WHER companyName=? AND gstNo=?";
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setString(1, sup.getCompanyName());
            ps.setString(2, sup.getGSTNO());
            try ( ResultSet rs = ps.executeQuery()){
                return rs.next();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        
    }

    public boolean addSupplier(Supplier sup) {
        try {
            Connection con = DBConnection.getConnection();
            String sid = GenerateID.generateID(con, "supplier", "sid", "SUP");
            String Query = "INSERT INTO supplier(sid,name,address,email,contact,companyName,gstNo) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setString(1, sid);
            ps.setString(2, sup.getName());
            ps.setString(3, sup.getAddress());
            ps.setString(4, sup.getEmail());
            ps.setString(5, sup.getContact());
            ps.setString(6,sup.getCompanyName());
            ps.setString(7, sup.getGSTNO());
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
