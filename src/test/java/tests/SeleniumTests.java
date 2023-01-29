package tests;

import config.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
