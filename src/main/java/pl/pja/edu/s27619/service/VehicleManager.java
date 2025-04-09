package pl.pja.edu.s27619.service;

import pl.pja.edu.s27619.vehicle.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleManager {
    private static final String FILE_NAME = "./Vehicle.ser";

    private static List<Vehicle> registeredVehicles = new ArrayList<>();

    public static List<Vehicle> getRegisteredVehicles() {
        return registeredVehicles;
    }

    /**
     * Save registered vehicles to file.
     */
    public static void saveRegisteredVehiclesToFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(registeredVehicles);
        } catch (IOException e) {
            System.out.println("No possibility to save registered vehicles to file " + e.getMessage());
        }
    }

    /**
     * Load registered vehicles from file.
     */
    public static void loadRegisteredVehiclesFromFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            registeredVehicles = (List<Vehicle>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No possibility to load registered vehicle from file " + e.getMessage());
        }
    }

}
