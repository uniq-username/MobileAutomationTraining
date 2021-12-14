package lib.UI.PageObject;

import io.appium.java_client.AppiumDriver;
import lib.CoreTestCase;
import org.openqa.selenium.By;

public class MainPage extends CoreTestCase {
    public MainPage(AppiumDriver driver){
        super(driver);
    }
    //Локатор строки поиска на главной странице по xpath
    public By textField = By.id("org.wikipedia:id/search_container");
    //Локатор сохраненных статей
    public By savedArticles = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout");

}
