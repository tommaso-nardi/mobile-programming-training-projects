package com.example.listacontatti;

public class Item {
    private String name;
    private String phoneNumber;

    public Item(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
