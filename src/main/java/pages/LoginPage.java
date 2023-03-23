package pages;

import helpers.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver webdriver) {
        super(webdriver);
    }
    WebElement userNameField = driver.findElement(By.cssSelector("input[id=\"user-name\"]"));
    WebElement passwordField = driver.findElement(By.cssSelector("input[id=\"password\"]"));
    WebElement loginButton = driver.findElement(By.cssSelector("input[id=\"login-button\"]"));
    By MessageError = By.cssSelector("div[class=\"error-message-container error\"]");


    public void setUserNameField(String userName) {
        fillTextField(userNameField , userName);
    }

    public void setPasswordField(String password) {
        fillTextField(passwordField , password);
    }
    public void loginAction (String userName , String password){
        setUserNameField(userName);
        setPasswordField(password);
        clickOnElement(loginButton);
    }
    public String getMessageError(){
        return driver.findElement(MessageError).getText();
    }
}
