package phillipma.project4;

import javax.swing.*;
import java.awt.event.*;

/**
 * Similar to the FileMenuHandler class. This one handles the Edit menu.
 * 
 * It holds a method to insert a date.
 * A JOptionPane is created to take in the string input.
 * The string input is then passed to Date212GUI's insertDateToGUI method, which verifies and updates the displayed dates.
 * 
 * @author Phillip Ma
 * @since 2018-11-21
 * for CS212
 * Professor Kenneth Lord
 * Lab Instructor Lin Zhao
 */

public class EditMenuHandler implements ActionListener {
    JFrame jframe;

    public EditMenuHandler (JFrame jf) {
       jframe = jf;
    }

    public void actionPerformed(ActionEvent event) {
       String  menuName;
       menuName = event.getActionCommand();
       if (menuName.equals("Insert"))
          insertDate(); 
    }

    private void insertDate() {
        String userInput = JOptionPane.showInputDialog("Please enter a date in the format YYYYMMDD.");
        if(userInput != null) Date212GUI.insertDateToGUI(userInput);
     }
}
