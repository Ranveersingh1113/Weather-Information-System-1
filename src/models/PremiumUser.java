package models;
import services.WeatherService;

import java.util.ArrayList;
import java.util.List;

public class PremiumUser extends User {
    private final List<Location> favouriteLocations;
    public PremiumUser(String Username, String Email, Location location) {
        super(Username, Email, location);
        this.favouriteLocations = new ArrayList<>();

    }

    @Override
    public void setFavourite(Location location) {
        super.setFavourite(location);

        for (Location loc : favouriteLocations) {
            if (loc.getCityName().equalsIgnoreCase(location.getCityName())) {
                System.out.println("⚠️ " + location.getCityName() + " is already in your favourite list.");
                return;
            }
        }
        favouriteLocations.add(location);
        System.out.println("✅ "+location.getCityName()+" added to your Favourite list.");
    }

    public void viewWeather(WeatherService service)
    {
        WeatherInfo information = service.getWeatherdata(location);
        System.out.println("Welcome to the Weather App:\nYou are the Premium User");
        System.out.println("Location: "+information.getLocation().getCityName());
        System.out.println("Temperature: "+information.getTemprature());
        System.out.println("Humidity: "+information.getHumidity());
        System.out.println("Condition: "+information.getCondition());


        if(!favouriteLocations.isEmpty()){
            System.out.println("\nFetching Weather for favourite locations....");
            for (Location loc : favouriteLocations) {
                WeatherInfo favInfo = service.getWeatherdata(loc);
                System.out.println("Location: " + favInfo.getLocation().getCityName());
                System.out.println("Temperature: " + favInfo.getTemprature());
                System.out.println("Humidity: " + favInfo.getHumidity());
                System.out.println("Condition: " + favInfo.getCondition());
            }
        }
    }

}

