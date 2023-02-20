package page;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SuccessPage extends BasePage {
    private final By checkoutCompleteContainer = new AppiumBy.ByAccessibilityId("test-CHECKOUT: COMPLETE!");

    public SuccessPage(AndroidDriver driver) {
        super(driver);
    }

    @Override
    @Step("Waiting Success Page to load")
    public void waitPageToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutCompleteContainer));
    }

    @Override
    @Step("Verifying Success Page")
    public void verifyPage(){
        softAssert.assertTrue(driver.findElement(checkoutCompleteContainer).isDisplayed());
        softAssert.assertAll();
    }
}
