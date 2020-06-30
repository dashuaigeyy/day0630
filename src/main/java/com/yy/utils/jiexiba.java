package com.yy.utils;

import com.yy.entity.QueryVo;
import com.yy.entity.SmokeBean;
import com.yy.entity.WineBean;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class jiexiba {
    public static QueryVo  jieXiStr1(String str1){
        QueryVo vo = null;
        Document document = null;
        Element root = null;

        try {
            document = DocumentHelper.parseText(str1);
            root = document.getRootElement();
            String uname = root.elementText("UNAME");
            String pwd = root.elementText("PWD");
            String code = root.elementText("CODE");
            vo=new QueryVo(uname,pwd,code);
            return vo;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String jieXiStr2(String str2) {
        Document document = null;
        Element root = null;
        try {
            /**
             * 这个地方报异常，就是xml解析失败
             */
            document = DocumentHelper.parseText(str2);
            root = document.getRootElement();
            String cardno = root.elementText("CARDNO");
            return cardno;
        } catch (DocumentException e) {
        }
        return null;
    }
    public static SmokeBean jieXiStr2Smoke(String str2) {
        SmokeBean smokeBean = null;
        Document document = null;
        Element root = null;
        try {
            /**
             * 这个地方报异常，就是xml解析失败
             */
            document = DocumentHelper.parseText(str2);
            root = document.getRootElement();
            String cardno = root.elementText("CARDNO");
            String madetime = root.elementText("MADEDATE");
            String address = root.elementText("ADDRESS");
            String price = root.elementText("PRICE");
            smokeBean = new SmokeBean(cardno, madetime, address, price);
            return smokeBean;
        } catch (DocumentException e) {

        }
        return null;
    }

    public static WineBean jieXiStr2Wine(String str2) {
        WineBean wineBean = null;
        Document document = null;
        Element root = null;
        try {
            /**
             * 这个地方报异常，就是xml解析失败
             */
            document = DocumentHelper.parseText(str2);
            root = document.getRootElement();
            String cardno = root.elementText("CARDNO");
            String madedate = root.elementText("MADEDATE");
            String address = root.elementText("ADDRESS");
            String price = root.elementText("PRICE");
            String vol = root.elementText("VOL");
            wineBean = new WineBean(cardno, madedate, address, price, vol);
            return wineBean;
        } catch (DocumentException e) {
        }
        return null;
    }
}
