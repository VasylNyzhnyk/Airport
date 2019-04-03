package com.project.airport;


import com.project.airport.controller.MenuController;

import java.io.IOException;
import java.util.*;

public class Application {

    public static void main(String[] args) throws IOException {
        Map<Integer, String> map = generatMenu();
        Scanner scan = new Scanner(System.in);
        boolean isExitChosen = false;
        while (!isExitChosen) {
            String chosenItem = " ";
            System.out.println("Choose any item:");
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                System.out.println(entry.getKey() + entry.getValue());
            }
            //readerList();
            chosenItem = scan.nextLine();
            isExitChosen = MenuController.processUserSelection(chosenItem);
        }
    }

    public static Map<Integer, String> generatMenu() {
        Map<Integer, String> mapMenu = new HashMap<>();
        mapMenu.put(1, " Online scoreboard");
        mapMenu.put(2, " Flight information");
        mapMenu.put(3, " Search reservation flight");
        mapMenu.put(4, " Cancel reservation");
        mapMenu.put(5, " Exit");
        return mapMenu;
    }

}
