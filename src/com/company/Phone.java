package com.company;

public class Phone {
    private int phone_type_id;
    private String phone_manufacturer;
    private String phone_model;
    private Integer phone_price;
    private Integer phone_count;

    public Phone(int phone_type_id, String phone_manufacturer, String phone_model, Integer phone_price, Integer phone_count) {
        this.phone_type_id = phone_type_id;
        this.phone_manufacturer = phone_manufacturer;
        this.phone_model = phone_model;
        this.phone_price = phone_price;
        this.phone_count = phone_count;
    }


    public Integer getPhone_price() {
        return phone_price;
    }

    public void setPhone_price(Integer phone_price) {
        this.phone_price = phone_price;
    }

    public void setPhone_count(Integer phone_count) {
        this.phone_count = phone_count;
    }

    public int getPhone_type_id() {
        return phone_type_id;
    }

    public void setPhone_type_id(int phone_type_id) {
        this.phone_type_id = phone_type_id;
    }

    public String getPhone_manufacturer() {
        return phone_manufacturer;
    }

    public void setPhone_manufacturer(String phone_manufacturer) {
        this.phone_manufacturer = phone_manufacturer;
    }

    public String getPhone_model() {
        return phone_model;
    }

    public void setPhone_model(String phone_model) {
        this.phone_model = phone_model;
    }

    public int getPhone_count() {
        return phone_count;
    }

    public void setPhone_count(int phone_count) {
        this.phone_count = phone_count;
    }

    @Override
    public String toString() {
        return "ID телефона: " + phone_type_id + "\n" +
                "Бренд телефона: " + phone_manufacturer + "\n" +
                "Модель телефона: " + phone_model + "\n" +
                "Кол-во телефонов на складе: " + phone_count + "\n"+
                "Цена телефона: " + phone_price + "\n";
    }
}
