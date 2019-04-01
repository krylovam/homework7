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
        clickXpath(driver,"//*[contains(text(),'тарифы')]");
        clickXpath(driver,"//h3[contains(text(),'Тарифы Тинькофф Мобайла')]");
        assertEquals("Тарифы Тинькофф Мобайла", driver.findElement(By.xpath("//p[contains(text(),'Тарифы Тинькофф Мобайла')]")).getText());
        assertEquals(driver.getCurrentUrl(),"https://www.tinkoff.ru/mobile-operator/tariffs/");
    }
}
