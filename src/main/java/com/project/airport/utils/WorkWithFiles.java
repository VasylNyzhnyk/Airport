package com.project.airport.utils;

import com.project.airport.model.Booking;
import com.project.airport.model.Flight;
import com.project.airport.model.Passenger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WorkWithFiles {

    public static List<Flight> generateListOfFlightsFromFile() throws IOException {

        BufferedReader bufReader = new BufferedReader(
                new FileReader(
                        "D://IdeaProjects//Airport//src//main//java//com" +
                                "//project//airport//resources//ListPlanes.txt"));
        List<String> listOfLines = new ArrayList<>();
        String line = "";

        while ((line = bufReader.readLine()) != null) {
            listOfLines.add(line);
        }
        List<Flight> flightsList = new ArrayList<>();
        for (String listOfLine : listOfLines) {
            String[] words = listOfLine.split("\t");
            flightsList.add(new Flight(words[0], words[1], words[2], words[3], words[4]));
        }

        return flightsList;
    }

    public static List<Passenger> generateListOfPassengerFromFile() throws IOException {
        BufferedReader bufReader = new BufferedReader(
                new FileReader(
                        "D://IdeaProjects//Airport//src//main//java//com" +
                                "//project//airport//resources//ListPassengers.txt"));

        List<String> listOfLines = new ArrayList<>();
        String line = "";

        while ((line = bufReader.readLine()) != null) {
            listOfLines.add(line);
        }
        List<Passenger> passengerList = new ArrayList<>();
        for (String listOfLine : listOfLines) {
            String[] words = listOfLine.split("\t");

            passengerList.add(new Passenger(words[0], words[1], words[2]));
        }

        return passengerList;
    }

    public static List<Booking> generateListOfBookingsFromFile() throws IOException {
        BufferedReader bufReader = new BufferedReader(
                new FileReader(
                        "D://IdeaProjects//Airport//src//main//java//com" +
                                "//project//airport//resources//ListBookings.txt"));

        List<String> listOfLines = new ArrayList<>();
        String line = "";

        while ((line = bufReader.readLine()) != null) {
            listOfLines.add(line);
        }
        List<Booking> bookingsList = new ArrayList<>();
        for (String listOfLine : listOfLines) {
            String[] words = listOfLine.split("\t");

            bookingsList.add(new Booking(words[0], words[1], words[2]));
        }
        return bookingsList;
    }

}
