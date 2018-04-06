package com.example.wes_o.testluckyapp.Entities;

import java.io.Serializable;

/**
 * Created by wes_o on 5/04/2018.
 */

public class Product implements Serializable {
    private int id;
    private int idMarket;
    private String nombre;
    private double precio;
    private int stock;

    public Product(int id, int idMarket, String nombre, double precio, int stock) {
        this.id = id;
        this.idMarket = idMarket;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public Product(){

    }

    public int getIdMarket() {
        return idMarket;
    }

    public void setIdMarket(int idMarket) {
        this.idMarket = idMarket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


}
