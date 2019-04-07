package com.project.airport.dao.interfaces;

import com.project.airport.model.Flight;

import java.util.List;

public interface FlightDAOInterface {

    List<Flight> getAllFlights();

    Flight getFlightById (String flightId);

    List<Flight> findFlightsForBooking(String city, String date, String quantityOfTickets);



}
