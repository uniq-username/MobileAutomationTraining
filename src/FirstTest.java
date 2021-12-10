import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.swing.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

class PageObject
{
    //локатор всех отображаемых результатов поиска
    public By selectSearchResultElement(int num)
    {
        return By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[" + num + "]/android.widget.ImageView");
                       ///hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.ImageView
    }
    //локатор строки поиска на главной странице по xpath
    public By textField = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView");
    //локатор строки поиска на странице поиска по id
    public By searchField = By.id("org.wikipedia:id/search_src_text");
    //локатор результатов поиска
    public By searResults = By.id("org.wikipedia:id/page_list_item_title");
    //локатор кнопки сброса поиска
    public By cancelSearchButton = By.id("org.wikipedia:id/search_close_btn");
    //локатор изображения страницы поиска без результатов
    public By emptySearchImg = By.id("org.wikipedia:id/search_empty_image");
    //локатор текста страницы поиска без результатов
    public By emptySearchText = By.id("org.wikipedia:id/search_empty_message");
    //локатор заголовка страницы
    public By viewPageTitleText = By.id("org.wikipedia:id/view_page_title_text");
    //локатор кнопки меню на странице статьи
    public By menuButton = By.xpath("//android.widget.ImageView[@content-desc=\"Ещё\"]");
    //Локатор пункта меню сохранения статьи
    public By menuItemMore = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.TextView");
    //Локатор кнопки онбординга
    public By acceptSaveArticleButton = By.id("android:id/button1");
    //Локатор кнопки перехода в сохраненные статьи в попапе
    public By toSaveArticlePageButton = By.id("org.wikipedia:id/snackbar_action");
    //Локатор заголовка списка сохраненных статей
    public By saveListTitleText = By.id("org.wikipedia:id/item_title");
    //Локатор поля ввода наименования списка сохранения
    public By saveListNameField = By.id("org.wikipedia:id/text_input");
    //Локатор кнопки закрытия онбординга
    public By onboardingButton = By.id("org.wikipedia:id/onboarding_button");
    //Локатор кнопки подтверждения сохранения статьи в список
    public By acceptNameListButton = By.id("android:id/button1");
    //Локатор кнопки поиска на странице статьи
    public By searchButtonArticlePage = By.id("org.wikipedia:id/menu_page_search");
    //Локатор созданного списка в попапе
    public By articleListName = By.id("org.wikipedia:id/item_title");
    //Локатор кнопки выхода на главную
    public By closeArticlePageButton = By.xpath("//android.widget.ImageButton[@content-desc=\"Перейти вверх\"]");
    //Локатор кнопки списков сохраненных статей
    public By savedListButton = By.xpath("//android.widget.FrameLayout[@content-desc=\"Мои списки\"]/android.widget.ImageView\n");
    //Локатор заголовков сохраненных статей
    public By savedListArticleTitle = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]");
    //Локатор кнопки меню сохраненной статьи
    public By menuButtonSavedArticle = By.xpath("(//android.widget.ImageView[@content-desc=\"Другие параметры\"])[3]");
    //Локатор пункта удаления статьи из сохраненных
    public By deleteSaveArticle = By.id("org.wikipedia:id/reading_list_item_remove_text");
    //Локатор сохраненных статей
    public By savedArticles = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout");
}

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



    private void assertElementHasText(By by, String expectedText, String errorText){
        WebElement element = waitForElement(by, 5);
        Assert.assertTrue(errorText, element.getText().contains(expectedText));
    }
    private WebElement waitForElement(By by, long timeInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected void swipeTo(int timeOfSwipe, double startPosition, double endPosition)
    {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();

        int x = (int)(size.width * 0.5);
        int startPos = (int)(size.height * startPosition);
        int endPos = (int)(size.height * endPosition);

        action.press(x, startPos).waitAction().moveTo(x, endPos).release().perform();
    }

    @Test
    public void searchFieldContainsText()
    {
        PageObject page = new PageObject();

        waitForElement(page.textField, 5).click();
        waitForElement(page.searchField, 5).sendKeys("Java");
        //Кликаем на первый элемент на странице результатов поиска
        waitForElement(page.selectSearchResultElement(1), 5).click();
        //Запоминаем заголовок статьи
        String viewPageTitleTextBefore = waitForElement(page.viewPageTitleText, 5).getText();
        //Кликаем на кнопку меню
        waitForElement(page.menuButton, 5).click();
        //Находим и кликаем пункт меню
        waitForElement(page.menuItemMore, 5).click();
        //Обработка появления онбординга
        try
        {
            waitForElement(page.onboardingButton, 5).click();
        }catch (Exception e){}

        //Находим, очищаем и заполняем поле имени нового списка
        WebElement nameListField = waitForElement(page.saveListNameField, 5);
        nameListField.clear();
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("hhmmss");
        String listName = "MyTestList" + dateFormat.format(date);
        nameListField.sendKeys(listName);
        //Тапаем на кнопку сохранения статьи в созданный список
        waitForElement(page.acceptNameListButton, 5).click();
        //Тапаем на кнопку закрытия страницы статьи
        waitForElement(page.closeArticlePageButton, 5).click();
        //Тапаем на строку поиска
        waitForElement(page.textField, 5).click();
        //Вводим поисковый запрос и проваливаемся в статью
        waitForElement(page.searchField, 5).sendKeys("Python");
        //Тапаем на результат поиска
        waitForElement(page.selectSearchResultElement(1), 5).click();
        //Кликаем на кнопку меню на странице статьи и пункт меню
        waitForElement(page.menuButton, 5).click();
        waitForElement(page.menuItemMore, 5).click();
        //Ждем появления, находим и кликаем на созданный список сохраненных статей
        waitForElement(page.articleListName, 5);
        List<WebElement> savedArticleList = driver.findElements(page.articleListName);
        //Находим сохраненный список и кликаем на него
        for (int i = 0; i < savedArticleList.size(); i++){
            if(savedArticleList.get(i).getText().contains(listName)) {
                savedArticleList.get(i).click();
                break;
            }
        }
        //Тапаем на кнопку закрытия страницы статьи
        waitForElement(page.closeArticlePageButton, 5).click();
        //Тапаем на кнопку открытия списка сохраненных статей
        waitForElement(page.savedListButton, 5).click();
        //Находим на странице сохраненный список статей
        List<WebElement> savedArticleListSecond = driver.findElements(page.articleListName);
        //Находим сохраненный список и кликаем на него
        for (int i = 0; i < savedArticleListSecond.size(); i++){
            if(savedArticleListSecond.get(i).getText().contains(listName)) {
                savedArticleListSecond.get(i).click();
                break;
            }
        }
        //Тапаем на кнопку меню и кнопку удаления статьи из сохраненных
        WebElement menuButtonSavedArticle = waitForElement(page.menuButtonSavedArticle, 5);
        List<WebElement> savedArticlesListbeforeDelete = driver.findElements(page.savedArticles);
        Assert.assertTrue(savedArticlesListbeforeDelete.size() == 2);
        menuButtonSavedArticle.click();

        //Переходим в статью и сравниванием заголовок страницы
        waitForElement(page.deleteSaveArticle, 5).click();
        WebElement saveArticle = waitForElement(page.savedArticles, 5);
        saveArticle.click();
        WebElement viewPageTitleTextAfter = waitForElement(page.viewPageTitleText, 5);
        Assert.assertTrue(viewPageTitleTextAfter.getText().contains(viewPageTitleTextBefore));
    }

    @After
    public void tearDawn()
    {
//        //Проверяем ориентацию экрана и если она не портретная то меняем
//        if (driver.getOrientation() != ScreenOrientation.PORTRAIT){
//            driver.rotate(ScreenOrientation.PORTRAIT);
//        }
        //driver.quit();
    }
}