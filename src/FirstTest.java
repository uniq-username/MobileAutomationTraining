import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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
        //локатор строки поиска на главной странице по xpath
        By textField = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView");
        //локатор строки поиска на странице поиска по id
        By searchField = By.id("org.wikipedia:id/search_src_text");
        //локатор результатов поиска
        By searResults = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
        //локатор первого результата поиска
        By firstSearchResult = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView");
        //локатор кнопки сброса поиска
        By cancelSearchButton = By.id("org.wikipedia:id/search_close_btn");
        //локатор изображения страницы поиска без результатов
        By emptySearchImg = By.id("org.wikipedia:id/search_empty_image");
        //локатор текста страницы поиска без результатов
        By emptySearchText = By.id("org.wikipedia:id/search_empty_message");



        //кликаем на элемент
        waitForElement(textField, 5).click();

        //ждем и находим поисковую строку на странице поиска
        waitForElement(searchField, 5).sendKeys("java");

        //ждем появление первого результата поиска
        WebElement firstElementSearchResult = waitForElement(firstSearchResult, 5);

        //Создаем массив из результатов поиска
        List<WebElement> webElementsList = driver.findElements(searResults);

        //Проверяем что размер списка элементов больше 1-го
        Assert.assertTrue("Incorrect array size", webElementsList.size() > 1);

        //Кликаем по кнопке сброса поиска
        driver.findElement(cancelSearchButton).click();

        //Находим текст на странице с нулевым результатом поиска
        WebElement emptySearchTextElement = waitForElement(emptySearchText, 5);

        //Находим текст на странице с нулевым результатом поиска
        WebElement emptySearchImgElement = waitForElement(emptySearchImg, 5);

        //Проверяем что отсутствуют результаты поиска из предыдущего шага
        Assert.assertNotEquals("The item is displayed", firstElementSearchResult, emptySearchTextElement);
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
