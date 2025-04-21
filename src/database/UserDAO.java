package database;

import models.User;

import java.sql.*;


public class UserDAO {
    public int saveUser(User user, String userType) {
        String query = "INSERT INTO users (username, email, user_type) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, userType);

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int userId = rs.getInt(1);
                System.out.println("✅ User saved with ID: " + userId);
                return userId;
            }
        } catch (SQLException e) {
            System.out.println("❌ Error saving user: " + e.getMessage());
        }
        return -1;
    }

}
