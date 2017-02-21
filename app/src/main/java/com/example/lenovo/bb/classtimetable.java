package com.example.lenovo.bb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class classtimetable extends AppCompatActivity {


    String[] year = {"1","2","3","4"};
    String[] sect1 = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};
    String[] sect2 = {"A","B","C","D","E","F","G","H","I","J","K"};
    String[] sect3 = {"A","B","C","D","E"};
    String[] sect4 = {"A"};
    ArrayList<String> v;
    int year1[]={
            R.drawable.a1,
            R.drawable.b1,
            R.drawable.c1,
            R.drawable.d1,
            R.drawable.e1,
            R.drawable.f1,
            R.drawable.g1,
            R.drawable.h1,
            R.drawable.i1,
            R.drawable.j1,
            R.drawable.k1,
            R.drawable.l1,
            R.drawable.m1,
            R.drawable.n1,
            R.drawable.o1
    };
    int year2[]={
            R.drawable.a2,
            R.drawable.b2,
            R.drawable.c2,
            R.drawable.d2,
            R.drawable.e2,
            R.drawable.f2,
            R.drawable.g2,
            R.drawable.h2,
            R.drawable.i2,
            R.drawable.j2,
            R.drawable.k2
    };
    int year3[]={
            R.drawable.a3,
            R.drawable.b3,
            R.drawable.c3,
            R.drawable.d3,
            R.drawable.e3
    };
    int year4[]={
            R.drawable.rr4
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classtimetable);

        final Spinner at2 = (Spinner) findViewById(R.id.sp1);
        final Spinner at3 = (Spinner) findViewById(R.id.sp2);
        Button button = (Button)findViewById(R.id.butt2);

        ImageView down2 = (ImageView)findViewById(R.id.down2);
        ImageView down3 = (ImageView)findViewById(R.id.down3);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,year);
        final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,sect1);
        final ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,sect2);
        final ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,sect3);
        final ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,sect4);

        at2.setAdapter(adapter1);
        at2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String str2=at2.getSelectedItem().toString();
                if(str2.equals("1")){v=new ArrayList<String>(Arrays.asList(sect1));
                    at3.setAdapter(adapter2);}
                else if(str2.equals("2")){
                    v=new ArrayList<String>(Arrays.asList(sect2));
                    at3.setAdapter(adapter3);}
                else if(str2.equals("3")){
                    v=new ArrayList<String>(Arrays.asList(sect3));
                    at3.setAdapter(adapter4);}
                else if(str2.equals("4")){
                    v=new ArrayList<String>(Arrays.asList(sect4));
                    at3.setAdapter(adapter5);}



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean cancel=false;
                String str2 = at2.getSelectedItem().toString();
                ArrayList<String> x=new ArrayList<String>(Arrays.asList(year));
                String str3 = at3.getSelectedItem().toString();

                    int pos = v.indexOf(str3);
                    if (pos == -1)
                        pos = 0;
                    if (str2.equals("1")) {
                        Intent intent = new Intent(getBaseContext(), displayclasstable.class);
                        intent.putExtra("drawable", year1[pos]);
                        startActivity(intent);
                    } else if (str2.equals("2")) {
                        Intent intent = new Intent(getBaseContext(), displayclasstable.class);
                        intent.putExtra("drawable", year2[pos]);
                        startActivity(intent);
                    } else if (str2.equals("3")) {
                        Intent intent = new Intent(getBaseContext(), displayclasstable.class);
                        intent.putExtra("drawable", year3[pos]);
                        startActivity(intent);
                    } else if (str2.equals("4")) {
                        Intent intent = new Intent(getBaseContext(), displayclasstable.class);
                        intent.putExtra("drawable", year4[pos]);
                        startActivity(intent);
                    }


                


            }
        });
    }
}
