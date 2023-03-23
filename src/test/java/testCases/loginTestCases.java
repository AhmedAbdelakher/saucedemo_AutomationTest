package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import testHelpers.TestBasis;

public class loginTestCases extends TestBasis {
@Test (priority = 0)
    public void userShouldLoginSuccessfullyWithStandardUser(){
    String userName = "standard_user";
    String password = "secret_sauce";
    String expectedProductURL ="https://www.saucedemo.com/inventory.html";
    LoginPage login = new LoginPage(driver.get());
    login.loginAction(userName , password );
    String actualProductURL = driver.get().getCurrentUrl();
    Assert.assertEquals(expectedProductURL , actualProductURL);
    }
    @Test (priority = 1)
    public void userShouldnotLoginWithLockedUpUserName(){
    String userName= "locked_out_user";
    String password = "secret_sauce";
    String expectedErrorMessage = "Epic sadface: Sorry, this user has been locked out.";
    LoginPage login = new LoginPage(driver.get());
    login.loginAction(userName , password );
    String actualErrorMessage =  login.getMessageError();
    Assert.assertEquals(expectedErrorMessage , actualErrorMessage);
    }
    @Test (priority = 2)
    public void userShouldLoginSuccessfullyWithProblemUser(){
        String userName = "problem_user";
        String password = "secret_sauce";
        String expectedProductURL ="https://www.saucedemo.com/inventory.html";
        LoginPage login = new LoginPage(driver.get());
        login.loginAction(userName , password );
        String actualProductURL = driver.get().getCurrentUrl();
        Assert.assertEquals(expectedProductURL , actualProductURL);
    }
    @Test (priority = 3)
    public void userShouldLoginSuccessfullyWithPerformanceGlitchUser(){
        String userName = "performance_glitch_user";
        String password = "secret_sauce";
        String expectedProductURL ="https://www.saucedemo.com/inventory.html";
        LoginPage login = new LoginPage(driver.get());
        login.loginAction(userName , password );
        String actualProductURL = driver.get().getCurrentUrl();
        Assert.assertEquals(expectedProductURL , actualProductURL);
    }
    @Test (priority = 4)
    public void userShouldnotLoginWithEmptyPassword(){
        String userName= "standard_user";
        String password = "";
        String expectedErrorMessage = "Epic sadface: Password is required";
        LoginPage login = new LoginPage(driver.get());
        login.loginAction(userName , password );
        String actualErrorMessage =  login.getMessageError();
        Assert.assertEquals(expectedErrorMessage , actualErrorMessage);
    }
    @Test (priority = 6)
    public void userShouldnotLoginWithUserName(){
        String userName= "";
        String password = "secret_sauce";
        String expectedErrorMessage = "Epic sadface: Username is required";
        LoginPage login = new LoginPage(driver.get());
        login.loginAction(userName , password );
        String actualErrorMessage =  login.getMessageError();
        Assert.assertEquals(expectedErrorMessage , actualErrorMessage);
    }

}
