package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleResultPage extends Page {
    public GoogleResultPage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
    }
    public void clickSearchResultsByLinkContains(String link){
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("%s%s%s","//h3[contains(text(),'",link,"')]"))));
        dynamicElement.click();
    }

}
