package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.Driver;

public class Hooks {

    // default test browser is chrome
    private String browser = "chrome";

    // for changing the browser if it's needed
    public void setBrowser(String browser){
        this.browser = browser;
    }

    // declare your page objects under and create it in @BeforeMethod

    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver(browser);
    }

    @AfterMethod
    public void teardown(){
        Driver.quitDriver();
    }


}
