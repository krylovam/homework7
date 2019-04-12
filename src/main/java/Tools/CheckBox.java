package Tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBox {
    String selector;
    WebDriver driver;
    public String getSelector() {
        return selector;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void setSelector(String selector) {
        this.selector = selector;
    }

    boolean isSelected(){
        boolean ans = this.getDriver().findElement(By.xpath(this.selector)).isSelected();
        return ans;
    }
    public String getDescription(){
        String ans = this.getDriver().findElement(By.xpath(this.selector)).getText();
        return ans;
    }
    public void getActive( boolean bool){
        boolean ans = isSelected();
        if (ans^bool){
            this.getDriver().findElement(By.xpath(this.selector)).click();
        }
    }
}
