import Tools.Button;
import Tools.TextInput;
import org.junit.Test;
public class Test23 extends BaseRunner {
    @Test
    public void test23() {
        TextInput textInput = new TextInput();
        textInput.setDriver(driver);
        driver.get(baseUrl);
        clickXpath(driver, "//*[contains(@class,'region')]");
        clickXpath(driver,"//div[contains(text(),'Москва и Московская обл.')]");
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
        if (button.isButton()){
            System.out.println("Displayed");
        }
        else{
            System.out.println("Is not displayed");
        }

    }
}
