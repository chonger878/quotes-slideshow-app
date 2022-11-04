package com.example.quotes_slideshow_app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {
    private List<SlideShowItemsModel_Class> quoteItems;
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

        //HashMap<String, Integer> timeDelay = new HashMap<String, Integer>();
        //timeDelay.put("Leia Organa", 3000);
        //timeDelay.put("Obi-Wan Kenobi", 2000);
        //timeDelay.put("Han Solo", 6000);
        //timeDelay.put("Yoda", 2000);
        SlideShowAdapter sPager_adapter = new SlideShowAdapter(this, quoteItems);
        sPage.setAdapter(sPager_adapter);

        //Using timer
        java.util.Timer sTimer = new java.util.Timer();
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