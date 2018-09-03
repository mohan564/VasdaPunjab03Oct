package com.example.harpreet.vasdapunjab;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class viewPagerAdaptor extends PagerAdapter {

    int[] image;
    LayoutInflater inflater;
    Context context;

    @RequiresApi(api = Build.VERSION_CODES.M)
    public viewPagerAdaptor(Home mainActivity, int[] img) {
        this.context = mainActivity.getContext();
        this.image = img;

    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager) container).removeView((RelativeLayout)object);

        super.destroyItem(container, position, object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView trailing;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemview = inflater.inflate(R.layout.item_view_pager, container, false);
        trailing = (ImageView) itemview.findViewById(R.id.trailing);

        trailing.setImageResource(image[position]);
        ((ViewPager) container).addView(itemview);
        return itemview;


    }
}
