package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage{

       public ProductsPage(WebDriver driver) {
        super(driver);
    }

//Se crean los elementos
    @FindBy(xpath="(//input[@type='checkbox'])[10]")
    WebElement adidas;

    @FindBy(css = ".srp-controls__count-heading > span:nth-child(1)")
    WebElement countOfProducts;

//Le hace click a adidas
    public void selectAdidas() throws Exception {
        adidas.click();
    }

//Verifica la cantidad de resultados que hay, las convierte a un entero y las devuelve.
    public int totalStock() {
        String strCount = countOfProducts.getText().replace(".","");
        return Integer.parseInt(strCount);
    }

}
