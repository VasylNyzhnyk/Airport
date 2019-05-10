package com.project.airport.service.impl;

import com.project.airport.dao.impl.FlightDAO;
import com.project.airport.model.Flight;
import com.project.airport.model.Passenger;
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
    public void showTodayFlights(String todayDate) {
        List<Flight> allFlightsList = new ArrayList<>();

        allFlightsList = flightDAO.getAllFlights();

        for (Flight flight : allFlightsList) {
            if (flight.getDate().equals(todayDate)) {
                System.out.println(flight);
            }
        }
    }

    @Override
    public Flight getFlightById(String idFlight) {
        Flight flight = flightDAO.getFlightById(idFlight);

        return flight;
    }

    @Override
    public void cancelBookingByIdPassenger(String listOfPassengers) {
        Passenger passenger = new Passenger();
    }

    @Override
    public void decreaseNumberOfSeats(int numberOfPassengers, String flightId) {

        Flight oldFlight = getFlightById(flightId);
        int oldNumberOfSeats = Integer.parseInt(oldFlight.getNumberOfSeats());
        System.out.println("Old number of seats=" + oldNumberOfSeats);

        int newNumberOfSeats = oldNumberOfSeats - numberOfPassengers;

        List<Flight> allFlightsList = new ArrayList<>();

        allFlightsList = flightDAO.getAllFlights();

        for (Flight flight : allFlightsList) {
            if (flight.getId().equals(flightId)) {
                flight.setNumberOfSeats(String.valueOf(newNumberOfSeats));
            }
        }

        flightDAO.addListOfFlights(allFlightsList);
    }

    @Override
    public void increaseNumberOfSeats(int numberOfPassengers, String flightId) {

    }


}



