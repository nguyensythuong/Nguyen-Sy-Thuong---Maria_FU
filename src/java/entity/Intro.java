/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Win 10
 */
public class Intro {
    private String title;
    private String picture;
    private String shortDes;
    private String detailDes;

    public Intro() {
    }

    public Intro(String title, String picture, String shortDes, String detailDes) {
        this.title = title;
        this.picture = picture;
        this.shortDes = shortDes;
        this.detailDes = detailDes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    @Override
    public String toString() {
        return "Intro{" + "title=" + title + ", picture=" + picture + ", shortDes=" + shortDes + ", detailDes=" + detailDes + '}';
    }
    
    
}
