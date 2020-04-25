package objectModels.gui.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shaft.gui.element.ElementActions;

public class Results {
    private WebDriver driver;
    private String genericSearchResultXPath = "//h1[contains(text(),'Search Result')]/following-sibling::div//a/h3";

    public Results(WebDriver driver) {
	this.driver = driver;
    }

    public By getSearchResult(int resultNumber) {
	return By.xpath("(" + genericSearchResultXPath + ")[" + resultNumber + "]");
    }

    public String getSearchResultText(int resultNumber) {
	return ElementActions.getText(driver, By.xpath("(" + genericSearchResultXPath + ")[" + resultNumber + "]"));
    }
}
