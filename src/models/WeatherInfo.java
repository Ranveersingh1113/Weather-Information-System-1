package models;

public class WeatherInfo {
    private final Location location; // ← Your question
    private final double temprature;
    private final double humidity;
    private final String condition;

    public WeatherInfo(Location location, double temprature, double humidity, String condition){
        this.location=location;
        this.temprature=temprature;
        this.humidity=humidity;
        this.condition=condition;
    }

    public double getTemprature(){
        return temprature;
    }
    public double getHumidity(){
        return humidity;
    }
    public String getCondition(){
        return condition;
    }
    public Location getLocation(){
        return location;
    }

    public String toString()
    {
        return "Temprature is"+temprature+"\nHumidity is "+humidity+"\nCondition is "+condition+".";
    }

}
