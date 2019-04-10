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
        Flight flight = flightDAO.getFlightById(flightId);
        if (flight != null) {
            System.out.println(flight);
        } else {
            System.out.println("No such flight!");
        }
    }

    @Override
    public List<Flight> findFlightsForBooking(String city, String date, String quantityOfTickets) {
        List<Flight> resultFlights = flightDAO.findFlightsForBooking(city, date, quantityOfTickets);
        if (resultFlights.size() != 0) {
            for (Flight flight : resultFlights) {
                System.out.println(flight);
            }
        } else {
            System.out.println("No such flights!");

        }

        return resultFlights;
    }

    @Override
    public List<Flight> flightBooking(String firstName, String lastName, String numberOfSeats) {
        List<Flight> resultBookingFlight = flightDAO.flightBooking(firstName,lastName,numberOfSeats);
        if (resultBookingFlight.size() != 0) {
            for (Flight flight : resultBookingFlight) {
                System.out.println(flight);
            }
        } else {
            System.out.println("BookingDAO is not completed!");

        }
        return resultBookingFlight;
    }


}



