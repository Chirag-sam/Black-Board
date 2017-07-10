package com.example.lenovo.bb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class StaffWithPhoneNumber extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_with_phone_number);
        List<Data> data = null;

        String s = getIntent().getStringExtra("dept");

        if(s.equals("cse")) {
            data = cse();
        }
        else if(s.equals("eee")) {
            data = eee();
        }
        else if(s.equals("ece")) {
            data = ece();
        }
        else if(s.equals("mech")) {
            data = mech();
        }
        else if(s.equals("it")) {
            data = it();
        }
        RecyclerView recycl = (RecyclerView) findViewById(R.id.recycl);
        PhoneAdapter adapter = new PhoneAdapter(data, getApplication());
        recycl.setAdapter(adapter);
        recycl.setLayoutManager(new LinearLayoutManager(this));
    }

    public List<Data> cse() {

        List<Data> data = new ArrayList<>();

        data.add(new Data("Mr.R. Augustian Isaac<", "9654647447",R.drawable.a1));
        data.add(new Data("Mr. Balika.J.Chelliah", "9654647447",R.drawable.a1));
        data.add(new Data("Mr.S. Jaya Kumar", "9654647447",R.drawable.a1));
        data.add(new Data("Mr.R.J. Poovaraghan", "9654647447",R.drawable.a1));
        data.add(new Data("Ms.M.S. Bennet Praba", "9654647447",R.drawable.a1));
        data.add(new Data("Mr.S. Pandiaraj", "9654647447",R.drawable.a1));

        return data;
    }
    public List<Data> ece() {

        List<Data> data = new ArrayList<>();

        data.add(new Data("Mr.R. Augustian Isaac<", "9654647447",R.drawable.a1));
        data.add(new Data("Mr. Balika.J.Chelliah", "9654647447",R.drawable.a1));
        data.add(new Data("Mr.S. Jaya Kumar", "9654647447",R.drawable.a1));
        data.add(new Data("Mr.R.J. Poovaraghan", "9654647447",R.drawable.a1));
        data.add(new Data("Ms.M.S. Bennet Praba", "9654647447",R.drawable.a1));
        data.add(new Data("Mr.S. Pandiaraj", "9654647447",R.drawable.a1));

        return data;
    }
    public List<Data> eee() {

        List<Data> data = new ArrayList<>();

        data.add(new Data("Mr.R. Augustian Isaac<", "9654647447",R.drawable.a1));
        data.add(new Data("Mr. Balika.J.Chelliah", "9654647447",R.drawable.a1));
        data.add(new Data("Mr.S. Jaya Kumar", "9654647447",R.drawable.a1));
        data.add(new Data("Mr.R.J. Poovaraghan", "9654647447",R.drawable.a1));
        data.add(new Data("Ms.M.S. Bennet Praba", "9654647447",R.drawable.a1));
        data.add(new Data("Mr.S. Pandiaraj", "9654647447",R.drawable.a1));

        return data;
    }
    public List<Data> mech() {

        List<Data> data = new ArrayList<>();

        data.add(new Data("Mr.R. Augustian Isaac<", "9654647447",R.drawable.a1));
        data.add(new Data("Mr. Balika.J.Chelliah", "9654647447",R.drawable.a1));
        data.add(new Data("Mr.S. Jaya Kumar", "9654647447",R.drawable.a1));
        data.add(new Data("Mr.R.J. Poovaraghan", "9654647447",R.drawable.a1));
        data.add(new Data("Ms.M.S. Bennet Praba", "9654647447",R.drawable.a1));
        data.add(new Data("Mr.S. Pandiaraj", "9654647447",R.drawable.a1));

        return data;
    }
    public List<Data> it() {

        List<Data> data = new ArrayList<>();

        data.add(new Data("Mr.R. Augustian Isaac<", "9654647447",R.drawable.a1));
        data.add(new Data("Mr. Balika.J.Chelliah", "9654647447",R.drawable.a1));
        data.add(new Data("Mr.S. Jaya Kumar", "9654647447",R.drawable.a1));
        data.add(new Data("Mr.R.J. Poovaraghan", "9654647447",R.drawable.a1));
        data.add(new Data("Ms.M.S. Bennet Praba", "9654647447",R.drawable.a1));
        data.add(new Data("Mr.S. Pandiaraj", "9654647447",R.drawable.a1));

        return data;
    }
}
