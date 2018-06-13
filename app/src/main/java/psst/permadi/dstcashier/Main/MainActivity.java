package psst.permadi.dstcashier.Main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import psst.permadi.dstcashier.R;
import psst.permadi.dstcashier.Util.CustomAndroidGridViewAdapter;
import psst.permadi.dstcashier.Util.CustomAndroidGridViewAdapter2;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    ListView trxList;
    CollapsingToolbarLayout collapsingToolbarLayoutAndroid;
    CoordinatorLayout rootLayoutAndroid;
    GridView gridView;
    Context context;
    ArrayList arrayList;

    String[] fruits = new String[] {
            "1 Cape Gooseberry",
            "2 Capuli cherry",
            "3 Cape Gooseberry",
            "4 Capuli cherry",
            "5 Cape Gooseberry",
            "6 Capuli cherry",
            "7 Cape Gooseberry",
            "8 Capuli cherry",
            "9 Cape Gooseberry",
            "10 Capuli cherry",
            "11 Cape Gooseberry",
            "12 Capuli cherry",
            "13 Cape Gooseberry",
            "14 Capuli cherry",
            "15 Cape Gooseberry",
            "16 Capuli cherry",
            "17 Cape Gooseberry",
            "18 Capuli cherry",
            "19 Cape Gooseberry",
            "20 Capuli cherry",
            "21 Cape Gooseberry",
            "22 Capuli cherry",
            "23 Cape Gooseberry",
            "24 Capuli cherry"
    };

    public static String[] gridViewStrings = {
            "Coffee",
            "Non Coffee",
            "Food",
            "Green Bean",
            "Rost Bean",
            "Mix Item",
            "Item",
            "Item",
            "Item",

    };
    public static int[] gridViewImages = {
            R.drawable.circle,
            R.drawable.circle,
            R.drawable.circle,
            R.drawable.circle,
            R.drawable.circle,
            R.drawable.circle,
            R.drawable.circle,
            R.drawable.circle,
            R.drawable.circle
    };


    protected ArrayList<String> arrayStrings = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity_transaction.class);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        trxList = (ListView) findViewById(R.id.listTrx);
        final List<String> fruits_list = new ArrayList<String>(Arrays.asList(fruits));

        // Create an ArrayAdapter from List
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, fruits_list);

        // DataBind ListView with items from ArrayAdapter
        trxList.setAdapter(arrayAdapter);

        //gridView = (GridView) findViewById(R.id.grid);
        //gridView.setAdapter(new CustomAndroidGridViewAdapter(this, gridViewStrings, gridViewImages));

        //initInstances();

    }

    private void initInstances() {
        rootLayoutAndroid = (CoordinatorLayout) findViewById(R.id.android_coordinator_layout);
        collapsingToolbarLayoutAndroid = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_android_layout);
        //collapsingToolbarLayoutAndroid.setTitle("Dashboard");
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
        getMenuInflater().inflate(R.menu.main, menu);
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

        if (id == R.id.nav_stock) {
            Intent intent = new Intent(getApplicationContext(), coba_Task.class);
            startActivity(intent);

            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
