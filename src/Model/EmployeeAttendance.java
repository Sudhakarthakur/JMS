/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;

/**
 *
 * @author kumar
 */
public class EmployeeAttendance {
    private String EAid;
    private int attendace;
    private String month;
    private boolean paymentStatus=false;
    private LocalDate paymentDate;
    private String eid;
    private double paymentAmount;

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setEAid(String EAid) {
        this.EAid = EAid;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getEAid() {
        return EAid;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }
 

    public void setEid(String eid) {
        this.eid = eid;
    }

    public void setAttendace(int attendace) {
        this.attendace = attendace;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    

    public String getEid() {
        return eid;
    }

    public int getAttendace() {
        return attendace;
    }

    public String getMonth() {
        return month;
    }

    public boolean isPaymentStatus(boolean par) {
        return paymentStatus;
    }

    public boolean isPaymentStatus() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
