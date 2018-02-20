package com.example.vanijais.assignment2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by vanijais on 10/3/17.
 */

public class ImageAdapter extends BaseAdapter {
    private static final int PADDING = 8;
    private static final int WIDTH = 300;
    private static final int HEIGHT = 300;
    private Context mContext;          // This will have to be passed to the ImageView
    private List<Integer> mThumbIds;   // Adapter must store AdapterView's items

    // Save the list of image IDs and the context
    public ImageAdapter(Context c, List<Integer> ids) {
        mContext = c;
        this.mThumbIds = ids;
    }



    // Return the number of items in the Adapter
    @Override
    public int getCount() {
        return mThumbIds.size();
    }

    // Return the data item at position
    @Override
    public Object getItem(int position) {
        return mThumbIds.get(position);
    }


    // passed to OnItemClickListener.onItemClick()
    @Override
    public long getItemId(int position) {
        return mThumbIds.get(position);
    }

    // Return an ImageView for each item referenced by the Adapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView = (ImageView) convertView;

        // if convertView's not recycled, initialize some attributes
        if (imageView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(WIDTH, HEIGHT));
            imageView.setPadding(PADDING, PADDING, PADDING, PADDING);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }

        imageView.setImageResource(mThumbIds.get(position));
        return imageView;
    }
}
