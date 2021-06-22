package com.tests.appium;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shaft.gui.browser.BrowserFactory;
import com.shaft.mobile.pages.Account;
import com.shaft.mobile.pages.CountryScreen;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

public class TestAppium {
    private MobileDriver<MobileElement> mobile;

    private String englishLanguage = "English";
    private String email = "test41QA@tes.com";
    private String password = "Aa12345#";
    private int countryIndex = 2;

    @Test
    public void checkSuccessfulRegistration() {
        new CountryScreen(mobile).clickOnCountry(countryIndex).clickOnLanguage(englishLanguage).dismissAlert()
                .clickOnAccount().clickOnLogin().clickOnCreateNewAccount()
                .fillRegistrationForm("Test1", "Test1", email, password);

        Assert.assertEquals(new Account(mobile).getAccountEmail(), email);
    }

    @Test(dependsOnMethods = {"checkSuccessfulRegistration"})
    public void checkSuccessfulLogin() {
        new CountryScreen(mobile).clickOnCountry(countryIndex).clickOnLanguage(englishLanguage).dismissAlert()
                .clickOnAccount().clickOnLogin().loginUser(email, password);

        Assert.assertEquals(new Account(mobile).getAccountEmail(), email);
    }

    @SuppressWarnings("unchecked")
	@BeforeMethod
    public void beforeMethod() throws MalformedURLException {
        mobile = (MobileDriver<MobileElement>) BrowserFactory.getBrowser();
    }

    @AfterMethod
    public void afterMethod() {
        mobile.quit();
    }
}
