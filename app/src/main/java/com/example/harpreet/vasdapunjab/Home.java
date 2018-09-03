package com.example.harpreet.vasdapunjab;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class Home extends Fragment  {

  /*  ViewPager viewPager;
    PagerAdapter adapter;

    int[] img;

    private  static  int currentpage=0;
    private static int numpage=0;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Viewpager di codding
        img= new int[]{R.drawable.imgone,
                R.drawable.imgtwo
        };

         viewPager = (ViewPager) viewPager.findViewById(R.id.view_pager);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            adapter = new viewPagerAdaptor(Home.this,img);
        }
        viewPager.setAdapter(adapter);
        ///
        //Circleidicator da code
        CircleIndicator indicator =(CircleIndicator) viewPager.findViewById(R.id.Indicator);
        indicator.setViewPager(viewPager);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentpage=position;

            }

            @Override
            public void onPageScrollStateChanged(int state) {

                if (state==viewPager.SCROLL_STATE_IDLE)
                {
                    int pagecount = img.length;
                    if (currentpage==0)
                    {
                        viewPager.setCurrentItem(pagecount-1,false);
                    }

                    else if (currentpage==pagecount-1)
                    {
                        viewPager.setCurrentItem(0,false);
                    }
                }

            }
        });




        // SLIDE SHOW WITH TIMER
        final Handler handler = new Handler();
        final Runnable update =new Runnable() {
            @Override
            public void run() {
                if (currentpage==numpage)
                {
                    currentpage=0;
                }
                viewPager.setCurrentItem(currentpage++,true);
            }
        };

        Timer swipe = new Timer();
        swipe.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }

        },2000,2000);

    }


*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home,container,false);

        return view;


}
}
