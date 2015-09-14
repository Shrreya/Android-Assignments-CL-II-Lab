package com.example.shrreya.context;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {

    //objects for UI elements
    private Button dataEntryButton, companyContextButton, matrimonyContextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //connect objects to XML UI elements
        dataEntryButton = (Button) findViewById(R.id.dataEntryButton);
        companyContextButton = (Button) findViewById(R.id.companyContextButton);
        matrimonyContextButton = (Button) findViewById(R.id.matrimonyContextButton);
        //set click listeners on buttons
        dataEntryButton.setOnClickListener(this);
        companyContextButton.setOnClickListener(this);
        matrimonyContextButton.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Actions to be taken when a button is clicked
    @Override
    public void onClick(View v) {
        int id = v.getId(); //get id of clicked button

        if (id == R.id.dataEntryButton) {
            //start activity to enter data
            Intent intent = new Intent(this, DataEntryActivity.class);
            startActivity(intent);
        }

        else if (id == R.id.companyContextButton) {
            //start activity to view company context data
            Intent intent = new Intent(this, CompanyContextActivity.class);
            startActivity(intent);
        }

        else if (id == R.id.matrimonyContextButton) {
            //start activity to view matrimony context data
            Intent intent = new Intent(this, MatrimonyContextActivity.class);
            startActivity(intent);
        }

    }
}
