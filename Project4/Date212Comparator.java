package phillipma.project4;

import java.util.Comparator;

/**
 * The Date212Comparator class defines the comparator used to create the TreeMap in Date212GUI.
 * It uses Date212's compareTo method for comparison.
 * 
 * @author Phillip Ma
 * @since 2018-11-21
 * for CS212
 * Professor Kenneth Lord
 * Lab Instructor Lin Zhao
 */

public class Date212Comparator implements Comparator<Date212> {
    public int compare(Date212 a, Date212 b) {
        //call unary version of aLessThanb in class Date212.
        return a.compareTo(b);
    }
}
