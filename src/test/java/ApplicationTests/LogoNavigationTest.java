package ApplicationTests;

import Base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class LogoNavigationTest extends BaseTest {

    //Проверить: если нажать на логотип «Самоката», попадёшь на главную страницу «Самоката».
    @Test
    public void verifySamokatLogoRedirectsToHomePage() {
        objHomePage.clickMakeOrderButton();
        objOrderPage.clickSamokatLogo();
        Assert.assertEquals("URL не совпадает", (driver.getCurrentUrl()), PAGE_URL);
    }

    //Проверить: если нажать на логотип Яндекса, в новом окне откроется главная страница Яндекса.
    @Test
    public void verifyYandexLogoRedirectsToNewPage(){
        //Кликнуть на лого "Яндекс"
        driver.findElement(By.xpath("//img[@src='/assets/ya.svg']")).click();
        //Получить вкладки
        Set<String> windowHandles = driver.getWindowHandles();
        //Перейти на новую вкладку
        for (String handle : windowHandles) {
            if (!handle.equals(driver.getWindowHandle())) {
                driver.switchTo().window(handle);
                break;
            }
        }
        //Дождаться загрузки страницы
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("yredirect=true"));
        //Получить URL новой вкладки
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://dzen.ru/?yredirect=true";
        Assert.assertEquals("URL не совпадает", expectedUrl, actualUrl);
    }
}
