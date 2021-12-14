package lib.UI.PageObject;

import io.appium.java_client.AppiumDriver;
import lib.CoreTestCase;
import org.openqa.selenium.By;

public class OnboardingPage extends CoreTestCase {
    public OnboardingPage(AppiumDriver driver){
        super(driver);
    }
    //Локатор кнопки онбординга
    public By saveListNameField = By.id("org.wikipedia:id/text_input");
    //Локатор кнопки закрытия онбординга
    public By onboardingButton = By.id("org.wikipedia:id/onboarding_button");
    //Локатор кнопки подтверждения сохранения статьи в список
    public By acceptNameListButton = By.id("android:id/button1");
    //Локатор созданного списка в попапе
    public By articleListName(String listName){
        return By.xpath("//*[@text = '" + listName + "']");
    }
}
