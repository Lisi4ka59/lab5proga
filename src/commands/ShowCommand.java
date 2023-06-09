package commands;

import models.City;
import java.util.List;

public class ShowCommand implements Command{
    private final List<City> collection;
    public ShowCommand(List<City> collection){

        this.collection = collection;
    }
    @Override
    public void execute() {
        if (collection.isEmpty()) {
            System.out.println("No cities in collection");
        }
        else {
            for (City city : collection) {
                System.out.println("\n" + city.toString());
            }
        }
    }
}
