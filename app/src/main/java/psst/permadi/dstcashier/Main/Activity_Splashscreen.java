package psst.permadi.dstcashier.Main;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import psst.permadi.dstcashier.R;

public class Activity_Splashscreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        if (!isNetworkAvailable()) {
            AlertDialog.Builder checkBuilder = new AlertDialog.Builder(Activity_Splashscreen.this);
            checkBuilder.setIcon(R.drawable.signal_off);
            checkBuilder.setTitle("No Connection!");
            checkBuilder.setMessage("Periksa koneksi internet anda!");

            checkBuilder.setPositiveButton("Ulangi", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            });
            checkBuilder.setNegativeButton("Keluar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            AlertDialog alert = checkBuilder.create();
            alert.show();
        } else {
            if (isNetworkAvailable()) {
                Thread thread = new Thread() {
                    public void run() {
                        try {
                            sleep(4500);
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            startActivity(new Intent(Activity_Splashscreen.this, MainActivity.class));
                            finish();
                        }
                    }
                };
                thread.start();
            }
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }
}
