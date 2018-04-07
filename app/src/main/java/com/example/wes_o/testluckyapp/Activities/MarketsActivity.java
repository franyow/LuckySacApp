package com.example.wes_o.testluckyapp.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

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
    private final int REQUEST_ACCES_FINE=0;



    //anterior
    //ConnectionSQLiteHelper helper = new ConnectionSQLiteHelper(this,"MarketDB",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_markets);

        comprobarPermisos();


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

    @Override
    public void onBackPressed() {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == REQUEST_ACCES_FINE){
            if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED);
            Toast.makeText(this,"Permiso agregado",Toast.LENGTH_SHORT).show();
            Toast.makeText(this,"Permiso denegado",Toast.LENGTH_SHORT).show();

        }
    }


    //menu logout
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()== R.id.action_sign_out){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
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

    public void comprobarPermisos(){
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_ACCES_FINE);
    }


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
