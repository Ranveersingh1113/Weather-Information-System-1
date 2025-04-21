package models;

public class Location {
    private final String cityName;


    public Location(String cityName){
        this.cityName=cityName;


    }

    public String getCityName(){
        return cityName;
    }

//    public void setCityName(String cityName) {
//        this.cityName = cityName;
//    }
//    public void setLatitude(double latitude) {
//        this.latitude = latitude;
//    }
//    public void setLongitude(double longitude) {
//        this.longitude = longitude;
//    }

//    public String toString()
//    {
//        return "City:"+cityName+" has latitude "+latitude+" and longitude "+longitude+".";
//    }
}
