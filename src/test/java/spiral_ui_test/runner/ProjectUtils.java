package spiral_ui_test.runner;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ProjectUtils {

    static void get(WebDriver driver) {
        driver.get("https://google.com/");
    }

    public static WebDriver createDriver()  {
        WebDriver driver;

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--window-size=1920,1080");
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("headless");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        return driver;
    }

}

