package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tools.TextInput;
import tools.Button;

import static org.junit.Assert.assertEquals;

public class TinkoffPage extends Page {
    public TinkoffPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void open() {
        driver.navigate().to("https://www.tinkoff.ru/mobile-operator/tariffs/");
    }
    public void typeNameField(String value){
        TextInput textInput = new TextInput();
        textInput.setDriver(driver);
        textInput.setName("fio");
        textInput.sendText(value);
    }
    public void typePhoneField(String value){
        TextInput textInput = new TextInput();
        textInput.setDriver(driver);
        textInput.setName("phone_mobile");
        textInput.sendText(value);
        driver.findElement(By.name("email")).click();
    }
    public void typeEmailField(String value){
        TextInput textInput = new TextInput();
        textInput.setDriver(driver);
        textInput.setName("email");
        textInput.sendText(value);
        driver.findElement(By.name("fio")).click();
    }
    public void clickButton(String locator){
        Button button = new Button();
        button.setDriver(driver);
        button.setSelector(locator);
        button.clickButton();
    }
    public void selectRegion(String region, String regionAll){
        driver.findElement(By.xpath(String.format("%s%s%s","//div[contains(text(),'",region,"')]"))).click();
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.name("email")));
        assertEquals(regionAll, driver.findElement(By.xpath("//*[contains(@class,'region')]//*[contains(@class,'title')]")).getText());
    }
    public void checkTitle(String title){
        assertEquals(driver.getCurrentUrl(),"https://www.tinkoff.ru/mobile-operator/tariffs/");
        assertEquals(title, driver.findElement(By.xpath(String.format("%s%s%s","//p[contains(text(),'",title,"')]"))).getText());
    }
}
