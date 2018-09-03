package com.example.harpreet.vasdapunjab;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    Toolbar toolbar;
    FrameLayout frameLayout;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Layout layout;
    Fragment fragment;

    BottomNavigationView bottomNavigationView;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);




        //tool bar di coding
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        ////////

        /// Bottom navigation Bar di coding

       frameLayout = findViewById(R.id.frameLayout);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);

        android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.frameLayout,new Home());
        ft.commit();


        //Bottom Navigation di onClick di coding


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                int id = item.getItemId();


                if(id==R.id.mcq)
                {
                    fragment = new Quiz();
                }
                else if(id==R.id.ayp)
                {
                    fragment = new Ask_Your_Parents();
                }
                else if(id==R.id.watsnew)
                {
                    fragment = new Whats_New();
                }
                else if(id==R.id.home)
                {
                    fragment = new Home();
                }

                if(fragment!=null)
                {
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.frameLayout,fragment);
                    ft.commit();
                }

                return true;
            }
        });




        // navigation drawer di coding
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        /////////



    }

    // click lister on

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

             if(id==R.id.settings_id)
        {
            fragment = new Setting();
        }
        else if(id==R.id.feedback_id)
        {
            fragment = new Feedback();
        }

        else if (id==R.id.aboutApp_id)
        {
            fragment = new About_app();
        }
        else if (id==R.id.aboutUs_id)
        {
            fragment = new About_us();
        }
        else if(id==R.id.myStatus_id)
        {
            Toast.makeText(MainActivity.this, "Yet to create", Toast.LENGTH_SHORT).show();
        }

        if(fragment!=null)
        {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.frameLayout,fragment);
            ft.commit();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
