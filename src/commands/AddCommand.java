package commands;


import common.Main;
import models.*;

import java.util.Date;
import java.util.Scanner;

import static common.CityReader.inputCoordinates;

public class AddCommand implements Command {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        Coordinates coordinates = inputCoordinates();
        System.out.print("Choose city climate\n1. TROPICAL_SAVANNA\n" +
                "2. HUMIDCONTINENTAL\n" +
                "3. OCEANIC\n" +
                "4. STEPPE\nEnter a number: ");
        int climateNumber = Integer.valueOf(scanner.nextLine());
        Climate climate;
        if (climateNumber == 1) {
            climate = Climate.TROPICAL_SAVANNA;
        } else if (climateNumber == 2) {
            climate = Climate.HUMIDCONTINENTAL;
        } else if (climateNumber == 3) {
            climate = Climate.OCEANIC;
        } else {
            climate = Climate.STEPPE;
        }

        System.out.print("Choose city government\n1. ANARCHY\n" +
                "2. COMMUNISM\n" +
                "3. MERITOCRACY\n" +
                "4. ETHNOCRACY\nEnter a number: ");
        int governmentNumber = Integer.valueOf(scanner.nextLine());
        Government government;
        if (governmentNumber == 1) {
            government = Government.ANARCHY;
        } else if (governmentNumber == 2) {
            government = Government.COMMUNISM;
        } else if (governmentNumber == 3) {
            government = Government.MERITOCRACY;
        } else {
            government = Government.ETHNOCRACY;
        }

        System.out.print("Choose city standard of living\n1. ULTRA HIGH\n" +
                "2. HIGH\n" +
                "3. VERY LOW\n" +
                "4. ULTRA LOW\n" +
                "5. NIGHTMARE\nEnter a number: ");
        int standardOfLivingNumber = Integer.valueOf(scanner.nextLine());
        StandardOfLiving standardOfLiving;
        if (standardOfLivingNumber == 1) {
            standardOfLiving = StandardOfLiving.ULTRA_HIGH;
        } else if (standardOfLivingNumber == 2) {
            standardOfLiving = StandardOfLiving.HIGH;
        } else if (standardOfLivingNumber == 3) {
            standardOfLiving = StandardOfLiving.VERY_LOW;
        } else if (standardOfLivingNumber == 4) {
            standardOfLiving = StandardOfLiving.ULTRA_LOW;
        } else if (standardOfLivingNumber == 5) {
            standardOfLiving = StandardOfLiving.NIGHTMARE;
        } else {
            standardOfLiving = null;
        }

        System.out.print("City governor\nEnter governor age: ");
        long age = Long.valueOf(scanner.nextLine());
        System.out.print("Governor birthday\nEnter year: ");
        int year = Integer.valueOf(scanner.nextLine());
        System.out.print("Enter month: ");
        int month = Integer.valueOf(scanner.nextLine());
        System.out.print("Enter day: ");
        int day = Integer.valueOf(scanner.nextLine());
        Date birthday = new Date(year, month, day);
        Human governor = new Human(age, birthday);

        System.out.println("Congratulations! City added to collection");
        City city = new City("P", coordinates, 233421412l, 13, 123, climate, government, standardOfLiving, governor);
        Main.cities.add(city);
    }
}
