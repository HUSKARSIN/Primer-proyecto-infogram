package com.kiton.infogramproyecto.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kiton.infogramproyecto.R;
import com.kiton.infogramproyecto.view.fragment.HomeFragment;
import com.kiton.infogramproyecto.view.fragment.ProfileFragment;
import com.kiton.infogramproyecto.view.fragment.ShearchFragment;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        Fragment selectedFragment = null;

                        switch (menuItem.getItemId()){
                            case R.id.search:
                                selectedFragment = new ShearchFragment();
                                break;
                            case R.id.home:
                                selectedFragment = new HomeFragment();
                                break;
                            case R.id.profile:
                                selectedFragment = new ProfileFragment();
                                break;
                        }

                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container_frame,selectedFragment)
                                .commit();

                        return true;
                    }
                });
    }
}