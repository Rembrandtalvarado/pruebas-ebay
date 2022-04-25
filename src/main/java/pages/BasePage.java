package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver webDriver;

    public BasePage (WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }

    public void applyWait(WebDriver driver, WebElement element, String waitType, int seconds) throws Exception {
        WebDriverWait wait;
        switch (waitType){
            case "sleep":
                int t = (seconds * 1000);
                Thread.sleep(t);
                break;
            case "clickable":
                wait = new WebDriverWait(driver, Duration.ofSeconds((seconds)));
                wait.until(ExpectedConditions.elementToBeClickable(element));
                break;
            case "visible":
                wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
                wait.until(ExpectedConditions.visibilityOf(element));
                break;
        }
    }
}
