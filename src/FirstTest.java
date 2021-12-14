import io.appium.java_client.AppiumDriver;
import lib.CoreTestCase;
import lib.UI.BaseMethods;
import lib.UI.PageObject.*;
import org.junit.*;

public class FirstTest extends CoreTestCase {
    private ArticlePage articlePage;
    private BaseMethods baseMethods;
    private SearchResultPage searchResultPage;
    private HeaderPage headerPage;
    private FooterPage footerPage;
    private OnboardingPage onboardingPage;
    public FirstTest(AppiumDriver driver) {
        super(driver);
    }
    public void setUp() throws Exception{
        super.setUp();
        baseMethods = new BaseMethods(driver);
        searchResultPage = new SearchResultPage(driver);
        headerPage = new HeaderPage(driver);
        footerPage = new FooterPage(driver);
        articlePage = new ArticlePage(driver);
        onboardingPage = new OnboardingPage(driver);
    }
    @Test
    public void testLesson4Ex5()
    {
        //Поиск элементов и поисковый запрос
        searchResultPage.openSearchResultPage("Java", 1);
        //Открываем
        headerPage.openSaveArticleWindow();
        //Находим, очищаем и заполняем поле имени нового списка
        String listName = baseMethods.uniqName();
        baseMethods.waitElementAndSendKeys(onboardingPage.saveListNameField, 5, listName);
        //Тапаем на кнопку сохранения статьи в созданный список
        baseMethods.waitElementAndClick(onboardingPage.acceptNameListButton, 5);
        //Тапаем на кнопку закрытия страницы статьи
        baseMethods.waitElementAndClick(headerPage.closeArticlePageButton,  5);
        //Поиск и переход в статью
        searchResultPage.openSearchResultPage("Python", 1);
        //Кликаем на кнопку меню на странице статьи и пункт меню
        baseMethods.waitElementAndClick(headerPage.menuButton, 5);
        baseMethods.waitElementAndClick(headerPage.menuItemMore, 5);
        //Ждем появления, находим и кликаем на созданный список сохраненных статей
        baseMethods.waitElementAndClick(onboardingPage.articleListName(listName), 5);
        //Тапаем на кнопку закрытия страницы статьи
        baseMethods.waitElementAndClick(headerPage.closeArticlePageButton, 5);
        //Тапаем на кнопку открытия списка сохраненных статей
        baseMethods.waitElementAndClick(footerPage.savedListButton, 5);
        //Находим на странице сохраненный список статей
        baseMethods.waitElementAndClick(onboardingPage.articleListName(listName), 5);
        //Удаляем статью с текстом
        baseMethods.swipeElement(searchResultPage.articleInSavedListWithText("Python"));
        //Ищем и тапаем на оставшуюся статью
        baseMethods.waitElementAndClick(searchResultPage.articleInSavedListWithText("Java"), 5);
        //Проверяем заголовок на странице статьи
        baseMethods.assertObjectContainsText(articlePage.viewPageTitleText,"Java");
    }

    @Test
    public void testLesson4Ex6(){
        //Поисковый запрос и переход в статью
        searchResultPage.openSearchResultPage("Java", 1);
        //Проверяем что на странице отображается заголовок
        baseMethods.assertElementPresent(articlePage.viewPageTitleText);
    }
}