package com.example.shrreya.pizzashop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends Activity {

    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Array of pizza options
        String[] pizzaListArray = new String[]{"Barbeque chicken-Rs 180", "Farm house-Rs 150",
                "Cheese and onion-Rs 120"};
        //Array adapter
        ArrayAdapter<String> pizzaListAdapter=new ArrayAdapter<String>(
                this,
                R.layout.list_item_layout,
                R.id.pizza_list_item,
                pizzaListArray);
        //Set array adapter to list view
        listview = (ListView) findViewById(R.id.pizza_list);
        listview.setAdapter(pizzaListAdapter);

        //Set click listener on list items
        listview.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Get position of clicked item
                int itemPosition = position;

                //Get value of clicked item that is, pizza option
                String  itemValue = (String) listview.getItemAtPosition(position);

                //start new activity with extra text that is, pizza option
                Intent intent = new Intent(getApplicationContext(),DataEntryActivity.class)
                        .putExtra(Intent.EXTRA_TEXT,itemValue);
                startActivity(intent);
            }

        });
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
}
