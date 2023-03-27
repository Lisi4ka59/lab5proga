package commands;

import com.github.cliftonlabs.json_simple.Jsoner;
import models.*;


import java.io.StringWriter;
import java.util.Date;


public class SaveCommand implements Command{
    @Override
    public void execute() {
        Coordinates coordinates = new Coordinates(34, 23f);
        Long age = 34L;
        Date birthday = new Date(1976, 6, 11);
        Human governor = new Human(age, birthday);
        City city = new City("p", coordinates, 34l, 3, 555, Climate.OCEANIC, Government.ANARCHY, StandardOfLiving.HIGH, governor);

// Объекты Java в строку JSON
        String json = Jsoner.serialize(city);

// красивая печать
        json = Jsoner.prettyPrint(json);

        System.out.println(json);

    }
}
