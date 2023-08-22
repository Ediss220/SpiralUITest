package spiral_ui_test.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import spiral_ui_test.model.MainPage;
import spiral_ui_test.runner.BaseTest;

import static org.testng.AssertJUnit.assertEquals;

public class DuckTestPom extends BaseTest {
    /**
     * This class created for Search Testing
     * @author edward isakov
     * @lastmodifiedby edward isakov
     */
    @Severity(SeverityLevel.NORMAL)
    @Feature("Functional")
    @Description("Verified that the search box is present on the page and is visible to the user.")
    @Test(priority = 1)
    public void SearchBoxVerification(){
        MainPage GooglePage  = new MainPage(getDriver())
                .wait2();
        Assert.assertTrue(true,GooglePage.searchboxassert());

    }

    @Severity(SeverityLevel.NORMAL)
    @Feature("Functional")
    @Description("Verified that the search box accepts input from the user.")
    @Test(dependsOnMethods = "SearchBoxVerification")
    public void InputQueryTest(){
        MainPage GooglePage  = new MainPage(getDriver())
                .entersearchquery()
                .wait2();
        assertEquals("Ducks",GooglePage.enteredText(), "Ducks");

    }

    @Severity(SeverityLevel.NORMAL)
    @Feature("Functional")
    @Description("Verified that the search results are displayed correctly on the page.")
    @Test(priority = 2)
    public void SearchTest(){
        MainPage GooglePage  = new MainPage(getDriver())
                .entersearchquery()
                .clicksubmit()
                .wait2();
        Assert.assertTrue(true,GooglePage.resultassert());

    }

    @Severity(SeverityLevel.NORMAL)
    @Feature("Functional")
    @Description("Verify Search Results for 'Ducks' ")
    @Test(priority = 3)
    public void VerifiedResultTest(){
        MainPage GooglePage  = new MainPage(getDriver())
                .entersearchquery()
                .clicksubmit()
                .wait2();
        Assert.assertTrue(true,GooglePage.resultassert());
        log(GooglePage.logresult());
    }

    @Severity(SeverityLevel.NORMAL)
    @Feature("Functional")
    @Description("Verify that the search results are relevant to the search query.")
    @Test(priority = 4)
    public void VerifiedDuckTest(){
        MainPage GooglePage  = new MainPage(getDriver())
                .entersearchquery()
                .clicksubmit()
                .wait2();
        Assert.assertEquals(GooglePage.duckconfirm(),"Duck");
        log(GooglePage.duckconfirm());
    }

    @Severity(SeverityLevel.NORMAL)
    @Feature("Functional")
    @Description("Verify Image Results for 'Ducks' ")
    @Test(priority = 5)
    public void DucksSearchImageTest(){
        MainPage GooglePage  = new MainPage(getDriver())
                .entersearchquery()
                .clicksubmit()
                .wait2();
        Assert.assertTrue(true,GooglePage.imageassert());
    }

    @Severity(SeverityLevel.NORMAL)
    @Feature("Functional")
    @Description("Verify Search Results for 'Bugs' ")
    @Test(priority = 6)
    public void NonDucksSearchTest(){
        MainPage GooglePage  = new MainPage(getDriver())
                .enternonexistsearchquery()
                .clicksubmit()
                .wait2();
        Assert.assertEquals(GooglePage.bugconfirm(),"Insects");
        log(GooglePage.bugconfirm());
    }
}
