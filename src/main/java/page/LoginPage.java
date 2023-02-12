package page;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utilities.Logs;

import static io.qameta.allure.Allure.step;

public class LoginPage extends BasePage {
    private final By usernameInput = new AppiumBy.ByAccessibilityId("test-Username");
    private final By passwordInput = new AppiumBy.ByAccessibilityId("test-Password");
    private final By loginButton = new AppiumBy.ByAccessibilityId("test-LOGIN");
    private final By errorMessage = new AppiumBy.ByAccessibilityId("test-Error message");

    private By getErrorMessageBy(String messageText){
        final var uiautomator2Locator = String.format("text(\"%s\")",messageText);
        return AppiumBy.androidUIAutomator(uiautomator2Locator);
    }

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        step("Waiting Login Page to load");{
            wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        }
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(driver.findElement(usernameInput).isDisplayed());
        softAssert.assertTrue(driver.findElement(passwordInput).isDisplayed());
        softAssert.assertTrue(driver.findElement(loginButton).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Filling username with {0} and password {1}")
    public void fillForm(String username, String password){
        Logs.info(String.format("Filling the username %s",username));
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        driver.findElement(usernameInput).sendKeys(username);

        Logs.info(String.format("Filling the password %s",password));
        driver.findElement(passwordInput).sendKeys(password);

        Logs.info(String.format("Clicking on login button"));
        driver.findElement(loginButton).click();
    }

    @Step("Verifying error message is displayed")
    public void verifyErrorMessage(String message){
        Logs.info("Verifying error message is displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        Assert.assertTrue(driver.findElement(getErrorMessageBy(message)).isDisplayed());
    }
}
