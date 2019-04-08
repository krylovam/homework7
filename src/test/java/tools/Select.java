package tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Select {
    String text;
    WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void setText(String text) {
        this.text = text;
    }
    public void chooseValue(String value){
        WebElement dynamicElement = (new WebDriverWait(this.getDriver(), 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("%s%s%s","//*[contains(@class,'select')][contains(text(),'",this.text,"')]"))));
        dynamicElement.click();
        dynamicElement = (new WebDriverWait(this.getDriver(), 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("%s%s%s","//span[contains(text(),'",value,"')]"))));
        dynamicElement.click();
    }
    public String getValue(){
        WebElement dynamicElement = (new WebDriverWait(this.getDriver(), 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("%s%s%s","//*[contains(@class,select')][contains(text(),'",this.text,"')]"))));
        String ans = dynamicElement.getText();
        return ans;
    }
}
