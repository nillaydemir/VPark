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
public interface Options {

    public abstract void bookMe(Date startDate, Date endDate) throws SorryWeDontHaveThatOneException;

    public abstract void cancelMe(Date cancelDate, Date startDate) throws NoCancellationYouMustPayException;

    public abstract void rentMe(Date startDate, Date endDate) throws SorryWeDontHaveThatOneException;
    
   // void rentMe(Date startDate, Date endDate, String deliverLocations, String dropLocations) throws SorryWeDontHaveThatOneException;

    public abstract double dropMe(Date startDate, Date endDate );
    
    public abstract void loadMe(int load) throws OverWeightException;
    
    

   
}
