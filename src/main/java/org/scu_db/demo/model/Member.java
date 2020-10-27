package org.scu_db.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "member")
public class Member {
    @Id
    private Integer memno;
    private String driverlic;
    private String fname;
    private String mi;
    private String lname;
    private String address;
    private String phonenumber;

    public Integer getMemno() {
        return memno;
    }

    public void setMemno(Integer memno) {
        this.memno = memno;
    }

    public String getDriverlic() {
        return driverlic;
    }

    public void setDriverlic(String driverlic) {
        this.driverlic = driverlic;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMi() {
        return mi;
    }

    public void setMi(String mi) {
        this.mi = mi;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
