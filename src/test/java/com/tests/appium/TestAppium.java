package com.tests.appium;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shaft.cli.FileActions;
import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.mobile.pages.Account;
import com.shaft.mobile.pages.CountryScreen;
import com.shaft.validation.Assertions;

public class TestAppium {
	private WebDriver mobile;

	private String englishLanguage = "English";
	private String email = "test56QA@tes.com";
	private String password = "Aa12345#";
	private int countryIndex = 2;

	@Test
	public void checkSuccessfulRegistration() {
		new CountryScreen(mobile).clickOnCountry(countryIndex).clickOnLanguage(englishLanguage).dismissAlert()
				.clickOnAccount().clickOnLogin().clickOnCreateNewAccount()
				.fillRegistrationForm("Test1", "Test1", email, password);

		Assertions.assertEquals(new Account(mobile).getAccountEmail(), email);
	}

	@Test(dependsOnMethods = { "checkSuccessfulRegistration" })
	public void checkSuccessfulLogin() {
		new CountryScreen(mobile).clickOnCountry(countryIndex).clickOnLanguage(englishLanguage).dismissAlert()
				.clickOnAccount().clickOnLogin().loginUser(email, password);

		Assertions.assertEquals(new Account(mobile).getAccountEmail(), email);
	}

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {
		System.setProperty("mobile_app", FileActions.getAbsolutePath("src/test/resources/", "jumia-7-5-1.apk"));
		mobile = BrowserFactory.getBrowser();
	}

	@AfterMethod
	public void afterMethod() {
		DriverFactory.closeAllDrivers();
	}
}
