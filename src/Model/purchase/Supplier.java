/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.purchase;

/**
 *
 * @author kumar
 */
public class Supplier {
    
    private String Sid;
    private String name;
    private String address;
    private String email;
    private String contact;
    private String CompanyName;
    private String GSTNO;

    public String getSid() {
        return Sid;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public void setSid(String Sid) {
        this.Sid = Sid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
      public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public void setGSTNO(String GSTNO) {
        this.GSTNO = GSTNO;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public String getGSTNO() {
        return GSTNO;
    }
}
