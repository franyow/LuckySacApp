package com.example.wes_o.testluckyapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import com.example.wes_o.testluckyapp.Entities.Market;
import com.example.wes_o.testluckyapp.OpenHelper.ConnectionSQLiteHelper;
import com.example.wes_o.testluckyapp.Utilities.Utilities;
import com.example.wes_o.testluckyapp.adapter.ListMarketAdapter;

public class MarketsActivity extends AppCompatActivity {

    RecyclerView recyclerViewMarkets;
    //LinearLayoutManager linearLayoutManager;
    ArrayList<Market> marketList = new ArrayList<>();

    ConnectionSQLiteHelper conn;

    //anterior
    //ConnectionSQLiteHelper helper = new ConnectionSQLiteHelper(this,"MarketDB",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_markets);


        conn = new ConnectionSQLiteHelper(getApplicationContext(),"MarketBD",null,1);
        marketList = new ArrayList<>();

        recyclerViewMarkets = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerViewMarkets.setLayoutManager(new LinearLayoutManager(this));

        registrarmarketSql();
        consultarListaMarkets();
        //SetDatosPredefinidos();


        ListMarketAdapter adapter = new ListMarketAdapter(marketList);
        recyclerViewMarkets.setAdapter(adapter);


    }

    private void registrarmarketSql() {
        ConnectionSQLiteHelper conn=new ConnectionSQLiteHelper(this,"MarketBD",null,1);
        SQLiteDatabase db=conn.getWritableDatabase();

        //inser into market
        //String insert="INSERT INTO market (id,nombre,direccion,distrito,latitud,longitud) " +
        //        "VALUES (1, 'Paul', 'tu vieja', 'California', 20000,3000 )";

        String metro="INSERT INTO MERCADO (id,nombre,direccion,distrito) " + "VALUES (1, 'Metro', 'Tiendas 290, 15047', 'Surquillo')";
        String wong="INSERT INTO MERCADO (id,nombre,direccion,distrito) " + "VALUES (2, 'Wong', 'Av. Sta. Cruz 771', 'Miraflores')";
        String tottus="INSERT INTO MERCADO (id,nombre,direccion,distrito) " + "VALUES (3, 'Tottus', 'Calle Las Begonias 785', 'San Isidro')";

        db.execSQL(metro);
        db.execSQL(wong);
        db.execSQL(tottus);


        db.close();


    }

    //Setear datos


    private void consultarListaMarkets() {
        SQLiteDatabase db = conn.getReadableDatabase();
        Market market = null;

        Cursor cursor = db.rawQuery("SELECT * FROM "+ Utilities.TABLA_MARKETS1, null);

        while(cursor.moveToNext()){
            market = new Market();
            market.setId(cursor.getInt(0));
            market.setNombre(cursor.getString(1));
            market.setDireccion(cursor.getString(2));
            market.setDistrito(cursor.getString(3));
            //market.setLongitud(cursor.getDouble(4));
            //market.setLatitud(cursor.getDouble(5));

            marketList.add(market);

        }
        db.close();

    }

    /*public void loadData(){
        helper.openDB();
        Market market=null;

        //Cursor cursor =
        //marketList.add();
    }*/

    public void SetDatosPredefinidos(){

        ConnectionSQLiteHelper conn=new ConnectionSQLiteHelper(this,"MarketBD",null,1);
        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();

        values.put(Utilities.CAMPO_ID,"1");
        values.put(Utilities.CAMPO_NOMBRE,"Wong");
        values.put(Utilities.CAMPO_DIRECCION,"Av. Sta. Cruz 771");
        values.put(Utilities.CAMPO_DISTRITO,"Miraflores");
        //values.put(Utilities.CAMPO_LATITUD,"77.02547370000002");
        //values.put(Utilities.CAMPO_LONGITUD,"2.0960258");

        db.close();


        //Long idResultante=db.insert(Utilities.TABLA_MARKETS,Utilities.CAMPO_ID,values);

        //values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());

        //values.put(Utilidades.CAMPO_TELEFONO,campoTelefono.getText().toString());


        /*marketList.add(new Market(1,"Wong","Av. Sta. Cruz 771", "Miraflores ",-12.0960258,-77.02547370000002));
        marketList.add(new Market(2,"Metro","Tiendas 290, 15047", "Surquillo",12.1038253,77.02055239999998));
        marketList.add(new Market(3,"Tottus","Calle Las Begonias 785", "San Isidro",12.0960258,77.02547370000002));
*/
    }


}
