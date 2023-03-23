package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import testHelpers.TestBasis;

public class CheckoutTestCases extends TestBasis {
    @Test
    public void userShouldCheckOutSuccessfully(){
        String userName = "standard_user";
        String lastName = "user";
        String postalCode = "2345";
        String password = "secret_sauce";
        String expectedConfirmationMessage = "Thank you for your order!";
        LoginPage login = new LoginPage(driver.get());
        login.loginAction(userName , password );
        ProductPage addProduct = new ProductPage(driver.get());
        addProduct.addBackPackToCart();

        addProduct.addOnesieToCart();
        addProduct.addBikeLightToCart();
        addProduct.addBoltTShirtToCart();
        addProduct.addFleeceJacketToCart();
        addProduct.addRedTShirtToCart();
        addProduct.goToCart();
        CartPage cart = new CartPage(driver.get());
        cart.clickOnCheckOutButton();
        InformationPage usertInformation = new InformationPage(driver.get());
        usertInformation.setInformationAttribute(userName , lastName , postalCode);
        usertInformation.clickOnContinueButton();
        CheckOutPage checkOut = new CheckOutPage(driver.get());
        checkOut.clickOnFinishButton();
        CompletePage complete = new CompletePage(driver.get());
        Assert.assertEquals(expectedConfirmationMessage , complete.getConfirmationMessage());
    }
    @Test
    public void userShouldContinueShoppingWhenPressContinueShoppingFromCart(){
        String userName = "standard_user";
        String password = "secret_sauce";
        String expectedProductPage = "https://www.saucedemo.com/inventory.html";
        LoginPage login = new LoginPage(driver.get());
        login.loginAction(userName , password );
        ProductPage addProduct = new ProductPage(driver.get());
        addProduct.addBackPackToCart();
        addProduct.addOnesieToCart();
        addProduct.addBikeLightToCart();
        addProduct.goToCart();
        CartPage cart = new CartPage(driver.get());
        cart.clickOnContinueShoppingButton();
        Assert.assertEquals(expectedProductPage , driver.get().getCurrentUrl());
    }
    @Test
    public void userShouldGoToCartWhenPressCancelFromInformationPage(){
        String userName = "standard_user";
        String lastName = "user";
        String postalCode = "2345";
        String password = "secret_sauce";
        String expectedCartURL ="https://www.saucedemo.com/cart.html";
        LoginPage login = new LoginPage(driver.get());
        login.loginAction(userName , password );
        ProductPage addProduct = new ProductPage(driver.get());
        addProduct.addBackPackToCart();
        addProduct.addOnesieToCart();
        addProduct.addRedTShirtToCart();
        addProduct.goToCart();
        CartPage cart = new CartPage(driver.get());
        cart.clickOnCheckOutButton();
        InformationPage usertInformation = new InformationPage(driver.get());
        usertInformation.setInformationAttribute(userName , lastName , postalCode);
        usertInformation.clickOnCancelButton();
        Assert.assertEquals(expectedCartURL , driver.get().getCurrentUrl());
    }
    @Test
    public void userShouldGoToProductPageWhenPressCancelFromCheckoutPage(){
        String userName = "standard_user";
        String lastName = "user";
        String postalCode = "2345";
        String password = "secret_sauce";
        String expectedProductPage = "https://www.saucedemo.com/inventory.html";
        LoginPage login = new LoginPage(driver.get());
        login.loginAction(userName , password );
        ProductPage addProduct = new ProductPage(driver.get());
        addProduct.addBackPackToCart();
        addProduct.addOnesieToCart();
        addProduct.addBikeLightToCart();
        addProduct.goToCart();
        CartPage cart = new CartPage(driver.get());
        cart.clickOnCheckOutButton();
        InformationPage usertInformation = new InformationPage(driver.get());
        usertInformation.setInformationAttribute(userName , lastName , postalCode);
        usertInformation.clickOnContinueButton();
        CheckOutPage checkOut = new CheckOutPage(driver.get());
        checkOut.clickOnCancelButton();
        Assert.assertEquals(expectedProductPage , driver.get().getCurrentUrl());
    }
    @Test
    public void userShouldGoToProductPageWhenPressHomePageFromConfirmationPage(){
        String userName = "standard_user";
        String lastName = "user";
        String postalCode = "2345";
        String password = "secret_sauce";
        String expectedProductPage = "https://www.saucedemo.com/inventory.html";
        LoginPage login = new LoginPage(driver.get());
        login.loginAction(userName , password );
        ProductPage addProduct = new ProductPage(driver.get());
        addProduct.addBikeLightToCart();
        addProduct.addBoltTShirtToCart();
        addProduct.addFleeceJacketToCart();
        addProduct.addRedTShirtToCart();
        addProduct.goToCart();
        CartPage cart = new CartPage(driver.get());
        cart.clickOnCheckOutButton();
        InformationPage usertInformation = new InformationPage(driver.get());
        usertInformation.setInformationAttribute(userName , lastName , postalCode);
        usertInformation.clickOnContinueButton();
        CheckOutPage checkOut = new CheckOutPage(driver.get());
        checkOut.clickOnFinishButton();
        CompletePage complete = new CompletePage(driver.get());
        complete.clickOnBackHomeButton();
        Assert.assertEquals(expectedProductPage , driver.get().getCurrentUrl());
    }
    @Test
    public void userShouldnotGoToCheckOutPagePyEnterEmptyUserNameToInformationPage(){
        String userName = "standard_user";
        String informationUserName = "";
        String lastName = "user";
        String postalCode = "2345";
        String password = "secret_sauce";
        String expectedErrorMessage= "Error: First Name is required";
        LoginPage login = new LoginPage(driver.get());
        login.loginAction(userName , password );
        ProductPage addProduct = new ProductPage(driver.get());
        addProduct.addBackPackToCart();
        addProduct.addOnesieToCart();
        addProduct.addBikeLightToCart();
        addProduct.addBoltTShirtToCart();
        addProduct.addFleeceJacketToCart();
        addProduct.addRedTShirtToCart();
        addProduct.goToCart();
        CartPage cart = new CartPage(driver.get());
        cart.clickOnCheckOutButton();
        InformationPage usertInformation = new InformationPage(driver.get());
        usertInformation.setInformationAttribute(informationUserName , lastName , postalCode);
        usertInformation.clickOnContinueButton();
        Assert.assertEquals(expectedErrorMessage , usertInformation.getErrorMessage());
    }
    @Test
    public void userShouldnotGoToCheckOutPagePyEnterEmptyLastNameToInformationPage(){
        String userName = "standard_user";
        String lastName = "";
        String postalCode = "2345";
        String password = "secret_sauce";
        String expectedErrorMessage= "Error: Last Name is required";
        LoginPage login = new LoginPage(driver.get());
        login.loginAction(userName , password );
        ProductPage addProduct = new ProductPage(driver.get());
        addProduct.addBackPackToCart();
        addProduct.addOnesieToCart();
        addProduct.addBikeLightToCart();
        addProduct.addBoltTShirtToCart();
        addProduct.addFleeceJacketToCart();
        addProduct.addRedTShirtToCart();
        addProduct.goToCart();
        CartPage cart = new CartPage(driver.get());
        cart.clickOnCheckOutButton();
        InformationPage usertInformation = new InformationPage(driver.get());
        usertInformation.setInformationAttribute(userName , lastName , postalCode);
        usertInformation.clickOnContinueButton();
        Assert.assertEquals(expectedErrorMessage , usertInformation.getErrorMessage());
    }
    @Test
    public void userShouldnotGoToCheckOutPagePyEnterEmptyPostelCodeToInformationPage(){
        String userName = "standard_user";
        String lastName = "user";
        String postalCode = "";
        String password = "secret_sauce";
        String expectedErrorMessage= "Error: Postal Code is required";
        LoginPage login = new LoginPage(driver.get());
        login.loginAction(userName , password );
        ProductPage addProduct = new ProductPage(driver.get());
        addProduct.addBackPackToCart();
        addProduct.addOnesieToCart();
        addProduct.addBikeLightToCart();
        addProduct.addBoltTShirtToCart();
        addProduct.addFleeceJacketToCart();
        addProduct.addRedTShirtToCart();
        addProduct.goToCart();
        CartPage cart = new CartPage(driver.get());
        cart.clickOnCheckOutButton();
        InformationPage usertInformation = new InformationPage(driver.get());
        usertInformation.setInformationAttribute(userName , lastName , postalCode);
        usertInformation.clickOnContinueButton();
        Assert.assertEquals(expectedErrorMessage , usertInformation.getErrorMessage());
    }

}
