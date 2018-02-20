package com.example.vanijais.assignment2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;

public class ShowWebActivity extends AppCompatActivity {


    private ArrayList<Uri> mUriList1 = new ArrayList<Uri>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_web);

        // Get the Intent used to start this Activity
        Intent i2 = getIntent();

        // Make a new ImageView
        ImageView imageView = new ImageView(getApplicationContext());

        // Get the ID of the image to display and set it as the image for this ImageView
        imageView.setImageResource(i2.getIntExtra(MainActivity.EXTRA_ID, 0));

        setContentView(imageView);
        final int pos=i2.getIntExtra("position2", 0);
        initStateUri();

        //Set shortclick listener for opening browser
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri aUri = mUriList1.get(pos);
                Intent aIntent = new Intent();
                aIntent.setData(aUri);
                aIntent.addCategory(Intent.CATEGORY_BROWSABLE);
                startActivity(aIntent);
            }


        });
    }



    private void initStateUri(){

        mUriList1.add(Uri.parse("https://www.tesla.com/"));
        mUriList1.add(Uri.parse("https://www.porsche.com"));
        mUriList1.add(Uri.parse("https://www.tesla.com/"));
    }


}
