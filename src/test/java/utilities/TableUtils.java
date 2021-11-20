package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableUtils{

    public static WebElement getElementWithTableId(WebDriver driver,String attribute, String attributeValue,
                                                   int row, int column) {

        return driver.findElement(By.xpath("((//table[@"+ attribute +"='" + attributeValue + "']/tbody/tr)[" + row
                + "]/td)[" + column + "]"));

    }


}
