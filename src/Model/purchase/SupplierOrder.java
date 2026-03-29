/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.purchase;

import java.time.LocalDate;
import java.util.*;
import java.util.Date;
import java.util.List;

/**
 *
 * @author kumar
 */
public class SupplierOrder {

    private String soId;
    private String sid;
    private List<SupplieOrderItem> items = new ArrayList<>();
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private double advancePayment;
    private double duePayment;
    private double totalPayment;
    private double amount;
    private String orderStatus;
    private LocalDate paymentdate;

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setPaymentdate(LocalDate paymentdate) {
        this.paymentdate = paymentdate;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public LocalDate getPaymentdate() {
        return paymentdate;
    }

    public LocalDate getTillEnd() {
        return tillEnd;
    }
    private boolean deliveryStatus = false;
    private String discount;
    private String paymentMode;
    private String paymentId;
    private LocalDate tillEnd;

    public double getAdvancePayment() {
        return advancePayment;
    }

    public void setTillEnd(LocalDate tillEnd) {
        this.tillEnd = tillEnd;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setAdvancePayment(double advancePayment) {
        this.advancePayment = advancePayment;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public void setSoId(String soId) {
        this.soId = soId;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setItems(List<SupplieOrderItem> items) {
        this.items = items;
    }

    public void setaddvancePaymet(double addvancePaymet) {
        this.advancePayment = addvancePaymet;
    }

    public void setDuePayment(double duePayment) {
        this.duePayment = duePayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }


    public void setDeliveryStatus(boolean deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getSoId() {
        return soId;
    }

    public String getSid() {
        return sid;
    }

    public List<SupplieOrderItem> getItems() {
        return items;
    }

    public double getaddvancePaymet() {
        return advancePayment;
    }

    public double getDuePayment() {
        return duePayment;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public double getAmount() {
        return amount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public boolean isDeliveryStatus() {
        return deliveryStatus;
    }

    public String getDiscount() {
        return discount;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

}
