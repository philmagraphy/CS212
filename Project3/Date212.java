package phillipma.project3;

/**
 * The Date212 class defines the objects that are created from the input file data.
 *
 * @author Phillip Ma
 * @since 2018-11-20
 * for CS212
 * Professor Kenneth Lord
 * Lab Instructor Lin Zhao
 */

public class Date212 {
// data members
    private int year;
    private int month;
    private int day;

    /**
     * Constructor for Date212 objects.
     * 
     * The month and day are parsed into temporary integer values.
     * If the month and day are valid, the object is initialized with a year, month, and day.
     * If not valid, a Date212Exception is thrown.
     * If the string is not numerical, the NumberFormatException will be caught.
     * If the string is less than the needed 8 digits, the IndexOutOfBoundsException will be caught.
     */

// non-default constructor
    public Date212(String s) {
        try {
            int tempMonth = Integer.parseInt(s.substring(4, 6));
            int tempDay = Integer.parseInt(s.substring(6, 8));
            
            if(valiDATEcheck(tempMonth, tempDay)) {
                year = Integer.parseInt(s.substring(0, 4));
                month = Integer.parseInt(s.substring(4, 6));
                day = Integer.parseInt(s.substring(6, 8));
            }
            else throw new Date212Exception(s);
        }
        catch(IndexOutOfBoundsException ibe) {
            System.out.println("String is too short.");
        }
        catch(NumberFormatException nfe) {
            System.out.println("Not a parseable numerical string.");
        }
        catch(Date212Exception de) {
            System.out.println(de.getMessage() + " is an invalid date.");
        }
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

/**
 * These two methods check whether a Date212 object's month and day are valid values.
 * The first one, valiDATEcheck, is called in the constructor.
 * The second, isValid, is for invocation when an object needs to be verified as non-empty.
 * 
 * The general logic is the following:
 * Months cannot fall outside of the 1-12 range.
 * 
 * Day values are checked according to the month:
 * 
 * February has 28 or 29 days depending on if its a leap year. Both are accounted for.
 * NOTE that leap years are not determined. This program assumes if 29 is entered for a February date, that a leap year occurred.
 * 
 * April, June, September, and November have 30 days.
 * The other months have 31 days.
 */
     private static boolean valiDATEcheck(int month, int day) {
         if(month < 1 || month > 12) return false;
         if(month == 2) return (day >= 1 && day <= 29);
         if(month == 4 || month == 6 || month == 9 || month == 11) return (day >= 1 && day <= 30);
         else return (day >= 1 && day <= 31);
     }

     public boolean isValid() {
         if(valiDATEcheck(this.month, this.day)) return true;
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
