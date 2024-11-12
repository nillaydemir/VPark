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
class NoCancellationYouMustPayException extends Exception {

    public NoCancellationYouMustPayException(String message) {
        super(message);
    }

    @Override
    public void printStackTrace() {
        System.out.println(" the date of cancellation is after the starting date of rental");
    }
}
