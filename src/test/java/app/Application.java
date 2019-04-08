package app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.GoogleMainPage;
import pages.GoogleResultPage;
import pages.TinkoffPage;
import tests.BaseRunner;
import tests.BrowsersFactory;

import java.util.concurrent.TimeUnit;

public class Application {
    Logger logger = LoggerFactory.getLogger(Application.class);
    private WebDriverWait wait;
    private WebDriver driver;
    public GoogleMainPage google;
    public GoogleResultPage googleResults;
    public TinkoffPage tinkoff;
    public WebDriver getWebDriver(){
        return driver;
    }
    public Application() {
        driver = new EventFiringWebDriver(BaseRunner.getDriver());
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
        ((EventFiringWebDriver) driver).register(new BrowsersFactory.MyListener());
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();

        //page
        google = new GoogleMainPage(driver);
        googleResults = new GoogleResultPage(driver);
        tinkoff = new TinkoffPage(driver);
    }

    public void quit() {
        driver.quit();
    }

}
