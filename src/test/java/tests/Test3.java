package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Test3{
    @Test
    public void downloadDocument() throws InterruptedException{

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-notifications");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("plugins.always_open_pdf_externally", true);
        prefs.put("download.default_directory",System.getProperty("user.dir"));
        options.setExperimentalOption("prefs",prefs);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
        driver.get("https://www.tinkoff.ru/mobile-operator/documents/");
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@href,'first-month-free')]")));
        dynamicElement.click();
        Thread.sleep(3000);
        System.out.println(String.format("%s%s%s",System.getProperty("user.dir"),File.separator,"first-month-free-siberia.pdf"));
        if(new File(String.format("%s%s%s",System.getProperty("user.dir"),File.separator,"first-month-free-siberia.pdf")).exists()){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
        driver.quit();
    }
}
