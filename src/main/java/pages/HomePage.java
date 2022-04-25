package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

//se crean los elementos
    @FindBy(id="gh-ac")
    private WebElement searchBar;

    @FindBy(id="gh-btn")
    private WebElement searchButton;

//Busca de acuerdo al string que se requiera
    public void search(String search) throws Exception {
        searchBar.sendKeys(search);
        applyWait(webDriver, searchButton, "clickable", 5);
        searchButton.click();
    }
}
