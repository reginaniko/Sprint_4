package ApplicationTests;

import Base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class VerifyErrorMessagesTest extends BaseTest {
    //Проверить ошибки для всех полей формы заказа
    @Test
    public void verifyErrorMessages() {
        // Список ошибок
        List<String> errorMessages = Arrays.asList(
                "Введите корректное имя",
                "Введите корректную фамилию",
                "Введите корректный адрес",
                "Выберите станцию",
                "Введите корректный номер"
        );
        //Перейти на страницу заказа
        objHomePage.clickMakeOrderButton();
        //Кликнуть по кнопке "Далее"
        objOrderPage.clickNextButton();
        //Ввести неверное значение в поле адрес в обход бага (валидация поля не активируется при нажатии на кнопку Далее)
        objOrderPage.setAddress("123");

        //Подвердить сообщения ошибок
        for (String errorMessage : errorMessages) {
            //Конструктор xpath
            String xpath = "//div[contains(text(),'" + errorMessage + "')]";
            //Локатор ошибки
            WebElement errorMessageElement = driver.findElement(By.xpath(xpath));
            //Подтверждение что сообщение отображается
            Assert.assertTrue(errorMessageElement.isDisplayed());
        }
    }
}
