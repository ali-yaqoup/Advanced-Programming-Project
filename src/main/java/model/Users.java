package model;

import org.mindrot.jbcrypt.BCrypt;
import java.sql.*;

public class Users {
    private String firstName;
    private String lastName;
    private String email;

    private String passwordHash;
    private String role;

    // Database credentials are read from environment variables so that no
    // secret is ever committed to source control.
    //
    // Set these before running the application:
    //   export DB_URL="jdbc:mysql://localhost:3306/UserRegistration"
    //   export DB_USER="root"
    //   export DB_PASSWORD="your_local_mysql_password"
    //
    // DB_URL and DB_USER fall back to local development defaults.
    // DB_PASSWORD has no default on purpose — see openConnection() below.
    private static final String DB_URL = System.getenv()
            .getOrDefault("DB_URL", "jdbc:mysql://localhost:3306/UserRegistration");
    private static final String DB_USER = System.getenv()
            .getOrDefault("DB_USER", "root");
    private static final String DB_PASSWORD = System.getenv("DB_PASSWORD");

    /**
     * Opens a database connection using credentials from the environment.
     * Fails loudly with an actionable message when DB_PASSWORD is missing,
     * rather than silently attempting to connect with a null password.
     */
    private static Connection openConnection() throws SQLException {
        if (DB_PASSWORD == null || DB_PASSWORD.isEmpty()) {
            throw new SQLException(
                    "DB_PASSWORD environment variable is not set. "
                            + "Set it before running the application, for example:\n"
                            + "  export DB_PASSWORD=your_local_mysql_password");
        }
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public Users(String firstName, String lastName, String email, String password, String selectedRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
        this.role = selectedRole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public static boolean isEmailInDatabase(String email) {
        String query = "SELECT COUNT(*) FROM users WHERE email = ?";

        try (Connection connection = openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next() && resultSet.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean updatePassword(String email, String newPassword) {
        String updateQuery = "UPDATE users SET password_hash = ? WHERE email = ?";

        try (Connection connection = openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, email);
            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean save() {
        String insertQuery = "INSERT INTO Users (first_name, last_name, email, password_hash, role) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, this.firstName);
            preparedStatement.setString(2, this.lastName);
            preparedStatement.setString(3, this.email);
            preparedStatement.setString(4, this.passwordHash);
            preparedStatement.setString(5, this.role);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
