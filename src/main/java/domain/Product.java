/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import javafx.scene.chart.PieChart.Data;

/**
 *
 * @author paulo
 */
public class Product {

    private int id;
    private String name;
    private double price;
    private String productType;
    private String productType2;
    private Data data;
    private String store;
    private String otherInfo;

    public Product(int id, String name, double price, String productType, String productType2, Data data, String store, String otherInfo) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productType = productType;
        this.productType2 = productType2;
        this.data = data;
        this.store = store;
        this.otherInfo = otherInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductType2() {
        return productType2;
    }

    public void setProductType2(String productType2) {
        this.productType2 = productType2;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    @Override
    public String toString() {
        return "Product: " + "id=" + id + ", name=" + name + ", price=" + price + ", productType=" + productType + ", productType2=" + productType2 + ", data=" + data + ", store=" + store + ", otherInfo=" + otherInfo;
    }
}
