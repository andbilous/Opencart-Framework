package pages;

//import libs.Drivers;
import libs.WebElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static libs.ConfigData.ui;
import static test.TestData.*;


public class HomePage {
    public WebDriver driver ;
   public   WebElements elements  ;

    public HomePage(WebDriver driver){

       this.driver = driver; //
       elements = new WebElements(driver);
        elements.openURL(BASEURL);
    }




    public boolean isUserLoggedIn(){

   if
           (driver.findElement(ui("HomePage.LoginPageLink")).getText().equals("login")){
       return false;
   }else

      return true;

    }

   public CategoryPage goToDesktopsCategoryPage() {
       elements.openURL(DesktopsCategoryURL);
       return PageFactory.initElements(driver,CategoryPage.class);
   }
    public CategoryPage goToTabletsCategoryPage(){
        elements.openURL(TabletsCategoryUrl);
        return PageFactory.initElements(driver,CategoryPage.class);
    }
    public boolean FooterVerifying(){
     if ((driver.findElement(ui("Footer.AboutUs")).getText().equals(footerLink1Text)))
        return true;
        else return false;
    }
    /*
    Footer.AboutUs=xpath(".//*[@id='footer']/div[1]/ul/li[1]/a")
Footer.DeliveryInfo=xpath(".//*[@id='footer']/div[1]/ul/li[2]/a")
Footer.PrivacyPolicy=xpath(".//*[@id='footer']/div[1]/ul/li[3]/a")
Footer.TermsAndConditions=xpath(".//*[@id='footer']/div[1]/ul/li[4]/a")
Footer.ContactUs=xpath(".//*[@id='footer']/div[2]/ul/li[1]/a")
Footer.Returns=xpath(".//*[@id='footer']/div[2]/ul/li[2]/a")
Footer.SiteMap=xpath(".//*[@id='footer']/div[2]/ul/li[3]/a")
Footer.Brands=xpath(".//*[@id='footer']/div[3]/ul/li[1]/a")
Footer.GiftVouchers=xpath(".//*[@id='footer']/div[3]/ul/li[2]/a")
Footer.Affiliates=xpath(".//*[@id='footer']/div[3]/ul/li[3]/a")
Footer.Specials=xpath(".//*[@id='footer']/div[3]/ul/li[4]/a")
Footer.MyAccount=xpath(".//*[@id='footer']/div[4]/ul/li[1]/a")
Footer.OrderHistory=xpath(".//*[@id='footer']/div[4]/ul/li[2]/a")
Footer.WishList=xpath(".//*[@id='footer']/div[4]/ul/li[3]/a")
Footer.NewsLetter=xpath(".//*[@id='footer']/div[4]/ul/li[4]/a")

     */


}
