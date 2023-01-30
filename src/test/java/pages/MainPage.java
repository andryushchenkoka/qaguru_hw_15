package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private final SelenideElement searchInput = $("input#search");

    // Ввести и отправить поисковый запрос
    public void fillSearchInput(String value) {
        searchInput.setValue(value).pressEnter();
    }
}
