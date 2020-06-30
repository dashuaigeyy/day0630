package com.yy.entity;


/**
 * 创作时间：2020/4/15 9:54
 * 作者：李增强
 */

public class SmokeBean {

    private Integer id;
    private String cardno;
    private String madetime;
    private String address;
    private String price;

    public SmokeBean() {
    }

    public SmokeBean(String cardno, String madetime, String address, String price) {
        this.cardno = cardno;
        this.madetime = madetime;
        this.address = address;
        this.price = price;
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

    public String getMadedate() {
        return madetime;
    }

    public void setMadedate(String madedate) {
        this.madetime = madedate;
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


}
