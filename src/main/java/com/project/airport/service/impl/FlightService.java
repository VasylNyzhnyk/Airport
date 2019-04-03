package com.project.airport.service.impl;

import com.project.airport.dao.impl.FlightDAO;
import com.project.airport.model.Flight;
import com.project.airport.service.interfaces.FlightServiceInterface;

import java.util.ArrayList;
import java.util.List;

public class FlightService implements FlightServiceInterface {

    FlightDAO flightDAO = new FlightDAO();

    @Override
    public void showAllFlights() {
        List<Flight> allFlightsList = new ArrayList<>();
        allFlightsList = flightDAO.getAllFlights();

        for (Flight flight : allFlightsList) {
            System.out.println(flight);
        }

    }

    @Override
    public void showFlightById(String flightId) {


    }
}
