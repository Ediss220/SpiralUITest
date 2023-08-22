package spiral_ui_test.runner;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.lang.reflect.Method;
import java.time.Duration;

public abstract class BaseTest {
    private WebDriverWait wait2;
    private WebDriver driver;

    @BeforeMethod
    protected void beforeMethod() {
     startDriver();
     getWeb();
    }

    protected void getWeb() {

        ProjectUtils.get(getDriver());
    }

    protected void startDriver() {

        driver = ProjectUtils.createDriver();
    }

    protected WebDriver getDriver() {

        return driver;
    }

    @AfterMethod
    protected void stopDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
    public static void log(String str) {
        System.out.println(str);
    }
}

