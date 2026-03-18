/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;




/**
 *
 * @author kumar
 */
public class GenerateID {
    public static String generateCode(Connection con ,String TableName ,String ColumnName,String Prefix) throws SQLException{
        String today = new SimpleDateFormat("yyMMdd").format(new Date());
        String pattern = Prefix+today+"%";
        String SQLQuery = " SELECT " + ColumnName + " FROM " + TableName + " WHERE " + ColumnName + " LIKE ? " + " ORDER BY " + ColumnName + " DESC LIMIT 1 ";
       
//        PreparedStatement ps = con.prepareStatement();
       try( PreparedStatement ps = con.prepareStatement(SQLQuery)){
        ps.setString(1, pattern);
        
       try(ResultSet rs = ps.executeQuery()){
        
        
        int nextNumber = 1;

        if (rs.next()) {
            String lastCode = rs.getString(ColumnName);
            
            String numberPart = lastCode.substring(7);
            nextNumber = Integer.parseInt(numberPart) + 1;
        }

        if (nextNumber > 999) {
            throw new SQLException("Daily limit reached for " + Prefix);
        }

        return Prefix + today + String.format("%03d", nextNumber);
    }
       }
    }
    public static String generateID (Connection con ,String TableName ,String ColumnName ,String prefix) throws SQLException {
       String pattern = prefix + "%"; 
       String SQLQuery = " SELECT " + ColumnName + " FROM " + TableName + " WHERE " + ColumnName + " LIKE ? " + " ORDER BY " + ColumnName + " DESC LIMIT 1 ";
       PreparedStatement ps = con.prepareStatement(SQLQuery);
        ps.setString(1, pattern);
        
        ResultSet rs = ps.executeQuery();
        
        
        int nextNumber = 1;
        
         if (rs.next()) {
            String lastCode = rs.getString(ColumnName);
            
            String numberPart = lastCode.substring(3);
            nextNumber = Integer.parseInt(numberPart) + 1;
        }

        if (nextNumber > 999) {
            throw new SQLException("Daily limit reached for " + prefix);
        }

        return prefix+String.format("%03d" ,nextNumber);
    }
    
}
