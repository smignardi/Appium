package test;

import base.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import page.LoginPage;
import utilities.Logs;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @Test
    public void invalidCredentialsTest(){
        loginPage.fillForm("aaa","aaa");
        loginPage.verifyErrorMessage("Username and password do not match any user in this service.");
    }

    @Test
    public void lockedOutUserTest(){
        loginPage.fillForm("locked_out_user","secret_sauce");
        loginPage.verifyErrorMessage("Sorry, this user has been locked out.");
    }

    @Override
    public void initPages(AndroidDriver driver) {
        loginPage = new LoginPage(driver);
    }
}
