package config;

public class WebDriverConfig {

    public String getBaseUrl(){
        return "https://www.youtube.com/";
    }

    public Browser getBrowser(){
        return Browser.CHROME;
    }


}
