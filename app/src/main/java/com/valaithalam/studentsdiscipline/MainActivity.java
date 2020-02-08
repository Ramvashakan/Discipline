package com.valaithalam.studentsdiscipline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    private Button bn_1,bn_2,bn_3,bn_4;

    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bn_1 = findViewById(R.id.bn_1);
        bn_2 = findViewById(R.id.bn_2);
        bn_3 = findViewById(R.id.bn_3);
        bn_4 = findViewById(R.id.bn_4);

        navigationView = findViewById(R.id.nav_draw);

        bn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SchoolActivity.class);
                startActivity(i);
            }
        });

        bn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CollegeActivity.class);
                startActivity(i);
            }
        });

        bn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(i);
            }
        });

        bn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, EnvironmentActivity.class);
                startActivity(i);
            }
        });

        drawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();

                Intent i;

                switch (id){

                    case R.id.item_scl :
                        i =new Intent(MainActivity.this, SchoolActivity.class);
                        startActivity(i);
                        break;

                    case R.id.item_clg :
                        i =new Intent(MainActivity.this, CollegeActivity.class);
                        startActivity(i);
                        break;

                    case R.id.item_environment :
                        i =new Intent(MainActivity.this, EnvironmentActivity.class);
                        startActivity(i);
                        break;

                    case R.id.item_home :
                        i =new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(i);
                        break;
                }
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                return false;

            }
        });
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)){

            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
            {
            super.onBackPressed();
            }
    }
}
