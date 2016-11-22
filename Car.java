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
public class Car extends AbstractVehicle{
    private boolean sunRoof = super.specialFeature;

    public Car(String Owner, String Model, String Color, String Transmission, int Wheels, Boolean Status, Boolean specialFeature) {
        super(Owner, Model, Color, Transmission, Wheels, Status, specialFeature);
    }

    public boolean isSunRoof() {
        return sunRoof;
    }

    public void setSunRoof(boolean sunRoof) {
        this.sunRoof = sunRoof;
    }

}
