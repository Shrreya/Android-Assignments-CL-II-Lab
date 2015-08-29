package com.example.shrreya.formanddatabase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

//The activity to display data list inherits from super class Activity
//It's hierarchical parent is the Main Activity
public class DisplayActivity extends Activity {
    private ArrayList<DataSet> dataList; //array list to store data list
    private DatabaseHelper databaseHelper; //database helper object to perform database operations
    private ListView listView; //listview object for UI element
    private DataListAdapter dataListAdapter; //adapter to convert our data list to appropriate list
                                            //view format

    //This function is used to initialize the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //save the current state of the application for revisit
        super.onCreate(savedInstanceState);
        //set the content view for this activity from activity_display.xml file
        setContentView(R.layout.activity_display);
        //initialise the database helper object
        databaseHelper = new DatabaseHelper(getApplicationContext());
        //get intent from previous activity
        Intent intent = this.getIntent();
        //get the extra information from the intent
        if(intent!=null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            String[] fields = intent.getStringArrayExtra(Intent.EXTRA_TEXT);
            //add the data into database
            databaseHelper.addNewData(fields[0], fields[1], fields[2]);
        }

        //connect listview object to XML UI element
        listView = (ListView) findViewById(R.id.datalist);
        //retrieve data list from database
        dataList = databaseHelper.getDataList();
        //provide data list to adapter
        dataListAdapter = new DataListAdapter(getApplicationContext(), dataList);
        //set adapter to listview
        listView.setAdapter(dataListAdapter);
    }

    //This function is used to initialize the options menu found on the right of the action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_display, menu);
        return true;
    }

    //This function is used to specify the actions to be taken when an item from the options menu
    //is selected by the user
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Identify the option selected
        int id = item.getItemId();

        //If user clicked on "Settings" do nothing as of now
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
