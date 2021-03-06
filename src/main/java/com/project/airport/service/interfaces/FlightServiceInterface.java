package com.project.airport.service.interfaces;

import com.project.airport.model.Flight;

import java.util.List;

public interface FlightServiceInterface {

    void showAllFlights();

    void showFlightById(String flightId);

    List<Flight> findFlightsForBooking(String city, String date, String quantityOfTickets);

    void showTodayFlights(String todayDate);

    Flight getFlightById(String idFlight);

    void cancelBookingByIdPassenger(String listOfPassengers);
    void decreaseNumberOfSeats(int numberOfPassengers,String flightId);
    void increaseNumberOfSeats(int numberOfPassengers,String flightId);






    //List<Flight> flightBooking(String firstName, String lastName, String numberOfSeats);



}
