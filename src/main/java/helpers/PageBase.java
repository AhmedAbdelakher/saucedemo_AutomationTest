package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {
    protected WebDriver driver;
    public static int duration = 30 ;
    public PageBase(WebDriver webdriver){
        this.driver=webdriver;
        PageFactory.initElements(driver,this);
    }
    public void waitForElementVisibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.visibilityOf(element)) ;
    }
    public void clickOnElement (WebElement element){
        waitForElementVisibility(element);
        element.click();
    }
    public void fillTextField(WebElement element , String text){
        waitForElementVisibility(element);
        element.sendKeys(text);
    }
    public void clearTextField(WebElement element){
        waitForElementVisibility(element);
        element.clear();
    }
}
