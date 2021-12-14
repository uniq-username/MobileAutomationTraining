package lib.UI.PageObject;

import io.appium.java_client.AppiumDriver;
import lib.CoreTestCase;
import org.openqa.selenium.By;

public class FooterPage extends CoreTestCase {
    public FooterPage(AppiumDriver driver){
        super(driver);
    }
    //Локатор кнопки списков сохраненных статей
    public By savedListButton = By.xpath("//android.widget.FrameLayout[@content-desc=\"Мои списки\"]/android.widget.ImageView\n");
}
