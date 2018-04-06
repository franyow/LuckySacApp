package com.example.wes_o.testluckyapp;

import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import OpenHelper.SQLite_OpenHelper;

public class MarketsActivity extends AppCompatActivity {

    SQLite_OpenHelper helper = new SQLite_OpenHelper(this,"MarketDB",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_markets);

        SetDatosPredefinidos();


    }

    public void SetDatosPredefinidos(){

        helper.openDB();
        helper.insertarReg("Wong","Av. Sta. Cruz 771", "Miraflores ","-12.0960258","-77.02547370000002");
        helper.insertarReg("Metro","Tiendas 290, 15047", "Surquillo","-12.1038253","-77.02055239999998");
        helper.insertarReg("Tottus","Calle Las Begonias 785", "San Isidro","-12.0960258","-77.02547370000002");
        helper.close();
    }


}
