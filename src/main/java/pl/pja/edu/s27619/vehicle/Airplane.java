package pl.pja.edu.s27619.vehicle;

import pl.pja.edu.s27619.exceptions.CheckDataException;
import pl.pja.edu.s27619.vehicle.component.Engine;

import java.io.Serializable;

public class Airplane extends Vehicle implements Serializable {
    private int numOfSeats;

    /**
     * Constructor to initialize Airplane object without a color.
     *
     * @param vehicleType the type of the vehicle
     * @param name        manufacturer name of the vehicle
     * @param model       model of the vehicle
     * @param engine      engine which used in vehicle
     * @param numOfSeats  contains info about seats on the airplane
     */
    public Airplane(VehicleType vehicleType, String name, String model, Engine engine, int numOfSeats) {
        super(vehicleType, name, model, engine);
        setNumOfSeats(numOfSeats);
    }

    /**
     * Overload constructor to initialize Car object with a color.
     *
     * @param vehicleType the type of the vehicle
     * @param name        manufacturer name of the vehicle
     * @param model       model of the vehicle
     * @param engine      engine which used in vehicle
     * @param color       color of vehicle
     * @param numOfSeats  contains info about seats on the airplane
     */
    public Airplane(VehicleType vehicleType, String name, String model, Engine engine, String color, int numOfSeats) {
        super(vehicleType, name, model, engine, color);
        setNumOfSeats(numOfSeats);
    }

    /**
     * Method sets available number of doors in car, if it is not negative value, otherwise throws exception.
     *
     * @param numOfSeats contains info about number of seats in airplane
     * @throws CheckDataException if number of seats is negative
     */
    public void setNumOfSeats(int numOfSeats) {
        if (numOfSeats < 0) {
            throw new CheckDataException("Airplane could not has negative number of seats");
        }
        this.numOfSeats = numOfSeats;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    /**
     * Override method of Vehicle class and add information to describe in details Airplane object.
     */
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of seats: " + numOfSeats + "\n");
    }

}
