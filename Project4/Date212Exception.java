package phillipma.project4;

/**
 * The Date212Exception class simply extends the IllegalArgumentException class.
 * It holds four constructors for extensibility.
 * 
 * @author Phillip Ma
 * @since 2018-11-21
 * for CS212
 * Professor Kenneth Lord
 * Lab Instructor Lin Zhao
 */

public class Date212Exception extends IllegalArgumentException {
// constructors
    public Date212Exception() {
        super();
    }
    
    public Date212Exception(String message) {
        super(message);
    }
    
    public Date212Exception(Throwable cause) {
        super(cause);
    }

    public Date212Exception(String message, Throwable cause) {
        super(message, cause);
    }
}
