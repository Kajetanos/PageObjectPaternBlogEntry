package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.MainPage;

public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        //noinspection deprecation
        wait = new WebDriverWait(driver, 15);
        driver.manage().window().maximize();
        MainPage mainPage = new MainPage(driver,wait);
        mainPage.openMainPage();
        mainPage.openFormToLogin();
        LoginPage loginPage = new LoginPage(driver,wait);
        loginPage.typeEmailAndSend();
        loginPage.typePasswordAndSend();
        loginPage.checkLogIn();
    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
