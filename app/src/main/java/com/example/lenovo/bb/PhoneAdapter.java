package com.example.lenovo.bb;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

/**
 * Created by Chirag on 06-Jul-17.
 */

public class PhoneAdapter extends RecyclerView.Adapter<PhoneHolder> {

    List<Data> list = Collections.emptyList();
    Context context;

    public PhoneAdapter(List<Data> list,Context context)
    {
        this.list = list;
        this.context = context;
    }

    @Override
    public PhoneHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.phonenumbercard, parent, false);
        PhoneHolder holder = new PhoneHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(PhoneHolder holder, int position) {
        holder.name.setText(list.get(position).name);
        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent callIntent = new Intent(Intent.ACTION_CALL);
//                callIntent.setData(Uri.parse("tel:123456789"));
//
//
//                context.startActivity(callIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
