/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vpark;

/**
 *
 * @author 90551
 */
class SorryWeDontHaveThatOneException extends Exception{
    public SorryWeDontHaveThatOneException(String message){
        super(message);
    }
    @Override
    public void printStackTrace(){
        System.out.println("no vehicle available");
    }
}
