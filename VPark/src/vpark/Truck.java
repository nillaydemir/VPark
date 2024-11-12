/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vpark;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 90551
 */
public class Truck extends Vehicle  implements Serializable{
    
    private double loadingCapacity;
    
    public Truck(double loadingCapacity, int plateNumber, int numberOfTires){
        super(plateNumber, numberOfTires);
        
    }

    @Override
    public double getDailyFee(int numberOfDays) {
        return numberOfDays*dailyFee;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        return super.toString() + " loadingCapacity " + loadingCapacity;
    }

    @Override
    public void bookMe(Date startDate, Date endDate) throws SorryWeDontHaveThatOneException {
        Date date = new Date();
        if(startDate.getTime()-date.getTime()>=7 ){
        if (available(startDate, endDate) == true) {
            System.out.println(startDate + "-" + endDate + "rented in range");
        } else {
            throw new SorryWeDontHaveThatOneException("no vehicle available");
        }
        }else{
            System.out.println("must be booked at least 7 days before");
        }
    }

    
    @Override
    public void cancelMe(Date cancelDate, Date startDate) throws NoCancellationYouMustPayException {
        if (available(cancelDate, startDate) == false) {
            System.out.println("Reservation date is cancelled..");
            isAvailable = true;
        }
        if (cancelDate.getTime() > startDate.getTime()) {
            throw new NoCancellationYouMustPayException("the date of cancellation is after the staring date...");
        }

    }

    @Override
    public void rentMe(Date startDate, Date endDate) throws SorryWeDontHaveThatOneException {
        if(available(startDate,endDate)==true){
        if(available(startDate,endDate)==true){
          System.out.println("You need to deliver and dropp from Vpark");
          isAvailable = false;
      }else{
           throw new SorryWeDontHaveThatOneException("no vehicle available");
              }
      }else{
           throw new SorryWeDontHaveThatOneException("no vehicle available");
              }
    }

    @Override
    public double dropMe(Date startDate, Date endDate) {
          throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
