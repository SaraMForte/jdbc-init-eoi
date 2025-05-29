package jdbcinit.e01.application.exception;

public class DatabaseMetadataAccessException extends Exception {
    public DatabaseMetadataAccessException(String message) {
        super(message);
    }

    public DatabaseMetadataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}

