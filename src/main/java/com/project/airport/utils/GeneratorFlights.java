package com.project.airport.utils;

import com.project.airport.model.Flight;

import java.util.ArrayList;
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

    public static void main(String[] args) {
        List<String> listTime = new ArrayList<>();
        listTime.add("1:50");
        listTime.add("2:10");
        listTime.add("3:00");
        listTime.add("3:10");
        listTime.add("2:30");
        listTime.add("4:00");
        int f = (int) (Math.random()*6);
        List<String> listCity = randomFlightList();

        List<String> listData = new ArrayList<>();
        listData.add("10.04");
        listData.add("11.04");
        listData.add("10.04");
        listData.add("12.04");

        List<String> listNumberOfSeats = new ArrayList<>();
        listNumberOfSeats.add("79");
        listNumberOfSeats.add("20");
        listNumberOfSeats.add("10");
        listNumberOfSeats.add("12");
        listNumberOfSeats.add("45");
        listNumberOfSeats.add("9");
        List<String> listFlight = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            String s = listCity.get(rnd(9)) + "   " + listTime.get(rnd(6))
                    + "    " + listData.get(rnd(4)) + "  " + listNumberOfSeats.get(rnd(6));
            listFlight.add(s);
        }
        for (String s : listFlight) {
            System.out.println(s);
        }

    }

}
