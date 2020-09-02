package phillipma.project4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.io.IOException;

import javax.swing.*;
import java.awt.GridLayout;

import java.util.Map;
import java.util.TreeMap;

/**
 * The Date212GUI class holds everything needed to create the GUI and the two menus, File and Edit.
 * 
 * It contains a static custom linked list for creating the unsorted list of dates.
 * It also contains a TreeMap for creating the sorted list of dates.
 * The TreeMap stores Date212 objects as keys and Integers as values.
 * The Integer values store how many instances of the respective Date212 objects are found in the input file.
 * 
 * @author Phillip Ma
 * @since 2018-11-24
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

    // using our user-written Date212Lists for the unsorted side.
    // using a TreeMap for the sorted side.
    // TreeMap uses Date212 objects as keys (since they are sortable), and Integer counts as values.
    // Given the nature of maps, duplicate values are stored as increments in the Integer count.
    private static UnsortedDate212List DateList = new UnsortedDate212List();
    private static TreeMap<Date212, Integer> sortTreeMap = new TreeMap<>();

// default constructor
    public Date212GUI() {
        super();
        setLayout(new GridLayout(1,2));
        setSize(400, 600);
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
 * 1. Stringbuilder blocks, text areas are reset. The linked list and tree map are cleared.
 * 
 * 2. Input lines are read from the input file and fed through a tokenizer to separate out dates.
 * Note: The tokenizer assumes a delimiter value of "," is used to separate multiple dates on a line.
 * 
 * 3. Each date read is stored as a temporary Date212 object.
 * 
 * 4. If the temporary Date212 object has valid dates, a Date212Node is created and added to the list and map.
 * 
 * 5. Once all input data is fed in, the list and map are fed as strings to the stringbuilders.
 */
    public static void readDatesFromFileToGUI(String inputFileName) {
        leftTXTA.setText("");
        rightTXTA.setText("");
        leftSB.setLength(0);
        rightSB.setLength(0);
        
        DateList.clear();
        sortTreeMap.clear();

        // read input and tokenize into Date212 objects.
        try (BufferedReader dateReader = new BufferedReader(new FileReader(inputFileName))) {
            String inputLine;
            while((inputLine = dateReader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(inputLine, ",", false);
                while(st.hasMoreTokens()) {
                    String tempToken = st.nextToken();
                    Date212 tempDate = new Date212(tempToken);
                    // add to the linked lists if valid.
                    if(tempDate.isValid()) {
                        DateList.add(tempDate);
                        // check if the tempDate already exists in the TreeMap.
                        // if so, increment the Integer count by 1.
                        // otherwise add the tempDate.
                        if (sortTreeMap.containsKey(tempDate)){
                            Integer newCount = sortTreeMap.get(tempDate) + 1;
                            sortTreeMap.put(tempDate, newCount);
                        }
                        else sortTreeMap.put(tempDate, 1);
                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            return;
        }
        
        // feed list and map to the StringBuilders to be shown to the user.
        Date212Node tempNode = DateList.first.next;
        while(tempNode != null) {
            leftSB.append(tempNode.date.toString() + "\n");
            tempNode = tempNode.next;
        }

        // for each entry in the map's entry set
        // add to the rightside stringbuilder block.
        for(Map.Entry<Date212, Integer> me : sortTreeMap.entrySet()){
            String tempString = me.getKey().toString();
            // check if the respective entry has a value larger than 1.
            // this indicates that there were multiple instances of the Date212 key in input data.
            // the instances are printed to indicate the multiple instances found.
            // if multiple instances are not found, the "instances" message and value are not printed.
            if(me.getValue().intValue() > 1) tempString += " - Instances: " + me.getValue();
            rightSB.append(tempString + "\n");
        }

        // set text areas to stringbuilder blocks.
        leftTXTA.setText(leftSB.toString());
        rightTXTA.setText(rightSB.toString());
        
    }


    /**
     * This method handles new dates from the Edit/Insert option in the GUI.
     * Because the left side list does not need sorting, we simply add a date to the end of the list.
     * For the right side, because of the sorting, the date list has to be recreated with the new date added.
     * 
     * 1. Text areas and the right stringbuilder block are reset.
     * 
     * 2. The input string is passed from a JOptionPane dialog from EditMenuHandler's insertDate method.
     * 
     * 3. A Date212 object is created from the input string.
     * 
     * 4. If the Date212 object is valid (non-empty), it is added to the list and map.
     * 
     * 5a. The Date212 object is added directly to the leftside stringbuilder block.
     * 5b. The Date212 object is added to the map and the rightside stringbuilder block is recreated from the updated map.
     */

    public static void insertDateToGUI(String insertDate) {
        leftTXTA.setText("");
        rightTXTA.setText("");
        rightSB.setLength(0);

        // read input and create Date212 object.
        Date212 tempDate = new Date212(insertDate);
        if(tempDate.isValid()) {
            // add to the linked list if valid.
            DateList.add(tempDate);
            // check if the tempDate already exists in the TreeMap.
            // if so, increment the Integer count by 1.
            // otherwise add the tempDate.
            if (sortTreeMap.containsKey(tempDate)){
                Integer newCount = sortTreeMap.get(tempDate) + 1;
                sortTreeMap.put(tempDate, newCount);
            }
            else sortTreeMap.put(tempDate, 1);
        }

        // add tempDate to the bottom of the list.
        if(tempDate.isValid()) {
            leftSB.append(tempDate.toString() + "\n");
        }

        // rebuild the rightside stringbuilder block with the updated map.
        // for each entry in the map's entry set
        for(Map.Entry<Date212, Integer> me : sortTreeMap.entrySet()){
            String tempString = me.getKey().toString();
            // check if the respective entry has a value larger than 1.
            // this indicates that there were multiple instances of the Date212 key in input data.
            // the instances are printed to indicate the multiple instances found.
            // if multiple instances are not found, the "instances" message and value are not printed.
            if(me.getValue().intValue() > 1) tempString += " - Instances: " + me.getValue();
            rightSB.append(tempString + "\n");
        }

        // set text areas to stringbuilder blocks.
        leftTXTA.setText(leftSB.toString());
        rightTXTA.setText(rightSB.toString());
    }

// createMenu
     private void createMenu() {
         JMenuBar menuBar  = new JMenuBar();
         JMenu fileMenu = new JMenu("File");
         JMenu editMenu = new JMenu("Edit");
         JMenuItem item;
         FileMenuHandler fmh = new FileMenuHandler(this);
         EditMenuHandler emh = new EditMenuHandler(this);
         
         // filemenu items
         item = new JMenuItem("Open"); 
         item.addActionListener(fmh);
         fileMenu.add(item);
         fileMenu.addSeparator(); 
         item = new JMenuItem("Quit"); 
         item.addActionListener(fmh);
         fileMenu.add(item);
         
         // editmenu items
         item = new JMenuItem("Insert"); 
         item.addActionListener(emh);
         editMenu.add(item);
         
         setJMenuBar(menuBar);
         menuBar.add(fileMenu);
         menuBar.add(editMenu);
     }
}
