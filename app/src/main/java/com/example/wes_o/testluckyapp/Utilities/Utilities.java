package com.example.wes_o.testluckyapp.Utilities;

/**
 * Created by wes_o on 5/04/2018.
 */


public class Utilities {

    //constantes tabla markets
    public static final String TABLA_MARKETS= "market";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NOMBRE= "nombre";
    public static final String CAMPO_DIRECCION = "direccion";
    public static final String CAMPO_DISTRITO = "distrito";
    public static final String CAMPO_LATITUD = "latitud";
    public static final String CAMPO_LONGITUD = "longitud";

    public static final String TABLA_MARKETS1= "MERCADO";


    public static final String CREAR_TABLA_MARKET = "CREATE TABLE "+TABLA_MARKETS+" ("+CAMPO_ID+" INTEGER, "+CAMPO_NOMBRE+" TEXT, "+CAMPO_DIRECCION+" TEXT, "+CAMPO_DISTRITO+" TEXT, "+CAMPO_LATITUD+" REAL, "+CAMPO_LONGITUD+" REAL)";
    public static final String CREAR_TABLA_MARKET1= "CREATE TABLE MERCADO(ID INTEGER , NOMBRE TEXT, DIRECCION TEXT, DISTRITO TEXT)";

//-------------------------------------
    //Constantes tabla products
    public static final String TABLA_PRODUCTS= "product";
    public static final String CAMPO_ID_PRODUCTO = "id";
    public static final String CAMPO_NOMBRE_PRODUCTO= "nombre";
    public static final String CAMPO_PRECIO_PRODUCTO= "precio";
    public static final String CAMPO_STOCK_PRODUCTO = "stock";
    public static final String CAMPO_ID_MARKET = "id_market";

    //public static final String CREAR_TABLA_PRODUCTS = "CREATE TABLE "+TABLA_PRODUCTS+", "+CAMPO_ID_PRODUCTO+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_NOMBRE_PRODUCTO+" TEXT, "+CAMPO_STOCK_PRODUCTO+" INTEGER, "+CAMPO_ID_MARKET+" INTEGER)";
    public static final String CREAR_TABLA_PRODUCTS = "CREATE TABLE product(ID INTEGER PRIMARY KEY AUTOINCREMENT, PRECIO REAL, STOCK INTEGER, ID_MARKET INTEGER)";

//----------------------------------------
    //constantes tabla users
    public static final int DATABASE_VERSION = 1;

    // Database Name
    public static final String DATABASE_NAME = "UserManager.db";

    // User table name
    public static final String TABLE_USER = "user";

    // User Table Columns names
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_USER_NAME = "user_name";
    public static final String COLUMN_USER_EMAIL = "user_email";
    public static final String COLUMN_USER_PASSWORD = "user_password";

    // create table sql query
    public static final String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")";

    // drop table sql query
    //private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;
}
