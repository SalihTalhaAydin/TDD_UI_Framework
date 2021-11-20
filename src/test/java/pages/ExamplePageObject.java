package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ExamplePageObject {

    public ExamplePageObject(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
