package pages;

import libs.WebElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static test.TestData.DesktopsCategoryURL;
//import static libs.Drivers.driver;


public class CategoryPage extends BasePage {


  WebDriver driver ;
   WebElements elements ;




   public CategoryPage( WebDriver driver) {

       this.driver = driver;
       elements = new WebElements(driver);

    }



    public void productAddToCart(int ProductNumber){
   WebElement elem =  driver.findElement(By.xpath(".//*[@id='content']/div[6]/div[" + ProductNumber + "]/div[1]/div[1]/input"));
        elem.click();

    }
    public void productAddToWishList (int ProductNumber){
        WebElement elem = driver.findElement(By.xpath(".//*[@id='content']/div[4]/div[" + ProductNumber + "]/div[1]/div[2]/a"));
        elem.click();
    }
    public CartPage openCart(){
        return new CartPage(driver);
    }


    public void openDesktopsCategory() {
        elements.openURL(DesktopsCategoryURL);

    }
    public ProductPage openProductPage(String productName){
        WebElement element = driver.findElement(new By.ByLinkText(productName));
        element.click();
        return PageFactory.initElements(driver,ProductPage.class);

    }

}
