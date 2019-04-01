import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Test23 extends BaseRunner {
    @Test
    public void test23() {
        TextInput textInput = new TextInput();
        textInput.setDriver(driver);
        driver.get(baseUrl);
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class,'region')]")));
        dynamicElement.click();
        dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Москва и Московская обл.')]")));
        dynamicElement.click();
        textInput.setName("fio");
        textInput.sendText("Иванов Иван Иванович");
        textInput.setName("phone_mobile");
        textInput.sendText("9999999999");
        textInput.setName("email");
        textInput.sendText("ivanov@mail.ru");
        Button button = new Button();
        button.setDriver(driver);
        button.setSelector("//div[contains(@class,'Button')]");
        button.clickButton();
        button.setSelector("//span[contains(@class,'Button')]");
        if (button.isDisabled()){
            System.out.println("Disabled");
        }
        else{
            System.out.println("Enabled");
        }

    }
}
