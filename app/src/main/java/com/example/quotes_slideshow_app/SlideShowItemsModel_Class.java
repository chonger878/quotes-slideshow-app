package com.example.quotes_slideshow_app;

public class SlideShowItemsModel_Class {
    private String theQuote;
    private String theSpeaker;

    public SlideShowItemsModel_Class(String quote, String speaker){
        this.theQuote = quote;
        this.theSpeaker = speaker;
    }

    public String get_quote() {
        return theQuote;
    }

    public String get_speaker() {
        return theSpeaker;
    }

    public void setQuote(String theQuote) {
        this.theQuote = theQuote;
    }

    public void setSpeaker(String theSpeaker) {
        this.theSpeaker = theSpeaker;
    }
}
