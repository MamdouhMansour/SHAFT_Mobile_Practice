package com.shaft.mobile.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shaft.gui.element.ElementActions;
import com.shaft.gui.element.TouchActions;

import io.appium.java_client.MobileBy;

public class Account {
    private WebDriver mobile;

    private By login_account = MobileBy.id("com.jumia.android:id/button_top_login");
    private By email_subtitle_welcome = MobileBy.id("com.jumia.android:id/subtitle_welcome");

    public Account(WebDriver mobile) {
        this.mobile = mobile;
    }

    public Login clickOnLogin() {
        new TouchActions(mobile)
        		.tap(login_account)
        		.performElementAction();
        return new Login(mobile);
    }

    public String getAccountEmail() {
        return new ElementActions(mobile).getText(email_subtitle_welcome);
    }
}
