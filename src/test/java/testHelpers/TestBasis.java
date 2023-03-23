package testHelpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.time.Duration;


public class TestBasis {
    protected ThreadLocal<WebDriver> driver;
    @Parameters(value = "browser")
    @BeforeMethod
    public void setDriverProperties(@Optional("chrome")String browser) throws Exception {
        driver = new ThreadLocal<>();
        if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
            driver.get().get("https://www.saucedemo.com/");
            driver.get().manage().window().maximize();
        }
        else if(browser.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver(options));
            driver.get().get("https://www.saucedemo.com/");
            driver.get().manage().window().maximize();

        }
        else if(browser.equalsIgnoreCase("Edge")){
            WebDriverManager.edgedriver().setup();
            driver.set(new EdgeDriver());
            driver.get().get("https://www.saucedemo.com/");
            driver.get().manage().window().maximize();

        }else{
            throw new Exception("Incorrect Browser");
        }
       // driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void tearDown() {
        driver.get().quit();
    }
}
