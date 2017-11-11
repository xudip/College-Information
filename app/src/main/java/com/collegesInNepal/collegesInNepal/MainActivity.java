package com.collegesInNepal.collegesInNepal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.List;

import sap.collegesInNepal.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private SliderLayout images;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        images = (SliderLayout) findViewById(R.id.images);
        gridView = (GridView) findViewById(R.id.faculties);
        String[] faculties = {"BEIT", "BCV", "BCE", "BEX"};
        gridView.setAdapter(new FacultyAdapter(MainActivity.this, faculties));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(MainActivity.this, CoursesOfferedActivity.class);

                switch (position) {
                    case 0:
                        intent.putExtra("Faculty", "IT");
                        startActivity(intent);
                        break;
                    case 1:
                        intent.putExtra("Faculty", "Civil");
                        startActivity(intent);
                        break;
                    case 2:
                        intent.putExtra("Faculty", "Computer");
                        startActivity(intent);
                        break;
                    case 3:
                        intent.putExtra("Faculty", "Electronics");
                        startActivity(intent);
                        break;
                    default:


                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.chairmanDesk) {
            Intent intent = new Intent(MainActivity.this, MessageFromChairmanActivity.class);
            startActivity(intent);
        } else if (id == R.id.principalMessage) {
            Intent intent = new Intent(MainActivity.this, MessageFromPrincipal.class);
            startActivity(intent);

        } else if (id == R.id.vicePrincipal) {
            Intent intent = new Intent(MainActivity.this, MessageFromVicePrincipal.class);
            startActivity(intent);

        } else if (id == R.id.multitudeOptions) {
            Intent intent = new Intent(MainActivity.this, MultitudeOfOptionsActivity.class);
            startActivity(intent);

        } else if (id == R.id.applicationProcedure) {
            Intent intent = new Intent(MainActivity.this, ApplicationProcedureActivity.class);
            startActivity(intent);
        } else if (id == R.id.scoreOfOpportunity) {
            Intent intent = new Intent(MainActivity.this, ScoreOfOpportunitiesActivity.class);
            startActivity(intent);
        } else if (id == R.id.pokharaUniversity) {
            Intent intent = new Intent(MainActivity.this, IntroPokharaUniversity.class);
            startActivity(intent);

        } else if (id == R.id.programs) {
            Intent intent = new Intent(MainActivity.this, BEProgrammesActivity.class);
            startActivity(intent);

        } else if (id == R.id.contact) {
            Intent intent = new Intent(MainActivity.this, ContactUsActivity.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onSuccessImageResponse(List<String> response) {
        TextSliderView textSliderView = new TextSliderView(this);
        for (int i = 0; i < response.size(); i++) {
            String image = response.get(i);
            textSliderView.image(image);
            textSliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {
                    //TODO
                }
            });
            images.addSlider(textSliderView);
        }

    }
}
