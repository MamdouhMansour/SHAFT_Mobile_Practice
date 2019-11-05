package duckDuckGo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Assertions;
import com.shaft.validation.Assertions.AssertionComparisonType;
import com.shaft.validation.Assertions.AssertionType;

public class searchForQuery {
    WebDriver browserObject;

    @Test
    public void firstTestMethod() {
	BrowserActions.navigateToURL(browserObject, "https://duckduckgo.com");
	By searchBox = By.id("search_form_input_homepage");

	ElementActions.type(browserObject, searchBox, "toptal");
	ElementActions.keyPress(browserObject, searchBox, Keys.ENTER);

	By firstSearchResult = By.xpath("(//div[@id='links']//a[@class='result__a'])[1]");

	ElementActions.click(browserObject, firstSearchResult);

	Assertions.assertBrowserAttribute(browserObject, "CurrentUrl", "https://www.toptal.com",
		AssertionComparisonType.EQUALS, AssertionType.POSITIVE);
    }

    @BeforeClass
    public void initializeDriver() {
	browserObject = BrowserFactory.getBrowser();
    }
}
