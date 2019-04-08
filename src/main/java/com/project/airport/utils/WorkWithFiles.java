package com.project.airport.utils;

import com.project.airport.model.Flight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WorkWithFiles {

    public static List<Flight> generateListOfFlightsFromFile() throws IOException {

        BufferedReader bufReader = new BufferedReader(
                new FileReader(
                        "D://IdeaProjects//Airport//src//main//java//com" +
                                "//project//airport//ListPlanes.txt"));
        List<String> listOfLines = new ArrayList<>();
        String line = "";

        while ((line = bufReader.readLine()) != null) {
            listOfLines.add(line);
        }
        List<Flight> flightsList = new ArrayList<>();
        for (String listOfLine : listOfLines) {
            String[] words = listOfLine.split("\t");
            flightsList.add(new Flight(words[0], words[1], words[2], words[3], words[4]));
        }

        return flightsList;
    }
}
