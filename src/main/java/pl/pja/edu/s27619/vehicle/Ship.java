package pl.pja.edu.s27619.vehicle;

import pl.pja.edu.s27619.exceptions.CheckDataException;
import pl.pja.edu.s27619.vehicle.component.Engine;

import java.io.Serializable;

public class Ship extends Vehicle implements Serializable {
    private int numOfShipCabins;

    /**
     * Constructor to initialize Ship object without a color.
     *
     * @param vehicleType     the type of the vehicle
     * @param name            manufacturer name of the vehicle
     * @param model           model of the vehicle
     * @param engine          engine which used in vehicle
     * @param numOfShipCabins contains info about cabins on the ship
     */
    public Ship(VehicleType vehicleType, String name, String model, Engine engine, int numOfShipCabins) {
        super(vehicleType, name, model, engine);
        setNumOfShipCabins(numOfShipCabins);
    }

    /**
     * Overload constructor to initialize Ship object with a color.
     *
     * @param vehicleType     the type of the vehicle
     * @param name            manufacturer name of the vehicle
     * @param model           model of the vehicle
     * @param color           contains info about color of the vehicle
     * @param engine          engine which used in vehicle
     * @param numOfShipCabins contains info about cabins on the ship
     */
    public Ship(VehicleType vehicleType, String name, String model, String color, Engine engine, int numOfShipCabins) {
        super(vehicleType, name, model, engine, color);
        setNumOfShipCabins(numOfShipCabins);
    }

    /**
     * Method sets number of cabins in the ship, if it is not negative value, otherwise throws exception.
     *
     * @param numOfShipCabins contains info about cabins on the ship
     * @throws CheckDataException if number of cabins is negative
     */
    public void setNumOfShipCabins(int numOfShipCabins) {
        if (numOfShipCabins < 0) {
            throw new CheckDataException("Ship could not has negative number of cabins");
        }
        this.numOfShipCabins = numOfShipCabins;
    }

    public int getNumOfShipCabins() {
        return numOfShipCabins;
    }

    /**
     * Override method of Vehicle class and add information to describe in details Ship object.
     */
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of ship's cabins: " + numOfShipCabins + "\n");
    }

}
