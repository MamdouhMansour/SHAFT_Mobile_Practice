package objectModels.gui.google;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;

public class Home {
    private WebDriver driver;
    private String expectedPageTitle = "Google";
    private By googleLogo_image = By.id("hplogo");
    private By searchbox_text = By.name("q");

    public Home(WebDriver driver) {
	this.driver = driver;
    }

    public String getExpectedPageTitle() {
	return expectedPageTitle;
    }

    public String getPageTitle() {
	return BrowserActions.getCurrentWindowTitle(driver);
    }

    public By getGoogleLogo() {
	return googleLogo_image;
    }

    public boolean isGoogleLogoDisplayed() {
	return ElementActions.isElementDisplayed(driver, googleLogo_image);
    }

    public Results searchForQuery(String query) {
	new ElementActions(driver).type(searchbox_text, query).keyPress(searchbox_text, Keys.ENTER);
	return new Results(driver);
    }

}
