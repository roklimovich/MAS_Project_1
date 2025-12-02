package pl.pja.edu.s27619.vehicle;

import pl.pja.edu.s27619.exceptions.CheckDataException;
import pl.pja.edu.s27619.service.VehicleManager;
import pl.pja.edu.s27619.vehicle.component.Engine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Vehicle implements Serializable {

    private String uniqueId;
    private static int idCounter;
    private VehicleType vehicleType;
    private String name;
    private String model;
    private String color;
    private Engine engine;
    private List<String> sensors;

    /**
     * Constructor to initialize Vehicle object without a color.
     *
     * @param vehicleType the type of the vehicle
     * @param name        manufacturer name of the vehicle
     * @param model       model of the vehicle
     * @param engine      engine which used in vehicle
     */
    public Vehicle(VehicleType vehicleType, String name, String model, Engine engine) {
        uniqueId = generateUniqueId(); // derived attribute
        setVehicleType(vehicleType);
        setName(name);
        setModel(model);
        setEngine(engine);
        this.sensors = new ArrayList<>();
        VehicleManager.getRegisteredVehicles().add(this);
    }

    /**
     * Overload constructor to initialize Vehicle object with a color.
     *
     * @param vehicleType the type of the vehicle
     * @param name        manufacturer name of the vehicle
     * @param model       model of the vehicle
     * @param engine      engine which used in vehicle
     * @param color       color of vehicle
     */
    public Vehicle(VehicleType vehicleType, String name, String model, Engine engine, String color) {
        uniqueId = generateUniqueId();
        setVehicleType(vehicleType);
        setName(name);
        setModel(model);
        setColor(color);
        setEngine(engine);
        this.sensors = new ArrayList<>();
        VehicleManager.getRegisteredVehicles().add(this);
    }

    /**
     * Iterate basic info about Vehicle and present it as String with special pattern.
     *
     * @return String containing the unique ID, name, model, and engine type of vehicle
     */
    public String getBasicVehicleInfo() {
        return "Unique ID: " + uniqueId + "; Name: " + name + "; Model: " + model +
                "; Engine: " + engine.getEngineType();
    }

    /**
     * Method to display detailed information about Vehicle in console.
     */
    public void displayInfo() {
        System.out.println("Unique ID: " + uniqueId);
        System.out.println("Vehicle type: " + vehicleType);
        System.out.println("Manufacturer name: " + name);
        System.out.println("Model:  " + model);
        System.out.println("Engine: " + engine);
        System.out.println("Color: " + (color != null ? color : "Not specified"));
        System.out.println("Sensors: " + sensors);
    }

    /**
     * Method to set the vehicle type, if it is not null, otherwise throw exception.
     *
     * @param vehicleType type of the vehicle
     * @throws CheckDataException if vehicleType is null
     */
    public void setVehicleType(VehicleType vehicleType) {
        if (vehicleType == null) {
            throw new CheckDataException("Vehicle type could not be null");
        }

        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    /**
     * Method sets the name of the vehicle, if it is not null and not empty.
     *
     * @param name the manufacturer name of the vehicle
     * @throws CheckDataException if name is null or empty
     */
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new CheckDataException("Vehicle name could not be null or empty");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Method sets the model of the vehicle, if it is not null and empty.
     *
     * @param model model name of the vehicle
     * @throws CheckDataException if model is null or empty
     */
    public void setModel(String model) {
        if (model == null || model.isBlank()) {
            throw new CheckDataException("Model could not be null or empty");
        }

        this.model = model;
    }

    public String getModel() {
        return model;
    }

    /**
     * Method sets the color of the vehicle, if it is not null and empty.
     *
     * @param color String variable contains color of the vehicle
     * @throws CheckDataException if color is null or empty
     */
    public void setColor(String color) {
        if (color == null || color.isBlank()) {
            throw new CheckDataException("Color could not be null or empty");
        }

        this.color = color;
    }

    public Optional<String> getColor() {
        return Optional.ofNullable(color);
    }

    /**
     * Methods adds sensors to the vehicle, only in case if sensor is not null or empty.
     *
     * @param sensor String variable which contains the name which should be added
     * @throws CheckDataException if sensor is null or empty
     */
    public void setSensors(String sensor) {
        if (sensor == null || sensor.isBlank()) {
            throw new CheckDataException("Sensor could not be null");
        }

        sensors.add(sensor);
    }

    public List<String> getSensors() {
        return sensors;
    }

    /**
     * Method sets the engine for vehicle, if it is not null.
     *
     * @param engine engine which should be added to vehicle
     * @throws CheckDataException if engine is null
     */
    public void setEngine(Engine engine) {
        if (engine == null) {
            throw new CheckDataException("Engine could not be null");
        }

        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    /**
     * Generates a unique ID for the vehicle using counter of the Vehicle objects.
     *
     * @return String with unique ID in special format "VEHICLE-<idCounter>"
     */
    public String generateUniqueId() {
        return "VEHICLE-" + (++idCounter);
    }

}
