package com.example.wes_o.testluckyapp.Activities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import com.example.wes_o.testluckyapp.Entities.Market;
import com.example.wes_o.testluckyapp.OpenHelper.ConnectionSQLiteHelper;
import com.example.wes_o.testluckyapp.R;
import com.example.wes_o.testluckyapp.Utilities.Utilities;
import com.example.wes_o.testluckyapp.Adapters.ListMarketAdapter;

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


        Cursor mCursor = db.rawQuery("SELECT * FROM  MERCADO", null);
        Boolean rowExists;

        if (mCursor.moveToFirst())
        {
            db.close();
            rowExists = true;

        } else
        {
            String metro = "INSERT INTO MERCADO (id,nombre,direccion,distrito) " + "VALUES (1, 'Metro', 'Tiendas 290, 15047', 'Surquillo')";
            String wong = "INSERT INTO MERCADO (id,nombre,direccion,distrito) " + "VALUES (2, 'Wong', 'Av. Sta. Cruz 771', 'Miraflores')";
            String tottus = "INSERT INTO MERCADO (id,nombre,direccion,distrito) " + "VALUES (3, 'Tottus', 'Calle Las Begonias 785', 'San Isidro')";

            db.execSQL(metro);
            db.execSQL(wong);
            db.execSQL(tottus);
            db.close();
            rowExists = false;
        }





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

    public interface RecyclerViewClickListener {

        void onRowClicked(int position);
        void onViewClicked(View v, int position);
    }


}