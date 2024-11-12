/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vpark;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import static vpark.FileOperations.readVehicle;
import static vpark.FileOperations.readVpark;
import static vpark.FileOperations.writerVehicle;



/**
 *
 * @author 90551
 */
public class VPark {

    /**
     * @param args the command line arguments
     */
    public static ArrayList<Vehicle> vehicleList;
    public static ArrayList<Sports> sportsList;
    public static ArrayList<StationWagon> stationWagonList;
    public static ArrayList<SUV> suvList;
    public static ArrayList<SmallTrucks> smallTrucksList;
    public static ArrayList<TransportTrucks> transportTrucksList;
    public static ArrayList<Object> customerList;
    public static int password = 101099;
    
    public static int customerMenu() {
        Scanner scn = new Scanner(System.in);
        System.out.println("1-Display all vehicles");
        System.out.println("2-Display available vehicles");
        System.out.println("3-Display available vehicles by type");
        System.out.println("4-Book a vehicle");
        System.out.println("5-Cancel my booking");
        System.out.println("6-Rent a vehicle");
        System.out.println("7-Drop a vehicle");
        System.out.println("8-Quit");
        int option = scn.nextInt();
        return option;
    }

    public static int adminMenu() {
        Scanner scn = new Scanner(System.in);
        System.out.println("1-Display all vehicles");
        System.out.println("2-Display available vehicles");
        System.out.println("3-Add a new vehicle to the system");
        System.out.println("4-Remove vehicle");
        System.out.println("5-Report");
        System.out.println("6-Quit");
        int option = scn.nextInt();
        return option;
    }

    public static int chooseType() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Choose the type of vehicle: ");
        System.out.println("1-CAR / SPORTS");
        System.out.println("2-CAR / STATIONWAGON");
        System.out.println("3-CAR / SUV");
        System.out.println("4-TRUCK / SMALLTRUCK");
        System.out.println("5-TRUCK / TRANSPORTTRUCK");
        int type = scn.nextInt();
        return type;
    }

    public static Date format(String date) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = formatter.parse(date);
        return startDate;
    }
    
    public static void writeObject(Object o) {
        File f = new File("VehiclePark_33");
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(o);
            oos.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Cannot write into the specified file");
        }
    }

    public static void readObject(Object o) {
        File f = new File("VehiclePark_33");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Vehicle> vehicle = (ArrayList<Vehicle>) ois.readObject();
            for (Vehicle list : vehicleList) {
                System.out.println(vehicleList);
            }
            ois.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Cannot write into the specified file");
        } catch (ClassNotFoundException e) {
            System.out.println("The class does not exist");
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        sportsList = new ArrayList();
        stationWagonList = new ArrayList();
        suvList = new ArrayList();
        smallTrucksList = new ArrayList();
        transportTrucksList = new ArrayList();
        customerList = new ArrayList();
        
        Vehicle v1 = new Sports(4, "blue", 5, 3, 2, 1);
        VehiclePark vp = new VehiclePark();
        sportsList.add((Sports) v1);

        System.out.println("Please choose your role");
        System.out.println("1-CUSTOMER");
        System.out.println("2-ADMIN");
        int role = scn.nextInt();
        if (role == 2) {
            System.out.print("Please enter the password for login: ");
            int pass = scn.nextInt();
            if (pass != password) {
                System.out.print("Password is wrong Please try again!");
                System.exit(0);
            } else {
                System.out.print("WELCOME");

            }
        } else {
            System.out.print("Please enter the id: ");
            int id = scn.nextInt();
            if (customerList.contains(id)) {
                System.out.println("Welcome!");
            } else {
                System.out.println("Do you want to sign in?"
                        + " 1-yes"
                        + " 2-no");
                int choose = scn.nextInt();
                if (choose == 1) {
                    customerList.add(id);
                }
            }
        }

        if (role == 1) {
            while (true) {
                int option = customerMenu();
                switch (option) {
                    case 1:
                        vp.displayVehicle();
                        break;
                    case 2:
                        System.out.print("Enter the startdate: ");
                        String SStartDate = scn.next();
                        Date sStartDate = format(SStartDate);
                        System.out.print("Enter the endDate: ");
                        String SEndDate = scn.next();
                        Date sEndDate = format(SEndDate);
                        vp.displayAvailableVehicle(sStartDate, sEndDate);
                        break;
                    case 3:
                        int type = chooseType();
                        if (type == 1) {
                            for (Vehicle sports : sportsList) {
                                System.out.println(sports);
                            }
                        } else if (type == 2) {
                            for (Vehicle stationWagon : stationWagonList) {
                                System.out.println(stationWagon);
                            }
                        } else if (type == 3) {
                            for (Vehicle suv : suvList) {
                                System.out.println(suv);
                            }
                        } else if (type == 4) {
                            for (Vehicle smallTrucks : smallTrucksList) {
                                System.out.println(smallTrucks);
                            }
                        } else if (type == 5) {
                            for (Vehicle transportTrucks : transportTrucksList) {
                                System.out.println(transportTrucks);
                            }
                        } else {
                            System.out.println("Invalid type");
                        }
                        break;
                    case 4:
                        System.out.print("Enter the your id: ");
                        int bookid = scn.nextInt();
                        if (!(customerList.contains(bookid))) {
                            System.out.print("PLEASE SIGN IN");
                            System.exit(0);
                        }
                        System.out.print("Enter the startDate: ");
                        String SbookingStartDate = scn.next();
                        Date bookingStartDate = format(SbookingStartDate);
                        System.out.println("Enter the endDate: ");
                        String SbookingEndDate = scn.next();
                        Date bookingEndDate = format(SbookingEndDate);
                        readVehicle();
                        System.out.print("Enter vehicle id: ");
                        int idbook = scn.nextInt();
                        vp.bookVehicle(bookid, vehicleList.get(idbook-1), bookingStartDate, bookingEndDate);

                        break;
                    case 5:
                        System.out.print("Enter the your id: ");
                        int cancelid = scn.nextInt();
                        if (!(customerList.contains(cancelid))) {
                            System.out.print("PLEASE SIGN IN");
                            System.exit(0);
                        }
                        System.out.print("Enter the startDate: ");
                        String ScancelStartDate = scn.next();
                        Date cancelstartDate = format(ScancelStartDate);
                        System.out.println("Enter the endDate: ");
                        String ScancelEndDate = scn.next();
                        Date cancelEndDate = format(ScancelEndDate);
                        ArrayList<Object> redObjects = FileOperations.readVehicleV2();
                        System.out.println(redObjects);
                        /*for(Object object : redObjects){
                            
                        }*/
                        System.out.print("Enter vehicle id: ");
                        int idcancel = scn.nextInt();
                        vp.cancelBooking(cancelid, vehicleList.get(idcancel-1), cancelEndDate, cancelstartDate);
                        break;
                    case 6:
                        System.out.print("Enter the your id: ");
                        int rentid = scn.nextInt();
                        if (!(customerList.contains(rentid))) {
                            System.out.print("PLEASE SIGN IN");
                            System.exit(0);
                        }
                        System.out.print("Enter the startDate: ");
                        String SrentStartDate = scn.next();
                        Date rentstartDate = format(SrentStartDate);
                        System.out.println("Enter the endDate: ");
                        String SrentEndDate = scn.next();
                        Date rentEndDate = format(SrentEndDate);
                    readVehicle();
                        System.out.print("Enter vehicle id: ");
                        int idrent = scn.nextInt();
                        vp.rentVehicle(rentid,vehicleList.get(idrent-1), rentstartDate, rentEndDate);
                        int loadtype = chooseType();
                        if (loadtype == 2 || loadtype == 4 || loadtype == 5) {
                            System.out.println("Enter the amount you want to load");
                            int amount = scn.nextInt();
                            vp.load(vehicleList.get(idrent-1), amount);
                        } else {
                            System.out.println("");
                        }

                        break;
                    case 7:
                        System.out.print("Enter the your id: ");
                        int dropid = scn.nextInt();
                        if (!(customerList.contains(dropid))) {
                            System.out.print("PLEASE SIGN IN");
                            System.exit(0);
                        }
                        System.out.print("Enter the startDate: ");
                        String SdropstartDate = scn.next();
                        Date dropstartDate = format(SdropstartDate);
                        System.out.println("Enter the endDate: ");
                        String SdropEndDate = scn.next();
                        Date dropEndDate = format(SdropEndDate);
                        readVehicle();
                        System.out.print("Enter vehicle id: ");
                        int iddrop = scn.nextInt();
                        vp.dropVehicle(dropid, vehicleList.get(iddrop-1), dropstartDate, dropEndDate);
                        break;
                    case 8:
                        System.exit(0);
                }
            }//switch end

        } else if (role == 2) {

            while (true) {
                int option = adminMenu();
                switch (option) {
                    case 1:
                        vp.displayVehicle();
                        break;
                    case 2:
                        System.out.print("Enter the startdate: ");
                        String SStartDate = scn.next();
                        Date sStartDate = format(SStartDate);
                        System.out.print("Enter the endDate: ");
                        String SEndDate = scn.next();
                        Date sEndDate = format(SEndDate);
                        vp.displayAvailableVehicle(sStartDate, sEndDate);

                        break;
                    case 3:
                        System.out.print("Enter the password please!: ");
                        int pass = scn.nextInt();
                        if (pass != password) {
                            System.exit(0);
                        }
                        
                        System.out.println("Enter the type number:");
                        int addType = chooseType();
                        switch (addType) {
                            case 1:
                                System.out.print("HP: ");
                                int hp = scn.nextInt();
                                System.out.print("color: ");
                                String color = scn.next();
                                System.out.print("seatingCapacity: ");
                                int seatingCapacity = scn.nextInt();
                                System.out.print("numOfDoors: ");
                                int numOfDoors = scn.nextInt();
                                System.out.print("plateNumber: ");
                                int plateNumber = scn.nextInt();
                                System.out.print("numberOfTires: ");
                                int numberOfTires = scn.nextInt();
                                Vehicle sport = new Sports(hp, color, seatingCapacity, numOfDoors, plateNumber, numberOfTires);
                               
                                vp.addVehicle(sport);
                               
                                break;
                            case 2:
                                System.out.print("loadingCapacity: ");
                                int loadingCapacity = scn.nextInt();
                                System.out.print("color: ");
                                String color1 = scn.next();
                                System.out.print("seatingCapacity: ");
                                int seatingCapacity1 = scn.nextInt();
                                System.out.print("numOfDoors: ");
                                int numOfDoors1 = scn.nextInt();
                                System.out.print("plateNumber: ");
                                int plateNumber1 = scn.nextInt();
                                System.out.print("numberOfTires: ");
                                int numberOfTires1 = scn.nextInt();
                                Vehicle stationWagon = new StationWagon(loadingCapacity, color1, seatingCapacity1, numOfDoors1, plateNumber1, numberOfTires1);
                                vp.addVehicle(stationWagon);
                                break;
                            case 3:
                                System.out.print("wd: ");
                                String wd = scn.next();
                                 System.out.print("color: ");
                                String color2 = scn.next();
                                System.out.print("seatingCapacity: ");
                                int seatingCapacity2 = scn.nextInt();
                                System.out.print("numOfDoors: ");
                                int numOfDoors2 = scn.nextInt();
                                System.out.print("plateNumber: ");
                                int plateNumber2 = scn.nextInt();
                                System.out.print("numberOfTires: ");
                                int numberOfTires2 = scn.nextInt();
                            Vehicle suv = new SUV(wd, color2, seatingCapacity2, numOfDoors2, plateNumber2, numberOfTires2);
                            vp.addVehicle(suv);
                            
                                break;
                            case 4:
                                System.out.print("loadingCapacity: ");
                                double loadingCapacity3 = scn.nextDouble();
                                System.out.print("plateNumber: ");
                                int plateNumber3 = scn.nextInt();
                                System.out.print("numberOfTires: ");
                                int numberOfTires3 = scn.nextInt();
                                Vehicle struck = new SmallTrucks(loadingCapacity3, plateNumber3, numberOfTires3);
                                vp.addVehicle(struck);
                                break;
                            case 5:
                                System.out.print("isGoesAbroad: ");
                                boolean isGoesAbroad4 = scn.nextBoolean();
                                System.out.print("loadingCapacity: ");
                                double loadingCapacity4 = scn.nextDouble();
                                System.out.print("plateNumber: ");
                                int plateNumber4= scn.nextInt();
                                System.out.print("numberOfTires: ");
                                int numberOfTires4 = scn.nextInt();
                                Vehicle ttruck = new TransportTrucks(isGoesAbroad4, loadingCapacity4, plateNumber4, numberOfTires4);
                                vp.addVehicle(ttruck);
                                break;
                        }
                        //writerVehicle(vehicleList);
                        break;
                    case 4:
                        System.out.print("Enter the password please!: ");
                        int pass1 = scn.nextInt();
                        if (pass1 != password) {
                            System.exit(0);
                        }
                        vp.removeVehicle(v1);
                        break;
                    case 5:
                        System.out.print("Enter the password please!: ");
                        int pass2 = scn.nextInt();
                        if (pass2 != password) {
                            System.exit(0);
                        }
                        vp.dailyReport();
                        break;
                    case 6:
                        System.exit(0);
                        break;
                }
            }
        }

    }

}

// end class
