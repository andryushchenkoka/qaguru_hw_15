package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.ProjectConfiguration;
import config.WebConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    protected static ProjectConfiguration projectConfig;
    protected static WebConfig config;

    @BeforeAll
    public static void beforeAll() {
        config = ConfigFactory.create(WebConfig.class, System.getProperties());
        projectConfig = new ProjectConfiguration();
        projectConfig.setupConfig(config);
    }

    @BeforeEach
    public void beforeEach() {
        open("https://www.youtube.com/");
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
