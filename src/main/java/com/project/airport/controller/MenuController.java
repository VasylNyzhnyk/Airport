package com.project.airport.controller;

import com.project.airport.Application;
import com.project.airport.service.impl.FlightService;
import com.sun.xml.internal.bind.v2.TODO;

import java.io.IOException;
import java.util.Scanner;

public class MenuController {

    public static boolean processUserSelection(String chosenItem) throws IOException {
        Scanner scanner = new Scanner(System.in);

        FlightService flightService = new FlightService();

        boolean isExitChosen = false;
        switch (chosenItem) {
            case "1":
                System.out.println("You chose: Online scoreboard");

                flightService.showAllFlights();
                break;
            case "2":
                System.out.println("You chose: Flight information ");
                System.out.println("Enter ID Flight");
                String s = scanner.nextLine();
                flightService.showFlightById(s);
                break;
            case "3":
                System.out.println("You chose: Search reservation flight ");
                System.out.println("Enter: City -  Data - Quantity tickets ");
                String city = scanner.nextLine();
                String data = scanner.nextLine();
                String quantityOfTickets = scanner.nextLine();
                flightService.findFlightsForBooking(city,data,quantityOfTickets);

                break;
            case "4":
                System.out.println("You chose: Cancel reservation ");
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
