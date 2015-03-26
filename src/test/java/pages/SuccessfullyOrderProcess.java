package pages;

import libs.WebElements;
import org.openqa.selenium.WebDriver;


public class SuccessfullyOrderProcess {
    WebDriver driver ;
    WebElements elements ;

    SuccessfullyOrderProcess(WebDriver driver){
        this.driver = driver;
        elements = new WebElements(driver);
    }
}
