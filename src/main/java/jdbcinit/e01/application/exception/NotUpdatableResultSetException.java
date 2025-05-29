package jdbcinit.e01.application.exception;

public class NotUpdatableResultSetException extends Exception {
    public NotUpdatableResultSetException(String message) {
        super(message);
    }

    public NotUpdatableResultSetException(String message, Throwable cause) {
        super(message, cause);
    }
}
