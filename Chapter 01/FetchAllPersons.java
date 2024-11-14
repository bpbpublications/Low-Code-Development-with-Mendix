import java.sql.*;

public class FetchAllPersons {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:your_database_type://localhost:port/database_name";
        String user = "username";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // Create a statement
            Statement stmt = conn.createStatement();
            // SQL query to fetch all rows from the "person" table
            String query = "SELECT * FROM person";
            // Execute the query and get the result set
            ResultSet resultSet = stmt.executeQuery(query);
            // Process the result set and print the data
            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                System.out.println(First Name: " + firstName +
                                   ", Last Name: " + lastName + ");
            }
            // Close the result set and statement
            resultSet.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
} 