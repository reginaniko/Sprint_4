package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageSamokat {
    private WebDriver driver;
    //Кнопка "Заказать" вверху страницы
    private By makeOrderButtonTop = By.xpath("//button[@class='Button_Button__ra12g']");
    //Кнопка "Заказать" внизу страницы
    private By makeOrderButtonBottom = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Кнопка "Статус Заказа"
    private By checkOrderStatusButton = By.xpath("//button[contains(text(),'Статус заказа')]");
    //Поле для ввода номера заказа
    private By orderNumberInputField = By.xpath("//input[@placeholder='Введите номер заказа']");
    //Кнопка поиска номера заказа "Go!"
    private By goButton = By.xpath(".//button[contains(text(),'Go!')]");

    //Заголовок секции "Вопросы о Важном"
    public By questionsSection = By.xpath(".//div[contains(text(),'Вопросы о важном')]");


    public HomePageSamokat (WebDriver driver){
        this.driver = driver;
    }

    //метод для перехода на страницу заказа
    public void clickMakeOrderButton(){
        driver.findElement(makeOrderButtonTop).click();
    }

    //метод для выбора кнопки заказа из двух доступных на странице
    public void chooseMakeOrderButtonFromTwoAvailable(String orderButton){
        if (orderButton.equals("Верхняя кнопка Заказать")) {
            driver.findElement(makeOrderButtonTop).click();
        } else if (orderButton.equals("Нижняя кнопка Заказать")) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", (driver.findElement(makeOrderButtonBottom)));
            driver.findElement(makeOrderButtonBottom).click();
        } else {
            System.out.println("Такой кнопки нет");
        }
    }

    // метод для проверки статуса заказа с домашней страницы
    public void submitOrderNumberToCheckStatusFromHomePage(String orderNumber) {
        //нажать на кнопку Статус Заказа
        driver.findElement(checkOrderStatusButton).click();
        //заполнить поле номера заказа данными
        driver.findElement(orderNumberInputField).sendKeys(orderNumber);
        //кликнуть на кнопку "Go"
        driver.findElement(goButton).click();

    }

    // метод прокрутки экрана до раздела «Вопросы о важном»
    public void scrollToViewQuestions() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(questionsSection));
    }

    //метод клика по вопросу из раздела «Вопросы о важном»
    public void clickQuestion(String questionIndex){
        driver.findElement(By.id("accordion__heading-"+questionIndex+"")).click();
    }

    //метод составления локатора ответа из раздела «Вопросы о важном»
    public WebElement answerLocator(String answerText){
        return driver.findElement(By.xpath("//p[contains(text(),'"+answerText+"')]"));
    }
}
