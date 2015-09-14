package com.example.shrreya.context;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.FileInputStream;


public class CompanyContextActivity extends Activity {

    private TextView NameTextView, EmailTextView, NumberTextView, QualificationTextView,
    AreaOfSpecializationTextView, ExperienceTextView;
    private String[] fields = new String[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_context);
        NameTextView = (TextView) findViewById(R.id.NameTextView);
        EmailTextView = (TextView) findViewById(R.id.EmailTextView);
        NumberTextView = (TextView) findViewById(R.id.NumberTextView);
        QualificationTextView = (TextView) findViewById(R.id.QualificationTextView);
        AreaOfSpecializationTextView = (TextView) findViewById(R.id.AreaOfSpecializationTextView);
        ExperienceTextView = (TextView) findViewById(R.id.ExperienceTextView);

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
            EmailTextView.setText("Email:"+fields[1]);
            NumberTextView.setText("Number:"+fields[2]);
            QualificationTextView.setText("Qualification:"+fields[6]);
            AreaOfSpecializationTextView.setText("Area of specialization:"+fields[7]);
            ExperienceTextView.setText("Experience:"+fields[8]);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_company_context, menu);
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
