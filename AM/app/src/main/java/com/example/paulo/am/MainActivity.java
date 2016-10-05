package com.example.paulo.am;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    Button chamarCalculoImc;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //ActionBar actionBar = getSupportActionBar();
        //actionBar.setIcon(R.mipmap.logo);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        //getSupportActionBar().setIcon(R.mipmap.logo);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);


    }

    public void chamarCalculoImc(View view) {
        Intent intent = new Intent(this, ImcActivity.class);
        startActivity(intent);
    }

    public void batimentos(View view) {
        Intent intent = new Intent(this, ListaDispositivosActivity.class);
        startActivity(intent);
    }
    public void teste(View view){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

}
