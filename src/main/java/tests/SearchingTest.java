package tests;

import org.testng.annotations.Test;
import pages.ApartmentPage;
import pages.MainPage;
import pages.SearchResultPage;

public class SearchingTest extends BaseTest{

    public String inputTown = "Zakopane";

    @Test
    public void checkSearchingApartmentInZakopane() {

        MainPage mainPage = new MainPage(driver,wait);
        mainPage.typeTownToSearch(inputTown);
        mainPage.chooseRandomDateToSearch();
        mainPage.sendFormToSearch();
        mainPage.checkSearchResult(inputTown);

        SearchResultPage searchResultPage = new SearchResultPage(driver,wait);
        searchResultPage.selectSortingAtTheLowerPrice();
        searchResultPage.checkSorting();
        String titleApartment = searchResultPage.getTitle();
        searchResultPage.openFirstProduct();

        ApartmentPage apartmentPage = new ApartmentPage(driver,wait);
        apartmentPage.compareNameProduct(titleApartment);
    }

}

