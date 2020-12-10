package com.entity;

/**
 * @author ：lyj
 * @date ：Created in 2020/12/7 0007 9:58
 * @description：
 * @modified By：
 * @version: $
 */
public class Types {
    private Integer id;
    private String name;
    private Integer num;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name ==null ? null: name.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
