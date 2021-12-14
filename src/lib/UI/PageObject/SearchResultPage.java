package lib.UI.PageObject;

import io.appium.java_client.AppiumDriver;
import lib.CoreTestCase;
import lib.UI.BaseMethods;
import org.openqa.selenium.By;

public class SearchResultPage extends CoreTestCase {
    MainPage mainPage;
    BaseMethods baseMethods;
    public SearchResultPage(AppiumDriver driver){
        super(driver);
        mainPage = new MainPage(driver);
        baseMethods = new BaseMethods(driver);
    }
    //Локатор строки поиска на странице поиска по id
    public By searchField = By.id("org.wikipedia:id/search_src_text");
    //локатор всех отображаемых результатов поиска
    public By selectSearchResultElement(int num)
    {
        return By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[" + num + "]/android.widget.ImageView");
    }
    //Локатор сохраненных статей с текстом
    public By articleInSavedListWithText(String text){
        return  By.xpath("//*[./*[@text='" + text + "']]");
    }
    //Поиск и переход по поисковому запросу
    public void openSearchResultPage(String searchText, int resultNumber){
        //Тапаем на строку поиска
        baseMethods.waitElementAndClick(mainPage.textField, 5);
        //Вводим поисковый запрос
        baseMethods.waitElementAndSendKeys(searchField, 5, searchText);
        //Тапаем на результат поиска
        baseMethods.waitElementAndClick(selectSearchResultElement(resultNumber),5);
    }
}
