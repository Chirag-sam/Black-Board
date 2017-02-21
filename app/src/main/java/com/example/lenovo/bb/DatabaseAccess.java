package com.example.lenovo.bb;
/**
 * Created by admin on 3/21/2016.
 */


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
public class DatabaseAccess {
    String comman="";


    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
    public List<String> getdat(String x, String y) {
       /* String t="p1";
        if (y.equals("1"))
            t = "p1";
        else if (y.equals("2"))
            t = "p2";
        else if (y.equals("3"))
            t = "p3";
        else if (y.equals("4"))
            t = "p4";
        else if (y.equals("5"))
            t = "p5";
        else if (y.equals("6"))
            t = "p6";
        else if (y.equals("2"))
            t = "p2";*/


        comman="SELECT NAME FROM "+x+" WHERE p"+y+"=1";

        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery(comman, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
}
