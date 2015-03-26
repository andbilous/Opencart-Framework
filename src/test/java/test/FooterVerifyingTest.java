package test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

/**
 Additional test
 */
public class FooterVerifyingTest extends BaseTest {
    Logger log;
    @Test
    public void FooterVerifyingLogOutUserTest(){
        log=Logger.getLogger(FooterVerifyingTest.class);
        HomePage homePage = new HomePage(driver);
        log.info("Home page was opened");
        Assert.assertTrue(homePage.FooterVerifying());

    }

}
