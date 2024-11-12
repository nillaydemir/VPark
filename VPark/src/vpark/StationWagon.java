/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vpark;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author 90551
 */
public class StationWagon extends Car {

    private double loadingCapacity;

    public StationWagon(double loadingCapacity, String color, int seatingCapacity, int numOfDoors, int plateNumber, int numberOfTires) {
        super(color, seatingCapacity, numOfDoors, plateNumber, numberOfTires);
        this.loadingCapacity = loadingCapacity;
         this.dailyFee = 800;
    }
    @Override
    public void rentMe(Date startDate, Date endDate) throws SorryWeDontHaveThatOneException {
           Scanner scn = new Scanner(System.in);
       if(available(startDate,endDate)==true){
        
          System.out.print("Enter the deliver location: ");
          String delloc = scn.next();
          System.out.print("Enter the drop location");
          String droploc = scn.next();
          System.out.print("RENTED");
      }else{
           throw new SorryWeDontHaveThatOneException("no vehicle available");
              }
    }

    @Override
    public double dropMe(Date startDate, Date endDate) {
        long days = startDate.getTime()- endDate.getTime();
         isAvailable = true;
         return days* dailyFee;
    }
    @Override
    public void loadMe(int load) throws OverWeightException {
        if(load>loadingCapacity){
            throw new OverWeightException("Exceeded the load capacity!");
        }else{
            System.out.println("Load capacity is sufficient");  
        }
       
    }
    @Override
    public String toString(){
        return super.toString() + " loadingCapacity " + loadingCapacity ; 
    }

    public double getLoadingCapacity() {
        return loadingCapacity;
    }

    public void setLoadingCapacity(double loadingCapacity) {
        this.loadingCapacity = loadingCapacity;
    }

    public double getDailyFee() {
        return dailyFee;
    }

    public void setDailyFee(double dailyFee) {
        this.dailyFee = dailyFee;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

} 
