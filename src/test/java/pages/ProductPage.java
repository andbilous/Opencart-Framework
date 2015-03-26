package pages;

import libs.WebElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by 007 on 14.03.2015.
 */
public class ProductPage extends BasePage {
    WebElements elements;
    WebDriver driver;

    public ProductPage(WebDriver driver){
        this.driver = driver;
        elements = new WebElements(driver);
    }
private void addToCartBtn(){
    elements.clickButton("ProductPage.AddToCartBtn");
}

    public void addToCart(){this.addToCartBtn();}

    public CartPage openShoppingCart(){
        elements.clickLink("HomePage.ShoppingCart");
        return PageFactory.initElements(driver,CartPage.class);
    }
    public CategoryPage pageBack(){
        driver.navigate().back();
        System.out.println("Back to Category page");
        return PageFactory.initElements(driver,CategoryPage.class);
    }
    public String getProductName(){
       String a =driver.findElement(By.xpath(".//*[@id='content']/h1")).getText();
        return a;
    }
    public void addToWishList(){
        elements.clickLink("ProductPage.AddTOWishList");
    }
    public WishList openWishList(){
        elements.clickLink("HomePage.WishList");
        return PageFactory.initElements(driver,WishList.class);
    }
}
