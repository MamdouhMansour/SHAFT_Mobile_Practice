package tests.gui.google;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.ExcelFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Assertions.AssertionComparisonType;
import com.shaft.validation.Assertions.AssertionType;

import objectModels.gui.google.Home;
import objectModels.gui.google.Results;

public class E_Search_PageObjectModel_Traditional_SHAFTAssertions {
    private WebDriver driver;
    private Home homePage;
    private Results resultsPage;
    private ExcelFileManager simpleSearch;

    @Test
    public void navigateToGoogleHomeAndAssertPageTitle() {
	Assertions.assertBrowserAttribute(driver, "Title", homePage.getExpectedPageTitle(),
		"Asserting that the page title is Google");
    }

    @Test
    public void navigateToGoogleHomeAndAssertGoogleLogoIsDisplayed() {
	Assertions.assertElementMatches(driver, homePage.getGoogleLogo(),
		"Asserting that the Google logo is displayed");
    }

    @Test
    public void searchForQueryAndAssertFirstResultTextIsCorrect() {
	homePage.searchForQuery(simpleSearch.getCellData("Search Query", "Data2"));
	Assertions.assertElementAttribute(driver, resultsPage.getSearchResult(1), "Text",
		simpleSearch.getCellData("Expected First Search Result Text"), AssertionComparisonType.CONTAINS,
		AssertionType.POSITIVE, "Asserting that the correct first result is displayed");
    }

    @BeforeClass
    public void beforeClass() {
	simpleSearch = new ExcelFileManager(System.getProperty("testDataFolderPath") + "Google/SimpleSearch.xlsx");
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
