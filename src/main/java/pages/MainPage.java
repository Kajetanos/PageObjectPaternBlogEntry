package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MainPage extends BasePage {
    private String mainPageUrl = "https://www.booking.com/";

    @FindBy(xpath = "//*[@id=\"b2indexPage\"]/div[18]/div/div[2]/a")
    protected WebElement openFormButton;
    @FindBy(xpath = "//*[@id=\"cookie_warning\"]/div[2]/a")
    private WebElement cookieAcceptBtn;
    @FindBy(id = "ss")
    private WebElement searchingPlaceInput;
    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[2]")
    private WebElement nextMonthBtn;
    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[1]/table/tbody/tr[3]/td[3]")
    private WebElement startDate;
    @FindBy(id = "//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[1]/table/tbody/tr[4]/td[4]")
    private WebElement endDate;
    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]")
    private WebElement firstElementSearchingList;
    @FindBy(xpath = "//*[@id=\"right\"]/div[4]/div/div/div/h1")
    private WebElement titleSearching;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void openMainPage(){
        driver.get(mainPageUrl);
    }
    public void openFormToLogin()  {
        closeCookie();
        wait.until(ExpectedConditions.visibilityOf(openFormButton)).click();
        Assert.assertEquals(driver.getCurrentUrl().substring(0,35) , "https://account.booking.com/sign-in");
    }
    public void closeCookie(){
        cookieAcceptBtn.click();
    }
    public void typeTownToSearch(String town){
        searchingPlaceInput.clear();
        searchingPlaceInput.sendKeys(town);
        wait.until(ExpectedConditions.visibilityOf(firstElementSearchingList)).click();
    }
    public void chooseRandomDateToSearch(){
        nextMonthBtn.click();
        startDate.click();
    }
    public void sendFormToSearch(){
        searchingPlaceInput.submit();
    }
    public void checkSearchResult(String town){ Assert.assertEquals(titleSearching.getText().substring(0,8), town);
    }
}
