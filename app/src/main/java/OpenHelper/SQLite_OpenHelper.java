package OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by wes_o on 5/04/2018.
 */

public class SQLite_OpenHelper extends SQLiteOpenHelper{
    public SQLite_OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        String query="CREATE TABLE MARKETS(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NOMBRE TEXT, " +
                "DIRECCIÓN TEXT, " + "DISTRITO TEXT" + "LAT REAL" + "LNG REAL)";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //Abre la DB
    public void openDB(){
        this.getWritableDatabase();

    }

    //Cierra BD
    public void closeDB(){
        this.close();
    }

    //insertarValues a la tabla
    public void insertarReg(String nombre, String direccion, String distrito,String latitud, String longitud){
        ContentValues values = new ContentValues();
        values.put("Nombre",nombre);
        values.put("Direccion", direccion);
        values.put("Distrito", distrito);
        values.put("Latitud", latitud);
        values.put("Longitud", longitud);

        this.getWritableDatabase().insert("markets",null,values);
    }

    //llenar datos predefinidos de markets




}
