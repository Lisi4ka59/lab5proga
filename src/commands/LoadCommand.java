package commands;

import com.github.cliftonlabs.json_simple.*;
import models.City;
import utils.CityLinkedList;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static common.AppClient.cities;

public class LoadCommand implements Command{
    private List collection;
    public LoadCommand(List collection){

        this.collection = collection;
    }
    @Override
    public void execute() {
        // read JSON from a file
        try {
            String fileName = "cities.json";
            String path = System.getenv("CITIES_PATH");
            if (path!=null)
                fileName = path;
            Reader reader = Files.newBufferedReader(Paths.get(fileName));
            JsonObject jsonObject = (JsonObject) Jsoner.deserialize(reader);
            JsonArray jsonArray = (JsonArray)jsonObject.get("cities");
            //cities=new CityLinkedList();
            for (Object obj: jsonArray) {
                JsonObject jo = (JsonObject) obj;
                City city = new City(jo);
                collection.add(city);
            }
            System.out.println("Collection uploaded");
        } catch (JsonException e) {
            System.out.println("Can not upload collection, data in the file incorrect!");
        } catch (IOException e) {
                System.out.println("Can not upload collection, the file does not exist!");
            }
    }
}
