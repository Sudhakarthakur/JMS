/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Employee;
import Model.EmployeeAttendance;
import com.mysql.cj.protocol.Resultset;
import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
import static java.util.Collections.list;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author kumar
 */
public class EmployeeDAO {

    public boolean chaekEmpExixstsDuringAdd(Employee e) throws SQLException {
        try {
            Connection con = DBConnection.getConnection();
            // 🔎 Check if already exists
            String checkQuery = "SELECT 1 FROM employee WHERE name=? AND contact=? AND idNo=?";
            PreparedStatement checkPs = con.prepareStatement(checkQuery);
            checkPs.setString(1, e.getName());
            checkPs.setString(2, e.getContact());
            checkPs.setString(3, e.getIdNo());
            try (ResultSet rs = checkPs.executeQuery()) {
                return rs.next();
            }
        } catch (Exception ex) {
            return false;
        }
    }

    public String insertEmployee(Employee e) {
        try {
            Connection con = DBConnection.getConnection();
            String eid = GenerateID.generateID(con, "employee", "eid", "EMP");
            String EmployeeQuery = "INSERT INTO employee(eid,name,contact,address,role ,salary,join_date,fatherName,sex,idName,idNo,education,experience,status) VALUES(?,?, ?,?, ?, ?, ?, ?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(EmployeeQuery);
            ps.setString(1, eid);
            ps.setString(2, e.getName());
            ps.setString(3, e.getContact());
            ps.setString(4, e.getAddress());
            ps.setString(5, e.getRole());
            ps.setDouble(6, e.getSalary());
            ps.setDate(7, Date.valueOf(e.getJoinDate()));
            ps.setString(8, e.getFatherName());
            ps.setString(9, e.getSex());
            ps.setString(10, e.getIdName());
            ps.setString(11, e.getIdNo());
            ps.setString(12, e.getEducation());
            ps.setString(13, e.getExperience());
            ps.setBoolean(14, e.isStatus());
         
            int rows = ps.executeUpdate();
            if( rows > 0){
                return eid;
            }else{
                return null;
            }

        } catch (SQLException x) {
            x.printStackTrace();
            return null;
        }
    }

    public boolean EmplyoeeExists(Employee e) {
        try {
            Connection con = DBConnection.getConnection();
            String deleteEmployeDetails = "SELECT * FROM employee WHERE eid = ? ";
            PreparedStatement ps = con.prepareStatement(deleteEmployeDetails);
            ps.setString(1, e.getEid());
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public boolean updateEmployee(Employee e) throws SQLException {
        try {
            Connection con = DBConnection.getConnection();
            String UpdateEmp = " UPDATE employee SET name = ? ,contact = ?,address =? ,role = ?,salary =?,join_date = ? ,status = ? WHERE eid =?";
            PreparedStatement ps = con.prepareStatement(UpdateEmp);
            ps.setString(1, e.getName());
            ps.setString(2, e.getContact());
            ps.setString(3, e.getAddress());
            ps.setString(4, e.getRole());
            ps.setDouble(5, e.getSalary());
            ps.setDate(6, Date.valueOf(e.getJoinDate()));
            ps.setBoolean(7, e.isStatus());
            ps.setString(8, e.getEid());
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean deactivateEmployee(Employee e) {
        try {
            Connection con = DBConnection.getConnection();
            String deleteEmployeDetails = "UPDATE employee SET status=false,laseDate = ? WHERE eid = ? AND status=true ";
            PreparedStatement ps = con.prepareStatement(deleteEmployeDetails);
            ps.setDate(1, Date.valueOf(e.getLastDate()));
            ps.setString(2, e.getEid());

            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Employee getEmployeeById(String e) {
        Employee emp = null;
        try {
            Connection con = DBConnection.getConnection();
            String findEmp = "SELECT * FROM employee WHERE eid = ? AND status = true";
            PreparedStatement ps = con.prepareStatement(findEmp);
            ps.setString(1, e);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                emp = new Employee();
                emp.setEid(rs.getString("eid"));
                emp.setName(rs.getString("name"));
                emp.setContact(rs.getString("contact"));
                emp.setRole(rs.getString("role"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setAddress(rs.getString("address"));

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return emp;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM employee WHERE status = true";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setEid(rs.getString("eid"));
                emp.setName(rs.getString("name"));
                emp.setContact(rs.getString("contact"));
                emp.setRole(rs.getString("role"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setAddress(rs.getString("address"));

                list.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean paymetStatus(EmployeeAttendance ea) {
        try (Connection con = DBConnection.getConnection()) {

            String checkQuery = "SELECT 1 FROM empAttentance WHERE eid=? AND month=?";
            PreparedStatement checkPs = con.prepareStatement(checkQuery);
            checkPs.setString(1, ea.getEid());
            checkPs.setString(2, ea.getMonth());

            ResultSet rs = checkPs.executeQuery();

            if (rs.next()) {

                // UPDATE
                String updateQuery = "UPDATE empAttentance SET paymentStatus=true, month=?, paymentDate=?,payAmpunt=? WHERE eid= ? AND month=? ";
                PreparedStatement ps = con.prepareStatement(updateQuery);

                ps.setDate(1, Date.valueOf(ea.getPaymentDate()));
                ps.setDouble(2, ea.getPaymentAmount());
                ps.setString(3, ea.getEid());
                ps.setString(4, ea.getMonth());

                return ps.executeUpdate() > 0;

            } else {

                // INSERT NEW RECORD
                String AttendedID = GenerateID.generateID(con, "empAttentance", "EAid", "SAL");
                String insertQuery = "INSERT INTO  empAttentance(EAid,eid, month, paymentDate, paymentStatus ,payAmpunt) VALUES (?, ?, ?, ?,?,?)";
                PreparedStatement ps = con.prepareStatement(insertQuery);
                ps.setString(1, AttendedID);
                ps.setString(2, ea.getEid());
                ps.setString(3, ea.getMonth());
                ps.setDate(4, Date.valueOf(ea.getPaymentDate()));
                ps.setBoolean(5, ea.isPaymentStatus(true));
                ps.setDouble(6, ea.getPaymentAmount());

                return ps.executeUpdate() > 0;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean increaseAttendance(EmployeeAttendance ea) {

        try (Connection con = DBConnection.getConnection()) {

            String checkQuery = "SELECT 1 FROM empAttentance WHERE eid=? AND month=?";
            PreparedStatement checkPs = con.prepareStatement(checkQuery);
            checkPs.setString(1, ea.getEid());
            checkPs.setString(2, ea.getMonth());

            ResultSet rs = checkPs.executeQuery();

            if (rs.next()) {

                // UPDATE
                String updateQuery = "UPDATE empAttentance SET attendace = attendace + 1 WHERE eid=? AND month=?";
                PreparedStatement ps = con.prepareStatement(updateQuery);
                ps.setString(1, ea.getEid());
                ps.setString(2, ea.getMonth());

                return ps.executeUpdate() > 0;

            } else {

                // INSERT NEW RECORD
                String AttendedID = GenerateID.generateID(con, "empAttentance", "EAid", "SAL");
                String insertQuery = "INSERT INTO  empAttentance(EAid,eid, month ,attendace) VALUES (?, ?, ?,1)";
                PreparedStatement ps = con.prepareStatement(insertQuery);
                ps.setString(1, AttendedID);
                ps.setString(2, ea.getEid());
                ps.setString(3, ea.getMonth());

                return ps.executeUpdate() > 0;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
