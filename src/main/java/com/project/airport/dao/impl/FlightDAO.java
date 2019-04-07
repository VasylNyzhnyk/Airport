package com.project.airport.dao.impl;

import com.project.airport.dao.interfaces.FlightDAOInterface;
import com.project.airport.model.Flight;
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
            if(flight.getId().equals(flightId)){
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
                    && Integer.parseInt(flight.getNumberOfSeats())>= Integer.parseInt(quantityOfTickets)){
               resultFlights.add(flight);

            }
        }
        return resultFlights;
    }


}
