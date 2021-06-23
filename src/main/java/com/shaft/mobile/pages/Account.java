package com.shaft.mobile.pages;

import org.openqa.selenium.By;

import com.shaft.gui.element.ElementActions;
import com.shaft.gui.element.TouchActions;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

public class Account {
    private MobileDriver<MobileElement> mobile;

    private By login_account = MobileBy.id("com.jumia.android:id/button_top_login");
    private By email_subtitle_welcome = MobileBy.id("com.jumia.android:id/subtitle_welcome");

    public Account(MobileDriver<MobileElement> mobile) {
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
