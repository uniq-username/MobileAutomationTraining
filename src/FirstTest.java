import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class FirstTest {
    private AppiumDriver driver;
    public File successfulLaunchScreen = new File("/Users/ilya-slivakov/Desktop/LearnQa/MobileAutomationTraining/apks/successfulLaunchScreen.jpg");

    @Before
    public void setUp() throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "MiA3");
        capabilities.setCapability("platformVersion", "10.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "/Users/ilya-slivakov/Desktop/LearnQa/MobileAutomationTraining/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }

//    @Test
//    public void test1()
//    {
//        String path = System.getProperty("user.dir");
//        File jpgFile = new File(path + "/Resourсes/successfulLaunchScreen.jpg");
//        try {
//            Desktop.getDesktop().open(jpgFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void searchFieldContainsText()
    {
        By by = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView");
        assertElementHasText(by, "Поиск по Википедии", "Element text does not match expectations");
    }

    @After
    public void tearDawn()
    {
        driver.quit();
    }

    private void assertElementHasText(By by, String expectedText, String errorText){
        WebElement element = waitForElement(by, 5);
        Assert.assertTrue(errorText, element.getText().contains(expectedText));
    }
    private WebElement waitForElement(By by, long timeInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
