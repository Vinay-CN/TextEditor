import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TextEditor implements ActionListener {
    //declaring the properties of TextEditor
    JFrame frame;
    JMenuBar menuBar ;

    JMenu file ,  edit ;

    //file menu items
    JMenuItem newWindow , openFile , saveFile ;

    JMenuItem cut , copy , paste , selectAll , close ;

    //initialize the text area
    JTextArea textArea ;
    TextEditor(){
        frame = new JFrame();

        menuBar = new JMenuBar();

        textArea = new JTextArea();

        file = new JMenu("File"); //giving name to the file menu
        edit = new JMenu("Edit"); //giving name to the edit menu

        //before adding menus to menubar //add menu options
        newWindow = new JMenuItem("New Window");
        openFile = new JMenuItem("Open File");
        saveFile = new JMenuItem("Save File");


        //before adding menus to menubar add actionlistener
        newWindow.addActionListener(this); //this keyword is referring to object texteditor class textedior is behaving like actionlistener
        openFile.addActionListener(this);
        saveFile.addActionListener(this);


        //add these option to the file menu
        file.add(newWindow);
        file.add(openFile);
        file.add(saveFile);

        //add menu options for edit

        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        selectAll = new JMenuItem("Select all");
        close = new JMenuItem("Close");


        //add actionlisteners to the edit menu

        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
        close.addActionListener(this);


        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        edit.add(close);

        //add menus to the menubar
        menuBar.add(file);
        menuBar.add(edit);



        //add  menu bar  to the frame
        frame.setJMenuBar(menuBar);

        //create content pane
        JPanel Panel = new JPanel();

        Panel.setBorder(new EmptyBorder(5,5,5,5));
        Panel.setLayout(new BorderLayout(0,0));

        //add text area to the panel
        Panel.add(textArea , BorderLayout.CENTER);

        //create a scroll pane
        //when we go out of the border then only we need border
        JScrollPane scrollPane = new JScrollPane(textArea , JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED , JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        //add the scrollpane to the panel
        Panel.add(scrollPane);

        //add panel to the frame
        frame.add(Panel);

        //add the text area
        //frame.add(textArea); //handeled by panel

        //set the boundary
        frame.setBounds(0,0,400,400); //x and y is location where the window should appear

        //add title
        frame.setTitle("Text Editor");
        //make the frame visible
        frame.setVisible(true);
        frame.setLayout(null);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent){
        if(actionEvent.getSource() == cut )
        {
            //fuction for cut
            textArea.cut(); //calling cut function
        }
        if(actionEvent.getSource() == copy )
        {
            //fuction for copy
            textArea.copy(); //calling copy fuction
        }
        if(actionEvent.getSource() == paste )
        {
            //fuction for paste
            textArea.paste();
        }
        if(actionEvent.getSource() == selectAll )
        {
            //fuction for selectAll
            textArea.selectAll();
        }
        if(actionEvent.getSource() == close )
        {
            //fuction for close
            System.exit(0); //status zero means we need to close the application
        }
        //open file means taking the entire text from the file we want and paste it to our textarea
        if(actionEvent.getSource() == openFile)
        {
            JFileChooser fileChooser = new JFileChooser("C:"); //give path where to start

            int chooseOption = fileChooser.showOpenDialog(null); //we need to open file so show open option

            //if we click open file option then
            if(chooseOption == JFileChooser.APPROVE_OPTION)
            {
                //getting the file to notepad
                File file = fileChooser.getSelectedFile();

                //get the path of the seleceted file
                String filePath = file.getPath();

                try{

                    //initialize the filereader
                    FileReader fileReader = new FileReader(filePath);

                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String intermediate = "" , output = "";

                    while((intermediate = bufferedReader.readLine())!=null) //redline on readLine to catch exception
                    {
                        output+=intermediate+"\n";
                    }

                    //set the output string
                    textArea.setText(output);

                }
                catch(FileNotFoundException fileNotFoundException){

                        fileNotFoundException.printStackTrace();

                }
                catch(IOException ioException){
                    ioException.printStackTrace();
                }


            }

        }
        //if user chooses save file then do the same thing
        if(actionEvent.getSource() == saveFile)
        {
            //file picker
            JFileChooser fileChooser = new JFileChooser("C:");
            int chooseOption = fileChooser.showSaveDialog(null); //we need to save file so show save option

            if(chooseOption == JFileChooser.APPROVE_OPTION)
            {
                //create a new file with choosen directory path
                File file = new File(fileChooser.getSelectedFile().getAbsoluteFile()+".txt");
                try{
                    //initialize the file writer
                    FileWriter fileWriter = new FileWriter(file);

                    //initialize buffered writer
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                    //write contents of text area to file
                    textArea.write(bufferedWriter);
                    bufferedWriter.close();

                }
                catch(IOException ioException){
                        ioException.printStackTrace(); //it will print java.io.IOExceptio at package.Test.main(Test.java:74)

                }
            }

        }
        if(actionEvent.getSource() == newWindow )
        {
            TextEditor textEditor = new TextEditor();
        }

    }
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();

    }
}