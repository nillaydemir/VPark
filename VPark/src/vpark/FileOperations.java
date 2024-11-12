/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vpark;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;





/**
 *
 * @author 90551
 */
public class FileOperations {
      
    
    
    public static void writerVpark(ArrayList list){

        FileWriter writer =null;
        try{
        writer = new FileWriter("C:\\Java\\Vpark_16.txt",true);
        writer.write(list.toString());
        }catch(IOException e) {
            System.out.println("Cannot write into the specified file");
        }
        finally{
            if(writer != null){
                try {
                    writer.close();
                } catch (IOException ex) {
                    System.out.println("dosya kapatılırken bir hata oluştu");
                }
            }
        }
    }
    
    public static void writerVehicle(ArrayList list){
        FileWriter writer =null;
        try{
            writer = new FileWriter("C:\\Java\\Vehicle_16.txt",true);
            writer.write(list.toString());
        }catch(IOException e) {
            System.out.println("Cannot write into the specified file");
        }
        finally{
            if(writer != null){
                try {
                    writer.close();
                } catch (IOException ex) {
                    System.out.println("dosya kapatılırken bir hata oluştu");
                }
            }
        }
    }
    
    public static void readVpark(){
        try{
            Scanner scn = new Scanner(new FileReader("C:\\Java\\Vpark_16.txt"));
           
            while(scn.hasNextLine()){
                System.out.println("okunan satır:" + scn.nextLine());
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("dosya bulunamadı");
        } catch (IOException ex) {
            System.out.println("dosya açılırken bir hata oluştu");
        }
    }
     public static void readVehicle(){
        try{
           Scanner scn = new Scanner(new FileReader("C:\\Java\\Vehicle_16.txt"));
            //ArrayList<Object> red = new ArrayList();
            while(scn.hasNextLine()){
                //red.add(scn.nextLine());
                System.out.println("okunan satır:" + scn.nextLine());
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("dosya bulunamadı");
        } catch (IOException ex) {
            System.out.println("dosya açılırken bir hata oluştu");
        }
    }
     
     public static ArrayList<Object> readVehicleV2(){
        try{
            Scanner scn = new Scanner(new FileReader("C:\\Java\\Vehicle_16.txt"));
            ArrayList<Object> red = new ArrayList();
            while(scn.hasNextLine()){
                red.add(scn.nextLine());
                //System.out.println("okunan satır:" + scn.nextLine());
            }
            return red;
            
        } catch (FileNotFoundException ex) {
            System.out.println("dosya bulunamadı");
        } catch (IOException ex) {
            System.out.println("dosya açılırken bir hata oluştu");
        }
        return null;
     }
}
