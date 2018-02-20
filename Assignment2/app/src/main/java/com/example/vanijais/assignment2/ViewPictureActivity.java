package com.example.vanijais.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

public class ViewPictureActivity extends AppCompatActivity {
    private int cars[] = {R.drawable.ferrari, R.drawable.porsche,
            R.drawable.tesla};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_picture);

        // Get the Intent used to start this Activity
        Intent i1 = getIntent();

        // Make a new ImageView
        ImageView imageView = new ImageView(getApplicationContext());

        // Get the ID of the image to display and set it as the image for this ImageView
        imageView.setImageResource(i1.getIntExtra(MainActivity.EXTRA_ID, 0));
        int pos = i1.getIntExtra("position2", 0);
        imageView.setImageResource(cars[pos]);
        setContentView(imageView);


    }
}
