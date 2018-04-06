package com.example.wes_o.testluckyapp.OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.wes_o.testluckyapp.Utilities.Utilities;

/**
 * Created by wes_o on 5/04/2018.
 */

public class ConnectionSQLiteHelper extends SQLiteOpenHelper{



    public ConnectionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Utilities.CREAR_TABLA_MARKET1);
        //db.execSQL(Utilities.CREAR_TABLA_PRODUCTS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int lastVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Utilities.TABLA_MARKETS1);
        //db.execSQL("DROP TABLE IF EXISTS "+Utilities.TABLA_PRODUCTS);
        onCreate(db);

    }


    //---------------------------------



    //insertarValues a la tabla
    public void insertarReg(String id,String nombre, String direccion, String distrito,String latitud, String longitud){
        ContentValues values = new ContentValues();
        values.put(Utilities.CAMPO_ID,id);
        values.put(Utilities.CAMPO_NOMBRE,nombre);
        values.put(Utilities.CAMPO_DIRECCION, direccion);
        values.put(Utilities.CAMPO_DISTRITO, distrito);
        values.put(Utilities.CAMPO_LATITUD, latitud);
        values.put(Utilities.CAMPO_LONGITUD, longitud);

        this.getWritableDatabase().insert("markets",null,values);
    }






}
