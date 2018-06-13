package psst.permadi.dstcashier.Main;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.Toolbar;

import java.util.ArrayList;

import psst.permadi.dstcashier.R;
import psst.permadi.dstcashier.Util.CustomAndroidGridViewAdapter;

public class coba_Task extends AppCompatActivity {

    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayoutAndroid;
    CoordinatorLayout rootLayoutAndroid;
    GridView gridView;
    Context context;
    ArrayList arrayList;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coba);

        gridView = (GridView) findViewById(R.id.grid);
        gridView.setAdapter(new CustomAndroidGridViewAdapter(this, gridViewStrings, gridViewImages));

        initInstances();
    }

    private void initInstances() {
        rootLayoutAndroid = (CoordinatorLayout) findViewById(R.id.android_coordinator_layout);
        collapsingToolbarLayoutAndroid = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_android_layout);
        collapsingToolbarLayoutAndroid.setTitle("Stock Management");
    }
}
