package com.example.yousafkhan.recyclerviewdemo.models;

public class Contact {

    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getContactName() {
        return name;
    }

    public String getContactPhoneNumber() {
        return phoneNumber;
    }
}
