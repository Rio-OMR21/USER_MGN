package com.orinaryaga.ManageUserWeb.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String fname;

    @Column
    private String lname;

    @Column
    private String gender;

    @Column
    private Integer age;

    @Column
    private String email;

    @Column
    private Integer mobile;

    @Column
    private String address;

    @Column
    private Integer pin;

    @Column(name = "date")
    @CreationTimestamp
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public User() {

    }

    
    public User(Integer id, String fname, String lname, String gender, Integer
      age, String email, Integer mobile, String address,
      Integer pin, Date date) {
      this.id = id;
      this.fname = fname;
      this.lname = lname;
      this.gender = gender;
      this.age = age;
      this.email = email;
      this.mobile = mobile;
      this.address = address;
      this.pin = pin;
      this.date = date;
     }
     
     

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    

    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "User [id=" + id + ", fname=" + fname + ", lname=" + lname + ", gender=" + gender + ", age=" + age
                + ", email=" + email + ", mobile=" + mobile + ", address=" + address + ", pin=" + pin + ", date="
                + date + "]";
    }


    
}
