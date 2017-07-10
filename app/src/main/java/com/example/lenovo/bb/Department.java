package com.example.lenovo.bb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.R.id.list;

public class Department extends AppCompatActivity {
    private Button cse;
    private Button ece;
    private Button eee;
    private Button mech;
    private Button it;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.department);

        cse = (Button)findViewById(R.id.cse);
        ece = (Button)findViewById(R.id.ece);
        eee = (Button)findViewById(R.id.eee);
        mech = (Button)findViewById(R.id.mech);
        it = (Button)findViewById(R.id.it);


        cse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Department.this, StaffWithPhoneNumber.class);
                intent.putExtra("dept", "cse");
                startActivity(intent);
            }
        });
        ece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Department.this, StaffWithPhoneNumber.class);
                intent.putExtra("dept", "ece");
                startActivity(intent);
            }
        });
        eee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Department.this, StaffWithPhoneNumber.class);
                intent.putExtra("dept", "eee");
                startActivity(intent);
            }
        });
        mech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Department.this, StaffWithPhoneNumber.class);
                intent.putExtra("dept", "mech");
                startActivity(intent);
            }
        });
        it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Department.this, StaffWithPhoneNumber.class);
                intent.putExtra("dept", "it");
                startActivity(intent);
            }
        });
    }
}
