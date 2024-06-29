package setup;

import factory.DriverFactory;
import org.junit.jupiter.api.AfterEach;

public class MobileTestSetup {
    @AfterEach
    public void tearDown(){
        if (DriverFactory.getInstance().getDriver() != null) {
            DriverFactory.getInstance().getDriver().quit();
        }
    }
}
