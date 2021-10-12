/*
 * File: LoadVehicle.java
 * Created Date: 2021-09-25 00:46:41
 * Author: Szivak Gergo, Ban Cinti, Hermanyi Gergely
 * Group: Szoft II N
 * Original: revehicle, Sallai Andras
 * Github: https://github.com/Gergosz-2000
 * -----
 * Last Modified: 2021-10-12
 * Modified By: Szivak Gergo, Ban Cinti, Hermanyi Gergely
 * -----
 * Copyright (c) 2021 Szivak Gergo, Ban Cinti, Hermanyi Gergely
 * 
 * GNU GPL v2
 */
package models;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadVehicle {
    
    ArrayList<String> vehicles;

    public LoadVehicle() {
        vehicles = new ArrayList<>();
    }
    public ArrayList<Vehicle> load(){
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        try {
            vehicleList = tryLoad();
        } catch (FileNotFoundException e) {
            System.err.println("Hiba! A fájl nem található");
        }
        return vehicleList;
    }
    private ArrayList<Vehicle> tryLoad() throws FileNotFoundException {
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        FileReader fileReader = new FileReader("data.txt");
        Scanner scanner = new Scanner(fileReader);
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] lineArray = line.split(":");
            Vehicle vehicle = new Vehicle();
            vehicle.ordinal = lineArray[0];
            vehicle.brand = lineArray[1];
            vehicle.year = lineArray[2];
            vehicleList.add(vehicle);
        }
        scanner.close();
        return vehicleList;
    }
}
