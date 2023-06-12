Text editor Intro:
The project involves building a text editor in Java, using Java Swing for creating a graphical user interface.
The text editor will have a window (frame) with a menu bar, consisting of two menus - file menu and edit menu.
The file menu will have features like new window, save file, and open file.
The edit menu will have five functions - Cut, Copy, Paste, Select All, and Close button.
The text area inside the window will be used for writing and editing the text.
Text editor Building UI:
Creating a basic UI for a text editor project in Java using Java Swing components.
Creating a new project in IntelliJ named "text data" with Java as the language and IntelliJ as the build system.
Choosing Open JDK 8 as the preferred JDK version.
Refactoring the main class to be called "text editor" and creating a constructor for the text editor class.
Calling the constructor in the main function to create an instance of the text editor application.
Using the JFrame class to create an application window.
Declaring a data member "frame" and initializing it as a new JFrame with dimensions 400x400.
Making the frame visible and setting the layout.
Text editor Adding Action Listeners:
Discussing Action Listener classes and action events.
Implementing the ActionPerformed method from the Action Listener interface to listen to action events.
Defining the action to be taken when a specific action event occurs, based on the event source.
Text editor Adding File Menu Functionalities:
Implementing file menu functionalities such as new window, open file, and save file.
Using JFileChooser to open the file chooser and allowing the user to select the file path and file to open.
Copying and pasting the text from the file into the text area.
Triggering an action event when the open button is clicked and listening to it in the ActionPerformed method.
Saving the text from the text area to a new file when the save button is clicked.
Text editor Adding File Menu Functionalities Part 2:
Implementing the save file functionality similar to the open file functionality.
Checking if the action event source is the save file functionality using an "if" statement.
Initializing a file chooser to select the file path and name using the show save dialog method.
Creating a new file with the chosen directory path and file name using the File object.
Saving the text from the text area to the new file.
Text editor Final touch:
Adding finishing touches to the application's UI.
Adding scroll bars to make the UI more user-friendly.
Wrapping the text area inside a scroll pane class to make it scrollable.
Creating a panel that contains the scroll pane and the text area.
Adding borders inside the panel to enhance the visual appeal.
Adding the text area to the panel and the panel to the scroll pane in the constructor.
Making the scroll pane scrollable only when the text goes beyond the borders of the application.
Adding scroll bars by creating a scroll pane with vertical and horizontal scroll bars as needed and adding it to the panel.
