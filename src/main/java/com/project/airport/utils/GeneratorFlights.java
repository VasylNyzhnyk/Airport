package com.project.airport.utils;

import com.project.airport.model.Flight;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeneratorFlights {
    String id;
    String city;
    String time;
    String date;
    String numberOfSeats;

    public static List<String> randomFlightList() {
        List<String> listCity = new ArrayList<>();
        listCity.add("Lviv");
        listCity.add("Warshawa");
        listCity.add("Krakow");
        listCity.add("Poznan");
        listCity.add("Nica");
        listCity.add("Vena");
        listCity.add("Lisbon");
        listCity.add("Praga");
        listCity.add("London");
        return listCity;
    }

    public static int rnd(int max) {
        return (int) (Math.random() * max);
    }

    public static void main(String[] args) throws IOException {
        List<String> listTime = new ArrayList<>();
        listTime.add("1:50");
        listTime.add("2:10");
        listTime.add("3:00");
        listTime.add("3:10");
        listTime.add("2:30");
        listTime.add("4:00");
        int f = (int) (Math.random() * 6);
        List<String> listCity = randomFlightList();

        List<String> listDay = new ArrayList<>();
        for (int i = 1; i <= 28; i++) {
            if (i < 10) {
                listDay.add("0" + i);
            } else {
                listDay.add(String.valueOf(i));
            }
        }

        List<String> listMonth = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            if (i < 10) {
                listMonth.add("0" + i);
            } else {
                listMonth.add(String.valueOf(i));
            }
        }

        List<String> listNumberOfSeats = new ArrayList<>();
        listNumberOfSeats.add("79");
        listNumberOfSeats.add("20");
        listNumberOfSeats.add("10");
        listNumberOfSeats.add("12");
        listNumberOfSeats.add("45");
        listNumberOfSeats.add("9");
        List<String> listFlight = new ArrayList<>();
        int j = 1;
        for (int i = 0; i <= 1000; i++) {
            String s = j + "\t" + listCity.get(rnd(9)) + "\t" + listTime.get(rnd(6))
                    + "\t" + listDay.get(rnd(28)) + "." + listMonth.get(rnd(12)) + "\t" + listNumberOfSeats.get(rnd(6));
            j += 1;
            listFlight.add(s);
        }
        Files.write(Paths.get("D://IdeaProjects//Airport//src//main//java//com" +
                "//project//airport//ListPlanes.txt"), listFlight, StandardOpenOption.CREATE);
    }
}
