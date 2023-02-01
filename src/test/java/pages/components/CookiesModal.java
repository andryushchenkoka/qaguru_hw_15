package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;

public class CookiesModal {

    private static final ElementsCollection confirmButtons = $$("#dialog .eom-button-row>ytd-button-renderer");

    // Принять все cookies
    public static void acceptAllCookies() {
        SelenideElement acceptAllButton = confirmButtons.get(1);
        if (acceptAllButton.isDisplayed()) {
            acceptAllButton.click();
        }
    }
}
