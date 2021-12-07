import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.List;
import java.util.Locale;

public class FirstTest {
    private AppiumDriver driver;
    //public File successfulLaunchScreen = new File("/Users/ilya-slivakov/Desktop/LearnQa/MobileAutomationTraining/apks/successfulLaunchScreen.jpg");

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

    @Test
    public void searchFieldContainsText()
    {
//        //локатор строки поиска на главной странице по xpath
//        By textField = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView");
//        //локатор строки поиска на странице поиска по id
//        By searchField = By.id("org.wikipedia:id/search_src_text");
//        //локатор результатов поиска
//        By searResults = By.id("org.wikipedia:id/page_list_item_title");
//        //локатор первого результата поиска
//        By firstSearchResult = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView");
//        //локатор кнопки сброса поиска
//        By cancelSearchButton = By.id("org.wikipedia:id/search_close_btn");
//        //локатор изображения страницы поиска без результатов
//        By emptySearchImg = By.id("org.wikipedia:id/search_empty_image");
//        //локатор текста страницы поиска без результатов
//        By emptySearchText = By.id("org.wikipedia:id/search_empty_message");

        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    @After
    public void tearDawn()
    {
        //Проверяем ориентацию экрана и если она не портретная то меняем
        if (driver.getOrientation() != ScreenOrientation.PORTRAIT){
            driver.rotate(ScreenOrientation.PORTRAIT);
        }
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
