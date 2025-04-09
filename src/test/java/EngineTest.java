import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.pja.edu.s27619.vehicle.component.Engine;
import pl.pja.edu.s27619.vehicle.component.EngineType;


public class EngineTest {

    @Test
    public void setEngineTypeAndPower() {
        Engine testEngine = new Engine(EngineType.PETROL, 444);
        Engine validEngine = new Engine(EngineType.DIESEL, 554);
        testEngine.setEngineType(EngineType.DIESEL);
        testEngine.setPower(900);

        Assertions.assertEquals(testEngine.getEngineType(), validEngine.getEngineType());
        Assertions.assertNotEquals(testEngine.getPower(), validEngine.getPower());
    }

}
