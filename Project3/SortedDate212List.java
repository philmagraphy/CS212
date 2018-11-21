package phillipma.project3;

/**
 * The SortedDate212List class is one of the two linked list classes used.
 * The only functional addition the method add.
 * Method add iterates through the sorted linked list to determine where to place a new node.
 * It uses the method aLessThanB from the Date212 class to check whether the new node's date is older than a given node in the list.
 * If the new node is found to be less than an existing node, the list is updated with the new node inserted in the place of the existing node and relations updated.
 * If the new node is not older than any of the existing nodes, the base class append is called to add the new node to the end of the list.
 * 
 * @author Phillip Ma
 * @since 2018-11-20
 * for CS212
 * Professor Kenneth Lord
 * Lab Instructor Lin Zhao
 */

public class SortedDate212List extends Date212List {
 // constructor
    public SortedDate212List() {
        super();
    }
    
// add
    public void add(Date212 d) {
        Date212Node iterFirst = first;
        Date212Node iterSecond = first.next;
        // check if the new date is older than the 2nd iterator date and insert if so
        while(iterSecond != null) {
            Date212Node newdn = new Date212Node(d);
            if(Date212.aLessThanb(newdn.date, iterSecond.date)) {
                newdn.next = iterSecond;
                iterFirst.next = newdn;
                length++;
                return;
            }
            iterFirst = iterSecond;
            iterSecond = iterSecond.next;
        }
        // else add new node to the end.
        super.append(d);
    }

}