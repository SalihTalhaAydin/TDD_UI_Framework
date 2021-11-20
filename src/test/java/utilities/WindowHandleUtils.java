package utilities;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowHandleUtils {

    public static String switchToNotMainWindow(WebDriver driver) {
        String mainWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {
            if (!window.equals(mainWindow)){
                driver.switchTo().window(window);
                break;
            }
        }
        return mainWindow;

    }

    public static String switchToCertainWindowWithUrl(WebDriver driver, String url) {
        String mainWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(mainWindow)){
                driver.switchTo().window(window);
                if (driver.getCurrentUrl().contains(url))break;
            }
        }
        return mainWindow;

    }

    public static String switchToCertainWindowWithTitle(WebDriver driver, String title) {
        String mainWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(mainWindow)){
                driver.switchTo().window(window);
                if (driver.getTitle().contains(title))break;
            }
        }
        return mainWindow;
    }
}
