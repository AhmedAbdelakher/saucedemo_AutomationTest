package pages;

import helpers.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompletePage extends PageBase {
    public CompletePage(WebDriver webdriver) {
        super(webdriver);
    }
    WebElement confirmationMessage = driver.findElement(By.cssSelector("h2[class=\"complete-header\"]"));
    WebElement backHomeButton = driver.findElement(By.id("back-to-products"));
    public String getConfirmationMessage(){
       return confirmationMessage.getText();
    }
    public void clickOnBackHomeButton(){
        clickOnElement(backHomeButton);
    }
}
