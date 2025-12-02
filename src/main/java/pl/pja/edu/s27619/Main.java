package pl.pja.edu.s27619;

import pl.pja.edu.s27619.service.VehicleManager;
import pl.pja.edu.s27619.vehicle.*;
import pl.pja.edu.s27619.vehicle.component.Engine;
import pl.pja.edu.s27619.vehicle.component.EngineType;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // generate CAR objects
        Engine bmwEngine = new Engine(EngineType.PETROL, 723);
        Car bmw = new Car(VehicleType.CAR, "BMW", "540i", bmwEngine, 5);
        bmw.setSensors("ConnectedDrive"); // multi-valued attribute
        bmw.setSensors("Autopilot"); // multi-valued attribute

        // generate AIRPLANE objects
        Airplane airplane = new Airplane(VehicleType.AIRPLANE, "Boeing", "777",
                new Engine(EngineType.DIESEL, 777), 120);
        airplane.setColor("Gray"); // optional attribute

        // generate TRAIN objects with overloaded constructor
        Train train = new Train(VehicleType.TRAIN, "PKP Intercity", "Stadler", "Gray",
                new Engine(EngineType.ELECTRICITY, 560),
                 7);
        train.setSensors("Automatic Increasing Speed"); // multi-valued attribute

        // generate SHIP objects
        Ship ship = new Ship(VehicleType.SHIP, "PJATK Submarine", "YACHT 7778",
                new Engine(EngineType.DIESEL, 800), 3);
        ship.setColor("White"); // optional attribute

        // Extent
        List<Vehicle> vehicleList = VehicleManager.getRegisteredVehicles(); // Class method
        System.out.println("Get registered vehicles:");
        printBasicInfo(vehicleList);

        // Extent-persistency - save registered vehicles to the file
        VehicleManager.saveRegisteredVehiclesToFile();

        // Removing vehicle from extent
        if (VehicleManager.getRegisteredVehicles().size() > 2) {
            VehicleManager.getRegisteredVehicles().remove(2);
        }

        System.out.println("Get registered vehicles after removing:");
        printBasicInfo(vehicleList);

        // Extent-persistency - load registered vehicles from file
        VehicleManager.loadRegisteredVehiclesFromFile();
        vehicleList = VehicleManager.getRegisteredVehicles();

        System.out.println("Get registered vehicles from file:");
        printBasicInfo(vehicleList);

        System.out.println();

        // display detailed vehicle info, using Override method in subclasses displayInfo()
        for (Vehicle vehicle : vehicleList) {
            vehicle.displayInfo();
        }

        // Derived attribute
        System.out.println("New unique ID: " + bmw.generateUniqueId());

        // complex
        Engine engineToTest = new Engine(EngineType.ELECTRICITY, 143);
        bmw.setEngine(engineToTest);
        System.out.println(bmw.getBasicVehicleInfo());

        // class attribute
        System.out.println("Max amount of vehicles, which can be added to the system: " +
                VehicleManager.MAX_AMOUNT_OF_VEHICLES);
    }

    public static void printBasicInfo(List<Vehicle> vehicleList) {
        if (!vehicleList.isEmpty()) {
            for (Vehicle vehicle : vehicleList) {
                System.out.print("{");
                System.out.print(vehicle.getBasicVehicleInfo());
                System.out.print("} \n");
            }
        } else {
            System.out.println("Vehicle list is empty");
        }
    }
}