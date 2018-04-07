package com.example.wes_o.testluckyapp.Activities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;

import com.example.wes_o.testluckyapp.Entities.Product;
import com.example.wes_o.testluckyapp.OpenHelper.ConnectionSQLiteHelper;
import com.example.wes_o.testluckyapp.OpenHelper.DatabaseHelper;
import com.example.wes_o.testluckyapp.OpenHelper.InputValidation;
import com.example.wes_o.testluckyapp.R;

public class RegisterProductsActivity extends AppCompatActivity {

    private NestedScrollView nestedScrollView;

    private TextInputLayout textInputLayoutName;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private TextInputLayout textInputLayoutConfirmPassword;

    private TextInputEditText textInputEditTextName;
    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextPassword;
    private TextInputEditText textInputEditTextConfirmPassword;

    private AppCompatButton appCompatButtonRegister;
    private AppCompatTextView appCompatTextViewLoginLink;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_products);
    }


    /*private void postDataToSQLite() {
        if (!inputValidation.isInputEditTextFilled(textInputEditTextName, textInputLayoutName, getString(R.string.error_message_name))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextEmail(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextPassword, textInputLayoutPassword, getString(R.string.error_message_password))) {
            return;
        }
        if (!inputValidation.isInputEditTextMatches(textInputEditTextPassword, textInputEditTextConfirmPassword,
                textInputLayoutConfirmPassword, getString(R.string.error_password_match))) {
            return;
        }

        if (!databaseHelper.checkUser(textInputEditTextEmail.getText().toString().trim())) {

            Product.setName(textInputEditTextName.getText().toString().trim());
            Product.setEmail(textInputEditTextEmail.getText().toString().trim());
            Product.setPassword(textInputEditTextPassword.getText().toString().trim());

            databaseHelper.addUser(Product);

            // Snack Bar to show success message that record saved successfully
            Snackbar.make(nestedScrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
            emptyInputEditText();


        } else {
            // Snack Bar to show error message that record already exists
            Snackbar.make(nestedScrollView, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
        }


    }*/



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
