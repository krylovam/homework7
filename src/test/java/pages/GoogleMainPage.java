package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleMainPage extends Page {
    public GoogleMainPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);


    }
    @FindBy(name = "q")
    public WebElement searchField;
    public void open() {
        driver.navigate().to("https://www.google.ru/");
    }
    public void openSearchResultsPageByRequest( String request) {
        searchField.sendKeys(request);


    }

}
