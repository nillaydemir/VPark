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
public class TransportTrucks extends Truck {
    private boolean isGoesAbroad;
    
    public TransportTrucks(boolean isGoesAbroad,double loadingCapacity, int plateNumber, int numberOfTires) {
        super(loadingCapacity, plateNumber, numberOfTires);
        this.isGoesAbroad = isGoesAbroad;
        this.dailyFee = 2500;
         
    }
    
    
    @Override
    public double dropMe(Date startDate, Date endDate) {
        double cost = 0;
        if(isGoesAbroad){
             cost = 1000;
        }else{
            cost = 0;
        }
        long days = startDate.getTime()- endDate.getTime();
         isAvailable = true;
         return days* dailyFee + cost;
    }
    
    @Override
    public String toString(){
        return super.toString() + " isGoesAbroad: " + isGoesAbroad ;
    }

    public boolean isIsGoesAbroad() {
        return isGoesAbroad;
    }

    public void setIsGoesAbroad(boolean isGoesAbroad) {
        this.isGoesAbroad = isGoesAbroad;
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
