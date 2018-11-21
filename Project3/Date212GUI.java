package phillipma.project3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.io.IOException;

import javax.swing.*;
import java.awt.GridLayout;

/**
 * The DateGUI class holds everything needed to create the GUI.
 * It contains two Date212 linked lists to be displayed on the GUI.
 * 
 * @author Phillip Ma
 * @since 2018-11-20
 * for CS212
 * Professor Kenneth Lord
 * Lab Instructor Lin Zhao
 */

public class Date212GUI extends JFrame{
// data members
    private static JTextArea leftTXTA;
    private static JTextArea rightTXTA;
    private static StringBuilder leftSB;
    private static StringBuilder rightSB;  

// default constructor
    public Date212GUI() {
        super();
        setLayout(new GridLayout(1,2));
        setSize(300, 600);
        setLocation(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        createMenu();
        
        leftSB = new StringBuilder();
        rightSB = new StringBuilder();
        
        leftTXTA = new JTextArea(leftSB.toString(), 1, 1);
        rightTXTA = new JTextArea(rightSB.toString(), 1, 1);
        
        getContentPane().add(leftTXTA);
        getContentPane().add(rightTXTA);
        
        setVisible(true);
    }

/**
 * This method does most of the work to convert input data to strings on the GUI.
 * 
 * 1. Stringbuilder blocks, text areas are reset. New Date212 linked lists are instantiated.
 * 
 * 2. Input lines are read from the input file and fed through a tokenizer to separate out dates.
 * Note: The tokenizer assumes a delimiter value of "," is used to separate multiple dates on a line.
 * 
 * 3. Each date read is stored as a temporary Date212 object.
 * 
 * 4. If the temporary Date212 object has valid dates, a Date212Node is created and added to the linked lists.
 * 
 * 5. Once both linked lists are complete and organized, they are fed as strings to the stringbuilders.
 */
    public static void readDatesFromFileToGUI(String inputFileName) {
        leftTXTA.setText("");
        rightTXTA.setText("");
        leftSB.setLength(0);
        rightSB.setLength(0);
        
     // using our user-written Date212Lists
        UnsortedDate212List DateList = new UnsortedDate212List();
        SortedDate212List sortDateList = new SortedDate212List();  

        // read input and tokenize into Date212 objects.
        try (BufferedReader dateReader = new BufferedReader(new FileReader(inputFileName))) {
            String inputLine;
            while((inputLine = dateReader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(inputLine, ",", false);
                while(st.hasMoreTokens()) {
                    String tempToken = st.nextToken();
                    Date212 tempDate = new Date212(tempToken);
                    // check if the newly created Date212 object is valid.
                    // add to the linked lists if valid.
                    if(tempDate.isValid()) {
                        DateList.add(tempDate);
                        sortDateList.add(tempDate);
                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            return;
        }
        
        // feeds linked lists to the StringBuilders to be shown to the user.
        Date212Node tempNode = DateList.first.next;
        Date212Node tempSortNode = sortDateList.first.next;
        
        // we do not need to know if tempSortNode is also null since both lists will have same # of elements.
        while(tempNode != null) {
            leftSB.append(tempNode.date.toString() + "\n");
            rightSB.append(tempSortNode.date.toString() + "\n");
            tempNode = tempNode.next;
            tempSortNode = tempSortNode.next;
        }

        // set text areas to stringbuilder blocks.
        leftTXTA.setText(leftSB.toString());
        rightTXTA.setText(rightSB.toString());
        
    }

// createMenu
     private void createMenu() {
         JMenuBar menuBar  = new JMenuBar();
         JMenu fileMenu = new JMenu("File");
         JMenuItem item;
         FileMenuHandler fmh = new FileMenuHandler(this);
         item = new JMenuItem("Open"); 
         item.addActionListener(fmh);
         fileMenu.add(item);
         fileMenu.addSeparator(); 
         item = new JMenuItem("Quit"); 
         item.addActionListener(fmh);
         fileMenu.add(item);
         setJMenuBar(menuBar);
         menuBar.add(fileMenu);
      }
}
