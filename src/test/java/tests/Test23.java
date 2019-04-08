package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import pages.TinkoffPage;
import tools.Button;
import tools.TextInput;

public class Test23 extends BaseRunner {
    @Test
    public void fillValidDataAndCheckButton() {
        TinkoffPage tinkoffPage = app.tinkoff;
        tinkoffPage.open();
        TextInput textInput = new TextInput();
        textInput.setDriver(app.getWebDriver());
        app.getWebDriver().findElement(By.xpath("//*[contains(@class,'region')]")).click();
        tinkoffPage.selectRegion("Москва и Московская обл.","Москва и Московская область");
        tinkoffPage.typeNameField("Иванов Иван Иванович");
        tinkoffPage.typePhoneField("9999999999");
        tinkoffPage.typeEmailField("ivanov@mail.ru");
        tinkoffPage.clickButton("//div[contains(@class,'Button')]");
        Button button = new Button();
        button.setDriver(app.getWebDriver());
        button.setSelector("//span[contains(@class,'Button')]");
        if (button.isDisabled()){
            System.out.println("Disabled");
        }
        else{
            System.out.println("Enabled");
        }

    }
}
