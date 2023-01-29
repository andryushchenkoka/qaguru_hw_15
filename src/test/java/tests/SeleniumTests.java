package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import java.time.Duration;

public class SeleniumTests extends BaseTest {

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
}
