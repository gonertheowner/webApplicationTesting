package babich.projects;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class LoginTest {
    public static MainPage mainPage;
    public static LoginPage loginPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

        //создание экземпляра драйвера
        driver = new ChromeDriver();

        mainPage = new MainPage(driver);

        loginPage = new LoginPage(driver);

        //окно разворачивается на полный экран
        driver.manage().window().maximize();

        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //получение ссылки на страницу из файла настроек
        driver.get(ConfProperties.getProperty("page"));
    }

    @Test
    public void logInTest() {
        mainPage.clickProfileButton();
        mainPage.clickLogInButtonInMainPage();
        loginPage.inputEmail(ConfProperties.getProperty("email"));
        loginPage.inputPassword(ConfProperties.getProperty("password"));
        loginPage.clickLogInButtonInAuthorizationPage();
        mainPage.clickProfileButton();
        String userName = mainPage.getUserName();
        Assert.assertEquals(ConfProperties.getProperty("username"), userName);
    }
}