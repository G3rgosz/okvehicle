/*
 * File: MainController.java
 * Created Date: 2021-09-24 22:13:27
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
        load();
        initEvent();
    }
    private void load(){
        ArrayList<Vehicle> vehicleList = this.loadVehicle.load();
        for(Vehicle vehicle : vehicleList) {
            this.mainWindow.vehicleModel.addRow(
                new Object[] {vehicle.ordinal, vehicle.brand, vehicle.year}
            );
        }
    }
    private void initEvent(){
        initAddButton();
        initDelButton();
        initSaveButton();
    }
    private void initAddButton(){
        this.mainWindow.addButton.addActionListener(event -> {
            System.out.println("Hozzáadás...");
            String[] vehicle = getFields();
            setFields();
            addRow(vehicle);
        });
    }
    private String[] getFields(){
        String ordinal = this.mainWindow.ordinalField.getText();
        String brand = this.mainWindow.brandField.getText();
        String year = this.mainWindow.yearField.getText();
        String[] vehicle = {ordinal, brand, year};
        return vehicle;
    }
    private void setFields(){
        this.mainWindow.ordinalField.setText("");
        this.mainWindow.brandField.setText("");
        this.mainWindow.yearField.setText("");
    }
    private void addRow(String[] vehicle){
        this.mainWindow.vehicleModel.addRow(
            new Object[] {vehicle[0], vehicle[1], vehicle[2]}
        );
    }
    //TODO: Törlés megvalósítása
    private void initDelButton(){
        this.mainWindow.delButton.addActionListener(event -> {
            System.out.println("Törlés...");
        });
    }
    //TODO: Mentés megvalósítása
    private void initSaveButton(){
        this.mainWindow.saveButton.addActionListener(event -> {
            System.out.println("Mentés...");
        });
    }
}
