package database;


import models.WeatherInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WeatherLogDAO {
    public void logWeather(int userId, WeatherInfo info) {
        String query = "INSERT INTO weather_logs (user_id, city, temperature, humidity, condition) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            stmt.setString(2, info.getLocation().getCityName());
            stmt.setFloat(3, info.getTemprature());
            stmt.setInt(4, info.getHumidity());
            stmt.setString(5, info.getCondition());

            stmt.executeUpdate();
            System.out.println("🌦 Weather log saved for " + info.getLocation().getCityName());
        } catch (SQLException e) {
            System.out.println("❌ Error saving weather log: " + e.getMessage());
        }
    }
}
