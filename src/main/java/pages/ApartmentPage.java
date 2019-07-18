package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ApartmentPage extends BasePage {
    public ApartmentPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    @FindBy(id = "hp_hotel_name")
    WebElement apartmentName;
    @FindBy(xpath = "//*[@id=\"photo_wrapper\"]/div[1]/div/div/div[25]")
    WebElement firstRoomLink;
    @FindBy(xpath = "//*[@id=\"blocktoggleRD244253818\"]/h1")
    WebElement firstRoomName;
    @FindBy(xpath = "//*[@id=\"right\"]/div[2]/ul/li[3]/a")
    WebElement policiesBtn;
    @FindBy(xpath = "//*[@id=\"hp_policies_box\"]/div[1]/h2")
    WebElement policies;


    public void compareNameProduct(String apartmentNameFromSearchingPage) {
        wait.until(ExpectedConditions.visibilityOf(apartmentName));
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOf(apartmentName)).getText(),apartmentNameFromSearchingPage);
    }
    public void openHostelProduct(){
        driver.get("https://www.booking.com/hotel/pl/hostel-1902.pl.html?errorc_checkin_invalid_format=checkin;errorc_intro_error_message_invalid=intro_error_message;errorv_checkin=2019-07-17;errorv_checkout=2019-07-18;errorv_hostname=www.booking.com;errorv_hotel_id=2442538;errorv_installment_count=1;errorv_interval=1;errorv_nr_rooms_244253812_143319810_1_0_0=1;errorv_room1=A%252CA;errorv_rt_num_blocks=2;errorv_rt_num_rooms=2;errorv_rt_pos_selected=1;errorv_rt_pos_selected_within_room=1;errorv_srpvid=57ba48d5acf9000a;errorv_stage=1;label=gen173nr-1FCAEoggI46AdIM1gEaLYBiAEBmAEeuAEXyAEM2AEB6AEB-AELiAIBqAIDuAKbzLfpBcACAQ;sid=3c6ef011dd8eb13ad408699628f4650f;srpvid=57ba48d5acf9000a#policies");
    }
    public void checkPoliciesBtn(){
        driver.get("https://www.booking.com/hotel/pl/hostel-1902.pl.html?label=gen173nr-1FCAEoggI46AdIM1gEaLYBiAEBmAEeuAEXyAEM2AEB6AEB-AELiAIBqAIDuAKbzLfpBcACAQ&sid=272d3d4f69511ebd9a4d4688f1561db1&checkin=2019-07-17&checkout=2019-07-18&dest_id=-538221&dest_type=city&hapos=1&hpos=1&soh=1&sr_order=popularity&srepoch=1563435916&srpvid=13b836857040022d&ucfs=1&from=searchresults;highlight_room=#no_availability_msg");
        policiesBtn.click();
        Assert.assertEquals(policiesBtn.getText(),policies.getText());
    }
}
