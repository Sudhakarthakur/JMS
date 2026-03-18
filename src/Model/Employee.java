/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author kumar
 */
public class Employee {
    private String eid;
    private String name;
    private String fatherName;
    private String sex;
    private String contact;
    private String address;
    private String role;
    private double salary;
    private String idName;
    private String idNo;
    private String education; 
    private String Experience ;

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setExperience(String Experience) {
        this.Experience = Experience;
    }

    public void setJoindate(LocalDate joindate) {
        this.joindate = joindate;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getSex() {
        return sex;
    }

    public String getIdName() {
        return idName;
    }

    public String getIdNo() {
        return idNo;
    }

    public String getEducation() {
        return education;
    }

    public String getExperience() {
        return Experience;
    }

    public LocalDate getJoindate() {
        return joindate;
    }
    private LocalDate joindate;
    private LocalDate lastDate;
    

    public void setLastDate(LocalDate lastDate) {
        this.lastDate = lastDate;
    }

    public LocalDate getLastDate() {
        return lastDate;
    }
    private boolean status=true;

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }
    

    public void setEid(String eid) {
        this.eid = eid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setJoinDate(LocalDate date) {
        this.joindate = date;
    }

    public String getEid() {
        return eid;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }

    public String getRole() {
        return role;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getJoinDate() {
        return joindate;
    }

    public void setJoinDate(Date date) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setSalary(String Esalary) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}
