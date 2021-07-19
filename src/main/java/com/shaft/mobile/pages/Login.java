package com.shaft.mobile.pages;

import org.openqa.selenium.By;

import com.shaft.gui.element.TouchActions;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

public class Login {
	private MobileDriver<MobileElement> mobile;

	private By create_new_account = MobileBy.id("com.jumia.android:id/login_email_create_account");
	private By email_field = MobileBy.AccessibilityId("email");
	private By password_field = MobileBy.AccessibilityId("password");
	private By login_button = MobileBy.id("login_button_continue");

	public Login(MobileDriver<MobileElement> mobile) {
		this.mobile = mobile;
	}

	public SignUp clickOnCreateNewAccount() {
		new TouchActions(mobile)
				.tap(create_new_account)
				.performElementAction();
		return new SignUp(mobile);
	}

	public Account loginUser(String email, String password) {
		// to deal with the alert occasionally pop up
//		if (ElementActions.isElementDisplayed(mobile, SignUp.dismissAdBtn)) {
//			while (ElementActions.isElementDisplayed(mobile, SignUp.dismissAdBtn)) {
//				new SignUp(mobile).dismissAd();
//				break;
//			}
//		}
		// to deal with the alert occasionally pop up
//		new SignUp(mobile).dismissAd();

		new TouchActions(mobile).performElementAction()
				.typeAppend(email_field, email)
				.typeAppend(password_field, password)
				.click(login_button);
		
		return new Account(mobile);
	}
}
