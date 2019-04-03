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
        return null;
    }
}
