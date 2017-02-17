package com.example.lenovo.bb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class availablestaff extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    String d="";
    String h="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availablestaff);


        //Spinner 1
        Spinner s1=(Spinner)findViewById(R.id.day);
        s1.setOnItemSelectedListener(this);

        List<String> days = new ArrayList<String>();
        days.add("MONDAY");
        days.add("TUESDAY");
        days.add("WEDNESDAY");
        days.add("THURSDAY");
        days.add("FRIDAY");
        days.add("SATURDAY");

        // Creating adapter for spinner
        ArrayAdapter<String> dayadapt = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, days);

        // Drop down layout style - list view with radio button
        dayadapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        s1.setAdapter(dayadapt);

//Spinner 2


        Spinner s2=(Spinner)findViewById(R.id.hour);
        s2.setOnItemSelectedListener(this);

        List<String> hours = new ArrayList<String>();
        hours.add("1");
        hours.add("2");
        hours.add("3");
        hours.add("4");
        hours.add("5");
        hours.add("6");
        hours.add("7");

        // Creating adapter for spinner
        ArrayAdapter<String> houradapt = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, hours);

        // Drop down layout style - list view with radio button
        houradapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        s2.setAdapter(houradapt);


        AutoCompleteTextView act = (AutoCompleteTextView) findViewById(R.id.uname);
// Get the string array
        String[] names = getResources().getStringArray(R.array.Staff_Name);
// Create the adapter and set it to the AutoCompleteTextView
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        act.setAdapter(adapter);









    }






    @Override
    public void onClick(View view) {

        switch(view.getId())
        {

            case R.id.butt2:



                Intent i2=new Intent(view.getContext(), displaystaff.class);
                i2.putExtra("day",d);
                i2.putExtra("hour",h);
                startActivity(i2);

                break;


        }




    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        String item = adapterView.getItemAtPosition(i).toString();


        switch(adapterView.getId())
        {
            case R.id.day:
                d=item;
                break;
            case R.id.hour:
                h=item;
                break;

        }


    }
    public String shift()
    {
        String cond;
        cond="SELECT NAME FROM "+d+" where hour="+h;

        return cond;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

