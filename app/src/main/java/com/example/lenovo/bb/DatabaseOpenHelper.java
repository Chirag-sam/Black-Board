package com.example.lenovo.bb;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by admin on 3/21/2016.
 */
public class DatabaseOpenHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "new_db.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



}
