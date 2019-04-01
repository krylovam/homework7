import org.junit.Test;
import org.openqa.selenium.By;

public class Test3 extends BaseRunner {
    @Test
    public void test3(){
        driver.get("https://www.tinkoff.ru/mobile-operator/documents/");
        driver.findElement(By.xpath("//a[contains(text(),'Описание акции «Первый месяц бесплатно»')]")).click();
    }
}
