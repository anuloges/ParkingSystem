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
public class Truck extends AbstractVehicle{
    private boolean Container = super.specialFeature;

    public Truck(String Owner, String Model, String Color, String Transmission, int Wheels, boolean Status, boolean specialFeature) {
        super(Owner, Model, Color, Transmission, Wheels, Status, specialFeature);
    }

    public boolean isContainer() {
        return Container;
    }

    public void setContainer(boolean Container) {
        this.Container = Container;
    }
    
}
