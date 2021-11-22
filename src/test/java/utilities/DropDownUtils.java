package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownUtils {

    /**
     *
     * @param dropdown
     * @param selectDropdown
     */
    public static void selectDropdown(WebElement dropdown, String selectDropdown){
        new Select(dropdown).selectByVisibleText(selectDropdown);
    }

    /**
     *
     * @param dropdown
     * @return
     */
    public static String getSelectedDropdownText(WebElement dropdown){
        return new Select(dropdown).getFirstSelectedOption().getText();
    }
}
