package test;

import base.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import page.LoginPage;
import utilities.Logs;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    @Test
    public void launchAppTest() {
        try{
            Thread.sleep(2500);
        }catch (InterruptedException interruptedException){
            Logs.error(interruptedException.getLocalizedMessage());
        }
    }

    @Test
    public void unhappyTest() {
        loginPage.fillForm("steven","mignardi");
        loginPage.verifyErrorMessage();
        try{
            Thread.sleep(2500);
        }catch (InterruptedException interruptedException){
            Logs.error(interruptedException.getLocalizedMessage());
        }
    }

    @Override
    public void initPages(AndroidDriver driver) {
        loginPage = new LoginPage(driver);
    }
}
