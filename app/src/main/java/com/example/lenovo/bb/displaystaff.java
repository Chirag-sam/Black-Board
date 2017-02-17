package com.example.lenovo.bb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class displaystaff extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaystaff);
        String l=getIntent().getStringExtra("day");
        String m=getIntent().getStringExtra("hour");

        ListView l1 = (ListView) findViewById(R.id.lv);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();

        List<String> quotes = databaseAccess.getdat(l,m);
        databaseAccess.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, quotes);
        l1.setAdapter(adapter);
    }

}
