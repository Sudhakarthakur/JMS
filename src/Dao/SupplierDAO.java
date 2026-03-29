/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.purchase.SupplierQutation;
import Model.purchase.SupplieOrderItem;
import Model.purchase.Supplier;
import Model.purchase.SupplierOrder;
//import com.sun.jdi.connect.spi.Connection;
import java.sql.*;
import java.util.*;
import java.sql.Date;

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
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }
    
      public boolean ExistSupplier(String sup) {
        try {
            Connection con = DBConnection.getConnection();
            String Query = "SELECT 1 FROM supplier WHER sup=?";
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setString(1, sup);
            try (ResultSet rs = ps.executeQuery()) {
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
            ps.setString(6, sup.getCompanyName());
            ps.setString(7, sup.getGSTNO());
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Supplier getProductByID(String sid) {
        Supplier sup = null;
        try {
            Connection con = DBConnection.getConnection();
            String findProductById = "SELECT * FROM supplier WHERE sid = ?";
            PreparedStatement ps = con.prepareStatement(findProductById);
            ps.setString(1, sid);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                sup = new Supplier();
                sup.setName(rs.getString("name"));
                sup.setContact(rs.getString("contact"));
                sup.setCompanyName(rs.getString("companyName"));
                sup.setAddress(rs.getString("address"));
                sup.setEmail(rs.getString("email"));
                sup.setGSTNO(rs.getString("gstNo"));
                sup.setSid(rs.getString("sid"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return sup;
    }

    public boolean saveAllDate(SupplierQutation supqutation, SupplierOrder supOrder) throws SQLException {
        Connection con = null;
        try {
            con = DBConnection.getConnection();
            con.setAutoCommit(false);
            String soid = GenerateID.generateID(con, "supplierorder", "soid", "SOI");
            //Insert into supplierOrder 
            String supplierOrderAdd = "INSERT INTO supplierorder(soid,orderdate,deliverydate,orderStatus,amount,advancePayment,duePayment,fullPaymentDate,paymentMode,paymentId,sid,discount,totalPayment) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(supplierOrderAdd);
            ps.setString(1, soid);
            ps.setDate(2, Date.valueOf(supOrder.getOrderDate()));
            ps.setDate(3, Date.valueOf(supOrder.getDeliveryDate()));
            ps.setString(4, supOrder.getOrderStatus());
            ps.setDouble(5, supOrder.getAmount());
            ps.setDouble(6, supOrder.getAdvancePayment());
            ps.setDouble(7, supOrder.getDuePayment());
            ps.setDate(8, Date.valueOf(supOrder.getPaymentdate()));
            ps.setString(9, supOrder.getPaymentMode());
            ps.setString(10, supOrder.getPaymentId());
            ps.setString(11, supOrder.getSid());
            ps.setString(12, supOrder.getDiscount());
            ps.setDouble(13, supOrder.getTotalPayment());

            ps.executeUpdate();

            // insert into supplierQutation
            String qid = GenerateID.generateID(con, "supplierqutation", "qid", "QID");
            String addSupplierQutation = "INSERT INTO supplierqutation(qid,soid,perUnit,ratePerUnit,tillValid) VALUES (?,?,?,?,?)";
            PreparedStatement psq = con.prepareStatement(addSupplierQutation);
            psq.setString(1, qid);
            psq.setString(2, soid);
            psq.setString(3, supqutation.getPerUnit());
            psq.setDouble(4, supqutation.getRatePerUnit());
            psq.setDate(5, java.sql.Date.valueOf(supqutation.getTillValid()));
            psq.executeUpdate();

            // add pid and its quntity in multiply
            String addOrderItem = "INSERT INTO supplierorderitems(soItemId,soid,pid,quantity)  VALUES (?,?,?,?)";
            PreparedStatement psa = con.prepareStatement(addOrderItem);
            for (SupplieOrderItem item : supOrder.getItems()) {
                String soItemID = GenerateID.generateID(con, "supplierorderitems", "soItemID", "OII");
                psa.setString(1, soItemID);
                psa.setString(2, soid);
                psa.setString(3, item.getPid());
                psa.setInt(4, item.getQuantity());
                psa.addBatch(); // store query
            }
            psa.executeBatch();  //execute all items together
            con.commit(); //  success
            return true;
        } catch (Exception ex) {
            if (con != null) {
                con.rollback(); // undo everything if error
            }
            ex.printStackTrace();
            return false;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

}
