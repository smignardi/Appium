package base;

import data.DataCaller;
import io.appium.java_client.android.AndroidDriver;
import listeners.InvokeMethodListeners;
import listeners.SuiteListeners;
import listeners.TestListeners;
import net.bytebuddy.utility.Invoker;
import org.testng.IInvokedMethodListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.internal.invokers.InvokedMethodListenerInvoker;
import page.LoginPage;
import utilities.DriverManager;
import utilities.Logs;

@Listeners({TestListeners.class, SuiteListeners.class, InvokeMethodListeners.class})
public abstract class BaseTest {
    protected final String regression = "Regression";
    protected final String smoke = "Smoke";
    protected final String setup = "Setup";
    private AndroidDriver driver;
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

    public AndroidDriver getDriver() {
        return driver;
    }

    protected void triggerDeeplink(String url){
        driver.get(url);
    }

    public abstract void initPages(AndroidDriver driver);
}
