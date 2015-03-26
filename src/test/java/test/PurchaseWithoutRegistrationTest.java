package test;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import static test.TestData.*;

public class PurchaseWithoutRegistrationTest extends BaseTest {
Logger logger;
    WebDriverWait wait;
@Test
public void purchaseWithoutRegistrationTest () {
logger=Logger.getLogger(PurchaseWithoutRegistrationTest.class);
    HomePage homePage = new HomePage(driver);
    CategoryPage categoryPage= homePage.goToTabletsCategoryPage();
 ProductPage productPage= categoryPage.openProductPage(ProductName1);
  productPage.addToCart();
    CartPage cart= productPage.openShoppingCart();
   CheckOutPage checkOutPage= cart.openCheckoutPage();
    checkOutPage.checkOutGuestAccount(true,true);
    wait=new WebDriverWait(driver,25);
    Assert.assertEquals(driver.getTitle(),"Your Order Has Been Processed!");

}

}
