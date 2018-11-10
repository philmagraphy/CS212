package phillipma.project2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.JFrame;
import java.awt.GridLayout;

/**
 * The DateGUI class holds everything needed to create the GUI.
 * It contains two Date212 linked lists to be displayed on the GUI.
 * It also has methods to validate dates in Date212 objects and to read input data through to its display in a GUI.
 * 
 * @author Phillip Ma
 * @since 2018-11-10
 * for CS212
 * Professor Kenneth Lord
 * Lab Instructor Lin Zhao
 */

public class Date212GUI extends JFrame{
// data members
    private JTextArea leftTXTA;
    private JTextArea rightTXTA;
    private StringBuilder leftSB;
    private StringBuilder rightSB;

// using our user-written Date212Lists
    public static UnsortedDate212List DateList = new UnsortedDate212List();
    public static SortedDate212List sortDateList = new SortedDate212List();    

// default constructor
    public Date212GUI() {
        super();
        this.setLayout(new GridLayout(1,2));
        this.setSize(100, 100);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.leftSB = new StringBuilder();
        this.rightSB = new StringBuilder();
        
        this.leftTXTA = new JTextArea(this.leftSB.toString(), 1, 1);
        this.rightTXTA = new JTextArea(this.rightSB.toString(), 1, 1);
        
        this.getContentPane().add(this.leftTXTA);
        this.getContentPane().add(this.rightTXTA);
    }

/**
 * This method does most of the work to convert input data to strings on the GUI.
 * 
 * 1. Input lines are read from the input file and fed through a tokenizer to separate out dates.
 * Note: The tokenizer assumes a delimiter value of "," is used to separate multiple dates on a line.
 * 
 * 2. Each date read is stored as a temporary Date212 object.
 * 
 * 3a. If the temporary Date212 object has valid dates, a Date212Node is created and added to the linked lists.
 * 
 * 3b. If the temporary Date212 object has invalid dates, it is printed to screen and not added.
 * 
 * 4. Once both linked lists are complete and organized, they are fed as strings to the stringbuilders.
 * 
 * 5. The text areas are then set to the size of the stringbuilder blocks.
 * 
 * 6. The GUI is made visible.
 */
    public void readDatesFromFileToGUI(String inputFileName) {

        // read input and tokenize into Date212 objects.
        try (BufferedReader dateReader = new BufferedReader(new FileReader(inputFileName))) {
            String inputLine;
            while((inputLine = dateReader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(inputLine, ",", false);
                while(st.hasMoreTokens()) {
                    String tempToken = st.nextToken();
                    Date212 tempDate = new Date212(tempToken);
                    // check if temp Date212 object has valid dates.
                    // add to the linked lists if valid, otherwise print to screen.
                    if(valiDATEcheck(tempDate)) {
                        DateList.add(tempDate);
                        sortDateList.add(tempDate);
                    }
                    else System.out.println(tempToken);
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
            this.leftSB.append(tempNode.date.toString() + "\n");
            this.rightSB.append(tempSortNode.date.toString() + "\n");
            tempNode = tempNode.next;
            tempSortNode = tempSortNode.next;
        }

        // set text areas to stringbuilder blocks.
        this.leftTXTA.setText(this.leftSB.toString());
        this.rightTXTA.setText(this.rightSB.toString());

        // show finished GUI.
        this.showGUI();
    }

/**
 * This method checks whether a Date212 object's month and day are valid values.
 * 
 * Months cannot fall outside of the 1-12 range.
 * 
 * Day values are checked according to the month:
 * 
 * February has 28 or 29 days depending on if its a leap year. Both are accounted for.
 * NOTE that leap years are not determined. This program assumes if 29 is entered for a February date, that a leap year occurred.
 * 
 * April, June, September, and November have 30 days.
 * The other months have 31 days.
 */
     private static boolean valiDATEcheck(Date212 a) {
         if(a.getMonth() < 1 || a.getMonth() > 12) return false;
         if(a.getMonth() == 2) return (a.getDay() >= 1 && a.getDay() <= 29);
         if(a.getMonth() == 4 || a.getMonth() == 6 || a.getMonth() == 9 || a.getMonth() == 11) return (a.getDay() >= 1 && a.getDay() <= 30);
         else return (a.getDay() >= 1 && a.getDay() <= 31);
     }
     
// showGUI
     private void showGUI() {
         this.pack();
         this.setVisible(true);
     }
}
