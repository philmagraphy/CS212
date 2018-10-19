package phillipma.project1;

public class Project1 {
      
    public static void main(String[] args) {
        // put the input file name here.
        String inputFileName = "inputTextFile.txt";
        DateGUI p1GUI = new DateGUI();
        p1GUI.readDatesFromFileToGUI(inputFileName);
    }
}