import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TextInput {
    String name;
    WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sendText(String text){
        WebElement dynamicElement = (new WebDriverWait(this.getDriver(), 10))
                .until(ExpectedConditions.elementToBeClickable(By.name(this.name)));
        dynamicElement.sendKeys(text);

    }
    public String getText(){
        String ans = this.getDriver().findElement(By.name(this.name)).getText();
        return ans;
    }
}
