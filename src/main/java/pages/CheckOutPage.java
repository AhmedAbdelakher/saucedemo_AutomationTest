package pages;

import helpers.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage extends PageBase {
    public CheckOutPage(WebDriver webdriver) {
        super(webdriver);
    }
    WebElement finishButton = driver.findElement(By.id("finish"));
    WebElement cancelButton = driver.findElement(By.id("cancel"));
    public void clickOnFinishButton(){
        clickOnElement(finishButton);
    }
    public void clickOnCancelButton(){
        clickOnElement(cancelButton);
    }
}
