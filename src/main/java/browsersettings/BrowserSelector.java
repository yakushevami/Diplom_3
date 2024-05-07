package browsersettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserSelector {
    public static WebDriver getDriver() {
        WebDriver driver;
        String browserName = System.getProperty("browser");
        if (browserName==null) { browserName = ""; }
        ChromeOptions options = new ChromeOptions();
        switch (browserName) {
            case "chrome":
            case "":
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                break;
            case "yandex":
                driver = new ChromeDriver(options);
                break;
            default:throw new RuntimeException("Incorrect Browser: "+ browserName);
        }
        return driver;
    }
}