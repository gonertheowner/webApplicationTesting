package babich.projects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class MainPage {
    public WebDriver driver;
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//div[@class='tm-header-user-menu__item tm-header-user-menu__user_desktop']")
    private WebElement profileButton;

    @FindBy(xpath = "//a[@class='tm-user-menu__auth-button']")
    private WebElement logInButtonInMainPage;

    @FindBy(xpath = "//a[@class='tm-user-item__username']")
    private WebElement userName;

    @FindBy(xpath = "//a[@href='/ru/search/']")
    private WebElement searchButton;

    public void clickProfileButton() {
        profileButton.click();
    }

    public void clickLogInButtonInMainPage() {
        logInButtonInMainPage.click();
    }

    public String getUserName() {
        return userName.getText();
    }

    public void clickSearchButton() {
        searchButton.click();
    }
}