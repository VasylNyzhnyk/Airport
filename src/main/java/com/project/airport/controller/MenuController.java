package com.project.airport.controller;

import com.project.airport.Application;
import com.project.airport.dao.impl.PassengerDAO;
import com.project.airport.model.Booking;
import com.project.airport.model.BookingRequest;
import com.project.airport.model.Flight;
import com.project.airport.model.Passenger;
import com.project.airport.service.impl.BookingService;
import com.project.airport.service.impl.FlightService;
import com.project.airport.service.impl.PassengerServise;
import com.sun.xml.internal.bind.v2.TODO;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MenuController {


    private static String obtainCurrentDateString() {
        String pattern = "dd.MM";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String date = simpleDateFormat.format(new Date());
        //System.out.println("TODAY-DATE:" + date);
        return date;
    }


    //public static String todayDate = "12.04";
    public static String todayDate = obtainCurrentDateString();
    //Date date;

    public static boolean processUserSelection(String chosenItem) throws IOException {
        Scanner scanner = new Scanner(System.in);

        FlightService flightService = new FlightService();
        PassengerServise passengerServise = new PassengerServise();
        BookingService bookingService = new BookingService();

        boolean isExitChosen = false;
        switch (chosenItem) {
            case "1":
                System.out.println("You chose: Online scoreboard");
                System.out.println("Today is:" + todayDate);
                flightService.showTodayFlights(todayDate);
                break;
            case "2":
                System.out.println("You chose: Flight information ");
                System.out.println("Enter ID Flight");
                String s = scanner.nextLine();
                flightService.showFlightById(s);
                break;
            case "3":
                System.out.println("You chose: Search reservation flight ");
                System.out.println("Enter: City -  Data - Quantity of tickets ");
                String city = scanner.nextLine();
                String data = scanner.nextLine();
                String quantityOfTickets = scanner.nextLine();
                flightService.findFlightsForBooking(city, data, quantityOfTickets);
                System.out.println("Choose a flight. Enter the id");
                String idFlight = scanner.nextLine();
                flightService.showFlightById(idFlight);
                Flight requestedFlight = flightService.getFlightById(idFlight);

                List<Passenger> passengersForBooking = new ArrayList<>(Integer.parseInt(quantityOfTickets));
                for (int i = 1; i <= Integer.parseInt(quantityOfTickets); i++) {
                    System.out.println("Enter: First Name of Passenger" + i);
                    String firstName = scanner.nextLine();

                    System.out.println("Enter: Last Name of Passenger" + i);
                    String lastName = scanner.nextLine();

                    Passenger passenger = new Passenger("1", firstName, lastName);
                    passengersForBooking.add(passenger);
                }
                BookingRequest bookingRequest = new BookingRequest(requestedFlight, passengersForBooking);

                System.out.println(bookingRequest);
                System.out.println();

                //Add passengers to "ListPassengers.txt"(забрать всех пасажиров из файла, добавить нового, перезаписать файл)
                List<Passenger> newPassengers = bookingRequest.getListOfPassengers();
                System.out.println(newPassengers);
                List<String> newPassengersIds = passengerServise.addListOfPassengers(newPassengers);
                System.out.println(newPassengersIds);
                //BookinggID+PassengerID+FlightID(Table)

                for (int i = 0; i < newPassengers.size(); i++) {
                    Booking newBooking = new Booking("1",newPassengersIds.get(i), idFlight);
                    System.out.println(newBooking);
                }

                //TODO
                //Add booking to "ListBookings.txt"
                //Update Flight, уменьшить число свободных мест.

                break;
            case "4":
                System.out.println("You chose: Cancel reservation ");
                passengerServise.showAllPassengers();
                bookingService.showAllBookings();


                break;
            case "5":
                System.out.println("You chose: Exit ");
                isExitChosen = true;
                break;
            default:
                System.out.println("Error");
                break;

        }
        return isExitChosen;
    }
}
