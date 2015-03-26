
package test;

import org.eclipse.jetty.util.log.Log;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterAccountPage;

import static test.TestData.*;

public class RegisterAccountTest extends BaseTest {
   @Test
    public void registerAccountTest()  {
       RegisterAccountPage registerAccountPage = new RegisterAccountPage(driver);
       registerAccountPage.registerUserWithRequiredFields(FIRSTNAME,LASTNAME,EMAIL,TELEPHONE,ADDRESS1,CITY,
               COUNTRY,REGION,PASSWORD);

       Assert.assertEquals(driver.getTitle(), "Your Account Has Been Created!");
       Log.info("Test RegisterAccountTest was passed");
   }
}