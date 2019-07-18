package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SearchResultPage extends BasePage{
    public SearchResultPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    private String SearchResultPageUrl = "https://www.booking.com/searchresults.pl.html?label=gen173nr-1FCAEoggI46AdIM1gEaLYBiAEBmAEeuAEXyAEM2AEB6AEB-AELiAIBqAIDuAKbzLfpBcACAQ&sid=a049cb54c81ac47a0c5fb5271628c247&sb=1&src=searchresults&src_elem=sb&error_url=https%3A%2F%2Fwww.booking.com%2Fsearchresults.pl.html%3Flabel%3Dgen173nr-1FCAEoggI46AdIM1gEaLYBiAEBmAEeuAEXyAEM2AEB6AEB-AELiAIBqAIDuAKbzLfpBcACAQ%3Bsid%3Da049cb54c81ac47a0c5fb5271628c247%3Btmpl%3Dsearchresults%3Bcheckin_month%3D7%3Bcheckin_monthday%3D16%3Bcheckin_year%3D2019%3Bcheckout_month%3D7%3Bcheckout_monthday%3D17%3Bcheckout_year%3D2019%3Bcity%3D-538221%3Bclass_interval%3D1%3Bdest_id%3D-538221%3Bdest_type%3Dcity%3Bdtdisc%3D0%3Bfrom_sf%3D1%3Bgroup_adults%3D2%3Bgroup_children%3D0%3Binac%3D0%3Bindex_postcard%3D0%3Blabel_click%3Dundef%3Bno_rooms%3D1%3Boffset%3D0%3Border%3Dprice%3Bpostcard%3D0%3Broom1%3DA%252CA%3Bsb_price_type%3Dtotal%3Bshw_aparth%3D1%3Bslp_r_match%3D0%3Bsrc%3Dsearchresults%3Bsrc_elem%3Dsb%3Bsrpvid%3D3f212e6c37120205%3Bss%3DZakopane%3Bss_all%3D0%3Bssb%3Dempty%3Bsshis%3D0%3Bssne%3DZakopane%3Bssne_untouched%3DZakopane%26%3B&order=price&ss=Zakopane&is_ski_area=0&ssne=Zakopane&ssne_untouched=Zakopane&city=-538221&checkin_year=2019&checkin_month=7&checkin_monthday=17&checkout_year=2019&checkout_month=7&checkout_monthday=18&group_adults=2&group_children=0&no_rooms=1&from_sf=1";

    @FindBy(linkText = "Cena (od najniższej)")
    WebElement sortAtTheLowestPriceBtn;
    @FindBy(xpath = "//*[@id=\"hotellist_inner\"]/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/div")
    WebElement firstPrice;
    @FindBy(xpath = "//*[@id=\"hotellist_inner\"]/div[4]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]")
    WebElement secondPrice;
    @FindBy(xpath = "//*[@id=\"hotellist_inner\"]/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]")
    WebElement thirdPrice;
    @FindBy(xpath = "//*[@id=\"hotellist_inner\"]/div[4]/div[2]/div[1]")
    WebElement titleApartment;

    public void selectSortingAtTheLowerPrice(){
        driver.get(SearchResultPageUrl);
        System.out.println(wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.linkText("Cena (od najniższej)")))).getText());
        wait.until(ExpectedConditions.visibilityOf(sortAtTheLowestPriceBtn)).click();
    }
    public void checkSorting(){
        Assert.assertTrue(Integer.parseInt(firstPrice.getText().replaceAll(" zł",""))  <= Integer.parseInt(secondPrice.getText().substring(0,6).replaceAll(" zł","")));
    }
    public void openFirstProduct() {
        wait.until(ExpectedConditions.visibilityOf(firstPrice)).click();
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL,Keys.SHIFT,Keys.TAB);
    }
    public String getTitle(){
        String[] lines = driver.findElement(By.xpath("//*[@id=\"hotellist_inner\"]/div[2]/div[2]")).getText().split("\\r?\\n");
        return lines[0];
    }
}

