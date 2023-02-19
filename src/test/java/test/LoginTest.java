package test;

import base.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import page.LoginPage;
import page.TopBarPage;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private TopBarPage topBarPage;

    @Test(groups = {regression})
    public void verifyPage(){
        loginPage.waitPageToLoad();
        loginPage.verifyPage();
    }

    @Test(groups = {smoke,regression})
    public void validCredentialsTest(){
        final var validCredentials = dataCaller.getValidCredential();
        loginPage.fillForm(validCredentials.getUsername(), validCredentials.getPassword());
        topBarPage.waitPageToLoad();
        topBarPage.verifyPage();
    }

    @Test(groups = {regression})
    public void invalidCredentialsTest(){
        final var invalidCredentials = dataCaller.getInvalidCredential();
        loginPage.fillForm(invalidCredentials.getUsername(), invalidCredentials.getPassword());
        loginPage.verifyErrorMessage(dataCaller.getInvalidErrorMessage());
    }

    @Test(groups = {regression})
    public void lockedOutUserTest(){
        final var lockedCredentials = dataCaller.getLockedCredential();
        loginPage.fillForm(lockedCredentials.getUsername(), lockedCredentials.getPassword());
        loginPage.verifyErrorMessage(dataCaller.getLockedErrorMessage());
    }

    @Override
    public void initPages(AndroidDriver driver) {
        loginPage = new LoginPage(driver);
        topBarPage = new TopBarPage(driver);
    }
}
