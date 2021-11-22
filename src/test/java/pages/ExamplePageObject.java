package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ExamplePageObject {

    public ExamplePageObject(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "xpathForTheElement")
    public WebElement element;

    @FindBy(xpath = "xpathForAllElements")
    public List<WebElement> elements;

}
