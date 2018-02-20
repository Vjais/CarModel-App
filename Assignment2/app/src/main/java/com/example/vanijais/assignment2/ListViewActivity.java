package com.example.vanijais.assignment2;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;

public class ListViewActivity extends ListActivity {


    String[] ferrari = {"Racine Avenue","Rush Street","State street"};
    String[] porsche = {"Damen Avenue","Halsted Street","Michigan Avenue"};
    String[] tesla = {"Grande Avenue","Morgan Street","Canal Street"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_list_view);

        // Get the Intent used to start this Activity
        Intent i3 = getIntent();
        int pos = i3.getIntExtra("position2", 0);


        switch (pos){

            case 0:
                setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_list_view,ferrari));
                ListView listView1 = getListView();
                listView1.setTextFilterEnabled(true);
                break;

            case 1:
                setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_list_view,porsche));
                ListView listView2 = getListView();
                listView2.setTextFilterEnabled(true);
                break;

            case 2:
                setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_list_view,tesla));
                ListView listView3 = getListView();
                listView3.setTextFilterEnabled(true);
                break;


        }

    }

}
