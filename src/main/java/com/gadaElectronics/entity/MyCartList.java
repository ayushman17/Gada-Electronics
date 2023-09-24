package com.gadaElectronics.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MyCart")
public class MyCartList {

    @Id
    private int id;
    private String name;
    private String company;
    private String price;
    public MyCartList() {
        super();
    }
    public MyCartList(int id, String name, String company, String price) {
        super();
        this.id = id;
        this.name = name;
        this.company = company;
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
}
