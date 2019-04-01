import org.junit.Test;
import org.openqa.selenium.By;

public class Test3 extends BaseRunner {
    @Test
    public void test3(){
        driver.get("chrome://settings/content/pdfDocuments");
       // new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='control'][@role='button']")));
        //driver.findElement(By.x("//*[@id='control'][@role='button'][@aria-label=\'Скачивать файлы PDF, а не автоматически открывать их в Chrome']")).click();
        clickXpath(driver,"//cr-toggle[@id='control']");
        driver.get("https://www.tinkoff.ru/mobile-operator/documents/");
        driver.findElement(By.xpath("//a[contains(text(),'Описание акции «Первый месяц бесплатно»')]")).click();
    }
}
