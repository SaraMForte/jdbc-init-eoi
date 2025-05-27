package jdbcinit.e01;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBBDD implements Closeable {
    // Parameters of database connection
    private static final String URL = "jdbc:postgresql://localhost:5432/jardineria";
    private static final String USER = "sara";
    private static final String PASSWORD = "sara";

    private Connection connection;

    private Connection createConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new SQLException("Cant not connect to PostgreSQL database", e);
        }
    }

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = createConnection();
        }
        return connection;
    }

    @Override
    public void close() throws IOException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
