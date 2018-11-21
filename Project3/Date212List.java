package phillipma.project3;

/**
 * The Date212List class is the abstract base class for the two other linked list classes.
 * It contains three protected data members, a constructor, and a method to add nodes to lists.
 * The constructor invokes the empty node constructor of Date212Node when initializing the list.
 * It also sets the first and last elements as the empty "head" node.
 * The method append updates the length and also sets the new node as the last element.
 * 
 * @author Phillip Ma
 * @since 2018-11-20
 * for CS212
 * Professor Kenneth Lord
 * Lab Instructor Lin Zhao
 */

public abstract class Date212List {
// data members
    protected Date212Node first;
    protected Date212Node last;
    protected int length;
    
// constructor
    public Date212List() {
        // instantiation of the list starts with an empty "head" node
        Date212Node dn = new Date212Node();
        first = dn;
        last = dn;
        length = 0;
    }
    
// append
    public void append(Date212 d) {
        Date212Node newdn = new Date212Node(d);
        last.next = newdn;
        last = newdn;
        length++;
    }

}
