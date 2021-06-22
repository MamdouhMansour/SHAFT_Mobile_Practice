package com.shaft.mobile.pages;

import com.shaft.gui.element.TouchActions;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class CountryScreen {
    private MobileDriver<MobileElement> mobile;

    private String profileIconExperssion = "(//*[@index='%d'])";
    private String languageSelection = "//*[contains(@text, '%s')]//parent::*";

    public CountryScreen(MobileDriver<MobileElement> mobile) {
        this.mobile = mobile;
    }

    public CountryScreen clickOnCountry(int index) {
        new TouchActions(mobile)
                .tap(By.xpath(String.format(profileIconExperssion, index)))
                .performElementAction();
        return this;
    }

    public Home clickOnLanguage(String language) {
        new TouchActions(mobile)
                .tap(By.xpath(String.format(languageSelection, language)))
                .performElementAction();
        return new Home(mobile);
    }
}
