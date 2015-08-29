package com.example.shrreya.formanddatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

//defining adapter for our data list
//inheriting from super class BaseAdapter
public class DataListAdapter extends BaseAdapter {
    private ArrayList<DataSet> list; //array list to store data list
    private LayoutInflater inflater; //Instantiates a layout XML file into its corresponding
                                    // View objects

    //constructor for class
    DataListAdapter(Context context,ArrayList<DataSet> list){
        this.list=list;
        //getSystemService is used to retrieve a LayoutInflater for inflating layout resources
        //in this context
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //Function to get size of list
    @Override
    public int getCount() {
        return list.size();
    }

    //Function to get item in the list by position
    @Override
    public DataSet getItem(int position) {
        return list.get(position);
    }

    //Function to get postion of item in the list
    @Override
    public long getItemId(int position) {
        return position;
    }

    //Function to create the view for the adapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //inflate the view onto UI elements in data_list_item_layout.xml file
        convertView = inflater.inflate(R.layout.data_list_item_layout, null);

        //create TextView objects and connect to the corresponding XML TextView elements
        TextView textViewName = (TextView) convertView.findViewById(R.id.textViewName);
        TextView textViewEmail = (TextView) convertView.findViewById(R.id.textViewEmail);
        TextView textViewNumber = (TextView) convertView.findViewById(R.id.textViewNumber);

        //retrieve data set object from list and set name,email and number onto
        //corresponding TextView objects
        final DataSet dataBean = list.get(position);
        textViewName.setText(dataBean.getName());
        textViewEmail.setText(dataBean.getEmail());
        textViewNumber.setText(dataBean.getNumber());
        return convertView;
    }
}
