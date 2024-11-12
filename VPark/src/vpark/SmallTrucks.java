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
public class SmallTrucks extends Truck {
    
    public SmallTrucks(double loadingCapacity, int plateNumber, int numberOfTires) {
        super(loadingCapacity, plateNumber, numberOfTires);
         this.dailyFee = 1700;
    }
     
  
    @Override
    public double dropMe(Date startDate, Date endDate) {
        long days = startDate.getTime()- endDate.getTime();
         isAvailable = true;
         return days* dailyFee;
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
    public String toString(){
       return super.toString() ;
    }
    
    
}
