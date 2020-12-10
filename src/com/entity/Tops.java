package com.entity;

/**
 * @author ：lyj
 * @date ：Created in 2020/12/8 0008 14:37
 * @description：
 * @modified By：
 * @version: $
 */
public class Tops {
    /*
    首页推荐类型-今日推荐
     */
    public static final byte TYPE_TODAY = 1;
    private int id;
    private byte type;
    private int goodId;

    public static byte getTypeToday() {
        return TYPE_TODAY;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }
}
