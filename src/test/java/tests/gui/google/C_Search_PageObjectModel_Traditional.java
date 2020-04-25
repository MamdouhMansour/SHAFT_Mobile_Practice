package tests.gui.google;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import com.shaft.validation.Assertions.AssertionComparisonType;
import com.shaft.validation.Assertions.AssertionType;

import objectModels.gui.google.Home;
import objectModels.gui.google.Results;

public class C_Search_PageObjectModel_Traditional {
    private WebDriver driver;
    private Home homePage;
    private Results resultsPage;

    @Test
    public void navigateToGoogleHomeAndAssertPageTitle() {
	Assertions.assertEquals(homePage.getExpectedPageTitle(), homePage.getPageTitle(),
		"Asserting that the page title is Google");
    }

    @Test
    public void navigateToGoogleHomeAndAssertGoogleLogoIsDisplayed() {
	Assertions.assertTrue(homePage.isGoogleLogoDisplayed(), "Asserting that the Google logo is displayed");
    }

    @Test
    public void searchForQueryAndAssertFirstResultTextIsCorrect() {
	homePage.searchForQuery("SHAFT_Engine");
	Assertions.assertEquals("MohabMohie", resultsPage.getSearchResultText(1),
		AssertionComparisonType.CONTAINS, AssertionType.POSITIVE,
		"Asserting that the correct first result is displayed");
    }

    @BeforeMethod
    public void beforeMethod() {
	driver = BrowserFactory.getBrowser();
	homePage = new Home(driver);
	resultsPage = new Results(driver);

	BrowserActions.navigateToURL(driver, "https://www.google.com/ncr", "https://www.google.com");
    }
    
    @AfterMethod
    public void afterMethod() {
	BrowserActions.closeCurrentWindow(driver);
    }
}
