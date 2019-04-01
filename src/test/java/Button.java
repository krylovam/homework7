import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Button {
    String selector;
    WebDriver driver;

    public String getSelector() {
        return selector;
    }

    public void setSelector(String selector) {
        this.selector = selector;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
    public void clickButton(){
        WebElement dynamicElement = (new WebDriverWait(this.getDriver(), 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(this.getSelector())));
        dynamicElement.click();
    }
    public boolean isDisabled(){
        WebElement dynamicElement = (new WebDriverWait(this.getDriver(), 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(this.getSelector())));
        if (dynamicElement.isDisplayed()){
            return true;
        }
        else{
            return false;
        }
    }
}
