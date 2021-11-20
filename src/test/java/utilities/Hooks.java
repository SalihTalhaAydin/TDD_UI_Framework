package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Hooks {

    private String browser = "chrome";

    public void setBrowser(String browser){
        this.browser = browser;
    }

    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver(browser);
    }

    @AfterMethod
    public void teardown(){

    }


}
