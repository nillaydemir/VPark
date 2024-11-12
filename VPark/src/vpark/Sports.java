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
public class Sports extends Car {

    private int hp; //horsePower

    public Sports(int hp, String color, int seatingCapacity, int numOfDoors, int plateNumber, int numberOfTires) {
        super(color, seatingCapacity, numOfDoors, plateNumber, numberOfTires);
        this.hp = hp;
        this.dailyFee = 1100;
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
        long days = startDate.getTime() - endDate.getTime();
        isAvailable = true;
        return days * dailyFee;
    }

    @Override
    public void bookMe(Date startDate, Date endDate) throws SorryWeDontHaveThatOneException {
        if (available(startDate, endDate) == true) {
            System.out.println(startDate + "-" + endDate + "booked in range");
            isAvailable = false;
        } else {
            throw new SorryWeDontHaveThatOneException("no vehicle available");
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
    
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
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

    @Override
    public String toString() {
        return super.toString() + " horse power: " + hp;
    }

}
