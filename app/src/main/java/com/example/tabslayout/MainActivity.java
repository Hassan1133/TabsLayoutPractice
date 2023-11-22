package com.example.tabslayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        tabsSelection();

        bottomNavigationSelection();
    }

    private void init()
    {
        tabLayout = findViewById(R.id.tabs);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        loadFragment(new FragmentOne());
    }

    private void tabsSelection()
    {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                switch (tab.getPosition())
                {
                    case 0 :
                        loadFragment(new FragmentOne());
                        break;
                    case 1 :
                        loadFragment(new FragmentTwo());
                        break;
                    case 2 :
                        loadFragment(new FragmentThree());
                        break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private boolean loadFragment(Fragment fragment)
    {
        if(fragment != null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.frames,fragment).commit();
            return true;
        }
        return  false;
    }

    private void bottomNavigationSelection()
    {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.home:
                        loadFragment(new FragmentOne());
                        return true;
                    case R.id.person:
                        loadFragment(new FragmentTwo());
                        return true;
                    case R.id.settings:
                        loadFragment(new FragmentThree());
                        return true;
                }
                return false;
            }
        });
    }
}