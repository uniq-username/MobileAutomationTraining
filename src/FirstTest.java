import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

class PageObject
{
    //локатор всех отображаемых результатов поиска
    public By selectSearchResultElement(int num)
    {
        return By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[" + num + "]/android.widget.ImageView");
    }
    //Локатор строки поиска на главной странице по xpath
    public By textField = By.id("org.wikipedia:id/search_container");
    //Локатор строки поиска на странице поиска по id
    public By searchField = By.id("org.wikipedia:id/search_src_text");
    //Локатор результатов поиска
    public By searResults = By.id("org.wikipedia:id/page_list_item_title");
    //Локатор кнопки сброса поиска
    public By cancelSearchButton = By.id("org.wikipedia:id/search_close_btn");
    //Локатор изображения страницы поиска без результатов
    public By emptySearchImg = By.id("org.wikipedia:id/search_empty_image");
    //Локатор текста страницы поиска без результатов
    public By emptySearchText = By.id("org.wikipedia:id/search_empty_message");
    //Локатор заголовка страницы
    public By viewPageTitleText = By.id("org.wikipedia:id/view_page_title_text");
    //Локатор кнопки меню на странице статьи
    public By menuButton = By.xpath("//android.widget.ImageView[@content-desc=\"Ещё\"]");
    //Локатор пункта меню сохранения статьи
    public By menuItemMore = By.xpath("//*[@text = 'Добавить в список для чтения']");
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
    public By articleListName(String listName){
        return By.xpath("//*[@text = '" + listName + "']");
    }
    //Локатор кнопки выхода на главную
    public By closeArticlePageButton = By.xpath("//android.widget.ImageButton[@content-desc=\"Перейти вверх\"]");
    //Локатор кнопки списков сохраненных статей
    public By savedListButton = By.xpath("//android.widget.FrameLayout[@content-desc=\"Мои списки\"]/android.widget.ImageView\n");
    //Локатор заголовков сохраненных статей
    public By savedListArticleTitle = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]");
    //Локатор сохраненных статей с текстом
    public By articleInSavedListWithText(String text){
        return  By.xpath("//*[./*[@text='" + text + "']]");
    }
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

        //Проверяем ориентацию экрана и если она не портретная то меняем
        if (driver.getOrientation() != ScreenOrientation.PORTRAIT){
            driver.rotate(ScreenOrientation.PORTRAIT);
        }
    }

    protected WebElement waitForElement(By by, long timeInSeconds, String errorMessage){
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected void swipeTo(int timeOfSwipe, double startPositionX, double endPositionX, double startPositionY, double endPositionY)
    {
        TouchAction action = new TouchAction(driver);
        action.press((int)startPositionX, (int)startPositionY).waitAction().moveTo((int)endPositionX, (int)endPositionY).release().perform();
    }

    protected void swipeElement(By by, String errorMessage){
        WebElement element = waitForElement(by, 5, errorMessage);
        int leftX = element.getLocation().getX();
        int rightX = leftX + element.getSize().getWidth();
        int leftY = element.getLocation().getY();
        int rightY = leftY + element.getSize().getHeight();

        swipeTo(5, leftX, rightX, leftY, rightY);
    }

    protected void waitElementAndClick(By by, String errorMessage, int timeOutInSeconds){
        WebElement element = waitForElement(by, timeOutInSeconds, errorMessage);
        element.click();
    }

    protected void waitElementAndSendKeys(By by, int timeOutInSeconds, String keys, String errorMessage){
        WebElement element = waitForElement(by, timeOutInSeconds, errorMessage);
        element.sendKeys(keys);
    }

    public void assertElementPresent(By by){
        WebElement element = driver.findElement(by);
        Assert.assertTrue(element.isDisplayed());
    }

    @Test
    public void lesson4Ex5()
    {
        PageObject page = new PageObject();
        //Поиск элементов и поисковый запрос
        waitElementAndClick(page.textField,"Cannot find element 'textField'",5);
        waitElementAndSendKeys(page.searchField, 5, "Java", "Cannot find element 'searchField'");
        //Кликаем на первый элемент на странице результатов поиска
        waitElementAndClick (page.selectSearchResultElement(1), "Cannot find element 'selectSearchResultElement'", 5);
        //Запоминаем заголовок статьи
        String viewPageTitleTextBefore = waitForElement(page.viewPageTitleText, 5, "Cannot find element 'viewPageTitleText'").getText();
        //Кликаем на кнопку меню
        waitElementAndClick(page.menuButton, "Cannot find element 'menuButton'", 5);
        //Находим и кликаем пункт меню
        waitElementAndClick(page.menuItemMore, "Cannot find element 'menuItemMore'", 5);
        //Обработка появления онбординга
        try
        {
            waitElementAndClick(page.onboardingButton, "Cannot find element 'onboardingButton'", 5);
        }catch (Exception e){}
        //Находим, очищаем и заполняем поле имени нового списка
        WebElement nameListField = waitForElement(page.saveListNameField, 5,"Cannot find element 'saveListNameField'");
        nameListField.clear();
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("hhmmss");
        String listName = "MyTestList" + dateFormat.format(date);
        nameListField.sendKeys(listName);
        //Тапаем на кнопку сохранения статьи в созданный список
        waitElementAndClick(page.acceptNameListButton, "Cannot find element acceptNameListButton", 5);
        //Тапаем на кнопку закрытия страницы статьи
        waitElementAndClick(page.closeArticlePageButton, "Cannot find element closwArticleButton", 5);
        //Тапаем на строку поиска
        waitElementAndClick(page.textField, "Cannot find element textField", 5);
        //Вводим поисковый запрос и проваливаемся в статью
        waitElementAndSendKeys(page.searchField, 5, "Python", "Cannot find element 'searchField'");
        //Тапаем на результат поиска
        waitElementAndClick(page.selectSearchResultElement(1), "Cannot find element 'selectSearchResultElement(1)'", 5);
        //Кликаем на кнопку меню на странице статьи и пункт меню
        waitElementAndClick(page.menuButton, "Cannot find element 'menuButton'", 5);
        waitElementAndClick(page.menuItemMore, "Cannot find element 'menuItemMore", 5);
        //Ждем появления, находим и кликаем на созданный список сохраненных статей
        waitElementAndClick(page.articleListName(listName), "Cannot find element 'articleListName'", 5);
        //Тапаем на кнопку закрытия страницы статьи
        waitElementAndClick(page.closeArticlePageButton, "Cannot find element 'closeArticleButton'", 5);
        //Тапаем на кнопку открытия списка сохраненных статей
        waitElementAndClick(page.savedListButton, "Cannot find element 'savedListButton'", 5);
        //Находим на странице сохраненный список статей
        waitElementAndClick(page.articleListName(listName), "Cannot find element 'articleListName'", 5);
        //Удаляем статью с текстом
        swipeElement(page.articleInSavedListWithText("Python"), "Cannot find element 'articleInSavedListWithText'");
        //Ищем и тапаем на оставшуюся статью
        waitElementAndClick(page.articleInSavedListWithText("Java"), "Cannot find element 'articleInSavedListWithText'", 5);
        //Проверяем заголовок на странице статьи
        String articleTitleText = waitForElement(page.viewPageTitleText, 5, "Cannot find element ''viewPageTitleText").getText();
        Assert.assertTrue(articleTitleText.contains("Java"));
    }

    @After
    public void tearDawn()
    {
        driver.quit();
    }
}