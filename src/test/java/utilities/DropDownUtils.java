package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownUtils {

    public static void selectDropdown(WebElement dropdown, String selectDropdown){
        new Select(dropdown).selectByVisibleText(selectDropdown);
    }

    public static String getSelectedDropdownText(WebElement dropdown){
        return new Select(dropdown).getFirstSelectedOption().getText();
    }
}
