package phillipma.project2;

/**
 * This part holds the main part of the program.
 * The only thing to do here is to put the name of the input file to be read and displayed.
 * 
 * @author Phillip Ma
 * @since 2018-11-10
 * for CS212
 * Professor Kenneth Lord
 * Lab Instructor Lin Zhao
 */

public class Project2 {

    public static void main(String[] args) {
        // put the input file name here.
        String inputFileName = "inputTextFile.txt";
        Date212GUI p1GUI = new Date212GUI();
        p1GUI.readDatesFromFileToGUI(inputFileName);
    }
}
