package services;

import models.Location;
import models.WeatherInfo;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenWeatherAPIClient implements WeatherService{
    private final String API_KEY = "c92b9d93e74f0b49c0f495ef28da8802";
    @Override
    public WeatherInfo getWeatherdata(Location location) {
        try {
            String city = location.getCityName();
            String urlString = String.format(
                    "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric",
                    city, API_KEY
            );

            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();

            // Parse JSON
            JSONObject json = new JSONObject(response.toString());

            double temp = json.getJSONObject("main").getDouble("temp");
            int humidity = json.getJSONObject("main").getInt("humidity");
            String condition = json.getJSONArray("weather").getJSONObject(0).getString("description");

            return new WeatherInfo(location, (float) temp, humidity, condition);

        } catch (Exception e) {
            System.out.println("⚠️ Error fetching weather data: " + e.getMessage());
            return new WeatherInfo(location, 0, 0, "Unavailable");
        }
    }
}
