package pages;

import libs.WebElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class AccountLoginPage  {
 WebDriver driver ;
     WebElements elements ;

    public AccountLoginPage(WebDriver driver){
      this.driver = driver;
     elements = new WebElements(driver);
      elements.openURL("http://www.group-one-project.tk/index.php?route=account/login");

    }

    public MyAccountPage login (String email,String password){
        elements.clearField("AccountLoginPage.Email");
        elements.inputText("AccountLoginPage.Email", email);
        elements.clearField("AccountLoginPage.Password");
        elements.inputText("AccountLoginPage.Password", password);
        elements.clickLink("AccountLoginPage.LoginBtn");

        return PageFactory.initElements(driver,MyAccountPage.class);
    }







}
