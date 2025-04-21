package services;

import models.Location;
import models.WeatherInfo;

public interface WeatherService
{
    WeatherInfo getWeatherdata(final Location location);
}
