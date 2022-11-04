package com.example.quotes_slideshow_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;

//This class sets up the adapter to display the slideshow
public class SlideShowAdapter extends PagerAdapter {
    private Context sContext;
    private List<SlideShowItemsModel_Class> slideShowItemsList;

    public SlideShowAdapter(Context sContext, List<SlideShowItemsModel_Class> slideShowItemsList){
        this.sContext = sContext;
        this.slideShowItemsList = slideShowItemsList;
    }

    //This object call will manifest each slide
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position){

        LayoutInflater inflater = (LayoutInflater) sContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View sliderLayout = inflater.inflate(R.layout.quote_items_layout,null);

        //Finds respective content for each slide
        TextView quote = sliderLayout.findViewById(R.id.quote_said);
        TextView speaker = sliderLayout.findViewById(R.id.quote_speaker);

        //Populates each slide
        quote.setText(slideShowItemsList.get(position).get_quote());
        speaker.setText(slideShowItemsList.get(position).get_speaker());
        container.addView(sliderLayout);
        return sliderLayout;
    }

    //Returns slide count based on side of ArrayList
    @Override
    public int getCount() {
        return slideShowItemsList.size();
    }

    //Destroys each slide but will recreate it if needed
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    //Checks that the object is the view
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
