package tests.gui.google;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A_Search_FlatTest_NativeSeleniumWebDriver {
    private WebDriver driver;

    @Test
    public void navigateToGoogleHomeAndAssertPageTitle() {
	System.out.println("Asserting that the page title is Google");
	Assert.assertEquals(driver.getTitle(), "Google");
    }

    @Test
    public void navigateToGoogleHomeAndAssertGoogleLogoIsDisplayed() {
	System.out.println("Asserting that the Google logo is displayed");
	Assert.assertTrue(driver.findElement(By.id("hplogo")).isDisplayed());
    }

    @Test
    public void searchForQueryAndAssertFirstResultTextIsCorrect() {
	driver.findElement(By.name("q")).sendKeys("SHAFT_Engine" + Keys.ENTER);
	String genericSearchResultXPath = "//h1[contains(text(),'Search Result')]/following-sibling::div//a/h3";
	System.out.println("Asserting that the correct first result is displayed");
	Assert.assertTrue(driver.findElement(By.xpath("(" + genericSearchResultXPath + ")[1]")).getText()
		.contains("MohabMohie"));
    }

    @BeforeClass
    public void beforeClass() {
	WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod() {
	driver = new ChromeDriver();
	driver.navigate().to("https://www.google.com/ncr");
    }

    @AfterMethod
    public void afterMethod() {
	driver.close();
    }
}
