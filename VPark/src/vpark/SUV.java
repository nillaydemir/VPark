/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vpark;

import java.util.Date;

/**
 *
 * @author 90551
 */
public class SUV extends Car{
    private String wd; //wheel drive
    
    public SUV(String wd, String color, int seatingCapacity, int numOfDoors, int plateNumber, int numberOfTires){
        super( color, seatingCapacity, numOfDoors, plateNumber, numberOfTires);
        this.wd = wd;
         this.dailyFee = 1500;
    }
    
    @Override
    public void rentMe(Date startDate, Date endDate) throws SorryWeDontHaveThatOneException {
        if(available(startDate,endDate)==true){
          System.out.println("You need to deliver and dropp from Vpark");
          isAvailable = false;
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

    public String getWd() {
        return wd;
    }

    public void setWd(String wd) {
        this.wd = wd;
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
    public String toString()
    {
        return super.toString() + " wheel drive : " + wd;
    }    
}
