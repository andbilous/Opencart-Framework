package pages;


import libs.WebElements;
import org.openqa.selenium.WebDriver;

public class AccountSuccessRegisterPage {
     WebDriver driver ;
       WebElements elements  ;
    public AccountSuccessRegisterPage(WebDriver driver){

        this.driver = driver;
        elements = new WebElements(driver);
    }
}
