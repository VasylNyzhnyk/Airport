package com.project.airport.dao.impl;

import com.project.airport.dao.interfaces.FlightDAOInterface;
import com.project.airport.model.Flight;
import com.project.airport.model.Passenger;
import com.project.airport.utils.WorkWithFiles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO implements FlightDAOInterface {

    @Override
    public List<Flight> getAllFlights() {
        List<Flight> allFlightsList = new ArrayList<>();
        try {
            allFlightsList = WorkWithFiles.generateListOfFlightsFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allFlightsList;
    }

    @Override
    public Flight getFlightById(String flightId) {
        Flight resultFlight = null;
        List<Flight> allFlights = getAllFlights();

        for (Flight flight : allFlights) {
            if (flight.getId().equals(flightId)) {
                resultFlight = flight;
            }
        }
        return resultFlight;
    }

    @Override
    public List<Flight> findFlightsForBooking(String city, String date, String quantityOfTickets) {
        List<Flight> resultFlights = new ArrayList<>();
        List<Flight> allFlights = getAllFlights();

        for (Flight flight : allFlights) {
            if (flight.getCity().equals(city)
                    && flight.getDate().equals(date)
                    && Integer.parseInt(flight.getNumberOfSeats())
                    >= Integer.parseInt(quantityOfTickets)) {
                resultFlights.add(flight);

            }
        }
        return resultFlights;
    }

    @Override
    public List<Flight> flightBooking(String firstName, String lastName, String numberOfSeats) {
        return null;
    }



    //TODO
    @Override
    public List<String> addListOfFlights(List<Flight> flights) {

        List<String> newFlightsIds = new ArrayList<>();



        List<Flight> oldAllFligntList = getAllFlights();
        List<Flight> newAllFlightList = new ArrayList<>();


        int oldAllFlightListSize = oldAllFligntList.size();
        long lastId = 0;

        if (oldAllFlightListSize== 0) {
            System.out.println("There was no passengers in the file");
        } else {
            System.out.println("There was " + oldAllFlightListSize + " passengers in the file");
            newAllFlightList.addAll(oldAllFligntList);
            lastId = Long.parseLong(oldAllFligntList.get(oldAllFlightListSize - 1).getId());
        }


        System.out.println("lastId =" + lastId);

        for (int i = 0; i < flights.size(); i++) {
            Flight newFlight = flights.get(i);
            String newFlightId = String.valueOf((lastId + 1 + i));
            newFlight.setId(newFlightId);
            newFlightsIds.add(newFlightId);
            newAllFlightList.add(newFlight);
        }


        try {
            WorkWithFiles.writeListOfFlightToFile(newAllFlightList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return newFlightsIds;
    }

  /*  @Override
    public List<Flight> flightBooking(String firstName, String lastName) {
        List<Flight> resultBookingFlight = new ArrayList<>();

        return resultBookingFlight;
    }*/


}
