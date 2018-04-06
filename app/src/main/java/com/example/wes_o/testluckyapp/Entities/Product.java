package com.example.wes_o.testluckyapp.Entities;

import java.io.Serializable;

/**
 * Created by wes_o on 5/04/2018.
 */

public class Product implements Serializable {
    private String id;
    private String precio;
    private String stock;
    private String id_market;



    public Product(String id, String precio, String stock, String id_market) {
        this.id = id;
        this.precio = precio;
        this.stock = stock;
        this.id_market = id_market;
    }

    public String getId_market() {
        return id_market;
    }

    public void setId_market(String id_market) {
        this.id_market = id_market;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }



    public Product(){

    }



}
