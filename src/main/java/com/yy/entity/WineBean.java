package com.yy.entity;

/**
 * 创作时间：2020/4/15 9:54
 * 作者：李增强
 */


public class WineBean {

    private Integer id;

    private String cardno;

    private String madetime;

    private String address;
    private String price;
    private String vol;

    public WineBean(String cardno, String madetime, String address, String price,  String vol) {
        this.cardno = cardno;
        this.madetime = madetime;
        this.address = address;
        this.price = price;
        this.vol = vol;
    }

    public WineBean() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMadetime() {
        return madetime;
    }

    public void setMadetime(String madetime) {
        this.madetime = madetime;
    }

    public String getVol() {
        return vol;
    }

    public void setVol(String vol) {
        this.vol = vol;
    }
}
