package psst.permadi.dstcashier.Main;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import psst.permadi.dstcashier.R;
import psst.permadi.dstcashier.Util.CustomAndroidGridViewAdapter;

public class Activity_transaction extends AppCompatActivity {
    GridView gridCoffee, gridNonCoffee, gridFood;
    public static String[] gridViewCoffee = {
            "Menu 1",
            "Menu 2",
            "Menu 3",
            "Menu 4",
            "Menu 5",
            "Menu 1",
            "Menu 2",
            "Menu 3",
            "Menu 4",
            "Menu 5",
            "Menu 1",
            "Menu 2",
            "Menu 3",
            "Menu 4",
            "Menu 5"
    };
    public static int[] gridImgCoffee = {
            R.drawable.vietdrip,
            R.drawable.vietdrip,
            R.drawable.vietdrip,
            R.drawable.vietdrip,
            R.drawable.vietdrip,
            R.drawable.milkshake,
            R.drawable.milkshake,
            R.drawable.milkshake,
            R.drawable.milkshake,
            R.drawable.milkshake,
            R.drawable.food,
            R.drawable.food,
            R.drawable.food,
            R.drawable.food,
            R.drawable.food
    };
    ListView listTrx;
    String[] itemTrx = new String[]{
            "Kopi Lanang Vietnam Drip",
            "Kopi Temanggung Tubruk",
            "Singkong balok",
            "Milksake",
            "Coklat",
            "Pisang"
    };

    Button btnProcess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        CustomAndroidGridViewAdapter AdapterViewAndroid = new CustomAndroidGridViewAdapter
                (Activity_transaction.this, gridViewCoffee, gridImgCoffee);
        gridCoffee = (GridView) findViewById(R.id.gridCoffee);
        gridCoffee.setAdapter(AdapterViewAndroid);

        listTrx = (ListView) findViewById(R.id.listTrx);
        final List<String> fruits_list = new ArrayList<String>(Arrays.asList(itemTrx));

        // Create an ArrayAdapter from List
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, fruits_list);

        // DataBind ListView with items from ArrayAdapter
        listTrx.setAdapter(arrayAdapter);

        btnProcess = (Button) findViewById(R.id.btnProccess);
        btnProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder checkBuilder = new AlertDialog.Builder(Activity_transaction.this);
                checkBuilder.setTitle("On Queue");
                checkBuilder.setMessage("Print Bill?");

                checkBuilder.setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                });
                checkBuilder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog alert = checkBuilder.create();
                alert.show();
            }
        });

    }
}
