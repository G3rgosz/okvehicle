/*
 * File: MainController.java
 * Created Date: 2021-09-24 22:13:27
 * Author: Szivak Gergo, Ban Cinti, Hermanyi Gergely
 * Group: Szoft II N
 * Original: revehicle, Sallai Andras
 * Github: https://github.com/Gergosz-2000
 * -----
 * Last Modified: 2021-10-11
 * Modified By: Szivak Gergo, Ban Cinti, Hermanyi Gergely
 * -----
 * Copyright (c) 2021 Szivak Gergo, Ban Cinti, Hermanyi Gergely
 * 
 * GNU GPL v2
 */

package controllers;

import java.util.ArrayList;
import models.LoadVehicle;
import models.Vehicle;
import views.MainWindow;


public class MainController {
    
    MainWindow mainWindow;
   
    LoadVehicle loadVehicle;
    
    public MainController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.loadVehicle = new LoadVehicle();
        
        ArrayList<Vehicle> carList = this.loadVehicle.load();
        for(Vehicle vehicle : carList) {
            this.mainWindow.vehicleModel.addRow(
                new Object[] {vehicle.ordinal, vehicle.brand, vehicle.year}
            );
        }

         
        //TODO A névtelen metódus tartalmát ki kell szervezni
        //TODO A függvény tartalmát is több részre bontani
        
        this.mainWindow.addButton.addActionListener(event -> {
            System.out.println("Hozzáadás...");
            String ordinal = this.mainWindow.ordinalField.getText();
            String brand = this.mainWindow.brandField.getText();
            String year = this.mainWindow.yearField.getText();
            this.mainWindow.ordinalField.setText("");
            this.mainWindow.brandField.setText("");
            this.mainWindow.yearField.setText("");
            this.mainWindow.vehicleModel.addRow(
                new Object[] {ordinal, brand, year}
            );
        });
        //TODO: Törlés megvalósítása
        this.mainWindow.delButton.addActionListener(event -> {
            System.out.println("Törlés...");
        });
        //TODO: Mentés megvalósítása
        this.mainWindow.saveButton.addActionListener(event -> {
            System.out.println("Mentés...");
        });
    }
    
}
