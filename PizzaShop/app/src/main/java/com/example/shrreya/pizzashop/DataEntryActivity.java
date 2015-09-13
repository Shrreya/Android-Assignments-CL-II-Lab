package com.example.shrreya.pizzashop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class DataEntryActivity extends Activity implements View.OnClickListener {

    //objects for UI elements
    private EditText editQuantity, editName, editAddress, editPinCode;
    private Button submitButton;
    //String array to hold data entered by user
    private String[] fields = new String[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);
        editQuantity = (EditText) findViewById(R.id.editQuantity);
        editName = (EditText) findViewById(R.id.editName);
        editAddress = (EditText) findViewById(R.id.editAddress);
        editPinCode = (EditText) findViewById(R.id.editPinCode);
        submitButton = (Button) findViewById(R.id.submitButton);
        //set the Click Listener on the submit button
        submitButton.setOnClickListener(this);
        //retrieve pizza option from extra text in intent
        Intent intent = this.getIntent();
        if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            fields[4] = intent.getStringExtra(Intent.EXTRA_TEXT); //pizza option stored in array
        }
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

    @Override
    public void onClick(View v) {
        //check if none of the text boxes are empty
        if (!editQuantity.getText().toString().equals("")
                && !editName.getText().toString().equals("")
                && !editAddress.getText().toString().equals("")
                && !editPinCode.getText().toString().equals("")) {
            //convert the text entered by user to string and store in array
            fields[0] = editQuantity.getText().toString();
            fields[1] = editName.getText().toString();
            fields[2] = editAddress.getText().toString();
            fields[3] = editPinCode.getText().toString();
            //start new intent with extra text that is, data fields
            Intent intent = new Intent(getApplicationContext(),DisplayActivity.class)
                    .putExtra(Intent.EXTRA_TEXT,fields);
            startActivity(intent);
        }
        else { //prompt user to enter all fields
            Toast.makeText(getApplicationContext(), "Enter All Fields",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
