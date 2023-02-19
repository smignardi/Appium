package page;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import static io.qameta.allure.Allure.step;

public class TopBarPage extends BasePage {
    private final By menuButton = new AppiumBy.ByAccessibilityId("test-Menu");
    private final By cartButton = new AppiumBy.ByAccessibilityId("test-Cart");

    public TopBarPage(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        step("Waiting Top Bar Page to load");
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(menuButton));
        }
    }

    @Override
    public void verifyPage(){
        step("Verify Top Bar Page elements to load");
        {
            softAssert.assertTrue(driver.findElement(menuButton).isDisplayed());
            softAssert.assertTrue(driver.findElement(cartButton).isDisplayed());
            softAssert.assertAll();
        }
    }
}
