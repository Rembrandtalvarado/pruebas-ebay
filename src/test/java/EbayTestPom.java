import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;

import java.nio.file.Paths;
import java.time.Duration;

public class EbayTestPom {
    private WebDriver driver;
    private HomePage homePage;
    private ProductsPage productsPage;
    private String pathChrome;

    @BeforeSuite
    public void beforeSuite() {
        pathChrome = Paths.get(System.getProperty("user.dir"), "src/main/resources/chromedriver.exe").toString();
        System.setProperty("webdriver.chrome.driver", pathChrome.toString());
    }

    @BeforeTest
    public void beforeTest() throws Exception {
        driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
    }

    @AfterMethod
    public void afterMethod() throws Exception {
        try {
            driver.manage().deleteAllCookies();
            driver.quit();
        }catch (Exception err) {
            Reporter.log(err.getMessage());
        }
    }

    @Test
    public void firstTestChrome(){
        try {
        //Busca en ebay shoes
            homePage.search("shoes");
            //Thread.sleep(1000);

        //Selecciona la categoría adidas
            productsPage.selectAdidas();
            //Thread.sleep(2000);

        //Verifica que haya más de 2000 resultados
            Assert.assertTrue(productsPage.totalStock() > 2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
