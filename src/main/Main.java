package main;
import models.Location;
import models.PremiumUser;
import models.RegularUser;
import models.User;
import services.SimpleWeatherService;
import services.OpenWeatherAPIClient;
import services.WeatherService;

import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        WeatherService service = new OpenWeatherAPIClient();

         //accepting user inputs
        System.out.println("Enter the Username: ");
        String username=scanner.nextLine();

        System.out.println("Enter Your Email: ");
        String email=scanner.nextLine();

        System.out.println("Enter the User Type(Regular/Premium): ");
        String userType=scanner.nextLine();

        System.out.println("Enter the Location Details");
        System.out.println("Enter the City name:");
        String city=scanner.nextLine();

//        System.out.println("Enter the Latitude");
//        double latitude=scanner.nextFloat();
//
//        System.out.println("Enter the Longitude");
//        double longitude=scanner.nextFloat();
//        scanner.nextLine();

        Location location = new Location(city);
        User user;
        if (userType.equalsIgnoreCase("Premium")){
            user = new PremiumUser(username,email,location);
        } else{
            user = new RegularUser(username,email,location);
        }
        user.viewWeather(service);
        System.out.println("Hope you have a nice day!");

        if(user instanceof PremiumUser){
            PremiumUser premium = (PremiumUser) user;

            System.out.print("Do you want to add a favourite location? (yes/no): ");
            String answer = scanner.nextLine();

            while(answer.equalsIgnoreCase("yes")){
                System.out.println("Enter favourite city: ");
                String favCity = scanner.nextLine();

                Location fav = new Location(favCity);
                premium.setFavourite(fav);

                System.out.println("Add another City as favourite:(yes/no): ");
                answer=scanner.nextLine();
            }
            premium.viewWeather(service);
            System.out.println("\n");
            System.out.println("Hope you have a nice day!");
        }
        scanner.close();
    }
}
