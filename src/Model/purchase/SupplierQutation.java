/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.purchase;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author kumar
 */
public class SupplierQutation {

    private String Qid;
    private String SOID;
    private Date OrderDate;
    private String perUnit;
    private double ratePerUnit;
    private LocalDate tillValid;

    
    public void setQid(String Qid) {
        this.Qid = Qid;
    }

    public void setSOID(String SOID) {
        this.SOID = SOID;
    }

    public void setOrderDate(Date OrderDate) {
        this.OrderDate = OrderDate;
    }

    public void setPerUnit(String perUnit) {
        this.perUnit = perUnit;
    }

    public void setRatePerUnit(double ratePerUnit) {
        this.ratePerUnit = ratePerUnit;
    }


    public String getQid() {
        return Qid;
    }

    public String getSOID() {
        return SOID;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public String getPerUnit() {
        return perUnit;
    }

    public double getRatePerUnit() {
        return ratePerUnit;
    }

    public LocalDate getTillValid() {
        return tillValid;
    }

    public void setTillValid(LocalDate tillValid) {
        this.tillValid = tillValid;
    }

   

}
