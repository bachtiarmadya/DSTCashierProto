package psst.permadi.dstcashier.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import psst.permadi.dstcashier.R;

public class Activity_Login extends AppCompatActivity{

    Button btnLogin;
    @Override
    protected void onCreate (Bundle savedInstatnceState)
    {
        super.onCreate(savedInstatnceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
