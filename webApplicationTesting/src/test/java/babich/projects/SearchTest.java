package babich.projects;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class SearchTest {
    public static MainPage mainPage;
    public static SearchPage searchPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

        //создание экземпляра драйвера
        driver = new ChromeDriver();

        mainPage = new MainPage(driver);

        searchPage = new SearchPage(driver);

        //окно разворачивается на полный экран
        driver.manage().window().maximize();

        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //получение ссылки на страницу из файла настроек
        driver.get(ConfProperties.getProperty("page"));
    }

    @Test
    public void correctSearchTest() {
        mainPage.clickSearchButton();
        searchPage.setSearchField("JUnit");
        Assert.assertTrue(searchPage.getAmountOfArticles() > 0);
    }

    @Test
    public void incorrectSearchTest() {
        mainPage.clickSearchButton();
        searchPage.setSearchField("adgsfdsfhsfgh");
        Assert.assertEquals(0, searchPage.getAmountOfArticles());
    }
}
