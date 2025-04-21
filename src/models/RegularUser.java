package models;
import services.WeatherService;

public class RegularUser extends User {
    public RegularUser(String Username, String Email, Location location) {
        super(Username, Email, location);
    }

    public void viewWeather(WeatherService service)
    {
        WeatherInfo information = service.getWeatherdata(location);
        System.out.println("Welcome to the Weather App:\nYou are the Regular User");
        System.out.println("Location: "+information.getLocation().getCityName());
        System.out.println("Temperature: "+information.getTemprature());
        System.out.println("Humidity: "+information.getHumidity());
        System.out.println("Condition: "+information.getCondition());
        System.out.println("\n");
    }
}
