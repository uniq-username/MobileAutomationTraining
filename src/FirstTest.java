import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

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
        capabilities.setCapability("deviceName", "test1");
        capabilities.setCapability("platformVersion", "11.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "com.yandex.zen");
        capabilities.setCapability("appActivity", ".ZenWelcomeActivity");
        capabilities.setCapability("app", "/Users/ilya-slivakov/Desktop/LearnQa/MobileAutomationTraining/apks/ZenApp.apk");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }

    @Test
    public void test1()
    {
        String path = System.getProperty("user.dir");
        File jpgFile = new File(path + "/Resourсes/successfulLaunchScreen.jpg");
        try {
            Desktop.getDesktop().open(jpgFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDawn()
    {
        driver.quit();
    }
}
