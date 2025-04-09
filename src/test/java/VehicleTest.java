import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.pja.edu.s27619.vehicle.Car;
import pl.pja.edu.s27619.vehicle.Vehicle;
import pl.pja.edu.s27619.vehicle.VehicleType;
import pl.pja.edu.s27619.vehicle.component.Engine;
import pl.pja.edu.s27619.vehicle.component.EngineType;

import java.util.List;

public class VehicleTest {

    @Test
    public void setVehicleType() {
        Engine vehicleEngine = new Engine(EngineType.ELECTRICITY, 666);
        Vehicle vehicle = new Vehicle(VehicleType.CAR, "TestVehicle", "VehicleModel",
                vehicleEngine, "Blue");

        vehicle.setVehicleType(VehicleType.AIRPLANE);

        Assertions.assertEquals(vehicle.getVehicleType(), VehicleType.AIRPLANE);
    }

    @Test
    public void setName() {
        Engine vehicleEngine = new Engine(EngineType.DIESEL, 666);
        Vehicle vehicle = new Vehicle(VehicleType.CAR, "TestVehicle", "VehicleModel",
                vehicleEngine, "Blue");
        vehicle.setName("TESLA");
        String validName = "TESLA";

        Assertions.assertEquals(vehicle.getName(), validName);
    }

    @Test
    public void setModel() {
        Engine vehicleEngine = new Engine(EngineType.ELECTRICITY, 666);
        Vehicle vehicle = new Vehicle(VehicleType.CAR, "TestVehicle", "VehicleModel",
                vehicleEngine, "Blue");
        vehicle.setModel("PJATK model");
        String validModel = "M3";

        Assertions.assertNotEquals(vehicle.getModel(), validModel);
    }

    @Test
    public void setColor() {
        Engine vehicleEngine = new Engine(EngineType.ELECTRICITY, 666);
        Vehicle vehicle = new Vehicle(VehicleType.CAR, "TestVehicle", "VehicleModel",
                vehicleEngine);
        vehicle.setColor("Red");
        String validColor = "Red";

        Assertions.assertEquals(vehicle.getColor().get(), validColor);

        vehicle.setColor("White");
        Assertions.assertNotEquals(vehicle.getColor().get(), validColor);

    }

    @Test
    public void setSensors() {
        Engine vehicleEngine = new Engine(EngineType.ELECTRICITY, 666);
        Vehicle vehicle = new Vehicle(VehicleType.CAR, "TestVehicle", "VehicleModel",
                vehicleEngine);
        vehicle.setSensors("Autopilot");
        vehicle.setSensors("Temperature Checker");
        String validSensor = "Temperature Checker";
        String invalidSensor = "ConnectedDrive";

        List<String> getSensors = vehicle.getSensors();

        Assertions.assertTrue(getSensors.contains(validSensor));
        Assertions.assertFalse(getSensors.contains(invalidSensor));
    }

    @Test
    public void setEngine() {
        Engine testEngine = new Engine(EngineType.PETROL, 444);
        Car car = new Car(VehicleType.CAR, "BMW", "M3", testEngine, 3);

        Engine validEngine = new Engine(EngineType.DIESEL, 560);
        car.setEngine(validEngine);

        Assertions.assertEquals(validEngine, car.getEngine());
        Assertions.assertNotEquals(validEngine.getPower(), testEngine.getPower());
        Assertions.assertEquals(car.getEngine().getEngineType(), validEngine.getEngineType());
    }

    @Test
    public void generateUniqueId() {
        Engine vehicleEngine = new Engine(EngineType.ELECTRICITY, 666);
        Vehicle vehicle = new Vehicle(VehicleType.CAR, "TestVehicle", "VehicleModel",
                vehicleEngine);
        String validId = "VEHICLE-1";

        Assertions.assertFalse(vehicle.getUniqueId().contains(validId));
    }
}
