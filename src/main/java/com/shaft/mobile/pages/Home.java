package com.shaft.mobile.pages;

import org.openqa.selenium.By;

import com.shaft.gui.element.TouchActions;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

public class Home {
	private By dismiss_alert = By.id("android:id/button3");
	private String navigation_link = "com.jumia.android:id/navigation_%s";

	private String account = "account";

	MobileDriver<MobileElement> mobile;

	public Home(MobileDriver<MobileElement> mobile) {
		this.mobile = mobile;
	}

	public Home dismissAlert() {
		// dismiss alert message
		new TouchActions(mobile)
				.tap(dismiss_alert);
		return this;
	}

	// Generic method to click on navigation menu icons in home page
	public void clickOnNavigationMenuLinks(String navigationLink) {
		new TouchActions(mobile)
				.tap(MobileBy.id(String.format(navigation_link, navigationLink)))
				.performElementAction();
	}

	public Account clickOnAccount() {
		clickOnNavigationMenuLinks(account);
		return new Account(mobile);
	}
}
