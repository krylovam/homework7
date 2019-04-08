package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.TinkoffPage;
import tools.CheckBox;
import tools.Select;

import static org.junit.Assert.assertEquals;

public class Test22 extends BaseRunner {
    @Test
    public void changeRegionAndComparePrices() {
        TinkoffPage tinkoffPage = app.tinkoff;
        tinkoffPage.open();
        Select select = new Select();
        select.setDriver(app.getWebDriver());
        CheckBox checkBox = new CheckBox();
        checkBox.setDriver(app.getWebDriver());
        app.getWebDriver().findElement(By.xpath("//*[contains(@class,'region')]")).click();
        tinkoffPage.selectRegion("Москва и Московская обл.","Москва и Московская область");
        app.getWebDriver().navigate().refresh();
        (new WebDriverWait(app.getWebDriver(), 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class,'region')]//*[contains(@class,'title')]")));
        assertEquals("Москва и Московская область", app.getWebDriver().findElement(By.xpath("//*[contains(@class,'region')]//*[contains(@class,'title')]")).getText());
        select.setText("Интернет");
        select.chooseValue("Безлимитный интернет");
        select.setText("Звонки");
        select.chooseValue("Безлимитные минуты");
        checkBox.setSelector("//*[contains(@class,'Checkbox')][contains(text(),'Режим модема')]");
        checkBox.getActive(true);
        checkBox.setSelector("//*[contains(@class,'Checkbox')][contains(text(),'Безлимитные СМС')]");
        checkBox.getActive(true);
        String Moscow = app.getWebDriver().findElement(By.xpath("//*[contains(text(),'Общая цена')]")).getText();
        app.getWebDriver().findElement(By.xpath("//*[contains(@class,'region')]//*[contains(@class,'title')]")).click();
        tinkoffPage.selectRegion("Краснодарский кр.", "Краснодарский край");
        select.setText("Интернет");
        select.chooseValue("Безлимитный интернет");
        select.setText("Звонки");
        select.chooseValue("Безлимитные минуты");
        checkBox.setSelector("//*[contains(@class,'Checkbox')][contains(text(),'Режим модема')]");
        checkBox.getActive(true);
        checkBox.setSelector("//*[contains(@class,'Checkbox')][contains(text(),'Безлимитные СМС')]");
        checkBox.getActive(true);
        String Krasnodar = app.getWebDriver().findElement(By.xpath("//*[contains(text(),'Общая цена')]")).getText();
        assertEquals(Moscow,Krasnodar);
    }
}
