package pages;

import libs.WebElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static test.TestData.CARTURL;
public class CartPage {
    public WebElements elements;
    public WebDriver driver;

    public CartPage(WebDriver driver) {


        this.driver = driver;
        elements = new WebElements(driver);
    }
    public void openCart(){
        elements.openURL(CARTURL);
    }
 public CheckOutPage openCheckoutPage(){
     elements.clickButton("CheckOutBtn");
     return PageFactory.initElements(driver,CheckOutPage.class);
 }
    public String  getProductName(int number){
        String a=driver.findElement(By.xpath(".//*[@id='content']/form/div/table/tbody/tr["+number+"]/td[2]/a")).getText();
        return a;
    }






}
