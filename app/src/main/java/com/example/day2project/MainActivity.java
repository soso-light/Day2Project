package com.example.day2project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    private String o = "You selected Order";
    private String s = "You selected Status";
    private String f = "You selected Favorites";
    private String c = "You selected Contacts";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_favorites: {
                displayToast(f);
                return true;
            }
            case R.id.action_contact: {
                displayToast(c);
                return true;
            }
            case R.id.action_order: {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                displayToast(o);
                return true;
            }
            case R.id.action_status: {
                displayToast(s);
                return true;
            }

        }

        return super.onOptionsItemSelected(item);
    }
    private void displayToast(String name){
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }
}