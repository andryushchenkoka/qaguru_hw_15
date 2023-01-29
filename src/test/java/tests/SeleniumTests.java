package tests;

import config.WebDriverProvider;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class SeleniumTests {

    private WebDriver driver;

    @BeforeEach
    public void startDriver() {
        driver = new WebDriverProvider().get();
    }

    @Test
    @DisplayName("Поиск находит канал с правильным никнеймом")
    @Tag("Search")
    public void simpleTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("input#search")).sendKeys("fc barcelona");
        driver.findElement(By.cssSelector("button#search-icon-legacy")).click();
        String searchResult = driver.findElement(By.cssSelector("#contents>ytd-channel-renderer #subscribers")).getText();
        Assertions.assertEquals("@FCBarcelona", searchResult);
    }

    @AfterEach
    public void stopDriver() {
        driver.quit();
    }
}
