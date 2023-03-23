package pages;

import helpers.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends PageBase {
    public CartPage(WebDriver webdriver) {
        super(webdriver);
    }
    WebElement checkOutButton = driver.findElement(By.id("checkout"));
    WebElement continueShoppingButton = driver.findElement(By.id("continue-shopping"));
    public void clickOnCheckOutButton(){
        clickOnElement(checkOutButton);
    }
    public void clickOnContinueShoppingButton(){
        clickOnElement(continueShoppingButton);
    }

}
