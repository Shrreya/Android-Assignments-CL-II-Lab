package com.example.shrreya.helloworld;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

//Our Activity is called MainActivity and it inherits from super class ActionBarActivity
public class MainActivity extends ActionBarActivity {

    //This function is used to initialize the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //save the current state of the application for revisit
        super.onCreate(savedInstanceState);
        //set the content view for this activity from activity_main.xml file
        setContentView(R.layout.activity_main);
    }

    //This function is used to initialize the options menu found on the right of the action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu with elements from the menu_main.xml file
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
