package test;

import libs.WebElements;
import org.eclipse.jetty.util.log.Log;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CategoryPage;
import pages.HomePage;
import pages.ProductPage;
import org.apache.log4j.Logger;
import static test.TestData.*;

public class CartVerifyingTest extends  BaseTest{

    @Test
    public void cartVerifyingTest() {

        HomePage homePage = new HomePage(driver);
        CategoryPage categoryPage= homePage.goToDesktopsCategoryPage();
        ProductPage productPage= categoryPage.openProductPage(ProductName2);

        productPage.addToCart();
        Log.info("Product with name" + ProductName2 + " was added");
        String firstProductName =productPage.getProductName();

        CategoryPage categoryPage2=productPage.pageBack();
        ProductPage productPage2=categoryPage2.openProductPage(ProductName3);
        productPage2.addToCart();
        Log.info("Product with name"+ProductName3+" was added");
        String secondProductName=productPage2.getProductName();
        CartPage cartPage = new CartPage(driver);
        cartPage.openCart();
        Assert.assertEquals(cartPage.getProductName(1), firstProductName);
        Assert.assertEquals(cartPage.getProductName(2),secondProductName);
        Log.info("Test CartVerifyingTest was passed");
    }




}