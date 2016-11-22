/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528final;

import java.util.ArrayList;

/**
 *
 * @author Hassan
 */
/**OVERVIEW: 
 * CarParkingLots are Mutable. Consist of and ArrayList bound to 50 spots 
 * containing AbstractVehicle objects.<br>
 * A typical CarParkingLot is {AbstractVehicle1, AbstractVehicle2,... 
 * AbstactVehicle50}.<br><br>
 * Abstraction Function: AF(c) = c.carParkingArray.get(n)| 0&lt;= n &lt;= maxCapacity<br>
 * <br>
 * Rep Invariant:<br>
 * maxCapacity &lt; 0<br>
 * c.carParkingArray.size &lt;= maxCapacity<br>
 * c.carParkingArray.size &gt;=0
 */
public class CarParkingLot {
    
    //Variables
    private static final int maxCapacity = 50;
    private ArrayList <AbstractVehicle>carParkingArray;
    
    //Constructor
    public CarParkingLot(){
        this.carParkingArray = new ArrayList<>(maxCapacity);
    }
    /**
     * Effects: Subtracts the size of the carParkingArray from the maxCapacity 
     * to get the amount of available spots in the carParkingArray.<br>
     * @return numOfAvailableSpots
     */
    public int AvailableSpots(){
        return maxCapacity - carParkingArray.size();
    }
    /**
     * Effects: returns the size of the carParkingArray<br>
     * @return numOfOccupiedSpots
     */
    public int OccupiedSpots(){
        return carParkingArray.size();
    }
    /**
     * Requires: carParkingArray is not full<br>
     * Modifies: carParkingArray<br>
     * Effects: Adds the vehicle to the carParkingArray<br>
     * @param vehicle 
     */
    public void addVehicle(AbstractVehicle vehicle){
        if(AvailableSpots() >0){
            carParkingArray.add(vehicle);
            System.out.println("Vehicle added Parking Lot");
        }
        else{
            System.out.println("Parking lot full");
        }
    }
    /**
     * Requires: carParkingArray is not empty<br>
     * Modifies: carParkingArray<br>
     * Effects: removes the Owner's vehicle from the carParkingArray<br>
     * @param Owner 
     */
    public void removeVehicle(String Owner){
        for(AbstractVehicle AV : carParkingArray){
                    if (Owner.equalsIgnoreCase(AV.getOwner())){
                        carParkingArray.remove(AV);
                    }
        }
    }
    /**
     * Effects: returns the maxCapacity value of the CarParkingLot
     * @return 
     */
    public int getMaxCapacity(){
        return maxCapacity;
    }
    /**
     * Requires: carParkingArray is not empty<br>
     * Effects: Goes through the carParkingArray and outputs the toString of all
     * the vehicles present<br>
     * @return returnString
     */
    /**
    public String allVehicleDetails(){
        String returnString = null;
        for(AbstractVehicle AV : carParkingArray){
             returnString = returnString + AbstractVehicle.toString();
        }
        return returnString;
    }*/
    
    /**
     * Effects: returns the string representation of the CarParkingLot<br>
     * @return StringRepresentation
     */
    @Override
    public String toString(){
        return "Max Capacity: "+maxCapacity+"\nAvailable lots: "
                +this.AvailableSpots()+"\nOccupied lots: "+this.OccupiedSpots();
    }
    /**
     * Effects: Checks values of the variables on the CarParkingLot to make sure
     * they meet the rep invariant requirements.
     * @return 
     */
    public Boolean repOk(){
        if (maxCapacity<0) return false;
        if (carParkingArray.size() > maxCapacity) return false;
        if (carParkingArray.size() < 0) return false;
        return true;
    }
    
}
