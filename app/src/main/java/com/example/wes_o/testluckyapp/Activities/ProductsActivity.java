package com.example.wes_o.testluckyapp.Activities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.wes_o.testluckyapp.Entities.Product;
import com.example.wes_o.testluckyapp.OpenHelper.ConnectionSQLiteHelper;
import com.example.wes_o.testluckyapp.R;
import com.example.wes_o.testluckyapp.Adapters.ListProductsAdapter;

import java.util.ArrayList;

public class ProductsActivity extends AppCompatActivity {

    RecyclerView recyclerViewMarkets;

    ArrayList<Product> productArrayList = new ArrayList<>();

    ConnectionSQLiteHelper conn;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products_recyclerview);


        conn = new ConnectionSQLiteHelper(getApplicationContext(), "MarketBD", null, 1);
        productArrayList = new ArrayList<>();

        recyclerViewMarkets = (RecyclerView) findViewById(R.id.recyclerview_products);
        recyclerViewMarkets.setLayoutManager(new LinearLayoutManager(this));

        registrarmarketSql();
        cosultaListaProducts();


        ListProductsAdapter adapter = new ListProductsAdapter(productArrayList);
        recyclerViewMarkets.setAdapter(adapter);




    }

    private void cosultaListaProducts() {
        SQLiteDatabase db = conn.getReadableDatabase();
        Product market = null;

        int positionInt ;
        Bundle positionM = getIntent().getExtras();
        positionInt = positionM.getInt("positionA");


        Cursor cursor = db.rawQuery("SELECT * FROM  product WHERE id_market=="+positionInt+"", null);

        while (cursor.moveToNext()) {
            market = new Product();
            market.setId(cursor.getString(0));
            market.setPrecio(cursor.getString(1));
            market.setStock(cursor.getString(2));
            market.setId_market(cursor.getString(3));


            productArrayList.add(market);

        }
        db.close();
    }

    private void registrarmarketSql() {
        ConnectionSQLiteHelper conn = new ConnectionSQLiteHelper(this, "MarketBD", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();


        Cursor mCursor = db.rawQuery("SELECT * FROM  product", null);
        Boolean rowExists;

        if (mCursor.moveToFirst()) {
            db.close();
            rowExists = true;

        } else {
            String testProduct = "INSERT INTO product (precio,stock,id_market) VALUES ( 50.5, 430,1)";
            String testProduct1 = "INSERT INTO product (precio,stock,id_market) VALUES ( 70.4, 350,2)";
            String testProduct2 = "INSERT INTO product (precio,stock,id_market) VALUES ( 20.5, 342,2)";
            String testProduct3 = "INSERT INTO product (precio,stock,id_market) VALUES ( 15.7, 127,3)";
            String testProduct4 = "INSERT INTO product (precio,stock,id_market) VALUES ( 12.3, 120,2)";
            String testProduct5 = "INSERT INTO product (precio,stock,id_market) VALUES ( 22.1, 241,1)";
            String testProduct6 = "INSERT INTO product (precio,stock,id_market) VALUES ( 31.8, 121,1)";
            String testProduct7 = "INSERT INTO product (precio,stock,id_market) VALUES ( 47.6, 324,1)";
            String testProduct8 = "INSERT INTO product (precio,stock,id_market) VALUES ( 52.7, 410,2)";
            String testProduct9 = "INSERT INTO product (precio,stock,id_market) VALUES ( 78.7, 730,3)";
            String testProduct10 = "INSERT INTO product (precio,stock,id_market) VALUES ( 99.9, 20,3)";


            db.execSQL(testProduct);
            db.execSQL(testProduct1);
            db.execSQL(testProduct2);
            db.execSQL(testProduct3);
            db.execSQL(testProduct4);
            db.execSQL(testProduct5);
            db.execSQL(testProduct6);
            db.execSQL(testProduct7);
            db.execSQL(testProduct8);
            db.execSQL(testProduct9);
            db.execSQL(testProduct10);


            db.close();
            rowExists = false;
        }
    }
}



