package com.rdr.rodrigocorvera.drawerlayout;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.jgabrielfreitas.core.BlurImageView;
import com.rdr.rodrigocorvera.drawerlayout.Fragments.*;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toogle;
    BlurImageView myBlur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        toogle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView mNavigationView = (NavigationView) findViewById(R.id.navigation_id);

        if (mNavigationView != null) {
            mNavigationView.setNavigationItemSelectedListener(this);
        }

        myBlur = (BlurImageView) findViewById(R.id.image_food);
        if (myBlur != null) {
            myBlur.setBlur(5);
        }

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.Entrada) {
            EntradaFragment entradaFragment = new EntradaFragment();
            FrameLayout fm = findViewById(R.id.fragments_box);
            fm.removeAllViews();
            getSupportFragmentManager().beginTransaction().add(R.id.fragments_box, entradaFragment).commit();

        } else if ( id == R.id.Principal) {
            PrincipalFragment principalFragment = new PrincipalFragment();
            FrameLayout fm = findViewById(R.id.fragments_box);
            fm.removeAllViews();
            getSupportFragmentManager().beginTransaction().add(R.id.fragments_box, principalFragment).commit();
        } else {
            PostresFragment postresFragment = new PostresFragment();
            FrameLayout fm = findViewById(R.id.fragments_box);
            fm.removeAllViews();
            getSupportFragmentManager().beginTransaction().add(R.id.fragments_box, postresFragment).commit();
        }
        drawerLayout.closeDrawers();
        return true;
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Log.d("Entro al context: ", item.toString());
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d("Entro: ", item.toString());
        if (toogle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


