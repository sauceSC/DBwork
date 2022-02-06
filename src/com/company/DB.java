package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static javax.management.remote.JMXConnectorFactory.connect;

public class DB{
    private final String url = "jdbc:postgresql://localhost:5432/";
    private final String user = "postgres";
    private final String password = "aisha0802";
    public String model;
    public int id;
    public int price;
    public String manufacturer;
    public int count;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("connected");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }

    public List<Phone> getPhones() {
        List<Phone> phones = new ArrayList<Phone>();
        String SQL = "SELECT * FROM phones";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL);) {
            int i = 0;
            while (rs.next()) {
                Phone phone = new Phone(
                        rs.getInt("phone_type_id"),
                        rs.getString("phone_manufacturer"),
                        rs.getString("phone_model"),
                        rs.getInt("phone_price"),
                        rs.getInt("phone_count")
                );
                phones.add(phone);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return phones;
    }

    public List<Phone> getPhonesByManufacturer() {
        List<Phone> phones = new ArrayList<Phone>();
        String SQL = "SELECT * from phones WHERE phone_manufacturer = " + "'" + getManufacturer() +  "'";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL);) {
            while (rs.next()) {
                Phone phone = new Phone(
                        rs.getInt("phone_type_id"),
                        rs.getString("phone_manufacturer"),
                        rs.getString("phone_model"),
                        rs.getInt("phone_price"),
                        rs.getInt("phone_count")
                );
                phones.add(phone);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return phones;
    }

    public List<Phone> getDiscount() {
        List<Phone> phones = new ArrayList<Phone>();
        String SQL = "UPDATE phones SET phone_price = phone_price - ((phone_price / 100) * 20) WHERE phone_manufacturer =" + "'" + getModel() +  "'";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL);) {
            while (rs.next()) {
                Phone phone = new Phone(
                        rs.getInt("phone_type_id"),
                        rs.getString("phone_manufacturer"),
                        rs.getString("phone_model"),
                        rs.getInt("phone_price"),
                        rs.getInt("phone_count")
                );
                phones.add(phone);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return phones;
    }

    public List<Phone> addPhone() {
        List<Phone> phones = new ArrayList<Phone>();
        String SQL = "INSERT INTO phones(phone_type_id, phone_manufacturer, phone_model, phone_price, phone_count)\n" +
                "VALUES(" + "phone_type_id = " + "'" + getId() + "'"+ "," +"phone_manufacturer = "+ "'"  + getManufacturer()+ "'" + "," + "phone_model = "+ "'" + getModel() + "'" + "," + "phone_price = "+ "'" + getPrice()+ "'" + ","+ "phone_count = " + "'" + getCount() + "'" + ")";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL);) {
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return phones;
    }


}
