package examwork4month;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "km-jm-kam-am1";

    public java.sql.Connection connect() {
        java.sql.Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected succesfully.");
            System.out.println("Connection closed");
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return connection;
    }
}
