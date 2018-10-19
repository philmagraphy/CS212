package phillipma.project1;

public class Date212 {
// data members
    private int year;
    private int month;
    private int day;

// default constructor for selection sort
    public Date212() {
        year = 1;
        month = 1;
        day = 1;
    }

// non-default constructor
    public Date212(String s) {
        year = Integer.parseInt(s.substring(0, 4));
        month = Integer.parseInt(s.substring(4, 6));
        day = Integer.parseInt(s.substring(6, 8));
    }

// format conversion: mm/dd/yyyy    
    public String toString() {
        String formatDate = String.format("%04d/%02d/%02d", year, month, day);
        return formatDate;
    }

// comparison(<) method for selection sort
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

// accessors for selection sort
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
