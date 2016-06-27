package com.baidu.waimai.entity;

/**
 * User: KdMobiB
 * Date: 2016/6/1
 * Time: 17:58
 */
public class HomeCategoryItem {
    private int    imgId;
    private String name;

    public HomeCategoryItem(int drawid, String name) {
        this.imgId = drawid;
        this.name = name;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
