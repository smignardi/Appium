package login;

import base.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import page.LoginPage;
import page.TopBarPage;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private TopBarPage topBarPage;

    @Test(groups = {regression})
    @Step("Verifying page")
    public void verifyPage(){
        loginPage.waitPageToLoad();
        loginPage.verifyPage();
    }

    @Test(groups = {smoke,regression})
    @Step("Verifying valid credential test")
    public void validCredentialsTest(){
        final var validCredentials = dataCaller.getValidCredential();
        loginPage.fillForm(validCredentials.getUsername(), validCredentials.getPassword());
        topBarPage.waitPageToLoad();
        topBarPage.verifyPage();
    }

    @Test(groups = {regression})
    @Step("Verifying invalid credential test")
    public void invalidCredentialsTest(){
        final var invalidCredentials = dataCaller.getInvalidCredential();
        loginPage.fillForm(invalidCredentials.getUsername(), invalidCredentials.getPassword());
        loginPage.verifyErrorMessage(dataCaller.getInvalidErrorMessage());
    }

    @Test(groups = {regression})
    @Step("Verifying locked out user test")
    public void lockedOutUserTest(){
        final var lockedCredentials = dataCaller.getLockedCredential();
        loginPage.fillForm(lockedCredentials.getUsername(), lockedCredentials.getPassword());
        loginPage.verifyErrorMessage(dataCaller.getLockedErrorMessage());
    }

    @Test(groups = {regression})
    @Step("Verifying locked out user tap test")
    public void lockedOutUserTapTest(){
        loginPage.scrollLockedOutUserLogin();
        loginPage.clickOnLogin();
        loginPage.verifyErrorMessage(dataCaller.getLockedErrorMessage());
    }

    @Override
    public void initPages(AndroidDriver driver) {
        loginPage = new LoginPage(driver);
        topBarPage = new TopBarPage(driver);
    }
}
