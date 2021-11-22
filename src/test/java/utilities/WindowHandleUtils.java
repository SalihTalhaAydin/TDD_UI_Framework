package utilities;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowHandleUtils {

    /**
     *
     * @param driver
     * @return
     */

    public static String switchToNotMainWindow(WebDriver driver) {
        String currentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(currentWindow)){
                driver.switchTo().window(window);
                break;
            }
        }
        return currentWindow;

    }

    /**
     *
     * @param driver
     * @param url
     * @return
     */

    public static String switchToCertainWindowWithUrl(WebDriver driver, String url) {
        String currentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(currentWindow)){
                driver.switchTo().window(window);
                if (driver.getCurrentUrl().contains(url))break;
            }
        }
        return currentWindow;

    }

    /**
     *
     * @param driver
     * @param title
     * @return
     */

    public static String switchToCertainWindowWithTitle(WebDriver driver, String title) {
        String currentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(currentWindow)){
                driver.switchTo().window(window);
                if (driver.getTitle().contains(title))break;
            }
        }
        return currentWindow;
    }
}
