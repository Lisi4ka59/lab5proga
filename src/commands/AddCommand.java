package commands;

import models.*;
import utils.CityComparator;

import java.util.Date;
import java.util.List;

import static utils.Checker.checkDate;
import static utils.CityLinkedList.idRepeat;
import static utils.CityLinkedList.isSave;
import static utils.CityReader.*;

/**
 * add command, use to make a city
 * @autor Mikhail Nachinkin
 * @version 1.0
 */
public class AddCommand implements Command {
    private final List collection;
    public AddCommand(List collection){

        this.collection = collection;
    }
    @Override
    public void execute() {
        City city = getCity();
        collection.add(city);
        System.out.println("Congratulations! City added to collection");
        collection.sort(new CityComparator());
        isSave = false;
    }
    @Override
    public void execute(String args) {
        City city = getCityArgs(args);
        collection.add(city);
        idRepeat+=1;
        System.out.println("Congratulations! City added to collection");
        collection.sort(new CityComparator());
        isSave = false;
    }
    /**
     * add command, use to make a city
     * @autor Mikhail Nachinkin
     */
    public static City getCity() {
        String name = inputName();
        Coordinates coordinates = inputCoordinates();
        double area = inputArea();
        long population = inputPopulation();
        int metersAboveSeaLevel = inputMetersAboveSeaLevel();
        Climate climate = inputClimate();
        Government government = inputGovernment();
        StandardOfLiving standardOfLiving = inputStandardOfLiving();
        Human governor = inputGovernor();
        return new City(name, coordinates, population, area, metersAboveSeaLevel, climate, government, standardOfLiving, governor);
    }
    public static City getCityArgs(String args){
        String[] cityArgs = args.trim().split(",");
        if (!(cityArgs.length == 11)){
            throw new IllegalArgumentException();
        }
        String name = cityArgs[0];
        double x = Double.valueOf(cityArgs[1]);
        float y = Float.valueOf(cityArgs[2]);
        double area = Double.valueOf(cityArgs[3]);
        long population = Long.parseLong(cityArgs[4]);
        int metersAboveSeaLevel = Integer.valueOf(cityArgs[5]);
        Climate climate = Climate.fromInt(Integer.valueOf(cityArgs[6]));
        Government government = null;
        if (!"null".equals(cityArgs[7])){
            government = Government.fromInt(Integer.valueOf(cityArgs[7]));
        }
        StandardOfLiving standardOfLiving = null;
        if (!"null".equals(cityArgs[8])){
            standardOfLiving = StandardOfLiving.fromInt(Integer.valueOf(cityArgs[8]));
        }
        boolean testAge = false;
        long age = 1;
        if (!"null".equals(cityArgs[9])){
            age = Long.parseLong(cityArgs[9]);
            testAge = true;
        }
        boolean testBirthday = false;
        Date birthday = checkDate("1.1.1");
        if (!"null".equals(cityArgs[10])){
            birthday = checkDate(cityArgs[10]);
            testBirthday = true;
        }
        if (x<=-25 || area <= 0 || population <= 0 || metersAboveSeaLevel>8849 || metersAboveSeaLevel<-432 ||age <=0){
            throw new IllegalArgumentException();
        }
        Coordinates coordinates = new Coordinates(x, y);
        Human governor = null;
        if (testAge && testBirthday){
            governor = new Human(age, birthday);
        }
        return new City(name, coordinates, population, area, metersAboveSeaLevel, climate, government, standardOfLiving, governor);
    }
}