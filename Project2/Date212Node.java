package phillipma.project2;

/**
 * The Date212Node class defines the nodes in the linked lists.
 * It contains two protected data members and two constructors.
 * The first constructor is invoked when the linked lists are initialized.
 * The second constructor is invoked whenever a new node is created to be added to the respective linked list.
 * 
 * @author Phillip Ma
 * @since 2018-11-10
 * for CS212
 * Professor Kenneth Lord
 * Lab Instructor Lin Zhao
 */

public class Date212Node {
// data members
    protected Date212 date;
    protected Date212Node next;
    
// constructors
    // empty "head" node constructor
    public Date212Node() {
        date = new Date212("00000000");
        next = null;
    }

    // regular node constructor
    public Date212Node(Date212 d) {
        date = d;
        next = null;
    }

}
