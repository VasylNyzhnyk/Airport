package com.project.airport.controller;

import com.project.airport.Application;
import com.project.airport.service.impl.FlightService;
import com.sun.xml.internal.bind.v2.TODO;

import java.io.IOException;

public class MenuController {

    public static boolean processUserSelection(String chosenItem) throws IOException {

        FlightService flightService = new FlightService();

        boolean isExitChosen = false;
        switch (chosenItem) {
            case "1":
                System.out.println("You chose: Online scoreboard");

                flightService.showAllFlights();
                break;
            case "2":
                System.out.println("You chose: Flight information ");
                //TODO
                //спросить Id рейса и передать в метод showFlightById
                //flightService.showFlightById();
                break;
            case "3":
                System.out.println("You chose: Search reservation flight ");
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
