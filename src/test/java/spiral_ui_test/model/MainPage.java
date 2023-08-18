package spiral_ui_test.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BaseModel{

    @FindBy(name = "q")
    private static WebElement searchbox;

    @FindBy(id = "result-stats")
    private static WebElement result;

    @FindBy(className = "sATSHe")
    private static WebElement imageassert;

    @FindBy(xpath = "//div[@role='heading'][normalize-space()='Duck']")
    private static WebElement duckconfirmation;

    @FindBy(xpath = "//div[@role='heading'][normalize-space()='Insects']")
    private static WebElement bugconfirmation;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage entersearchquery() {
        searchbox.sendKeys("Ducks");
        return this;
    }
    public MainPage enternonexistsearchquery() {
        searchbox.sendKeys("Bugs");
        return this;
    }

    public MainPage clicksubmit() {
        searchbox.submit();
        return this;
    }
    public MainPage wait2() {
        getWait();
        return this;
    }
    public String resultassert() {
        return String.valueOf(result.isDisplayed());

    }
    public String logresult() {
       return result.getText();

    }
    public String imageassert() {
        return String.valueOf(imageassert.isDisplayed());

    }

    public String searchboxassert() {
        return String.valueOf(searchbox.isDisplayed());

    }
    public String duckconfirm() {
        return duckconfirmation.getText();

    }
    public String bugconfirm() {
        return bugconfirmation.getText();

    }

    public String enteredText() {
        return searchbox.getAttribute("value");

    }

}
