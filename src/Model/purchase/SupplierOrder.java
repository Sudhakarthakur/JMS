/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.purchase;

import java.util.Date;

/**
 *
 * @author kumar
 */
public class SupplierOrder {

    private String SOId;
    private String Sid;
    private String Pid; 
    private Date OrderDate;
    private Date DeliveryDate; 
    private double AddvancePaymet;
    private double duePayment;
    private double totalPayment;
    private String OrderStatus;
    private Date paymentdate;
    private boolean deliveryStatus=false;

    public boolean isDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(boolean deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public void setPaymentdate(Date paymentdate) {
        this.paymentdate = paymentdate;
    }

    public Date getPaymentdate() {
        return paymentdate;
    }

    public String getSOId() {
        return SOId;
    }
    
    public void setSid(String Sid) {
        this.Sid = Sid;
    }

    public String getSid() {
        return Sid;
    }

    public String getPid() {
        return Pid;
    }

    public void setPid(String Pid) {
        this.Pid = Pid;
    }
    public Date getOrderDate() {
        return OrderDate;
    }

    public Date getDeliveryDate() {
        return DeliveryDate;
    }

    public double getAddvancePaymet() {
        return AddvancePaymet;
    }

    public double getDuePayment() {
        return duePayment;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public String getOrderStatus() {
        return OrderStatus;
    }

    public void setSOId(String SOId) {
        this.SOId = SOId;
    }

    public void setOrderDate(Date OrderDate) {
        this.OrderDate = OrderDate;
    }

    public void setDeliveryDate(Date DeliveryDate) {
        this.DeliveryDate = DeliveryDate;
    }

    public void setAddvancePaymet(double AddvancePaymet) {
        this.AddvancePaymet = AddvancePaymet;
    }

    public void setDuePayment(double duePayment) {
        this.duePayment = duePayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public void setOrderStatus(String OrderStatus) {
        this.OrderStatus = OrderStatus;
    }
}
