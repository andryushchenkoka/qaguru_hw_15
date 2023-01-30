package tests;

import config.ProjectConfiguration;
import config.WebConfig;
import org.aeonbits.owner.ConfigFactory;
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
    }
}
