import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertEquals;

public class FirstTest extends BaseRunner{

    @Test
    public void testFirst() {
        driver.get(baseUrl);
        clickXpath(driver,"//input[@name='fio']");
        clickXpath(driver,"//input[@name='phone_mobile']");
        clickXpath(driver,"//input[@name='email']");
        assertEquals("Укажите ваше ФИО", driver.findElement(By.xpath("//div[contains(text(),'Укажите ваше ФИО')]")).getText());
        assertEquals("Необходимо указать номер телефона", driver.findElement(By.xpath("//div[contains(text(),'Необходимо указать номер телефона')]")).getText());
        if(driver.findElement(By.xpath("//*[@id='agreement']")).isSelected()){
            driver.findElement(By.xpath("//span[contains(text(),'Я принимаю')]")).click();
        }
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'Button')]")));
        dynamicElement.click();
        assertEquals("Для продолжения нужно согласие с условиями", driver.findElement(By.xpath("//div[contains(text(),'Для продолжения нужно согласие с условиями')]")).getText());
    }


}

