package com.example.graduationproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainScreen extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mToogle;
    private NavigationView navigationView;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        navigationView=findViewById(R.id.drawer_nav);
        drawerLayout=findViewById(R.id.drawer);
        mToogle=new ActionBarDrawerToggle(this, drawerLayout, R.string.Open, R.string.Close);
        drawerLayout.addDrawerListener(mToogle);
        mToogle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(nav);

    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 3000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(),"Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    private NavigationView.OnNavigationItemSelectedListener nav= new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.signout:
                    startActivity(new Intent(MainScreen.this, Login.class));
                    finish();
                    break;

                case R.id.color:
                    startActivity(new Intent(MainScreen.this, Colors.class));
                    break;

                case R.id.home:
                    startActivity(new Intent(MainScreen.this, MainScreen.class));
                    finish();
                    break;

                case R.id.phonetics:
                    startActivity(new Intent(MainScreen.this, Youtube.class));
                    break;

                case R.id.food:
                    startActivity(new Intent(MainScreen.this, ClassifierActivity.class));
                    break;

                case R.id.profile:
                    startActivity(new Intent(MainScreen.this, Passcode.class));
                    break;
            }
            return true;
        }
    };

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(mToogle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

}