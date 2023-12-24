package repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataManager {
    private static final String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres?characterEncoding=UTF-8";
    private static final String user = "postgres";
    private static final String password = "admin";
    
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Ошибка загрузки драйвера PostgreSQL JDBC.", e);
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(jdbcUrl, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка соединения с бд.", e);
        }
    }
}
