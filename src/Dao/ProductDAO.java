/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kumar
 */
public class ProductDAO {

    public String addProduct(Product pro) throws SQLException {
        try {
            Connection con = DBConnection.getConnection();
            String pid = GenerateID.generateID(con, "product", "pid", "PRO");
            String ProductSt = "INSERT INTO product(pid,name,categary,metal,weight,price,pstatus,size,carat,design,todayPrice) VALUES(?,?, ?,?, ?, ?, ?, ?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(ProductSt);
            ps.setString(1, pid);
            ps.setString(2, pro.getName());
            ps.setString(3, pro.getCategary());
            ps.setString(4, pro.getMetal());
            ps.setDouble(5, pro.getWeight());
            ps.setDouble(6, pro.getPrice());
            ps.setBoolean(7, pro.isPstatus());
            ps.setString(8, pro.getSize());
            ps.setString(9, pro.getCarat());
            ps.setString(10, pro.getDesign());
            ps.setDouble(11, pro.getTodayPrice());
            int rows = ps.executeUpdate();
            if( rows > 0){
                return pid;
        }else{
                return null;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        
    }

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM product WHERE pstatus = true";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setPid(rs.getString("pid"));
                pro.setName(rs.getString("name"));
                pro.setCategary(rs.getString("categary"));
                pro.setMetal(rs.getString("metal"));
                pro.setWeight(rs.getDouble("weight"));
                pro.setPrice(rs.getDouble("price"));
//                pro.setQuantity(rs.getInt("quantity"));

                list.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> getAlloutofStoclProducts() {
        List<Product> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM product WHERE pstatus = false";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setPid(rs.getString("pid"));
                pro.setName(rs.getString("name"));
                pro.setCategary(rs.getString("categary"));
                pro.setMetal(rs.getString("metal"));
                pro.setWeight(rs.getDouble("weight"));
                pro.setPrice(rs.getDouble("price"));
//                pro.setQuantity(rs.getInt("quantity"));

                list.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> getAllProductByCategary(String categary) {
        List<Product> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM product WHERE categary = ? AND pstatus = true";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, categary);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setPid(rs.getString("pid"));
                pro.setName(rs.getString("name"));
                pro.setCategary(rs.getString("categary"));
                pro.setMetal(rs.getString("metal"));
                pro.setWeight(rs.getDouble("weight"));
                pro.setPrice(rs.getDouble("price"));
//                pro.setQuantity(rs.getInt("quantity"));

                list.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Product getProductByID(String pid, String name) {
        Product pro = null;
        try {
            Connection con = DBConnection.getConnection();
            String findProductById = "SELECT * FROM product WHERE pid = ? AND name = ?";
            PreparedStatement ps = con.prepareStatement(findProductById);
            ps.setString(1, pid);
            ps.setString(2, name);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pro = new Product();
                pro.setPid(rs.getString("pid"));
                pro.setName(rs.getString("name"));
                pro.setCategary(rs.getString("categary"));
                pro.setMetal(rs.getString("metal"));
                pro.setWeight(rs.getDouble("weight"));
                pro.setPrice(rs.getDouble("price"));
//                pro.setQuantity(rs.getInt("quantity"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return pro;
    }
}
