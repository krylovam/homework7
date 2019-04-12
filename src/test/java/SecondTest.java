import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
public class SecondTest extends BaseRunner {
    @Test
    public void testSecond() {
        driver.get(baseUrl);
        clickCss(driver,"input[name='fio']");
        driver.findElement(By.cssSelector("input[name='fio']")).sendKeys("иванов");
        clickCss(driver,"input[name='phone_mobile']");
        driver.findElement(By.cssSelector("input[name='phone_mobile']")).sendKeys("+7(999)");
        driver.findElement(By.cssSelector("input[name='phone_mobile']")).sendKeys(Keys.ENTER);
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'Button')]")));
        dynamicElement.click();
        assertEquals("Номер телефона должен состоять из 10 цифр, начиная с кода оператора", driver.findElement(By.xpath("//div[contains(text(),'Номер телефона должен состоять')]")).getText());
        assertEquals("Недостаточно информации. Введите фамилию, имя и отчество через пробел (Например: Иванов Иван Алексеевич)", driver.findElement(By.xpath("//div[contains(text(),'Недостаточно информации. Введите фамилию, имя и от')]")).getText());
    }


}
