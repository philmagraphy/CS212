package phillipma.project4;

/**
 * The Date212List class is the abstract base class for linked lists.
 * It contains three protected data members, a constructor, two methods - append and clear.
 * 
 * The constructor invokes the empty node constructor of Date212Node when initializing the list.
 * It also sets the first and last elements as the empty "head" node.
 * 
 * The method append updates the length and also sets the new node as the last element.
 * 
 * The method clear instantiates a new empty Date212Node and sets the first and last references to it.
 * This orphans the existing nodes in the list for garbage collection, effectively resetting the list.
 * 
 * @author Phillip Ma
 * @since 2018-11-21
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

// clear
    public void clear() {
        Date212Node newdn = new Date212Node();
        first = newdn;
        last = newdn;
        length = 0;
    }
}
