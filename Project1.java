package phillipma.project1;

/**
 * This part holds the main part of the program.
 * The name of the input file is entered here.
 * Everything else is mostly done in the DateGUI class along with the Date212 class.
 * 
 * @author Phillip Ma
 * @since 2018-10-22
 * for CS212
 * Professor Kenneth Lord
 * Lab Instructor Lin Zhao
 */

public class Project1 {
      
    public static void main(String[] args) {
        // put the input file name here.
        String inputFileName = "inputTextFile.txt";
        DateGUI p1GUI = new DateGUI();
        p1GUI.readDatesFromFileToGUI(inputFileName);
    }
}