package com.project.airport.utils;

import com.project.airport.model.Booking;
import com.project.airport.model.Flight;
import com.project.airport.model.Passenger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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


    public static void writeListOfPassengerToFile(List<Passenger> listOfPassengers) throws IOException {

        List<String> listOfStringPassenger = new ArrayList<>();

        for (int i = 0; i < listOfPassengers.size(); i++) {
            Passenger passenger = listOfPassengers.get(i);

            String s = passenger.getIdPasssenger() + "\t" + passenger.getFirstName()
                    + "\t" + passenger.getLastName();
            listOfStringPassenger.add(s);
            System.out.println(s);
        }
        Files.write(Paths.get("D://IdeaProjects//Airport//src//main//java//com" +
                        "//project//airport//resources//ListPassengers.txt")
                , listOfStringPassenger, StandardOpenOption.CREATE);

    }

    public static void writeListOfBookingToFile(List<Booking> listOfBookings) throws IOException {

        List<String> listOfStringBooking = new ArrayList<>();

        for (int i = 0; i < listOfBookings.size(); i++) {
            Booking booking = listOfBookings.get(i);

            String s = booking.getId() + "\t" + booking.getPassengerId()
                    + "\t" + booking.getFlightId();
            listOfStringBooking.add(s);
            System.out.println(s);
        }
        Files.write(Paths.get("D://IdeaProjects//Airport//src//main//java//com" +
                        "//project//airport//resources//ListBookings.txt")
                , listOfStringBooking, StandardOpenOption.CREATE);

    }

    public static void writeListOfFlightToFile(List<Flight> listOfFlights) throws IOException {

        List<String> listOfStringFlights = new ArrayList<>();

        for (int i = 0; i < listOfFlights.size(); i++) {
            Flight flight = listOfFlights.get(i);

            String s = flight.getId() + "\t" + flight.getCity() + "\t" + flight.getTime() + "\t" + flight.getDate() + "\t" + flight.getNumberOfSeats();
            listOfStringFlights.add(s);
            System.out.println(s);
        }
        Files.write(Paths.get("D://IdeaProjects//Airport//src//main//java//com" +
                        "//project//airport//resources//ListPlanes.txt")
                , listOfStringFlights, StandardOpenOption.CREATE);

    }
}
