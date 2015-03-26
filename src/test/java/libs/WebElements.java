package libs;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import test.CartVerifyingTest;

import static libs.ConfigData.ui;

public class WebElements {
    Logger Log = Logger.getLogger(WebElements.class);
     WebDriver driver;



    public WebElements(WebDriver driver) {
        this.driver = driver;



    }



    public void inputText(String fieldLocator, String text) {
    {
        WebElement inputField;
        inputField = driver.findElement(ui(fieldLocator));
        inputField.clear();
        inputField.sendKeys(text);
        Log.info("text was entered info field with locator  "+fieldLocator);
    } }

    public  void openURL(String url) {

        try {
            driver.manage().window().maximize();
            driver.get(url);
        } catch (WebDriverException e) {
            Log.info("Something wrong with Webdriver");

        }


    }
    public void clickButton(String buttonLocator) {

   WebElement button = driver.findElement(ui(buttonLocator));
      try{
        button.click();

          Log.info("Button with locator <" + buttonLocator + "> was clicked");
    }catch (InvalidElementStateException e){
        Log.info("Element is disabled");
      }}

    public void clickLink(String linkLocator) {
       try {
           WebElement link = driver.findElement(ui(linkLocator));
           link.click();

           Log.info("Link with locator " + linkLocator + "   was clicked");
       }catch (NoSuchElementException e){
           Log.info("This Link is absent");
       }
    }



    public void clearField(String fieldLocator) {   //Needs implementation to inputText Method.
        WebElement field;

        field = driver.findElement(ui(fieldLocator));

       try{
            field.clear();
        Log.info("Field was cleared");
    }catch (InvalidElementStateException e){
           Log.info("Field is disabled");
       }}

    public void refreshPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.location.reload(true)");
        Log.info("Page refreshed");


    }

   public void openUrl(String url) {

        try {
            driver.manage().window().maximize();
            driver.get(url);

        } catch (WebDriverException e) {
            Log.info("Webdriver Exception");
            e.getMessage();}}





    public void chooseValueInDropdown(String dropDownLocator, String dropdownValue) {
        WebElement dropDownElement;
        dropDownElement = driver.findElement(ui(dropDownLocator));


          if(driver.findElement(ui(dropDownLocator)).isSelected()==true){
              Log.info("Element is already selected");}
              else

           new Select(driver.findElement(ui((dropDownLocator)))).selectByVisibleText(dropdownValue);
        Log.info("Element is selected");}



    public void selectCheckBox(String checkBoxLocator, boolean checkBoxState) {
        WebElement checkBox;
        checkBox = driver.findElement(ui(checkBoxLocator));

      boolean  currentState = checkBox.isSelected();
        try {
            if (currentState==checkBoxState) {
                Log.info("CheckBox is already selected");
            } else {
                checkBox.click();
            }
        } catch (InvalidElementStateException e) {
            Log.info("This element is disabled");

        }
    }
    public boolean isElementPresent (String ElementLocator)
    {
      try{ driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
          driver.findElement(ui(ElementLocator));
          return true;
      }catch (NoSuchElementException e){
       return false;
      }
        finally {

      }

    }
    public void checkRadioBtn (String radioBtnLocator)
    {
        WebElement radioBtn;
        radioBtn = driver.findElement(ui(radioBtnLocator));
        radioBtn.click();
        Log.info("Button was clicked");
      /*  if(!radioBtn.getAttribute("readonly").equals(null)){
            System.out.println("This radiobutton is read-only");
        }else
        if (!radioBtn.isEnabled()){
            System.out.println("This element is disabled");
        }
        else if(radioBtn.isSelected()){
            System.out.println("Element is already selected");
        } else radioBtn.click();
        System.out.println("Element was selected");*/

    }

}

































