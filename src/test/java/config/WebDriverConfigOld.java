package config;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverConfigOld {

    public String getBaseUrl() {
        String baseUrl = System.getProperty("baseUrl", "https://www.youtube.com/");
        return baseUrl;
    }

    public Browser getBrowser() {
        String browser = System.getProperty("browser", Browser.CHROME.toString());
        return Browser.valueOf(browser);
    }

    public URL getRemoteUrl() {
        String remoteUrl = System.getProperty("remoteUrl", "http://localhost:4444");
        try {
            return new URL(remoteUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
