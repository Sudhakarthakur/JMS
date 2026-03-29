/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.purchase;

/**
 *
 * @author kumar
 */
public class SupplieOrderItem {
    private String soIitemid;
    private String soid;
    private String pid;
    private int quantity;

    public void setSoIitemid(String soIitemid) {
        this.soIitemid = soIitemid;
    }

    public void setSoid(String soid) {
        this.soid = soid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSoIitemid() {
        return soIitemid;
    }

    public String getSoid() {
        return soid;
    }
    

    public SupplieOrderItem(String pid, int quantity) {
        this.pid = pid;
        this.quantity = quantity;
    }

    public String getPid() {
        return pid;
    }

    public int getQuantity() {
        return quantity;
    }

    
}
