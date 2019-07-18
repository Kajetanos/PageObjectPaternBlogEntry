package tests;

import org.testng.annotations.Test;
import pages.ApartmentPage;

public class ProductTest extends BaseTest {
    @Test
    public void apartmentProductTest(){
        ApartmentPage apartmentPage = new ApartmentPage(driver,wait);
        apartmentPage.openHostelProduct();
        apartmentPage.checkPoliciesBtn();
    }
}
