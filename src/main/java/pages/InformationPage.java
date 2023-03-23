package pages;

import helpers.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.PublicKey;

public class InformationPage extends PageBase {
    public InformationPage(WebDriver webdriver) {
        super(webdriver);
    }
    WebElement firstNameField = driver.findElement(By.id("first-name"));
    WebElement lastNameField = driver.findElement(By.id("last-name"));
    WebElement postalCodeField = driver.findElement(By.id("postal-code"));
    WebElement continueButton = driver.findElement(By.id("continue"));
    WebElement cancelButton = driver.findElement(By.id("cancel"));
    By emptyUserNameErrorMessage = By.cssSelector("h3[data-test=\"error\"]");

    public void setInformationAttribute(String firstName , String lastName , String postalCode){
        fillTextField(firstNameField , firstName);
        fillTextField(lastNameField , lastName);
        fillTextField(postalCodeField , postalCode);
    }
    public void clickOnContinueButton(){
        clickOnElement(continueButton);
    }
    public void clickOnCancelButton(){
        clickOnElement(cancelButton);
    }
    public String getErrorMessage(){
        return driver.findElement(emptyUserNameErrorMessage).getText();
    }
}
