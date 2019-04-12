package Tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        this.getDriver().findElement(By.name(this.name)).sendKeys(text);
    }
    public String getText(){
        String ans = this.getDriver().findElement(By.name(this.name)).getText();
        return ans;
    }
}
