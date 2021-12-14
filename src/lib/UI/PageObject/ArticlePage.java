package lib.UI.PageObject;

import io.appium.java_client.AppiumDriver;
import lib.CoreTestCase;
import lib.UI.BaseMethods;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ArticlePage extends CoreTestCase {
    BaseMethods baseMethods;
    public ArticlePage(AppiumDriver driver){
        super(driver);
        baseMethods = new BaseMethods(driver);
    }
    //Локатор заголовка страницы
    public By viewPageTitleText = By.id("org.wikipedia:id/view_page_title_text");
}
