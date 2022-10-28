package babich.projects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@id='email_field']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='password_field']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@name='go']")
    private WebElement logInButtonInAuthorizationPage;

    public void inputEmail(String email) {
        emailField.sendKeys(email);
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLogInButtonInAuthorizationPage() {
        logInButtonInAuthorizationPage.click();
    }
}
