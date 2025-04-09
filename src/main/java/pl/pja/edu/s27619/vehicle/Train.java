package pl.pja.edu.s27619.vehicle;

import pl.pja.edu.s27619.exceptions.CheckDataException;
import pl.pja.edu.s27619.vehicle.component.Engine;

import java.io.Serializable;

public class Train extends Vehicle implements Serializable {
    private int availableNumOfCargos;

    /**
     * Constructor to initialize Train object without a color.
     *
     * @param vehicleType          the type of the vehicle
     * @param name                 manufacturer name of the vehicle
     * @param model                model of the vehicle
     * @param engine               engine which used in vehicle
     * @param availableNumOfCargos contains info about available cargos for train
     */
    public Train(VehicleType vehicleType, String name, String model, Engine engine,
                 int availableNumOfCargos) {
        super(vehicleType, name, model, engine);
        setAvailableNumOfCargos(availableNumOfCargos);
    }

    /**
     * Overload constructor to initialize Train object with a color.
     *
     * @param vehicleType          the type of the vehicle
     * @param name                 manufacturer name of the vehicle
     * @param model                model of the vehicle
     * @param color                color of vehicle
     * @param engine               engine which used in vehicle
     * @param availableNumOfCargos contains info about available cargos for vehicle
     */
    public Train(VehicleType vehicleType, String name, String model, String color, Engine engine,
                 int availableNumOfCargos) {
        super(vehicleType, name, model, engine, color);
        setAvailableNumOfCargos(availableNumOfCargos);
    }

    /**
     * Method sets available number of cargos to train, if it is not negative value, otherwise throws exception.
     *
     * @param availableNumOfCargos contains info about available cargos for train
     * @throws CheckDataException if number of cargos is negative
     */
    public void setAvailableNumOfCargos(int availableNumOfCargos) {
        if (availableNumOfCargos < 0) {
            throw new CheckDataException("Train could no has negative number of available cargos");
        }
        this.availableNumOfCargos = availableNumOfCargos;
    }

    public int getAvailableNumOfCargos() {
        return availableNumOfCargos;
    }

    /**
     * Override method of Vehicle class and add information to describe in details Train object.
     */
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Maximum number of cargos: " + availableNumOfCargos + "\n");
    }

}
