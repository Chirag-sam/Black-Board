package com.example.lenovo.bb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HodWithPhoneNumber extends AppCompatActivity {

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

        data.add(new Data("Mr.R. Augustian Isaac<", "Following the destruction of Metropolis, Batman embarks on a personal vendetta against Superman "));
        data.add(new Data("Mr. Balika.J.Chelliah", "X-Men: Apocalypse is an upcoming American superhero film based on the X-Men characters that appear in Marvel Comics "));
        data.add(new Data("Mr.S. Jaya Kumar", "A feud between Captain America and Iron Man leaves the Avengers in turmoil.  "));
        data.add(new Data("Mr.R.J. Poovaraghan", "After reuniting with his long-lost father, Po  must train a village of pandas"));
        data.add(new Data("Ms.M.S. Bennet Praba", "Fleeing their dying home to colonize another, fearsome orc warriors invade the peaceful realm of Azeroth. "));
        data.add(new Data("Mr.S. Pandiaraj", "Alice in Wonderland: Through the Looking Glass "));

        return data;
    }
}
