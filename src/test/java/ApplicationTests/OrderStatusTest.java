package ApplicationTests;

import Base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.time.Duration;

public class OrderStatusTest extends BaseTest {


    @Test
    public void verifyInvalidOrderNumber(){
        //ждать 1 секунду
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        //ввести непавильный номер заказа и нажать на кнопку Go
        objHomePage.submitOrderNumberToCheckStatusFromHomePage("абвгд");
        //Проверить что отображается сообщение "Такого заказа нет"
        Assert.assertTrue(driver.findElement(By.xpath(".//div[@class='Track_NotFound__6oaoY']")).isDisplayed());
    }
}

