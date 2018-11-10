// Phillip Ma
// Lab Section 11E

import javax.swing.JOptionPane;

public class Project0 {
    public static void main(String[] args) {

        // not ideal to use an always-true while loop but the objective is simple enough.
        while (true) {
            String userInput = JOptionPane.showInputDialog("Please enter a sentence.");

            if(userInput.equalsIgnoreCase("Stop")) break;

            int eCount = 0, ECount = 0;
            for(int i = 0; i < userInput.length(); ++i) {
                if(userInput.charAt(i) == 'e') eCount++;
                if(userInput.charAt(i) == 'E') ECount++;
            }

            JOptionPane.showMessageDialog(null, "Number of lower case e's: " + eCount + "\n" + "Number of upper case E's: " + ECount);
        }
    }
}