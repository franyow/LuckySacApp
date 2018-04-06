package com.example.wes_o.testluckyapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.example.wes_o.testluckyapp.Entities.Market;
import com.example.wes_o.testluckyapp.OpenHelper.ConnectionSQLiteHelper;

public class MarketsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    List<Market> marketList = new ArrayList<>();

    //anterior
    ConnectionSQLiteHelper helper = new ConnectionSQLiteHelper(this,"MarketDB",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_markets);

        //nueva col
        //ConnectionSQLiteHelper conn = new ConnectionSQLiteHelper(this,"MarketDB",null,1);





        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        SetDatosPredefinidos();
        //consultarListaMarkets();




    }

    //Setear datos








    /*private void consultarListaMarkets() {
        SQLiteDatabase db = helper.getReadableDatabase();
        Market market = null;

        Cursor cursor = db.rawQuery("SELECT * FROM MarketDB", null);
        while(cursor.moveToNext()){
            //market = new Market();
            market.setNombre(cursor.getString(0));
            market.setDireccion(cursor.getString(1));
            market.setDistrito(cursor.getString(2));

            marketList.add(market);

        }

    }*/

    public void loadData(){
        helper.openDB();
        Market market=null;

        //Cursor cursor =
        //marketList.add();
    }

    public void SetDatosPredefinidos(){

        helper.openDB();
        helper.insertarReg("1","Wong","Av. Sta. Cruz 771", "Miraflores ","-12.0960258","-77.02547370000002");
        helper.insertarReg("2","Metro","Tiendas 290, 15047", "Surquillo","-12.1038253","-77.02055239999998");
        helper.insertarReg("3","Tottus","Calle Las Begonias 785", "San Isidro","-12.0960258","-77.02547370000002");
        helper.close();
    }


}
