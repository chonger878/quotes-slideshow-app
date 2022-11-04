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

    /**Constructor
     * @param sContext- app context
     * @param slideShowItemsList-data to be displayed on the slide
     **/
    public SlideShowAdapter(Context sContext, List<SlideShowItemsModel_Class> slideShowItemsList){
        this.sContext = sContext;
        this.slideShowItemsList = slideShowItemsList;
    }

    /**This object call "inflates" (produces) each slide
     * @param container-slide
     * @param position-order in which the data is put into the slides
     **/
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

        //Makes the slide and adds it to the deck
        container.addView(sliderLayout);

        //returns the slideshow
        return sliderLayout;
    }

    //Returns slide count based on side of ArrayList
    @Override
    public int getCount() {
        return slideShowItemsList.size();
    }

    /**Destroys each slide after it passes but will recreate it if needed
     * @param container - the slide itself
     * @param position- slide order
     * @param object - the slide object
     **/
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    /**Checks that the object key is the view
     * @param view- what is displayed on the slide
     * @param object- components of the slide to be displayed
     **/
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
