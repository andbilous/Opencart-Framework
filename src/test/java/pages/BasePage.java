package pages;


import libs.WebElements;
import org.openqa.selenium.WebDriver;

public class BasePage {
    WebDriver driver ;
     WebElements elements  ;

    public BasePage (WebDriver driver){

        this.driver = driver; //
        elements = new WebElements(driver);

    }

    public BasePage() {
        elements = new WebElements(driver);
    }

   /* public void openShoppingCart(){
        elements.clickLink("HomePage.ShoppingCart");
    }
*/
}
