/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vpark;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 90551
 */
public abstract class Vehicle implements Options,Serializable {
    private int id;
    private int count = 1;
    private final int plateNumber;
    private final int numberOfTires;
    protected double dailyFee;
    protected boolean isAvailable = true;
    protected Date availableStartDate;
    protected Date availableEndDate;

    public Date getAvailableStartDate() {
        return availableStartDate;
    }

    public void setAvailableStartDate(Date availableStartDate) {
        this.availableStartDate = availableStartDate;
    }

    public Date getAvailableEndDate() {
        return availableEndDate;
    }

    public void setAvailableEndDate(Date availableEndDate) {
        this.availableEndDate = availableEndDate;
    }
    
    
    public Vehicle(int plateNumber, int numberOfTires ){
        this.id = count;
        this.isAvailable = true;
        this.plateNumber = plateNumber;
        this.numberOfTires = numberOfTires;
        count++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
    
    public abstract double getDailyFee(int numberOfDays);
    
    public boolean available(Date startDate, Date endDate){
        if(startDate.getTime()>= (24/07/2023) && endDate.getTime()<(24/11/2023)){
            isAvailable = false;   
            return false;
        }else{
            isAvailable = true;
            return true;
        }
       
    }

    @Override
    public abstract void bookMe(Date startDate, Date endDate) throws SorryWeDontHaveThatOneException ;
        

    @Override
    public abstract void cancelMe(Date cancelDate, Date startDate) throws NoCancellationYouMustPayException ;

    @Override
    public abstract void rentMe(Date startDate, Date endDate) throws SorryWeDontHaveThatOneException ;

    @Override
    public abstract double dropMe(Date startDate, Date endDate) ;
      

    @Override
    public abstract void loadMe(int load) throws OverWeightException ;
        
    
    @Override
    public String toString(){
        return " id: " + id + " isAvailable: " + isAvailable + " plateNumber: " + plateNumber + " numberOfTires: " + numberOfTires;
    }
   
    
    
    
}

