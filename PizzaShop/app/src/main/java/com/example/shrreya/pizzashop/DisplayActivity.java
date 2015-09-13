package com.example.shrreya.pizzashop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class DisplayActivity extends Activity {

    private String[] fields = new String[5]; //array to hold data entered by user
    private TextView message; //object for UI element

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        //retrieve data entered by user from extra text in intent
        Intent intent = this.getIntent();
        if(intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            fields = intent.getStringArrayExtra(Intent.EXTRA_TEXT);
        }
        String msg = ""; //message to be displayed to user
        int amt; //amount calculated for order
        //Check pizza option selected by user, calculate amount and generate corresponding
        //message to be displayed to user
        if(fields[4].equals("Barbeque chicken-Rs 180")) {
            amt = Integer.parseInt(fields[0]) * 180;
            msg = fields[0] + " barbeque chicken pizzas will be delivered to your address in 30 " +
                    "minutes. Total amount is Rs " + Integer.toString(amt) + ". Thank you!";
        }
        else if(fields[4].equals("Farm house-Rs 150")) {
            amt = Integer.parseInt(fields[0]) * 150;
            msg = fields[0] + " farm house pizzas will be delivered to your address in 30 " +
                    "minutes. Total amount is Rs " + Integer.toString(amt) + ". Thank you!";
        }
        else if(fields[4].equals("Cheese and onion-Rs 120")) {
            amt = Integer.parseInt(fields[0]) * 120;
            msg = fields[0] + " cheese and onion pizzas will be delivered to your address in 30 " +
                    "minutes. Total amount is Rs " + Integer.toString(amt) + ". Thank you!";
        }
        //set message on to text view
        message = (TextView) findViewById(R.id.message);
        message.setText(msg);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_display, menu);
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
}
