package com.example.juanantonioredondo.submenusejercicio;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.view.Menu;
import android.view.MenuItem;

import static android.Manifest.permission.CALL_PHONE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_submenu, menu);
        MenuBuilder m = (MenuBuilder) menu;
        m.setOptionalIconsVisible(true);
        return true;
    }
    

    @SuppressLint("NewApi")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.opcion41:
                Intent i41 = new Intent(Intent.ACTION_SEND);
                i41.setType("text/plain");
                i41.putExtra(Intent.EXTRA_SUBJECT, "Asunto de prueba");
                i41.putExtra(Intent.EXTRA_TEXT, "Probando el envío");
                i41.putExtra(Intent.EXTRA_EMAIL, new String[]{"mi@email.es"});
                startActivity(i41);
                break;
            case R.id.opcion42:
                if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    Intent i42 = new Intent(Intent.ACTION_CALL);
                    i42.setData(Uri.parse("tel:954112233"));
                    startActivity(i42);
                } else {
                    requestPermissions(new String[]{CALL_PHONE}, 1);
                }
                break;
        }

        return false;
    }
}
