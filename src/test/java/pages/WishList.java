package pages;

import libs.WebElements;
import org.openqa.selenium.WebDriver;

import static libs.ConfigData.ui;

/**
This Class is incomplete..
 */
public class WishList {
    public WebElements elements;
    public WebDriver driver;

    public WishList(WebDriver driver) {
        this.driver = driver;
        elements = new WebElements(driver);
    }
    public String getFirstProductText(){
        String a;
       a= driver.findElement(ui("WishList.FirstProduct")).getText();
        return a;
    }
   public void deleteFirstProduct(){
       elements.clickLink("WishList.DeleteFirstProduct");
   }
}
