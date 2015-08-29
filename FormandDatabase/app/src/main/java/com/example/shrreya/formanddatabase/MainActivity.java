package com.example.shrreya.formanddatabase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//Our main activity inherits from super class Activity and implements from interface
//OnCLickListener
public class MainActivity extends Activity implements OnClickListener {

    //Create objects for UI elements
    private EditText editName, editEmail, editNumber;
    private Button submitButton;
    //Create string array to store user input values
    private String[] fields = new String[3];

    //This function is used to initialize the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //save the current state of the application for revisit
        super.onCreate(savedInstanceState);
        //set the content view for this activity from activity_main.xml file
        setContentView(R.layout.activity_main);
        //connect each object to the corresponding XML UI elements
        editName = (EditText) findViewById(R.id.editName);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editNumber = (EditText) findViewById(R.id.editNumber);
        submitButton = (Button) findViewById(R.id.submitButton);
        //set the Click Listener on the submit button
        submitButton.setOnClickListener(this);
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

    //This function is used to specify the actions to be taken after the button is clicked
    @Override
    public void onClick (View v){
    //check if none of the text boxes are empty
        if (!editName.getText().toString().equals("")
            && !editEmail.getText().toString().equals("")
            && !editNumber.getText().toString().equals("")) {
        //convert the text entered by user to string and store in array
        fields[0] = editName.getText().toString();
        fields[1] = editEmail.getText().toString();
        fields[2] = editNumber.getText().toString();

        //start new activity with intent
        //the intent contains extra text information that is the 'fields' array as we must pass
        //on the data entered by user in this activity to the next activity
        Intent intent=new Intent(this,DisplayActivity.class).putExtra(Intent.EXTRA_TEXT, fields);
        startActivity(intent);
    //if any one of the text boxes are empty display a short duration toast message to user
    } else {
        Toast.makeText(getApplicationContext(), "Enter All Fields",
                Toast.LENGTH_SHORT).show();
        }
    }

}
