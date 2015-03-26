package pages;

import libs.WebElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static libs.ConfigData.ui;
import static test.TestData.*;

/**
 * Created by 007 on 15.03.2015.
 */
public class CheckOutPage {
    WebDriver driver ;
    WebElements elements ;
    WebDriverWait wait ;

public CheckOutPage(WebDriver driver){

    this.driver = driver;
    elements = new WebElements(driver);
}
    private void checkRegisterUserRadioBtn(){
    elements.checkRadioBtn("CheckOutPage.RegisterCustomerTypeRadioBtn");
    }
    private void checkGuestUserRadioBtn(){
elements.checkRadioBtn("CheckOutPage.GuestUserRadioBtn");
    }
    private void clickContinueBtn(){
        elements.clickButton("CheckOutPage.ButtonGuest");
    }




    public void checkOutGuestAccount (boolean onlyRequiredFields,boolean sameShippingAndDeliveryAddress) {

        elements.checkRadioBtn("CheckOutPage.GuestUserRadioBtn");
        elements.clickButton("CheckOutPage.ContinueBtn");


        if(onlyRequiredFields==true){
            enterRequiredFields();

            if(sameShippingAndDeliveryAddress==true){
                elements.selectCheckBox("CheckOutPage.SameShippingDeliveryCheckbox",true);
            }else{
                elements.selectCheckBox("CheckOutPage.SameShippingDeliveryCheckbox",false);
            }
            deliveryMethodForm();

            paymentMethodForm();

            confirmOrder();

        }else {
            enterRequiredFields();
            enterAdditionalFields();}
    }

    private void enterRequiredFields(){
        new WebDriverWait(driver,7,7000);
        elements.inputText("CheckOutPage.FirstName",FIRSTNAME);
        elements.inputText("CheckOutPage.LastName",LASTNAME);
        elements.inputText("CheckOutPage.Email",EMAIL);
        elements.inputText("CheckOutPage.Telephone",TELEPHONE);
        elements.inputText("CheckOutPage.Address1",ADDRESS1);
        elements.inputText("CheckOutPage.City",CITY);
        elements.chooseValueInDropdown("CheckOutPage.CountryDropdown",COUNTRY);
        elements.chooseValueInDropdown("CheckOutPage.RegionDropdown",REGION);
        clickContinueBtn();

    }
    private void enterAdditionalFields(){
     elements.inputText("CheckOutPage.Fax",FAX);
    }
    private  void deliveryMethodForm(){
    elements.clickButton("CheckOutPage.ShippingContinueBtn");
    }

    private void paymentMethodForm(){
        wait= new WebDriverWait(driver,25);
    wait.until(ExpectedConditions.elementToBeClickable(ui("CheckOutPage.PaymentMethodTermsAndCondCheckbox")));
        elements.selectCheckBox("CheckOutPage.PaymentMethodTermsAndCondCheckbox", true);

        elements.clickButton("CheckOutPage.ButtonPaymentPage");
    }
    private SuccessfullyOrderProcess confirmOrder(){
        wait.until(ExpectedConditions.elementToBeClickable(ui("CheckOutPage.ConfirmOrderBtn")));
    elements.clickButton("CheckOutPage.ConfirmOrderBtn");
        wait.until(ExpectedConditions.titleIs("Your Order Has Been Processed!"));
        return new SuccessfullyOrderProcess(driver);
    }

}
