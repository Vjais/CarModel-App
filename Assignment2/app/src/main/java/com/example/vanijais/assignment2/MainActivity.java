package com.example.vanijais.assignment2;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import android.app.Activity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity {

    int position;

    protected static final String EXTRA_ID = "CPS";

    private ArrayList<Integer> mThumbIdsCars = new ArrayList<Integer>(
            Arrays.asList(R.drawable.ferrari, R.drawable.porsche,
                    R.drawable.tesla));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent intent = new Intent(MainActivity.this, ImageViewActivity.class);
        final GridView gridview = (GridView) findViewById(R.id.gridview);


        // Create a new ImageAdapter and set it as the Adapter for this GridView
        gridview.setAdapter(new ImageAdapter(this, mThumbIdsCars));

        // Set an setOnItemClickListener on the GridView
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                //Create an Intent to start the ImageViewActivity


                // Add the ID of the thumbnail to display as an Intent Extra
                intent.putExtra(EXTRA_ID, (int) id);
                intent.putExtra("position", position);
                // Start the ImageViewActivity
                startActivity(intent);
            }
        });
        // Set an setOnItemLongClickListener on the GridView
        gridview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                registerForContextMenu(gridview);
                intent.putExtra("position2",position);
                return false;

            }
        });
    }

        //Create contextmenu
     @Override

       public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override

        public boolean onContextItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.option1:
                Toast.makeText(getApplicationContext(), "Option1 Shown",
                        Toast.LENGTH_LONG).show();
                Intent i1 = new Intent(MainActivity.this,ViewPictureActivity.class);
                i1.putExtra(EXTRA_ID,0);
                i1.putExtra("position2", position);
                startActivity(i1);
                break;
            case R.id.option2:
                Toast.makeText(getApplicationContext(), "Option2 Shown",
                        Toast.LENGTH_LONG).show();
                Intent i2 = new Intent(MainActivity.this,ShowWebActivity.class);
                i2.putExtra(EXTRA_ID, 0);
                i2.putExtra("position2",position);
                startActivity(i2);
                break;
            case R.id.option3:
                Toast.makeText(getApplicationContext(), "Option3 Shown",
                        Toast.LENGTH_LONG).show();
                Intent i3 = new Intent(MainActivity.this,ListViewActivity.class);
                i3.putExtra(EXTRA_ID, 0);
                i3.putExtra("position2",position);
                startActivity(i3);
                break;
        }

        return super.onContextItemSelected(item);


    }


}

