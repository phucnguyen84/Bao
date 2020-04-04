package com.volio.bao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomePage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Fragment selectedFragment=new HomeFragment(HomePage.this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                selectedFragment).commit();
        BottomNavigationView bottomNav=findViewById(R.id.btn_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment=null;
                    switch (menuItem.getItemId()){
                        case R.id.nav_home:
                            selectedFragment=new HomeFragment(HomePage.this);
                            break;
                        case R.id.nav_video:
                            selectedFragment=new VideoFragment();
                            break;
                        case R.id.nav_story:
                            break;
                        case R.id.nav_mission:
                            break;
                        case R.id.nav_user:
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };
}
