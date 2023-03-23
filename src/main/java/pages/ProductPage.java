package pages;

import helpers.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.datatransfer.Clipboard;

public class ProductPage extends PageBase {
    public ProductPage(WebDriver webdriver) {
        super(webdriver);
    }
    WebElement backPackAddToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
    WebElement bikeLightAddToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
    WebElement boltTShirtAddToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
    WebElement fleeceJacketAddToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
    WebElement onesieAddToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
    WebElement redTShirtAddToCartButton = driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)"));
    WebElement cartButton = driver.findElement(By.id("shopping_cart_container"));


    public void addBackPackToCart (){
        clickOnElement(backPackAddToCartButton);
    }
    public void addBikeLightToCart(){
        clickOnElement(bikeLightAddToCartButton);
    }
    public void addBoltTShirtToCart(){
        clickOnElement(boltTShirtAddToCartButton);
    }
    public void addFleeceJacketToCart(){
        clickOnElement(fleeceJacketAddToCartButton);
    }
    public void addOnesieToCart(){
        clickOnElement(onesieAddToCartButton);
    }
    public void addRedTShirtToCart(){
        clickOnElement(redTShirtAddToCartButton);
    }
    public void goToCart(){
        clickOnElement(cartButton);
    }

}
