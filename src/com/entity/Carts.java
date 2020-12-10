package com.entity;

/**
 * @author ：lyj
 * @date ：Created in 2020/12/9 0009 11:16
 * @description：
 * @modified By：
 * @version: $
 */
public class Carts {
    private int id;
    private int amount;
    private int goodId;
    private int userId;
    private int total;
    private Goods good;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Goods getGood() {
        return good;
    }

    public void setGood(Goods good) {
        this.good = good;
    }
}
