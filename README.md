# quotes-slideshow-app

#Purpose: 
The purpose of this project was to create an app that would display a slideshow of
quotes and who spoke them.  The sample data for this project were quotes from the Star Wars movie
franchise.

#App architecture: 
When I was building the app, the architecture appears to be straightforward, and
consists of two layers. 

At the top, there is the UI layer, where I would be using the ViewPager, TabLayout, and Adapter UI
tools/libraries, which would display what is on those slides. 

At the bottom, there is the backend, such as where the slides' data are stored, as well as
the Timer object/library that manipulates how much time passes between slides.

#Components of the program:
There was a total of One (1) Activity (AKA MainActivity) and Three (3) Java 
classes (one of which is inside the Main Activity) that I used for this project:
SlideShowAdapter, SlideShowItemsModel_Class and Slide_timer.

Main Activity:
This activity is like the interface where the slides will be displayed. Using the blueprints that the 
SlideShowAdapter and data from SlideShowItemsModel_Class has  provided for producing the slides, 
the activity calls for an ArrayList that would populate and store the slides for display. 
After that task is executed, the Activity would call on a specific Timer object, which is called 
from its' respective Library, to specify the time delay between slides.

SlideShowAdapter:
The SlideShow adapter provides the blueprints for how the slides should appear.  In addition, 
the adapter returns how many slides there should be based on the size of the ArrayList passed in 
by the SlideShowItemsModel_Class.  Finally, the Adapter would also destroy each slide as the slideshow 
progresses to conserve memory and also ensures that the view of the slide
matches the components of its' object.

Slide_timer:
To summarize, this class determines the order of the slides in the slideshow, which is in 
a consecutive order. The Timer object declared in Main Activity would call on it to "schedule" how 
long each slide is displayed in the determined order.

#Area(s) of improvement: 
I noticed that the slides were not running in the consecutive order that
was requested. I think it might have something to do with how I hardcoded the data. Perhaps I should
have a.) put the data in a DATA.json file, b.) wrote code to parse it and probably use a 
StringBuilder to form the data to populate the slides.  In my personal opinion, I can see now how
that can make the code more cleaner. 

I would also revisit the documentation on the Timer Object to see how to properly use it.  Well, more
specifically I would like to review the documentation for the function to schedule a fixed rate of 
time between tasks (Timer.scheduleFixedRate(task, long delay, long period) to improve the slideshow
app.

#Resources
I found this article to be very helpful on building the app:
https://www.section.io/engineering-education/how-to-create-an-automatic-slider-in-android-studio/

The tutorials on the Android Developer website, specifically the ones on ViewPager and Adapters
were helpful too.
