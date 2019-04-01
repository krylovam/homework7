import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Test21 extends BaseRunner {
    @Test
    public void test21() throws Exception {
        driver.get("https://www.google.com");
        TextInput textInput = new TextInput();
        textInput.setDriver(driver);
        textInput.setName("q");
        textInput.sendText("мобайл тинькофф");
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'тарифы')]")));
        dynamicElement.click();
        dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[contains(text(),'Тарифы Тинькофф Мобайла')]")));
        dynamicElement.click();
        assertEquals("Тарифы Тинькофф Мобайла", driver.findElement(By.xpath("//p[contains(text(),'Тарифы Тинькофф Мобайла')]")).getText());
        assertEquals(driver.getCurrentUrl(),"https://www.tinkoff.ru/mobile-operator/tariffs/");
    }
}
