/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528final;

/**
 *
 * @author Jad
 */
public abstract class AbstractVehicle {
    String Owner;
    String Model;
    String Color;
    String Transmission;
    int Wheels;
    boolean Status;
    boolean specialFeature;

    public AbstractVehicle(String Owner, String Model, String Color, String Transmission, int Wheels, boolean Status, boolean specialFeature) {
        this.Owner = Owner;
        this.Model = Model;
        this.Color = Color;
        this.Transmission = Transmission;
        this.Wheels = Wheels;
        this.Status = Status;
        this.specialFeature = specialFeature;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String Owner) {
        this.Owner = Owner;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getTransmission() {
        return Transmission;
    }

    public void setTransmission(String Transmission) {
        this.Transmission = Transmission;
    }

    public int getWheels() {
        return Wheels;
    }

    public void setWheels(int Wheels) {
        this.Wheels = Wheels;
    }
    
    public boolean parkedStatus(){
        return true; //false
    }

    public boolean getStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public boolean getSpecialFeature() {
        return specialFeature;
    }

    public void setSpecialFeature(boolean specialFeature) {
        this.specialFeature = specialFeature;
    }
    
    @Override
    public String toString(){
        return ("lol");
    }
    
    public boolean rekOK(){
        return true; //false
    }
}
