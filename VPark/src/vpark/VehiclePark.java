/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vpark;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import static vpark.FileOperations.writerVehicle;
import static vpark.FileOperations.writerVpark;


/**
 *
 * @author 90551
 */
public class VehiclePark {

    public static ArrayList<Vehicle> vehicleList = new ArrayList();
    public static ArrayList<Object> bookList = new ArrayList();
    public static ArrayList<Object> rentList = new ArrayList();
  
    public VehiclePark() {

    }

    public void displayVehicle()  {
        System.out.println("All Vehicles");
        for (Vehicle vehicle : vehicleList) {
            System.out.println(vehicle);
        }
    }
   

    public void displayAvailableVehicle(Date startDate,Date endDate) {
        for (int i = 0; i < vehicleList.size(); i++) {
            if (vehicleList.get(i).available(startDate, endDate) == true) {
                System.out.println(vehicleList.get(i).toString());
            } else {
                System.out.print("");
            }
        }
    }
    

    public void addVehicle(Vehicle vehicle) {
        if (vehicleList.contains(vehicle)) {
            System.out.println("already have");
        } else {
            vehicleList.add(vehicle);
            writerVehicle(vehicleList);
        }
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicleList.remove(vehicle);
    }

    public void bookVehicle(int id,Vehicle vehicle, Date startDate, Date endDate) throws SorryWeDontHaveThatOneException {
       bookList.add("customer id " + id);
         bookList.add( vehicle);
          bookList.add(startDate);
           bookList.add(endDate);

        vehicle.bookMe(startDate, endDate);
       writerVpark(bookList);
    }

    public void cancelBooking(int id,Vehicle vehicle, Date cancelDate, Date startDate) throws NoCancellationYouMustPayException {
        
        vehicle.cancelMe(cancelDate, startDate);
       
    }

    public void rentVehicle(int id,Vehicle vehicle, Date startDate, Date endDate) throws SorryWeDontHaveThatOneException {
        rentList.add("id" + id);
        rentList.add(vehicle);
        rentList.add(startDate);
        rentList.add(endDate);
        
        vehicle.rentMe(startDate, endDate);
         writerVpark(rentList);
    }

    public void dropVehicle(int id,Vehicle vehicle, Date startDate, Date endDate) {
        vehicle.dropMe(startDate, endDate);
    }

    public void load(Vehicle vehicle, int load) throws OverWeightException {
        vehicle.loadMe(load);
    }
    
     
    public void dailyReport() {
       

    }

}
