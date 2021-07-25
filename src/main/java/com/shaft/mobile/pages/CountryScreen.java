package com.shaft.mobile.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shaft.gui.element.TouchActions;

public class CountryScreen {
    private WebDriver mobile;

    private String profileIconExperssion = "(//*[@index='%d'])";
    private String languageSelection = "//*[contains(@text, '%s')]//parent::*";

    public CountryScreen(WebDriver mobile) {
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
