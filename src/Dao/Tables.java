/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author kumar
 */
public class Tables {

    public static void main(String[] args) {
        try {
            Connection con = DBConnection.getConnection();
            Statement stm = con.createStatement();
            //User Table
//            String userTable = "create table  IF NOT EXISTS users ("
//                    +"id INT AUTO_INCREMENT PRIMARY KEY ," 
//                    +"userName VARCHAR(50) NOT NULL ,"
//                    +"email VARCHAR(70) UNIQUE,"
//                    +"contact VARCHAR(15),"
//                    +"password VARCHAR(50)"
//                     +")";
//            stm.executeUpdate(userTable);
//            System.out.println("TAble cteated");

            //Customet table
//            String customertable = "CREATE TABLE  IF NOT EXISTS customer("
//                    +"id VARCHAR(9)  PRIMARY KEY,"
//                    +"name VARCHAR(50) NOT NULL ,"
//                    +"email VARCHAR(50) UNIQUE,"
//                    +"phone VARCHAR(15) NOT NULL,"
//                    +"address VARCHAR(200) NOT NULL"
//                    +")";
//            stm.executeUpdate(customertable);
//            System.out.println("Customer table created");
            // Employee table
            String EmployeeTable = "CREATE TABLE IF NOT EXISTS employee( "
                    + "eid VARCHAR(6) PRIMARY KEY,"
                    + "name VARCHAR(30) NOT NULL,"
                    + "contact VARCHAR(10) NOT NULL UNIQUE,"
                    + "address VARCHAR(100) NOT NULL,"
                    + "salary DECIMAL(10,2) NOT NULL,"
                    + "role VARCHAR(30) NOT NULL,"
                    + "fatherName VARCHAR(30) NOT NULL,"
                    + "sex VARCHAR(10) NOT NULL,"
                    + "idName VARCHAR(30) NOT NULL,"
                    + "idNo VARCHAR(20) NOT NULL,"
                    + "education VARCHAR(50),"
                    + "experience VARCHAR(50),"
                    + "join_date DATE,"
                    + "status BOOLEAN NOT NULL DEFAULT TRUE,"
                    + "laseDate DATE"
                    + ")";

            stm.executeUpdate(EmployeeTable);
            System.out.println("Employee table created");

            String EmployeAttendance = "CREATE TABLE IF NOT EXISTS empAttentance("
                    + "EAid varchar(6) PRIMARY KEY,"
                    + "eid VARCHAR(6) NOT NULL,"
                    + "attendace INTEGER NOT NULL DEFAULT 0,"
                    + "month VARCHAR(20) NOT NULL,"
                    + "paymentDate DATE,"
                    + "payAmpunt DECIMAL(10,2) NOT NULL,"
                    + "paymentStatus BOOLEAN NOT NULL DEFAULT FALSE,"
                    + "CONSTRAINT fk_empAttentance FOREIGN KEY (eid)"
                    + "REFERENCES  employee(eid)"
                    + ")";

            stm.executeUpdate(EmployeAttendance);
            System.out.println("Attendance table created");

            //product table
            String productTable = "CREATE TABLE IF NOT EXISTS product("
                    + "pid varchar(6) PRIMARY KEY,"
                    + "name VARCHAR(40) NOT NULL,"
                    + "categary VARCHAR(20) NOT NULL,"
                    + "metal VARCHAR(30) NOT NULL,"
                    + "size VARCHAR(20) NOT NULL,"
                    + "design VARCHAR(50) NOT NULL,"
                    + "carat VARCHAR(15) NOT NULL,"
                    + "weight DECIMAL(10,2) NOT NULL,"
                    + "price DECIMAL(10,2) not null,"
                    + "todayPrice DECIMAL(10,2) not null,"
                    + "pstatus BOOLEAN NOT NULL DEFAULT true,"
                    + " url VARCHAR(100) "
                    + ")";

            stm.executeUpdate(productTable);
            System.out.println("Product table created");

            String SupplierDetails = "CREATE TABLE IF NOT EXISTS supplier("
                    + "sid varchar(6) PRIMARY KEY,"
                    + "name VARCHAR(40) NOT NULL,"
                    + "address VARCHAR(100) NOT NULL,"
                    + "email VARCHAR(30),"
                    + "companyName VARCHAR(60) NOT NULL,"
                    + "gstNo VARCHAR(16) NOT NULL,"
                    + "contact VARCHAR(10) NOT NULL"
                    + ")";

            stm.executeUpdate(SupplierDetails);
            System.out.println("Supplier table created");

            String SupplierOrder = "CREATE TABLE IF NOT EXISTS supplierOrder("
                    + "soid VARCHAR(6) PRIMARY KEY,"
                    + "sid VARCHAR(6) NOT NULL,"
                    + "pid VARCHAR(6) NOT NULL,"
                    + "orderdate DATE,"
                    + "deliverydate DATE,"
                    + "totalPayment decimal(10,2) NOT NULL,"
                    + "advancePayment decimal(10,2),"
                    + "duePayment decimal(10,2),"
                    + "orderStatus VARCHAR(30),"
                    + "fullPaymentDate DATE,"
                    + "delveryStatus BOOLEAN DEFAULT false,"
                    + "CONSTRAINT fk_supplier_sid FOREIGN KEY (sid)"
                    + "REFERENCES  supplier(sid),"
                    + "CONSTRAINT fk_product_pid FOREIGN KEY (pid)"
                    + "REFERENCES  product(pid)"
                    + ")";

            stm.executeUpdate(SupplierOrder);
            System.out.println("supplierOrder table created");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
