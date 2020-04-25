package tests.gui.google;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Assertions;
import com.shaft.validation.Assertions.AssertionComparisonType;
import com.shaft.validation.Assertions.AssertionType;

public class B_Search_FlatTest_SHAFT {
    private WebDriver driver;

    @Test
    public void navigateToGoogleHomeAndAssertPageTitle() {
	Assertions.assertBrowserAttribute(driver, "Title", "Google", "Asserting that the page title is Google");
    }

    @Test
    public void navigateToGoogleHomeAndAssertGoogleLogoIsDisplayed() {
	Assertions.assertElementMatches(driver, By.id("hplogo"), "Asserting that the Google logo is displayed");
    }

    @Test
    public void searchForQueryAndAssertFirstResultTextIsCorrect() {
	new ElementActions(driver).type(By.name("q"), "SHAFT_Engine").keyPress(By.name("q"), Keys.ENTER);
	String genericSearchResultXPath = "//h1[contains(text(),'Search Result')]/following-sibling::div//a/h3";
	Assertions.assertElementAttribute(driver, By.xpath("(" + genericSearchResultXPath + ")[1]"), "Text",
		"MohabMohie", AssertionComparisonType.CONTAINS, AssertionType.POSITIVE,
		"Asserting that the correct first result is displayed");
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
