package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.$;

public class SelenideTests extends BaseTest {

    @ParameterizedTest
    @CsvSource({
            "фк ростов", "@fcrostovlive",
            "fc barcelona", "@FCBarcelona",
            "qa guru", "@QAGURU"
    })
    @DisplayName("Поиск находит канал с правильным никнеймом")
    @Tag("Search")
    public void simpleTest(String channelName, String expectedTag) {
        $("input#search").setValue(channelName);
        $("button#search-icon-legacy").click();
        String actualTag = $("#subscribers").getText();
        Assertions.assertEquals(expectedTag, actualTag);
    }
}
