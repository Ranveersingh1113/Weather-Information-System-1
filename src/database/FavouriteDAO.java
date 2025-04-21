package database;

import exceptions.DuplicateFavouriteException;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FavouriteDAO {
    public void addFavourite(int userId, String city) throws DuplicateFavouriteException {

        List<String> existing = getFavouritesByUserId(userId);
        if (existing.contains(city)) {
            // 2) If it’s already there, bail out
            throw new DuplicateFavouriteException(city);
        }
        String query = "INSERT INTO favourites (user_id, city) VALUES (?, ?)";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            stmt.setString(2, city);
            stmt.executeUpdate();

            System.out.println("📍 Favourite location saved: " + city);
        } catch (SQLException e) {
            System.out.println("❌ Error saving favourite: " + e.getMessage());
        }
    }
    public List<String> getFavouritesByUserId(int userId) {
        List<String> cities = new ArrayList<>();
        String query = "SELECT city FROM favourites WHERE user_id = ?";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                cities.add(rs.getString("city"));
            }

        } catch (SQLException e) {
            System.out.println("❌ Error fetching favourites: " + e.getMessage());
        }

        return cities;
    }
}
