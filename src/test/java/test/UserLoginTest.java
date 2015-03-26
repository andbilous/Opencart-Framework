package test;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountLoginPage;


public class UserLoginTest extends BaseTest   {

    @Test
   public void userLoginTest(){
       AccountLoginPage accountLoginPage = PageFactory.initElements(driver,AccountLoginPage.class);
       accountLoginPage.login("andbilous@gmail.com","456456");
       Assert.assertEquals(driver.getTitle(), "My Account");

   }

}









