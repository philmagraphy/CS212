package phillipma.project1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class DateGUI extends JFrame{
// data members
    private JTextArea leftTXTA;
    private JTextArea rightTXTA;
    private StringBuilder leftSB;
    private StringBuilder rightSB;

// using arraylists instead of since we don't know # of dates in input file.
    public static ArrayList<Date212> inputAL = new ArrayList<Date212>();
    public static ArrayList<Date212> sortedAL = new ArrayList<Date212>();    

// default constructor
    public DateGUI() {
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

// readDatesFromFileToGUI - does 5 things:
// 1. reads input from files and creates Date212 objects from input data
// 2. validates Date212 objects and adds to arraylists
// 3. takes complete input-arraylist and copies it to/sorts it as sorted-arraylist
// 4. adds arraylist elements to stringbuilders and sets text areas to the stringbuilder blocks.
// 5. makes the completed GUI visible.
    public void readDatesFromFileToGUI(String inputFileName) {

        // read input and tokenize into Date212 objects.
        try {
            BufferedReader dateReader = new BufferedReader(new FileReader(inputFileName));
            String inputLine;
            while((inputLine = dateReader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(inputLine, ",", false);
                while(st.hasMoreTokens()) {
                    String tempToken = st.nextToken();
                    Date212 tempDate = new Date212(tempToken);
                    if(valiDATEcheck(tempDate)) inputAL.add(tempDate);
                    else System.out.println(tempToken);
                }
            }
            dateReader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // take complete input arraylist and copies over and sorts as sorted arraylist.
        sortedAL.addAll(inputAL);
        selectionSortAL(sortedAL);

        // feeds cleaned arraylists to the StringBuilders to be shown to the user.
        for(int i = 0; i < sortedAL.size(); ++i) {
            this.leftSB.append(inputAL.get(i).toString() + "\n");
            this.rightSB.append(sortedAL.get(i).toString() + "\n");
        }

        // set text areas to stringbuilder blocks.
        this.leftTXTA.setText(this.leftSB.toString());
        this.rightTXTA.setText(this.rightSB.toString());

        // show finished GUI.
        this.showGUI();
    }

// arraylist selection sort, sorts sortedAL once copied over from inputAL
    private static void selectionSortAL (ArrayList<Date212> aList) {
        for(int i = 0; i < aList.size() - 1; ++i) {
            int indexOldest = i;
            for(int j = i + 1; j < aList.size(); ++j) {
                if(Date212.aLessThanb(aList.get(j), aList.get(indexOldest))) indexOldest = j;
            }
            if(aList.get(indexOldest) != aList.get(i)) {
                Date212 temp = aList.get(indexOldest);
                aList.set(indexOldest, aList.get(i));
                aList.set(i, temp);
            }
        }
    }

// date validity checker
// Leap year Februaries are accounted for.
     private static boolean valiDATEcheck(Date212 a) {
         if(a.getMonth() < 1 || a.getMonth() > 12) return false;
         if(a.getMonth() == 2) return (a.getDay() <= 28 || a.getDay() <= 29);
         if(a.getMonth() == 4 || a.getMonth() == 6 || a.getMonth() == 9 || a.getMonth() == 11) return (a.getDay() <= 30);
         else return (a.getDay() <= 31);
     }
     
// showGUI
     private void showGUI() {
         this.pack();
         this.setVisible(true);
     }
}
