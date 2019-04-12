import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
public class BaseRunner {
    WebDriver driver;
    String baseUrl;
    public String browserName = System.getProperty("browser");
    @Before
    public void setUp(){
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
        baseUrl = "https://www.tinkoff.ru/mobile-operator/tariffs/";

    }
    public void clickXpath(WebDriver driver, String selector){
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(selector)));
        dynamicElement.click();
    }
    public void clickCss(WebDriver driver, String selector){
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
        dynamicElement.click();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    private WebDriver getDriver() {
        try {
            BrowsersFactory.valueOf(System.getProperty("browser"));
            return BrowsersFactory.valueOf(browserName).create();
        } catch (Exception e) {
            return new ChromeDriver();
        }
    }
}
