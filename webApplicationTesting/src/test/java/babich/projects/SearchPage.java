package babich.projects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {
    public WebDriver driver;
    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchField;

    @FindBy(xpath = "//h2[@data-test-id='articleTitle']")
    private List<WebElement> articles;

    public void setSearchField(String searchField) {
        this.searchField.sendKeys(searchField + "\n");
    }
}
