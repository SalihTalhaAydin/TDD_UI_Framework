package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver() {

    }

    private static WebDriver driver;

    /**
     *
     * @param browser
     * @return
     *
     * Create for browser type, maximize, add implicit wait and return the driver
     */
    public static WebDriver getDriver(String browser) {

        if (driver == null){
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                default:
                    throw new NotFoundException("The browser you entered is not founded in Driver class");
            }

            // Maximizing the browser for best use
            driver.manage().window().maximize();

            // Adding implicit wait, first arg (seconds) is coming from configuration.properties
            driver.manage().timeouts().implicitlyWait(
                    Integer.parseInt(ConfigReader.getProperty("implicitWaitSeconds")), TimeUnit.SECONDS);
        }
        return driver;
    }

    /**
     * quitting driver and deleting the all cookies if it is initialized
     */
    public static void quitDriver() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
            driver = null;
        }

    }

}
