package gui.objectModels.google;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.locators.RelativeLocator;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Assertions;
import com.shaft.validation.Assertions.AssertionComparisonType;
import com.shaft.validation.Assertions.AssertionType;

public class Home {
    private WebDriver browserObject;
    private String urlForNavigation = "https://www.google.com/ncr";
    private String urlAfterRedirection = "https://www.google.com";
    private String pageTitle = "Google";

    private By body_googleLogo_image = By.id("hplogo");
    private By body_searchBox_textField = By.xpath("//input[@id='lst-ib' or @class='lst' or @name='q']");
//    private By body_searchBox_textField_relative = RelativeLocator.withTagName("input").below(body_googleLogo_image);

    public Home(WebDriver browserObject) {
	this.browserObject = browserObject;
    }

    public void navigateToURL() {
	BrowserActions.navigateToURL(browserObject, urlForNavigation, urlAfterRedirection);
    }

    public void searchForQuery(String searchQuery) {
	ElementActions.type(browserObject, body_searchBox_textField, searchQuery);
	ElementActions.keyPress(browserObject, body_searchBox_textField, Keys.ENTER);
    }

    public void assertGoogleLogoIsDisplayed() {
	Assertions.assertElementExists(browserObject, body_googleLogo_image, AssertionType.POSITIVE);
    }

    public void assertPageTitleIsCorrect() {
	Assertions.assertBrowserAttribute(browserObject, "Title", pageTitle, AssertionComparisonType.EQUALS,
		AssertionType.POSITIVE);
    }

}
