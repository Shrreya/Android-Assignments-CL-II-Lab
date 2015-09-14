package com.example.shrreya.context;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.FileInputStream;


public class MatrimonyContextActivity extends Activity {

    private TextView NameTextView, NumberTextView, HeightTextView, GenderTextView,
            AgeTextView, QualificationTextView;
    private String[] fields = new String[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrimony_context);
        NameTextView = (TextView) findViewById(R.id.NameTextView);
        NumberTextView = (TextView) findViewById(R.id.NumberTextView);
        HeightTextView = (TextView) findViewById(R.id.HeightTextView);
        GenderTextView = (TextView) findViewById(R.id.GenderTextView);
        AgeTextView = (TextView) findViewById(R.id.AgeTextView);
        QualificationTextView = (TextView) findViewById(R.id.QualificationTextView);

        //read contents from file in input storage
        try{
            String FILENAME = "myfile";
            FileInputStream fin = openFileInput(FILENAME);
            int c;
            String temp="";
            int i = 0;

            while( (c = fin.read()) != -1){
                if(c == '-') {
                    fields[i] = temp;
                    i++;
                    temp = "";
                }
                else {
                    temp = temp + Character.toString((char) c);
                }
            }
            //set relevant fields to corresponding text views
            NameTextView.setText("Name:"+fields[0]);
            NumberTextView.setText("Number:"+fields[2]);
            HeightTextView.setText("Height:"+fields[3]);
            GenderTextView.setText("Gender:"+fields[4]);
            AgeTextView.setText("Age:"+fields[5]);
            QualificationTextView.setText("Qualification:"+fields[6]);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_matrimony_context, menu);
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
