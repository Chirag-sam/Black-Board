package com.example.lenovo.bb;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Chirag on 06-Jul-17.
 */

public class PhoneHolder extends RecyclerView.ViewHolder{

    CardView cv1;
    TextView name;
    Button call;


    public PhoneHolder(View itemView)
    {
        super(itemView);
        cv1=(CardView)itemView.findViewById(R.id.cv1);
        name = (TextView)itemView.findViewById(R.id.name);
        call = (Button)itemView.findViewById(R.id.call);
    }
}
