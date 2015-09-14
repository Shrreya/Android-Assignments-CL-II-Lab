package com.example.shrreya.context;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;


public class DataEntryActivity extends Activity implements View.OnClickListener{

    //objects for UI elements
    private EditText editName, editEmail, editNumber, editHeight, editGender,
    editAge, editQualification, editAreaOfSpecialization, editExperience;
    private Button submitButton;
    String[] fields = new String[9]; //string array to store input from user

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);
        //connect objects to XML UI elements
        editName = (EditText) findViewById(R.id.editName);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editNumber = (EditText) findViewById(R.id.editNumber);
        editHeight = (EditText) findViewById(R.id.editHeight);
        editGender = (EditText) findViewById(R.id.editGender);
        editAge = (EditText) findViewById(R.id.editAge);
        editQualification = (EditText) findViewById(R.id.editQualification);
        editAreaOfSpecialization = (EditText) findViewById(R.id.editAreaOfSpecialization);
        editExperience = (EditText)findViewById(R.id.editExperience);
        submitButton = (Button) findViewById(R.id.submitButton);
        ////set click listener on button
        submitButton.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_data_entry, menu);
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

    //Actions to be taken when button is clicked
    @Override
    public void onClick(View v) {
        //make sure name, email and number are not empty
        if (!editName.getText().toString().equals("")
                && !editEmail.getText().toString().equals("")
                && !editNumber.getText().toString().equals("")) {
            //convert the text entered by user to string and store in array
            fields[0] = editName.getText().toString() + "-";
            fields[1] = editEmail.getText().toString() + "-";
            fields[2] = editNumber.getText().toString() + "-";
            fields[3] = editHeight.getText().toString() + "-";
            fields[4] = editGender.getText().toString() + "-";
            fields[5] = editAge.getText().toString() + "-";
            fields[6] = editQualification.getText().toString() + "-";
            fields[7] = editAreaOfSpecialization.getText().toString() + "-";
            fields[8] = editExperience.getText().toString() + "-";

            //write contents of array into file in internal storage
            String FILENAME = "myfile";
            try {
                FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                for (int i = 0; i < 9; i++) {
                    fos.write(fields[i].getBytes());
                }
                fos.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            //use intent to go back to main activity
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        } else { //if any one of the important text boxes are empty display a short duration toast
            Toast.makeText(getApplicationContext(), "Enter All Important Fields",
                    Toast.LENGTH_SHORT).show();
        }

    }
}
