package com.example.wes_o.testluckyapp.Entities;

import java.io.Serializable;

/**
 * Created by wes_o on 5/04/2018.
 */

public class Market implements Serializable{

    private int id;
    private String nombre;
    private String direccion;
    private String Distrito;
    private double longitud;
    private double latitud;

    public Market(int id, String nombre, String direccion, String distrito, double longitud, double latitud) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        Distrito = distrito;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public Market(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return Distrito;
    }

    public void setDistrito(String distrito) {
        Distrito = distrito;
    }


}
