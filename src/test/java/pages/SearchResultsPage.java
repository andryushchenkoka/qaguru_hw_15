package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultsPage {

    private final SelenideElement accountTag = $("#subscribers");

    // Получить тег канала из описания (через @)
    public String getAccountTag() {
        return accountTag.getText();
    }
}
