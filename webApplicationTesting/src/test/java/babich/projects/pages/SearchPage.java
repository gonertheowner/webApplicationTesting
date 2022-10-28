package babich.projects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
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
    private List<WebElement> articles = new ArrayList<>(0);

    public void setSearchField(String searchField) {
        this.searchField.sendKeys(searchField + "\n");
    }

    public int getAmountOfArticles() {
        return articles.size();
    }
}
