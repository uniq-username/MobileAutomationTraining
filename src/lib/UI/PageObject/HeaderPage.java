package lib.UI.PageObject;

import io.appium.java_client.AppiumDriver;
import lib.CoreTestCase;
import lib.UI.BaseMethods;
import org.openqa.selenium.By;

public class HeaderPage extends CoreTestCase {
    BaseMethods baseMethods;
    OnboardingPage onboardingPage;
    public HeaderPage(AppiumDriver driver){
        super(driver);
        baseMethods = new BaseMethods(driver);
        onboardingPage = new OnboardingPage(driver);
    }
    //Локатор кнопки выхода на главную
    public By closeArticlePageButton = By.xpath("//android.widget.ImageButton[@content-desc=\"Перейти вверх\"]");
    //Локатор кнопки меню на странице статьи
    public By menuButton = By.xpath("//android.widget.ImageView[@content-desc=\"Ещё\"]");
    //Локатор пункта меню сохранения статьи
    public By menuItemMore = By.xpath("//*[@text = 'Добавить в список для чтения']");

    public void openSaveArticleWindow(){
        //Кликаем на кнопку меню
        baseMethods.waitElementAndClick(menuButton, 5);
        //Находим и кликаем пункт меню
        baseMethods.waitElementAndClick(menuItemMore, 5);
        try {
            //Тапаем по кнопке онбординга
            baseMethods.waitElementAndClick(onboardingPage.onboardingButton, 5);
        }catch (Exception e){}
    }
}
