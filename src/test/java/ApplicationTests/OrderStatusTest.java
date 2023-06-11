package ApplicationTests;

import Base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderStatusTest extends BaseTest {


    @Test
    public void verifyInvalidOrderNumber(){
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[contains(text(),'Статус заказа')]")));
        //ждать 1 секунду
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        //ввести непавильный номер заказа и нажать на кнопку Go
        objHomePage.submitOrderNumberToCheckStatusFromHomePage("абвгд");
        //Проверить что отображается сообщение "Такого заказа нет"
        Assert.assertTrue(driver.findElement(By.xpath(".//div[@class='Track_NotFound__6oaoY']")).isDisplayed());
    }
}

