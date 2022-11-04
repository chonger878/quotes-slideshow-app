package com.example.quotes_slideshow_app;

//This class sets up the data model that will store the quotes and speakers
public class SlideShowItemsModel_Class {
    private String theQuote;
    private String theSpeaker;

    /**Constructor
     * @param quote- quote to be stored
     * @param speaker- speaker name to be stored
     * */
    public SlideShowItemsModel_Class(String quote, String speaker){
        this.theQuote = quote;
        this.theSpeaker = speaker;

    }

    //This method returns the quote
    public String get_quote() {
        return theQuote;
    }

    //This method returns the speaker's name
    public String get_speaker() {
        return theSpeaker;
    }

    /**This method updates the quote
     * @param theQuote-quote to update the current one
     **/
    public void setQuote(String theQuote) {
        this.theQuote = theQuote;
    }

    /**This method updates the name of the speaker
     * @param theSpeaker-update to the current speaker's name listed
     */
    public void setSpeaker(String theSpeaker) {
        this.theSpeaker = theSpeaker;
    }

}
