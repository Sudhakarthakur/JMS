/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author kumar
 */
public class Product {

    private String pid;
    private String name;
    private String categary; // ring braslate
    private String metal;  // gold silver
    private double weight;
    private String size;
    private String design;
    private String carat;
    private double todayPrice;
    private String url;
    private double price;
    private boolean pstatus=true;

    public void setSize(String size) {
        this.size = size;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public void setCarat(String carat) {
        this.carat = carat;
    }

    public void setTodayPrice(double todayPrice) {
        this.todayPrice = todayPrice;
    }

    public String getSize() {
        return size;
    }

    public String getDesign() {
        return design;
    }

    public String getCarat() {
        return carat;
    }

    public double getTodayPrice() {
        return todayPrice;
    }
    
    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategary(String categary) {
        this.categary = categary;
    }

    public void setMetal(String metal) {
        this.metal = metal;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPstatus(boolean pstatus) {
        this.pstatus = pstatus;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPid() {
        return pid;
    }

    public String getName() {
        return name;
    }

    public String getCategary() {
        return categary;
    }

    public String getMetal() {
        return metal;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public boolean isPstatus() {
        return pstatus;
    }

    public String getUrl() {
        return url;
    }

}
