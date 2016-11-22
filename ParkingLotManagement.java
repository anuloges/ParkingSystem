/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528final;

import java.util.Scanner;

/**
 * Overview: ParkingLotManagement are immutable. Consists of a Login method(main)
 * , menu method(parkingAttendantMain). Also, consists of a bookVehicle,
 * removeVehicle and, parkingLotInformation
 * <br><br>
 * Abstraction Function: AF(c) = c.CarParkingLot| 0&lt;= CarParkingLot
 * &lt;= maxCapacity<br>
 * <br>
 * Rep Invariant:<br>
 * maxCapacity &lt; 0<br>
 * c.CarParkingLot.size &lt;= maxCapacity<br>
 * c.CarParkingLot.size &gt;=0
 * @author Hassan
 */
public class ParkingLotManagement {
    
    //Instance Variables
    private CarParkingLot parkingLot;
    /**
     * Effects: Confirms the login credentials of the attendant using preset
     * and send confirmed attendants to their menu
     * @param args 
     */ 
    public static void main(String[] args){
        ParkingLotManagement start = new ParkingLotManagement();
        String s;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the JAH Condo Residential Parking Management System");
        s = "start";
        while(!s.equals("end")){
        System.out.println("Please provide your Username and Password or type"
                + " 'end' to terminate the program");
        System.out.print("Login: ");
        s = scanner.nextLine();
            if("admin".equalsIgnoreCase(s)){
                System.out.print("Password: ");
                s = scanner.nextLine();
                if("admin".equalsIgnoreCase(s)){
                   start.parkingAttendantMain();
                }
                else System.out.println("Incorrect Password!");
            }
            else System.out.println("Incorrect Username!");
        }
    }
    /**
     * Requires: An authorized user goes through main menu to gain access<br>
     * Modifies: parkingLot<br>
     * Effects: Allows the attendant to be able to book a new vehicle, remove
     * a registered vehicle, print out parking lot information and, return to 
     * the login screen.
     */
    public void parkingAttendantMain(){
        Scanner scanner = new Scanner(System.in);
        String s;
        System.out.println("\nLogin Successful\n " 
                + "Please type following commands:'\n"
                + "'logout' - to logout\n"
                + "'NV VehicleType Owner Model Color Wheels Transmission ParkedStatus SpecialFeature' - to create new vehicle\n"
                + "'RV Owner' - to remove owner's vehicle\n"
                + "'PLI' - to view parking lot information \n "
                + "\n");
        
        s = scanner.next();
        
        while(!s.equalsIgnoreCase("logout")){
            if(s.equalsIgnoreCase("NV")){
                String VT, O, M, C, W, T, PS, SF;
                int WH;
                boolean PSB = false, SFB = false;
                VT = scanner.next();
                O = scanner.next();
                M = scanner.next();
                C = scanner.next();
                W = scanner.next();
                T = scanner.next();
                PS = scanner.next();
                SF = scanner.next();
                WH = Integer.parseInt(W);
                if(PS.equalsIgnoreCase("True"))
                    PSB = true;
                if(SF.equalsIgnoreCase("True"))
                    SFB = true;
                bookVehicle(VT, O, M, C, WH, T, PSB, SFB);
            }
            else if(s.equalsIgnoreCase("RV")){
                String O;
                O = scanner.next();
                removeVehicle(O);
            }
            else if(s.equalsIgnoreCase("PLI")){
                parkingLotInformation();
            }
        }
    }
    /**
     * Requires: All parameters of the vehicle to be valid.<br>
     * Modifies: parkingLot.carParkingArray<br>
     * Effects: Creates a vehicle following the specifications provided.<br>
     * @param VT
     * @param O
     * @param M
     * @param C
     * @param WH
     * @param T
     * @param PS
     * @param SF 
     */
    public void bookVehicle(String VT, String O, String M, String C, int WH,
            String T, Boolean PS, Boolean SF){
        if(VT.equalsIgnoreCase("Car")){
            Car AV = new Car(O, M, C, T, WH, PS, SF);
            parkingLot.addVehicle(AV);
        }
        else if (VT.equalsIgnoreCase("Truck")){
            Truck AV = new Truck(O, M, C, T, WH, PS, SF);
            parkingLot.addVehicle(AV);
        }
        else if (VT.equalsIgnoreCase("Motorcycle")){
            Motorcycle AV = new Motorcycle(O, M, C, T, WH, PS, SF);
            parkingLot.addVehicle(AV);
        }
        else System.out.println("Vehicle type not supportted");
    }
    /**
     * Requires: parkingLot is not empty and, the owners vehicle is registered
     * <br>
     * Modifies: parkingLot.carParkingArray<br>
     * Effects: Removes the owners vehicle from the parkingLot.carParkingArray
     * @param O 
     */
    public void removeVehicle(String O){
        parkingLot.removeVehicle(O);
    }
    /**
     * Effects: Prints out the information of the parking lot. Also, gives the 
     * option to print the list of cars.<br>
     */
    public void parkingLotInformation(){
        Scanner scanner = new Scanner(System.in);
        String s;
        parkingLot.toString();
        System.out.println("Would you like a list of all cars? (Y/N)\n");
        s = scanner.nextLine();
        if(s.equalsIgnoreCase("Y")){
            //parkingLot.allVehicleDetails();
        }
    }
    /**
     * Effects: returns the string representation of the parkingLot and the
     * Vehicle details.
     * @return StringRepresentation
     */
    @Override
    public String toString(){
        return "The current parking lot has the following capacity"
                + parkingLot.toString()+ "and the vehicles inside are" ;
                //+ parkingLot.allVehicleDetails();
    }
    /**
     * Effects: Checks to see if the CarParkingLot to make sure it meets the 
     * rep invariant requirements.
     * @return 
     */
    public Boolean repOk(){
        return parkingLot.repOk();
    }
    
    
}
