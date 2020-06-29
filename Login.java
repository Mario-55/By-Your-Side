package com.example.graduationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Button _buttonlogin, _buttonsignup;
    EditText _txtmail, _txtpass;
    Cursor cursor;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Boolean savelogin;
    CheckBox savelogincheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        openHelper= new DatabaseHelper(this);
        db=openHelper.getReadableDatabase();
        _buttonlogin = (Button)findViewById(R.id.buttonlogin);
        _buttonsignup = (Button) findViewById(R.id.buttonsignup);
        _txtmail=(EditText)findViewById(R.id.txtmail);
        _txtpass=(EditText)findViewById(R.id.txtpass);
        sharedPreferences = getSharedPreferences("loginref", MODE_PRIVATE);
        savelogincheckbox= (CheckBox)findViewById(R.id.checkbox);
        editor=sharedPreferences.edit();

        _buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String email = _txtmail.getText().toString();
                 String pass = _txtpass.getText().toString();
                cursor = db.rawQuery("SELECT *FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL_5 + "=? AND " + DatabaseHelper.COL_4 + "=?", new String[]{email, pass});
                if (cursor!=null){
                     if (cursor.getCount()>0){
                         cursor.moveToNext();
                         Toast.makeText(getApplicationContext(),"Logged In", Toast.LENGTH_LONG).show();
                         if(savelogincheckbox.isChecked()){
                             editor.putBoolean("savelogin",true);
                             editor.putString("Email", email);
                             editor.putString("Password", pass);
                             editor.commit();
                         }

                         openNavigationBar();
                     }
                     else {
                         Toast.makeText(getApplicationContext(),"Incorrect Email or Password", Toast.LENGTH_LONG).show();
                     }
                 }
            }
        });
        _buttonsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Registration.class);
                startActivity(intent);
            }
        });
        savelogin=sharedPreferences.getBoolean("savelogin",true);
        if (savelogin==true){
            _txtmail.setText(sharedPreferences.getString("Email",null));
            _txtpass.setText(sharedPreferences.getString("Password",null));
        }
    }
    public void openNavigationBar(){
        Intent intent = new Intent(Login.this, MainScreen.class);
        startActivity(intent );
        finish();
    }
}