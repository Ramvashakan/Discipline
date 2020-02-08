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
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.material.navigation.NavigationView;

public class SchoolActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    NavigationView navigationView;

    ImageView  img1,img2,img3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);

        img1 = findViewById(R.id.scl_img1);
        img2 = findViewById(R.id.scl_img2);
        img3 = findViewById(R.id.scl_img3);

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.nav_draw_s);

        drawerLayout = findViewById(R.id.drawer_layout_s);

        YoYo.with(Techniques.RubberBand).delay(500).playOn(img1);
        YoYo.with(Techniques.RubberBand).delay(1000).playOn(img2);
        YoYo.with(Techniques.RubberBand).delay(2000).playOn(img3);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.Shake).playOn(img1);

            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.Shake).playOn(img2);

            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.Shake).playOn(img3);

            }
        });





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
                        i =new Intent(SchoolActivity.this, SchoolActivity.class);
                        startActivity(i);
                        break;

                    case R.id.item_clg :
                        i =new Intent(SchoolActivity.this, CollegeActivity.class);
                        startActivity(i);
                        break;

                    case R.id.item_environment :
                        i =new Intent(SchoolActivity.this, EnvironmentActivity.class);
                        startActivity(i);
                        break;

                    case R.id.item_home :
                        i =new Intent(SchoolActivity.this, HomeActivity .class);
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
