package tests;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.TinkoffPage;

import static org.junit.Assert.assertEquals;
public class SecondTest extends BaseRunner {
    @Test
    public void fillNoValidData() {
        TinkoffPage tinkoffPage = app.tinkoff;
        tinkoffPage.open();
        tinkoffPage.typeNameField("иванов");
        tinkoffPage.typePhoneField("+7(999)");
                WebElement dynamicElement = (new WebDriverWait(app.getWebDriver(), 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'Button')]")));
        dynamicElement.click();
        assertEquals("Номер телефона должен состоять из 10 цифр, начиная с кода оператора", app.getWebDriver().findElement(By.xpath("//div[contains(text(),'Номер телефона должен состоять')]")).getText());
        assertEquals("Недостаточно информации. Введите фамилию, имя и отчество через пробел (Например: Иванов Иван Алексеевич)", app.getWebDriver().findElement(By.xpath("//div[contains(text(),'Недостаточно информации. Введите фамилию, имя и от')]")).getText());
    }


}
