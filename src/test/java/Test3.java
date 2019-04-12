import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class Test3 extends BaseRunner {
    @Test
    public void test3(){

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-notifications");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("plugin s.always_open_pdf_externally", true);
        prefs.put("download.default_directory",System.getProperty("user.dir"));
        options.setExperimentalOption("prefs",prefs);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.tinkoff.ru/mobile-operator/documents/");
        clickXpath(driver,"//*[contains(@href,'first-month-free')]");
            }
}
