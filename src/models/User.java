package models;
import services.WeatherService;

public class User {
    private final String Username;
    private String Email;
    public Location location;

    public User(String Username,String Email, Location location)
    {
        this.Email=Email;
        this.Username=Username;
        this.location=location;
    }

    public void viewWeather(WeatherService service)
    {
        WeatherInfo information = service.getWeatherdata(location);
        System.out.println("models.Location: "+information.getLocation());
        System.out.println("Temperature: "+information.getTemprature());
        System.out.println("Humidity: "+information.getHumidity());
        System.out.println("Condition: "+information.getCondition());
    }
    public void setFavourite(Location location)
    {
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
