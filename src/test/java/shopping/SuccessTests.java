package shopping;

import base.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import page.SuccessPage;

public class SuccessTests extends BaseTest {
    private SuccessPage successPage;

    @Test
    public void deepLinkTest(){
        triggerDeeplink("swaglabs://complete");
        successPage.waitPageToLoad();
        successPage.verifyPage();
    }

    @Override
    public void initPages(AndroidDriver driver) {
        successPage=new SuccessPage(driver);
    }
}
