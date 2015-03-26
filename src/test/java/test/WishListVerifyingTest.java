
package test;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import static test.TestData.*;

public class WishListVerifyingTest extends BaseTest {
@Test
    public void WishListVerifyingTest(){
    AccountLoginPage accountLoginPage = PageFactory.initElements(driver, AccountLoginPage.class);
    accountLoginPage.login(WISHLISTLOGIN,WISHLISTPASS);
   HomePage homePage=new HomePage(driver);
    CategoryPage categoryPage= homePage.goToDesktopsCategoryPage();
    ProductPage productPage= categoryPage.openProductPage(WISHLISTPRODUCTNAME);
    String firstProductName=productPage.getProductName();
    productPage.addToWishList();
    WishList wishList= productPage.openWishList();
    Assert.assertEquals(firstProductName,wishList.getFirstProductText());
    //@AfterTest
    wishList.deleteFirstProduct();
}

}


