package com.baidu.waimai.entity;

import java.util.ArrayList;

/**
 * User: KdMobiB
 * Date: 2016/6/1
 * Time: 17:58
 */
public class HomeItem {
    private int    imgId;
    private String title;
    private ArrayList<String> tabs = new ArrayList<>();//券票付赔
    private float rate;
    private int salenum;
    private long address;
    private float startprize;
    private float sendprize;
    private float sendtime;

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getTabs() {
        return tabs;
    }

    public void setTabs(ArrayList<String> tabs) {
        this.tabs = tabs;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getSalenum() {
        return salenum;
    }

    public void setSalenum(int salenum) {
        this.salenum = salenum;
    }

    public long getAddress() {
        return address;
    }

    public void setAddress(long address) {
        this.address = address;
    }

    public float getStartprize() {
        return startprize;
    }

    public void setStartprize(float startprize) {
        this.startprize = startprize;
    }

    public float getSendprize() {
        return sendprize;
    }

    public void setSendprize(float sendprize) {
        this.sendprize = sendprize;
    }

    public float getSendtime() {
        return sendtime;
    }

    public void setSendtime(float sendtime) {
        this.sendtime = sendtime;
    }
}
