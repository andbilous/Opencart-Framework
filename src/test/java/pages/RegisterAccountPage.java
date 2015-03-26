package pages;

import libs.WebElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 This test case requires changing E-mail final String in Test Data every time it is executing. Otherwise it fails.
 */
public class RegisterAccountPage {
     WebDriver driver;
    WebElements elements;

    public RegisterAccountPage(WebDriver driver){
        this.driver = driver;
        elements = new WebElements(driver);
        elements.openURL("http://www.group-one-project.tk/index.php?route=account/register");
    }

public AccountSuccessRegisterPage registerUserWithRequiredFields(String firstName,
                                                                 String lastName,
                                                                 String eMail,
                                                                 String telephone,
                                                                 String address1,
                                                                 String city,
                                                                 String country,
                                                                 String region,
                                                                 String password){


    elements.inputText("RegisterPage.FirstName",firstName);
    elements.inputText("RegisterPage.LastName",lastName);
    elements.inputText("RegisterPage.Email",eMail);
    elements.inputText("RegisterPage.Telephone",telephone);
    elements.inputText("RegisterPage.Address1",address1);
    elements.inputText("RegisterPage.City",city);
    elements.chooseValueInDropdown("RegisterPage.CountryDropdown",country);
    elements.chooseValueInDropdown("RegisterPage.RegionDropdown",region);
    elements.inputText("RegisterPage.Password",password);
    elements.inputText("RegisterPage.PasswordConfirm",password);
    elements.selectCheckBox("RegisterPage.PrivacyPolicyCheckbox",true);
    elements.clickButton("RegisterPage.ContinueBtn");

    return PageFactory.initElements(driver,AccountSuccessRegisterPage.class);

}


}
