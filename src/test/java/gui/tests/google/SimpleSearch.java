package gui.tests.google;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.browser.BrowserFactory.BrowserType;
import com.shaft.tools.io.ExcelFileManager;

import gui.objectModels.google.Home;
import gui.objectModels.google.SearchResults;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

/**
 * This class demonstrates how to use SHAFT_Engine for basic web GUI actions and
 * assertions. </br>
 * </br>
 * For more information on how to perform actions and assertions, please refer
 * to the SHAFT_Engine documentation here:
 * https://mohabmohie.github.io/SHAFT_ENGINE/ </br>
 * </br>
 * For more information on how to drive the test execution, please refer to the
 * TestNG Documentation here: https://testng.org/doc/documentation-main.html
 * </br>
 * For more information on how to drive the reporting, please refer to the
 * Allure Documentation here: https://docs.qameta.io/allure/
 *
 */
public class SimpleSearch {
    // Declaring WebDriver and ExcelFileManager instances
    private WebDriver browserObject;
    private ExcelFileManager simpleSearch;

    // Declaring The Page Objects that will be used throughout the test class
    private Home homePage;
    private SearchResults searchResultsPage;

    @Test(description = "TC001 - Page Title is correct")
    @Description("Given I am on the home page, Then the correct page title will be displayed.")
    @Severity(SeverityLevel.TRIVIAL)
    public void assertPageTitle() {
	homePage.assertPageTitleIsCorrect();
    }

    @Test(description = "TC002 - Google Logo is displayed")
    @Description("Given I am on the home page, Then the google logo will be displayed.")
    @Severity(SeverityLevel.NORMAL)
    public void assertGoogleLogoIsDisplayed() {
	homePage.assertGoogleLogoIsDisplayed();
    }

    @Test(description = "TC003 - Search for Query and Assert that the number of results is not empty")
    @Description("Given I am on the home page, When I search for the first query, Then the number of results will not be empty.")
    @Severity(SeverityLevel.BLOCKER)
    public void searchForQueryAndAssertResultsNumberIsNotEmpty() {
	homePage.searchForQuery(simpleSearch.getCellData("Search Query"));

	searchResultsPage = new SearchResults(browserObject);
	searchResultsPage.assertResultsStatsExistsAndIsNotEmpty();
    }

    @Test(description = "TC004 - Search for Query and Assert that the link of the first result matches the expected text")
    @Description("Given I am on the home page, When I search for the second query, Then the link of the first result will match the expected text.")
    @Severity(SeverityLevel.CRITICAL)
    public void searchForQueryAndAssertTextOfTheFirstResult() {
	homePage.searchForQuery(simpleSearch.getCellData("Search Query", "Data2"));

	searchResultsPage = new SearchResults(browserObject);
	searchResultsPage.assertResultLinkForSpecificResultIndex(1,
		simpleSearch.getCellData("Expected First Search Result Link"));
    }

    /**
     * This is a Set-up method, to be always run once before the first test in the
     * current class
     */
    @BeforeClass(alwaysRun = true)
    public void initializeGlobalObjectsAndNavigateToHomePage() {
	System.setProperty("aiSupportedElementIdentification", "true");
	// initializing the simpleSearch object by pointing it to the directory of the
	// target test data file
	simpleSearch = new ExcelFileManager(System.getProperty("testDataFolderPath") + "Google/SimpleSearch.xlsx");

	// initializing the browserObject by selecting one of the supported browsers
	// Note: you can leave this empty and override the global default browser from
	// your properties file
	browserObject = BrowserFactory.getBrowser(BrowserType.GOOGLE_CHROME);
    }

    /**
     * This is a Set-up method, to be always run once before each test in the
     * current class. A method with the annotation @BeforeClass will always run
     * before this method's first run
     */
    @BeforeMethod(alwaysRun = true)
    public void initializeObjectAndNavigateToHomePage() {
	homePage = new Home(browserObject);
	homePage.navigateToURL();
    }
}