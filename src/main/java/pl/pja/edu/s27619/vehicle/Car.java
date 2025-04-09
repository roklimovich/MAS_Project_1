package pl.pja.edu.s27619.vehicle;

import pl.pja.edu.s27619.exceptions.CheckDataException;
import pl.pja.edu.s27619.vehicle.component.Engine;

import java.io.Serializable;

public class Car extends Vehicle implements Serializable {
    private int numOfDoors;

    /**
     * Constructor to initialize Car object without a color.
     *
     * @param vehicleType the type of the vehicle
     * @param name        manufacturer name of the vehicle
     * @param model       model of the vehicle
     * @param engine      engine which used in vehicle
     * @param numOfDoors  contains info about number of doors in car
     */
    public Car(VehicleType vehicleType, String name, String model, Engine engine, int numOfDoors) {
        super(vehicleType, name, model, engine);
        setNumOfDoors(numOfDoors);
    }

    /**
     * Overload constructor to initialize Car object with a color.
     *
     * @param vehicleType the type of the vehicle
     * @param name        manufacturer name of the vehicle
     * @param model       model of the vehicle
     * @param engine      engine which used in vehicle
     * @param color       color of vehicle
     * @param numOfDoors  contains info about number of doors in car
     */
    public Car(VehicleType vehicleType, String name, String model, Engine engine, String color, int numOfDoors) {
        super(vehicleType, name, model, engine, color);
        setNumOfDoors(numOfDoors);
    }

    /**
     * Method sets available number of doors in car, if it is not negative value, otherwise throws exception.
     *
     * @param numOfDoors contains info about number of doors in car
     * @throws CheckDataException if number of doors is negative
     */
    public void setNumOfDoors(int numOfDoors) {
        if (numOfDoors < 0) {
            throw new CheckDataException("Car could not has negative number of doors");
        }
        this.numOfDoors = numOfDoors;
    }

    public int getNumOfDoors() {
        return numOfDoors;
    }

    /**
     * Override method of Vehicle class and add information to describe in details Car object.
     */
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of doors: " + numOfDoors + "\n");
    }

}
