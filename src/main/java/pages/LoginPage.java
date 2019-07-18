package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    @FindBy(id = "username")
    private WebElement emailInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "current_account")
    private WebElement accountInfo;

    public void typeEmailAndSend(){
        emailInput.sendKeys("nowak@gmail.com");
        emailInput.submit();
    }
    public void typePasswordAndSend(){
        wait.until(ExpectedConditions.visibilityOf(passwordInput)).sendKeys("*******");
        passwordInput.submit();
    }
    public void checkLogIn(){
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOf(accountInfo)).getText() , "Twoje konto\n" +
                "Poziom 2");
    }
}
