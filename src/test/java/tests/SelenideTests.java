package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.MainPage;
import pages.SearchResultsPage;

public class SelenideTests extends BaseTest {

    @ParameterizedTest
    @CsvSource({
            "фк ростов, @fcrostovlive",
            "fc barcelona, @FCBarcelona",
            "qa guru, @QAGURU"
    })
    @DisplayName("Поиск находит канал с правильным никнеймом")
    @Tag("Search")
    public void simpleTest(String channelName, String expectedTag) {
        new MainPage().fillSearchInput(channelName);
        String actualTag = new SearchResultsPage().getAccountTag();
        Assertions.assertEquals(expectedTag, actualTag);
    }
}
