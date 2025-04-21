package services;

import models.Location;
import models.WeatherInfo;

public class SimpleWeatherService implements WeatherService {
    @Override
    public WeatherInfo getWeatherdata(final Location location) {
        return new WeatherInfo(location,45.80,66,"Scorching Hot");
    }
}
