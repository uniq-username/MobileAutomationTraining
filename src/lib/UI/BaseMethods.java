package lib.UI;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import lib.CoreTestCase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseMethods extends CoreTestCase {
    public BaseMethods(AppiumDriver driver){
        super(driver);
    }

    public WebElement waitForElement(By by, long timeInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.withMessage(errorFindElement(by) + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void swipeTo(int timeOfSwipe, double startPositionX, double endPositionX, double startPositionY, double endPositionY)
    {
        TouchAction action = new TouchAction(driver);
        action.press((int)startPositionX, (int)startPositionY).waitAction().moveTo((int)endPositionX, (int)endPositionY).release().perform();
    }

    public void swipeElement(By by){
        WebElement element = waitForElement(by, 5);
        int leftX = element.getLocation().getX();
        int rightX = leftX + element.getSize().getWidth();
        int leftY = element.getLocation().getY();
        int rightY = leftY + element.getSize().getHeight();

        swipeTo(5, leftX, rightX, leftY, rightY);
    }

    public void waitElementAndClick(By by, int timeOutInSeconds){
        WebElement element = waitForElement(by, timeOutInSeconds);
        element.click();
    }

    public void waitElementAndSendKeys(By by, int timeOutInSeconds, String keys){
        WebElement element = waitForElement(by, timeOutInSeconds);
        element.clear();
        element.sendKeys(keys);
    }

    public void assertElementPresent(By by){
        WebElement element = driver.findElement(by);
        Assert.assertTrue(element.isDisplayed());
    }

    public String uniqName(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("hhmmss");
        return "MyTestList" + dateFormat.format(date);
    }
    public String errorFindElement(By by){
        return "Cannot find element with locator: " + by.toString();
    }

    public void assertObjectContainsText(By by, String findText){
        String articleTitleText = waitForElement(by, 5).getText();
        Assert.assertTrue(articleTitleText.contains(findText));
    }
}
