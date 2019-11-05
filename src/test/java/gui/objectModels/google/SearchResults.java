package gui.objectModels.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Assertions;
import com.shaft.validation.Assertions.AssertionComparisonType;
import com.shaft.validation.Assertions.AssertionType;

public class SearchResults {
    private WebDriver browserObject;
    private By resultsStats_label = By.id("resultStats");
    private By searchResult_box = By.xpath("//div[@class='srg']//div[@class='g']");
    private By body_searchResults_dynamicSearchResultLink;

    public SearchResults(WebDriver browserObject) {
	this.browserObject = browserObject;
    }

    public void assertResultsStatsExistsAndIsNotEmpty() {
	Assertions.assertElementAttribute(browserObject, resultsStats_label, "Text", "", AssertionComparisonType.EQUALS,
		AssertionType.NEGATIVE);
    }

    public void assert10ResultsAreDisplayedPerPageExcludingSponsoredContent() {
	Assertions.assertEquals(10, ElementActions.getElementsCount(browserObject, searchResult_box),
		AssertionComparisonType.EQUALS, AssertionType.POSITIVE);
    }

    public void assertResultLinkForSpecificResultIndex(int resultIndex, String expectedResultText) {
	body_searchResults_dynamicSearchResultLink = By.xpath("(//cite)[" + resultIndex + "]");
	Assertions.assertElementAttribute(browserObject, body_searchResults_dynamicSearchResultLink, "Text",
		expectedResultText, AssertionComparisonType.CONTAINS, AssertionType.POSITIVE);
    }
}
