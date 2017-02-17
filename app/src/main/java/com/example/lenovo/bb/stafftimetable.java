package com.example.lenovo.bb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;

import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class stafftimetable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        final AutoCompleteTextView act1 = (AutoCompleteTextView) findViewById(R.id.uname);
        final String[] names = getResources().getStringArray(R.array.Staff_Name);// Create the adapter and set it to the AutoCompleteTextView
        final ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        act1.setAdapter(adapter);

        Button bt1 = (Button) findViewById(R.id.butt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean cancel = false;
                String name1 = act1.getText().toString();
                if (TextUtils.isEmpty(name1) || names.equals(name1)) {
                    cancel = true;
                    Toast.makeText(stafftimetable.this, "Invalid field", Toast.LENGTH_SHORT);
                }

                if (!cancel) {
                    Intent myintent = new Intent(stafftimetable.this, displaytable.class);
                    myintent.putExtra("mytext", name1);

                    startActivity(myintent);
                }
            }
        });


    }
}


