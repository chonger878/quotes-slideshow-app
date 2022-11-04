package com.example.quotes_slideshow_app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimerTask;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {
    private List<SlideShowItemsModel_Class> quoteItems;
    private List<Long> slideTimes;
    java.util.Timer sTimer = new java.util.Timer();
    private ViewPager sPage;
    private TabLayout sTabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sPage = findViewById(R.id.pager);
        sTabLayout = findViewById(R.id.tablayout);

        quoteItems = new ArrayList<>();
        quoteItems.add(new SlideShowItemsModel_Class("Help me, Obi-Wan Kenobi. You’re my only " +
                "hope.", "Leia Organa"));
        quoteItems.add(new SlideShowItemsModel_Class("The Force will be with you. Always.",
                "Obi-Wan Kenobi"));
        quoteItems.add(new SlideShowItemsModel_Class("It’s the ship that made the Kessel run " +
                "in less than twelve parsecs.  I’ve outrun Imperial starships. " +
                "Not the local bulk cruisers, mind you.  I’m talking about the big Corellian " +
                "ships, now. She’s fast enough for you, old man.", "Han Solo"));
        quoteItems.add(new SlideShowItemsModel_Class("Do. Or do not. There is no try.",
                "Yoda"));
        
        SlideShowAdapter sPager_adapter = new SlideShowAdapter(this, quoteItems);
        sPage.setAdapter(sPager_adapter);

        //Using timer

        slideTimes = new ArrayList<>();
        slideTimes.add(3000L);
        slideTimes.add(2000L);
        slideTimes.add(6000L);
        slideTimes.add(2000L);
        Iterator<Long> iter = slideTimes.iterator();
        while (iter.hasNext()){
            sTimer.scheduleAtFixedRate((TimerTask) new Slide_timer(), 0L, (Long) iter.next());
        }
        sTabLayout.setupWithViewPager(sPage,true);


    }

    public class Slide_timer extends TimerTask{

        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sPage.getCurrentItem()< quoteItems.size()-1) {
                        sPage.setCurrentItem(sPage.getCurrentItem()+1);
                    }
                    else
                        //moves to first slide
                        sPage.setCurrentItem(0);
                }
            });

        }
    }

}