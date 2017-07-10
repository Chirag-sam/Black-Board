package com.example.lenovo.bb;


import android.Manifest;
import android.app.Activity;
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
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.Collections;
import java.util.List;

/**
 * Created by Chirag on 06-Jul-17.
 */

public class PhoneAdapter extends RecyclerView.Adapter<PhoneHolder> {

    List<Data> list = Collections.emptyList();
    Context mcontext;

    public PhoneAdapter(List<Data> list,Context context)
    {
        this.list = list;
        mcontext = context;
    }

    @Override
    public PhoneHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.phonenumbercard, parent, false);
        PhoneHolder holder = new PhoneHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final PhoneHolder holder, final int position) {
        holder.name.setText(list.get(position).name);
        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity act = (Activity)(holder.call.getContext());
                final Intent callIntent = new Intent(Intent.ACTION_CALL);
                String s = list.get(position).phone;
                callIntent.setData(Uri.parse("tel:"+s));

                Dexter.withActivity(act)
                        .withPermission(Manifest.permission.CALL_PHONE)
                        .withListener(new PermissionListener() {
                            @Override public void onPermissionGranted(PermissionGrantedResponse response) {

                                mcontext.startActivity(callIntent);
                            }
                            @Override public void onPermissionDenied(PermissionDeniedResponse response) {
                                Toast.makeText(mcontext, "Accept call permissions first!",
                                    Toast.LENGTH_LONG).show();}
                            @Override public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {/* ... */}
                        }).check();

            }
        });
        holder.cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext, displayclasstable.class);
                intent.putExtra("drawable", list.get(position).timetable);
                mcontext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
