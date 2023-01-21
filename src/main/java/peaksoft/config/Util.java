package peaksoft.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Author
 * Eliza Ashyrbaeva
 * Don't give up!
 **/
public class Util {
    private final static String url = "jdbc:postgresql://localhost:5432/postgres";
    private final static String userName = "postgres";
    private final static String password = "22661030eliz";


    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
