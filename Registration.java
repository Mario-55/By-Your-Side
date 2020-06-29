package com.example.graduationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button _buttonreg, _buttonacc;
    EditText _txtfname, _txtlname, _txtpsw, _txtemail, _txtphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openHelper=new DatabaseHelper(this);
        _buttonreg = (Button)findViewById(R.id.buttonreg);
        _txtfname= (EditText)findViewById(R.id.txtfname);
        _txtlname= (EditText)findViewById(R.id.txtlname);
        _txtemail= (EditText)findViewById(R.id.txtemail);
        _txtpsw= (EditText)findViewById(R.id.txtpsw);
        _txtphone= (EditText)findViewById(R.id.txtphone);
        _buttonacc = (Button)findViewById(R.id.buttonacc);
        _buttonreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=openHelper.getWritableDatabase();
                String firstname=_txtfname.getText().toString();
                String lastname=_txtlname.getText().toString();
                String password=_txtpsw.getText().toString();
                String email=_txtemail.getText().toString();
                String phone=_txtphone.getText().toString();
                insertdata(firstname,lastname,password,email,phone);
                Toast.makeText(getApplicationContext(), "Register Successfully", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Registration.this, MainScreen.class);
                startActivity(intent);
                finish();
            }
        });
        _buttonacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registration.this, Login.class);
                startActivity(intent);
            }
        });
       _txtphone.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (_txtfname.getText().toString().trim().isEmpty() || _txtlname.getText().toString().trim().isEmpty() || _txtemail.getText().toString().trim().isEmpty() || _txtpsw.getText().toString().trim().isEmpty()) {
                    _buttonreg.setEnabled(false);
                } else {
                    _buttonreg.setEnabled(true);
                }
           }

           @Override
           public void afterTextChanged(Editable s) {

           }
       });
    }
    public void  insertdata (String firstname, String lastname, String password, String email, String phone){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2,firstname);
        contentValues.put(DatabaseHelper.COL_3,lastname);
        contentValues.put(DatabaseHelper.COL_4,password);
        contentValues.put(DatabaseHelper.COL_5, email);
        contentValues.put(DatabaseHelper.COL_6, phone);
        long id= db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
    }
}