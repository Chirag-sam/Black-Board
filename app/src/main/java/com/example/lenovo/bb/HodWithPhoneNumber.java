package com.example.lenovo.bb;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HodWithPhoneNumber extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hod_with_phone_number);

        List<Data> data = fill_with_data();

        RecyclerView recycl = (RecyclerView) findViewById(R.id.recycl);
        PhoneAdapter adapter = new PhoneAdapter(data, getApplication());
        recycl.setAdapter(adapter);
        recycl.setLayoutManager(new LinearLayoutManager(this));
    }
    public List<Data> fill_with_data() {

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
