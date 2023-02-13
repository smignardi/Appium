package base;

import data.DataCaller;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.DriverManager;
import utilities.Logs;

public abstract class BaseTest {
    protected final String regression = "Regression";
    protected final String smoke = "Smoke";
    protected final String setup = "Setup";
    protected AndroidDriver driver;
    protected DataCaller dataCaller = new DataCaller();

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        driver = new DriverManager().buildLocalDriver();
        initPages(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(){
        Logs.debug("Killing the driver");
        driver.quit();
    }

    public abstract void initPages(AndroidDriver driver);
}
