# CSC480Test1
CSC 480 Test 1 - Solar Star System

Displays an image of the solar system, info on a selected star/heavenly body, buttons for each planet + the sun & moon, and a text area for selecting a random star within a GUI frame. Info on stars obtained from Wikipedia articles. Pulls data from the starDesc file using the StarDescAccessor class, wraps data using the SolarSystemStarEnum enumeration, gets an icon from the images folder and wraps as using the SolarSystemStarIcon class, and builds the full GUI using the SolarSystemStarGui class. The SolarSystemStarPanel class organizes the GUI into a frame and displays to the user.
File structure:
  bin - contains Java code files, separated into gui and main
    bin/gui - contains Java code for GUI elements and wrappers
    bin/main - contains main Java file
    
  data - contains data and image files
    data/desc - contains the starDesc file, which holds the descriptions of each star
    data/images - contains the icon for the Java frame, the solar system image, and the image from which the individual star icons are cropped
