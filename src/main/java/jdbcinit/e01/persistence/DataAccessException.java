package jdbcinit.e01.persistence;

public class DataAccessException extends Exception {
    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
