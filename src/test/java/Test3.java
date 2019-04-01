import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

public class Test3 extends BaseRunner {
    @Test
    public void test3(){
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        String downloadFilepath = "D:/MyDeskDownload";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("pdfjs.disabled", true);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        //WebDriver driver = new ChromeDriver(cap);
        //driver.get("chrome://settings/content/pdfDocuments");
       // new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='control'][@role='button']")));
        //driver.findElement(By.x("//*[@id='control'][@role='button'][@aria-label=\'Скачивать файлы PDF, а не автоматически открывать их в Chrome']")).click();
        //clickXpath(driver,"//cr-toggle[@id='control']");
        driver.get("https://www.tinkoff.ru/mobile-operator/documents/");
        clickXpath(driver,"//a[contains(text(),'Описание акции «Первый месяц бесплатно»')]");
            }
}
