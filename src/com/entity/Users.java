package com.entity;

import com.utils.SystemStringUtils;

/**
 * 用户实体类
 */
public class Users {
    private int id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = SystemStringUtils.strNotNullTrim(username);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = SystemStringUtils.strNotNullTrim(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = SystemStringUtils.strNotNullTrim(name);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = SystemStringUtils.strNotNullTrim(address );
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                '}';
    }
}
