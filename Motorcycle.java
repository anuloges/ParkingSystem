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
public class Motorcycle extends AbstractVehicle {
    private boolean Suspension = super.specialFeature;

    public Motorcycle(String Owner, String Model, String Color, String Transmission, int Wheels, boolean Status, boolean specialFeature) {
        super(Owner, Model, Color, Transmission, Wheels, Status, specialFeature);
    }

    public boolean isSuspension() {
        return Suspension;
    }

    public void setSuspension(boolean Suspension) {
        this.Suspension = Suspension;
    }

}

