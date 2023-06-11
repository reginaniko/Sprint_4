package Base;

import PageObjects.HomePageSamokat;
import PageObjects.OrderPageSamokat;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    public final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    protected HomePageSamokat objHomePage;
    protected OrderPageSamokat objOrderPage;


    @Before
    public void setUp() {
        //для Firefox
//        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
//        driver = new FirefoxDriver();
//        driver.manage().window().maximize();
//        driver.get(PAGE_URL);
//        objHomePage = new HomePageSamokat(driver);
//        objOrderPage = new OrderPageSamokat(driver);

        //для Chrome
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.get(PAGE_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        objHomePage = new HomePageSamokat(driver);
        objOrderPage = new OrderPageSamokat(driver);
    }

    @After
     public void tearDown() {
        driver.quit();
    }
}
