package PageObjects;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderPageSamokat {
    private WebDriver driver;
    //Логотип "Самокат"
    private By samokatLogo = By.xpath("//img[@src='/assets/scooter.svg']");
    //Поле "Имя"
    private By firstNameField = By.xpath("//input[@placeholder='* Имя']");
    //Поле "Фамилия"
    private By lastNameField = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле "Адрес"
    private By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //Выпадающий список "Станция":
    private By stationField = By.xpath(".//input[@tabindex='0']");
    //Поле "Телефон":
    private By phoneNumberField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка "Далее":
    private By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Поле "Дата":
    private By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Выпадающий список "Срок аренды":
    private By rentDurationDropdown = By.xpath(".//div[contains(text(),'* Срок аренды')]");
    //Поле "Комментарий для курьера":
    private By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка "Заказать":
    private By makeOrderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Всплывающее окно "Хотите оформить заказ"
    private By orderConfirmationModal = By.className("Order_Modal__YZ-d3");
    //Кнопка "Да" на всплывающем окне "Хотите оформить заказ"
    private By orderConfirmationModalOkButton = By.xpath(".//button[contains(text(),'Да')]");


    public OrderPageSamokat(WebDriver driver) {
        this.driver = driver;
    }

    //нажать на логотип "Самокат"
    public void clickSamokatLogo(){
        driver.findElement(samokatLogo).click();
    }

    //перейти на страницу оформления заказа
    public void goToOrderPage(){
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        objHomePage.clickMakeOrderButton();
    }

    //дождаться загрузки страницы
    public void waitForOrderPageToLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@class='Button_Button__ra12g']"))));
    }

    //заполнить поле "Имя"
    public void setFirstName(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    //заполнить поле "Фамилия"
    public void setLastName(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    //заполнить поле "Адрес"
    public void setAddress(String address){
        driver.findElement(addressField).sendKeys(address);
    }

    //заполнить поле "Станция"
    public void setStation(String stationName ){
        driver.findElement(stationField).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", (driver.findElement(By.xpath("//div[contains(text(),'"+stationName+"')]"))));
        driver.findElement(By.xpath("//div[contains(text(),'"+stationName+"')]")).click();
    }

    //заполнить поле "Телефон"
    public void setPhoneNumber(String phoneNumber){
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    //Кликнуть кнопку "Далее"
    public void clickNextButton(){
        driver.findElement(nextButton).click();
    }

    //Заполнить поле "Дата"
    public void setDate(String date) {
        driver.findElement(dateField).click();
        if (date.equals("Сегодня")) {
            driver.findElement(By.xpath("//div[@class='react-datepicker__month']//div[@tabindex='0']")).click();
        } else if (date.equals("Завтра")) {
            driver.findElement(By.xpath("//div[@class='react-datepicker__month']//div[@tabindex='0']/following-sibling::div[1]")).click();
        } else if (date.equals("Вчера")) {
            driver.findElement(By.xpath("//div[@class='react-datepicker__month']//div[@tabindex='0']/preceding-sibling::div[1]")).click();
        } else {
            System.out.println("Такой даты нет: " + date);
        }
    }

    //Заполнить поле "Срок аренды"
    public void setRentDuration(String duration){
        driver.findElement(rentDurationDropdown).click();
        driver.findElement(By.xpath("//div[contains(text(),'"+duration+"')]")).click();
    }

    //Заполнить поле "Цвет самоката"
    public void setScooterColor(String color){
        driver.findElement(By.xpath("//label[@for='"+color+"']")).click();
    }

    //Заполнить поле "Комментарий для курьера"
    public void setComment(String comment){
        driver.findElement(commentField).sendKeys(comment);
    }

    //Кликнуть кнопку "Заказать"
    public void clickMakeOrderButton(){
        driver.findElement(makeOrderButton).click();
    }

    //Подтвердить всплывающее окно "Хотите оформить заказ"
    public void confirmOrderConfirmationModalIsEnabled(){
        Assert.assertTrue(orderConfirmationModal != null);
    }

    //Кликнуть кнопку "Да" на всплывающем окне "Хотите оформить заказ"
    public void clickOrderConfirmationModalOkButton(){
        driver.findElement(orderConfirmationModalOkButton).click();
    }

    // метод оформления заказа
    public void makeOrder(String firstName, String lastName, String address, String stationName, String phoneNumber, String date, String duration, String color, String comment) {
        goToOrderPage();
        waitForOrderPageToLoad();
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setStation(stationName);
        setPhoneNumber(phoneNumber);
        clickNextButton();
        setDate(date);
        setRentDuration(duration);
        setScooterColor(color);
        setComment(comment);
        clickMakeOrderButton();
        confirmOrderConfirmationModalIsEnabled();
        clickOrderConfirmationModalOkButton();
    }

}