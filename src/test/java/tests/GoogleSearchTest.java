package tests;

import org.junit.jupiter.api.Test;
import pages.GoogleSearchPage;

public class GoogleSearchTest {

    @Test
    public void searchTest(){
        String searchValue = "DTEK";

        new GoogleSearchPage()
                .setSearch(searchValue)
                .clickSearchButton()
                .assertContainsSearchResult(searchValue);
    }
}
