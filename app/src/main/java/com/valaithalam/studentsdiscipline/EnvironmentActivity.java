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

import com.google.android.material.navigation.NavigationView;

public class EnvironmentActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_environment);

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.nav_draw_e);

        drawerLayout = findViewById(R.id.drawer_layout_e);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();

                Intent i;

                switch (id) {

                    case R.id.item_scl:
                        i = new Intent(EnvironmentActivity.this, SchoolActivity.class);
                        startActivity(i);
                        break;

                    case R.id.item_clg:
                        i = new Intent(EnvironmentActivity.this, CollegeActivity.class);
                        startActivity(i);
                        break;

                    case R.id.item_environment:
                        i = new Intent(EnvironmentActivity.this, EnvironmentActivity.class);
                        startActivity(i);
                        break;

                    case R.id.item_home:
                        i = new Intent(EnvironmentActivity.this, HomeActivity.class);
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

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}