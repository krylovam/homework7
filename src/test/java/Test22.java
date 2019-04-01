import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Test22 extends BaseRunner {
    @Test
    public void test22() {
        driver.get(baseUrl);
        Select select = new Select();
        select.setDriver(driver);
        CheckBox checkBox = new CheckBox();
        checkBox.setDriver(driver);
        clickXpath(driver,"//*[contains(@class,'region')]");
        clickXpath(driver,"//div[contains(text(),'Москва и Московская обл.')]");
        assertEquals("Москва и Московская область", driver.findElement(By.xpath("//*[contains(@class,'region')]//*[contains(@class,'title')]")).getText());
        driver.navigate().refresh();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class,'region')]//*[contains(@class,'title')]")));
        assertEquals("Москва и Московская область", driver.findElement(By.xpath("//*[contains(@class,'region')]//*[contains(@class,'title')]")).getText());
        select.setText("Интернет");
        select.chooseValue("Безлимитный интернет");
        select.setText("Звонки");
        select.chooseValue("Безлимитные минуты");
        checkBox.setSelector("//*[contains(@class,'Checkbox')][contains(text(),'Режим модема')]");
        checkBox.getActive(true);
        checkBox.setSelector("//*[contains(@class,'Checkbox')][contains(text(),'Безлимитные СМС')]");
        checkBox.getActive(true);
        String Moscow = driver.findElement(By.xpath("//*[contains(text(),'Общая цена')]")).getText();
        clickXpath(driver,"//*[contains(@class,'region')]//*[contains(@class,'title')]");
        clickXpath(driver,"//div[contains(text(),'Краснодарский кр.')]");
        select.setText("Интернет");
        select.chooseValue("Безлимитный интернет");
        select.setText("Звонки");
        select.chooseValue("Безлимитные минуты");
        checkBox.setSelector("//*[contains(@class,'Checkbox')][contains(text(),'Режим модема')]");
        checkBox.getActive(true);
        checkBox.setSelector("//*[contains(@class,'Checkbox')][contains(text(),'Безлимитные СМС')]");
        checkBox.getActive(true);
        String Krasnodar = driver.findElement(By.xpath("//*[contains(text(),'Общая цена')]")).getText();
        assertEquals(Moscow,Krasnodar);
    }
}
