package tests;

import org.junit.jupiter.api.Test;
import pages.GoogleSearchPage;
import setup.MobileTestSetup;

public class GoogleSearchTest extends MobileTestSetup {

    @Test
    public void searchTest(){
        String searchValue = "DTEK";

        new GoogleSearchPage()
                .setSearch(searchValue)
                .clickSearchButton()
                .assertContainsSearchResult(searchValue);
    }
}
