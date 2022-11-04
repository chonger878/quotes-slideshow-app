package com.example.quotes_slideshow_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;

public class SlideShowAdapter extends PagerAdapter {
    private Context sContext;
    private List<SlideShowItemsModel_Class> slideShowItemsList;

    public SlideShowAdapter(Context sContext, List<SlideShowItemsModel_Class> slideShowItemsList){
        this.sContext = sContext;
        this.slideShowItemsList = slideShowItemsList;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position){

        LayoutInflater inflater = (LayoutInflater) sContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View sliderLayout = inflater.inflate(R.layout.quote_items_layout,null);

        TextView quote = sliderLayout.findViewById(R.id.quote_said);
        TextView speaker = sliderLayout.findViewById(R.id.quote_speaker);

        quote.setText(slideShowItemsList.get(position).get_quote());
        speaker.setText(slideShowItemsList.get(position).get_speaker());
        container.addView(sliderLayout);
        return sliderLayout;
    }
    @Override
    public int getCount() {
        return slideShowItemsList.size();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
