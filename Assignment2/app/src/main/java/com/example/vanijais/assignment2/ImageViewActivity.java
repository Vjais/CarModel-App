package com.example.vanijais.assignment2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import java.util.ArrayList;

public class ImageViewActivity extends AppCompatActivity {

    private ArrayList<Uri> mUriList = new ArrayList<Uri>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        // Get the Intent used to start this Activity
        Intent intent = getIntent();

        // Make a new ImageView
        ImageView imageView = new ImageView(getApplicationContext());

        // Get the ID of the image to display and set it as the image for this ImageView
        imageView.setImageResource(intent.getIntExtra(MainActivity.EXTRA_ID, 0));
        setContentView(imageView);
        final int pos=intent.getIntExtra("position", 0);
        initStateUri();

        //Set shortclick listener for opening browser
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri aUri = mUriList.get(pos);
                Intent aIntent = new Intent(Intent.ACTION_VIEW);
                aIntent.setData(aUri);
                aIntent.addCategory(Intent.CATEGORY_BROWSABLE);
                startActivity(aIntent);
            }


        });
    }



    private void initStateUri(){

        mUriList.add(Uri.parse("https://www.ferrari.com"));
        mUriList.add(Uri.parse("https://www.porsche.com"));
        mUriList.add(Uri.parse("https://www.tesla.com/"));
    }
}

