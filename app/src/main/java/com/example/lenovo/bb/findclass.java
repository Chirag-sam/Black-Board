package com.example.lenovo.bb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class findclass extends AppCompatActivity {

    String[] dept = {"CSE","EEE","Mech","IT"};
    String[] year = {"1","2","3","4"};
    String[] sect = {"A","B","C","D","E","F","G","H","I","J","K","L"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findclass);
        final AutoCompleteTextView at1 = (AutoCompleteTextView)findViewById(R.id.at1);
        final AutoCompleteTextView at2 = (AutoCompleteTextView)findViewById(R.id.at2);
        final AutoCompleteTextView at3 = (AutoCompleteTextView)findViewById(R.id.at3);
        Button button = (Button)findViewById(R.id.button);
        ImageView down1 = (ImageView)findViewById(R.id.down1);
        ImageView down2 = (ImageView)findViewById(R.id.down2);
        ImageView down3 = (ImageView)findViewById(R.id.down3);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,dept);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,year);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,sect);
        at1.setAdapter(adapter);
        at2.setAdapter(adapter1);
        at3.setAdapter(adapter2);
        at1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                at1.showDropDown();
            }
        });
        at2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                at2.showDropDown();
            }
        });
        at3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                at3.showDropDown();
            }
        });
        down1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                at1.showDropDown();
            }
        });
        down2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                at2.showDropDown();
            }
        });
        down3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                at3.showDropDown();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = at1.getText().toString();
                String str2 = at2.getText().toString();
                String str3 = at3.getText().toString();
                if(str.equals("CSE")&&str2.equals("2")&&str3.equals("F"))
                {
                    Toast.makeText(findclass.this ,"BMS Block, 7th Floor!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
