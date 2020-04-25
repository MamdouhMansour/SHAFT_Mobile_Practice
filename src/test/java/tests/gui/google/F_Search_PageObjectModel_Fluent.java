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

public class F_Search_PageObjectModel_Fluent {
    private WebDriver driver;
    private ExcelFileManager simpleSearch;

    @Test
    public void navigateToGoogleHomeAndAssertPageTitle() {
	Assertions.assertBrowserAttribute(driver, "Title", new Home(driver).getExpectedPageTitle(),
		"Asserting that the page title is Google");
    }

    @Test
    public void navigateToGoogleHomeAndAssertGoogleLogoIsDisplayed() {
	Assertions.assertElementMatches(driver, new Home(driver).getGoogleLogo(),
		"Asserting that the Google logo is displayed");
    }

    @Test
    public void searchForQueryAndAssertFirstResultTextIsCorrect() {
	Assertions.assertElementAttribute(driver,
		new Home(driver).searchForQuery(simpleSearch.getCellData("Search Query", "Data2")).getSearchResult(1),
		"Text", simpleSearch.getCellData("Expected First Search Result Text"), AssertionComparisonType.CONTAINS,
		AssertionType.POSITIVE, "Asserting that the correct first result is displayed");
    }

    @BeforeClass
    public void beforeClass() {
	simpleSearch = new ExcelFileManager(System.getProperty("testDataFolderPath") + "Google/SimpleSearch.xlsx");
    }

    @BeforeMethod
    public void beforeMethod() {
	driver = BrowserFactory.getBrowser();
	BrowserActions.navigateToURL(driver, "https://www.google.com/ncr", "https://www.google.com");
    }

    @AfterMethod
    public void afterMethod() {
	BrowserActions.closeCurrentWindow(driver);
    }
}
