package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageSamokat {
    private WebDriver driver;
    //Кнопка "Заказать"
    private By makeOrderButton = By.xpath("//button[@class='Button_Button__ra12g']");
    //Кнопка "Статус Заказа"
    private By checkOrderStatusButton = By.xpath("//button[contains(text(),'Статус заказа')]");
    //Поле для ввода номера заказа
    private By orderNumberInputField = By.xpath("//input[@placeholder='Введите номер заказа']");
    //Кнопка поиска номера заказа "Go!"
    private By goButton = By.xpath(".//button[contains(text(),'Go!')]");

    //Заголовок секции "Вопросы о Важном"
    public By questionsSection = By.xpath(".//div[contains(text(),'Вопросы о важном')]");
    //Локаторы вопросов из списка «Вопросы о важном» и соответствующих им ответов
    private By firstQuestion = By.id("accordion__heading-0");
    private By firstAnswer = By.xpath(".//p[contains(text(),'Сутки — 400 рублей. Оплата курьеру — наличными или')]");
    private By secondQuestion = By.id("accordion__heading-1");
    private By secondAnswer = By.xpath(".//p[contains(text(),'Пока что у нас так: один заказ — один самокат. Есл')]");
    private By thirdQuestion = By.id("accordion__heading-2");
    private By thirdAnswer = By.xpath(".//p[contains(text(),'Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.')]");
    private By fourthQuestion = By.id("accordion__heading-3");
    private By fourthAnswer = By.xpath(".//p[contains(text(),'Только начиная с завтрашнего дня. Но скоро станем ')]");
    private By fifthQuestion = By.id("accordion__heading-4");
    private By fifthAnswer = By.xpath(".//p[contains(text(),'Пока что нет! Но если что-то срочное — всегда можн')]");
    private By sixthQuestion = By.id("accordion__heading-5");
    private By sixthAnswer = By.xpath(".//p[contains(text(),'Самокат приезжает к вам с полной зарядкой. Этого х')]");
    private By seventhQuestion = By.id("accordion__heading-6");
    private By seventhAnswer = By.xpath(".//p[contains(text(),'Да, пока самокат не привезли. Штрафа не будет, объ')]");
    private By eighthQuestion = By.id("accordion__heading-7");
    private By eighthAnswer = By.xpath("//p[contains(text(),'Да, обязательно. Всем самокатов! И Москве, и Моско')]");


    public HomePageSamokat (WebDriver driver){
        this.driver = driver;
    }

    //метод для перехода на страницу заказа
    public void clickMakeOrderButton(){
        driver.findElement(makeOrderButton).click();
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
    public void scrollToViewQuestions(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    // методы нажатия на кнопки вопросов из списка «Вопросы о важном» и валидации сообщения ответа
    public void verifyFirstQuestion() {
        driver.findElement(firstQuestion).click();
        Assert.assertTrue(driver.findElement(firstAnswer).isEnabled());
    }
    public void verifySecondQuestion() {
        driver.findElement(secondQuestion).click();
        Assert.assertTrue(driver.findElement(secondAnswer).isEnabled());
    }
    public void verifyThirdQuestion() {
        driver.findElement(thirdQuestion).click();
        Assert.assertTrue(driver.findElement(thirdAnswer).isEnabled());
    }
    public void verifyFourthQuestion() {
        driver.findElement(fourthQuestion).click();
        Assert.assertTrue(driver.findElement(fourthAnswer).isEnabled());
    }
    public void verifyFifthtQuestion() {
        driver.findElement(fifthQuestion).click();
        Assert.assertTrue(driver.findElement(fifthAnswer).isEnabled());
    }
    public void verifySixthQuestion() {
        driver.findElement(sixthQuestion).click();
        Assert.assertTrue(driver.findElement(sixthAnswer).isEnabled());
    }
    public void verifySeventhQuestion() {
        driver.findElement(seventhQuestion).click();
        Assert.assertTrue(driver.findElement(seventhAnswer).isEnabled());
    }
    public void verifEighthQuestion() {
        driver.findElement(eighthQuestion).click();
        Assert.assertTrue(driver.findElement(eighthAnswer).isEnabled());
    }

    //метод проверки всех вопросов
    public void verifyAllQuestions() {
        scrollToViewQuestions(questionsSection);
        verifyFirstQuestion();
        verifySecondQuestion();
        verifyThirdQuestion();
        verifyFourthQuestion();
        verifyFifthtQuestion();
        verifySixthQuestion();
        verifyFifthtQuestion();
        verifySeventhQuestion();
        verifEighthQuestion();
    }

}
