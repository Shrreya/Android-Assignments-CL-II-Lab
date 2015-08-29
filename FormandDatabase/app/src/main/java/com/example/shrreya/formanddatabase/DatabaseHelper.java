package com.example.shrreya.formanddatabase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

//Inheriting from super class SQLiteOpenHelper
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = DatabaseHelper.class.getName();
    public static final String DATABASE_NAME = "MYDATABASE";
    private static final int DATABASE_VERSION = 1;
    //table creation query
    private static final String TABLE_QUERY = "CREATE TABLE MYDATABASE( ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "NAME TEXT NOT NULL, EMAIL TEXT NOT NULL, NUMBER TEXT NOT NULL)";

    private static DatabaseHelper sDbInstance = null;
    private Context context;

    //constructor for class
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    //Function to create database
    @Override
    public void onCreate(SQLiteDatabase db) {
        //execute table creation query
        db.execSQL(TABLE_QUERY);
    }

    //Function to upgrade database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public static DatabaseHelper getInstance(Context context) {
        if (sDbInstance == null) {
            sDbInstance = new DatabaseHelper(context);
        }
        return sDbInstance;
    }

    //data retrieval queries
    public synchronized Cursor ExecuteRawSql(String s) {
        try {
            SQLiteDatabase sqLiteDb = getReadableDatabase();
            Cursor cursor = sqLiteDb.rawQuery(s, null);
            return cursor;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //data addition queries
    public synchronized boolean ExecuteSql(String s) {
        try {
            Log.d(TAG, "Actual Query--->>" + s);
            SQLiteDatabase sqLiteDb = getWritableDatabase();
            sqLiteDb.execSQL(s);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Function to add data onto database
    public boolean addNewData(String name, String email, String number) {
        //data addition query
        String qry = "INSERT INTO MYDATABASE (NAME,EMAIL,NUMBER) VALUES('"
                + name + "','" + email + "','" + number +"');";
        return ExecuteSql(qry);
    }

    //Function to retrieve data from database
    public ArrayList<DataSet> getDataList() {

        ArrayList<DataSet> list = new ArrayList<DataSet>();
        String qry;

        //data retrieval query
        qry = "SELECT ID,NAME,EMAIL,NUMBER FROM MYDATABASE";

        //use cursor to traverse through each data set
        Cursor cursor = ExecuteRawSql(qry);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                //store data elements in a DataSet object
                DataSet newData = new DataSet();
                newData.setId(cursor.getInt(0));
                newData.setName(cursor.getString(1));
                newData.setEmail(cursor.getString(2));
                newData.setNumber(cursor.getString(3));
                //add DataSet object onto list
                list.add(newData);
            } while (cursor.moveToNext());
        }
        return list;
    }
}