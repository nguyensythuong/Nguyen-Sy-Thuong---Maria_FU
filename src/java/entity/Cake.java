/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Win 10
 */
public class Cake {
    private int id;
    private String name;
    private String picture;
    private String shortDes;
    private String detailDes;
    private Date date;
    private double price;

    public Cake() {
    }

    public Cake(int id, String name, String picture, String shortDes, String detailDes, Date date, double price) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.shortDes = shortDes;
        this.detailDes = detailDes;
        this.date = date;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getShortDes() {
        return shortDes;
    }

    public void setShortDes(String shortDes) {
        this.shortDes = shortDes;
    }

    public String getDetailDes() {
        return detailDes;
    }

    public void setDetailDes(String detailDes) {
        this.detailDes = detailDes;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Cake{" + "id=" + id + ", name=" + name + ", picture=" + picture + ", shortDes=" + shortDes + ", detailDes=" + detailDes + ", date=" + date + ", price=" + price + '}';
    }
    
}
