package phillipma.project4;

import javax.swing.*;
import java.awt.event.*;

/**
 * Almost the same as the FileMenuHandler class described in lecture.
 * Only differences are:
 * 1. The absolute path of the input file is read, instead of only the filename.
 * 2. Reading of input data is handed over to Date212GUI's readDatesFromFileToGUI method.
 * 
 * @author Phillip Ma
 * @since 2018-11-21
 * for CS212
 * Professor Kenneth Lord
 * Lab Instructor Lin Zhao
 */

    public class FileMenuHandler implements ActionListener {
       JFrame jframe;
       public FileMenuHandler (JFrame jf) {
          jframe = jf;
       }
       public void actionPerformed(ActionEvent event) {
          String  menuName;
          menuName = event.getActionCommand();
          if (menuName.equals("Open"))
             openFile( ); 
          else if (menuName.equals("Quit"))
             System.exit(0);
       }

        private void openFile( ) {
           JFileChooser chooser;
           int          status;
           chooser = new JFileChooser( );
           status = chooser.showOpenDialog(null);
           if (status == JFileChooser.APPROVE_OPTION) 
              readSource(chooser.getSelectedFile().getAbsolutePath());
           else 
              JOptionPane.showMessageDialog(null, "Open File dialog cancelled");
        }
      
        private void readSource(String path) {
            Date212GUI.readDatesFromFileToGUI(path);
        }
}
