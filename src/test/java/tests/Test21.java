package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import pages.GoogleMainPage;
import pages.GoogleResultPage;

import static org.junit.Assert.assertEquals;


public class Test21 extends BaseRunner {
    @Test
    public void openTinkoffTariffsPage() {
        GoogleMainPage googleMainPage = app.google;
        googleMainPage.open();

        googleMainPage.openSearchResultsPageByRequest("tinkoff mobile");
        clickXpath(app.getWebDriver(),"//*[contains(text(),'тарифы')]");

        GoogleResultPage googleResultPage = app.googleResults;
        googleResultPage.clickSearchResultsByLinkContains("Тарифы Тинькофф Мобайла");

        assertEquals(app.getWebDriver().getCurrentUrl(),"https://www.tinkoff.ru/mobile-operator/tariffs/");
        assertEquals("Тарифы Тинькофф Мобайла", app.getWebDriver().findElement(By.xpath(String.format("%s%s%s","//p[contains(text(),'Тарифы Тинькофф Мобайла')]"))).getText());

    }
}
