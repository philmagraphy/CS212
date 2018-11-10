package phillipma.project2;

/**
 * The Date212 class defines the objects that are created from the input file data.
 * It also defines some methods to get internal data members, compare objects, and convert to strings of type mm/dd/yyyy.
 * 
 * @author Phillip Ma
 * @since 2018-11-10
 * for CS212
 * Professor Kenneth Lord
 * Lab Instructor Lin Zhao
 */

public class Date212 {
// data members
    private int year;
    private int month;
    private int day;

// non-default constructor
    public Date212(String s) {
        year = Integer.parseInt(s.substring(0, 4));
        month = Integer.parseInt(s.substring(4, 6));
        day = Integer.parseInt(s.substring(6, 8));
    }

/**
 * This method takes the three data members and returns them as a string of the form mm/dd/yyyy
 * 
 * If a data member has less characters than desired, they are padded on the left with zeros.
 * e.g. Years: 191 becomes 0191, 2011 stays 2011.
 * e.g. Months: 7 becomes 07, 12 stays 12.
 * e.g. Days: 4 becomes 04, 30 stays 30.
 */
    public String toString() {
        String formatDate = String.format("%04d/%02d/%02d", year, month, day);
        return formatDate;
    }

/**
 * Comparison(equivalent to <) method for sorting.
 * Specifically determines if Date212 a is an older date than Date212 b.
 * 
 * First compares years, and returns true if a < b.
 * Second, if the years are the same, compares months.
 * Third, if the years and months are the same, compares days.
 * 
 * If all 3 checks do not return anything, then returns false since a is not less than b in any part of the date. 
 */
    public static boolean aLessThanb(Date212 a, Date212 b) {

            // if Date a has an older year, return a;
            if(a.year < b.year) return true;

            // else if Date a has the same year but an older month, return a.
            else if(a.year == b.year && a.month < b.month) return true;

            // else if Date a has the same year, month but an older day, return a.
            else if(a.year == b.year && a.month == b.month && a.day < b.day) return true;

            // else return b.
            else return false;
    }

// accessors
    public int getYear() {
        return year;
    }
    
    public int getMonth() {
        return month;
    }
    
    public int getDay() {
        return day;
    }
}
