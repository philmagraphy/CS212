package phillipma.project4;

/**
 * The UnsortedDate212List class is one of the two linked list classes used.
 * This class does not add any new functionality beyond the base class.
 * 
 * @author Phillip Ma
 * @since 2018-11-21
 * for CS212
 * Professor Kenneth Lord
 * Lab Instructor Lin Zhao
 */

public class UnsortedDate212List extends Date212List {
// constructor
    public UnsortedDate212List() {
        super();
    }
    
// add
    public void add(Date212 d) {
        super.append(d);
    }
}
