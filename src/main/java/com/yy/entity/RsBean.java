package com.yy.entity;

/**
 * 创作时间：2020/4/16 14:40
 * 作者：李增强
 */
public class RsBean {

    private Integer id;
    private String cardno;
    private String madedate;
    private String address;
    private String price;
    private String vol;
    private String name;

    public String getMadetime() {
        return madedate;
    }

    public void setMadetime(String madetime) {
        this.madedate = madetime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getVol() {
        return vol;
    }

    public void setVol(String vol) {
        this.vol = vol;
    }

    @Override
    public String toString() {
        return "RsBean{" +
                "id=" + id +
                ", cardno='" + cardno + '\'' +
                ", madetime='" + madedate + '\'' +
                ", address='" + address + '\'' +
                ", price='" + price + '\'' +
                ", vol='" + vol + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
