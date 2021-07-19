package com.shaft.mobile.pages;

import org.openqa.selenium.By;

import com.shaft.gui.element.TouchActions;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

public class SignUp {

    private MobileDriver<MobileElement> mobile;

    private By first_name = MobileBy.AccessibilityId("first_name");
    private By last_name = MobileBy.AccessibilityId("last_name");
    private By email_field = MobileBy.AccessibilityId("email");
    private By password_field = MobileBy.AccessibilityId("password");
    private By terms = MobileBy.AccessibilityId("terms");
    private By login_button = MobileBy.id("login_button_continue");
    private By male_checkbox = MobileBy.xpath("//*[@text='Male']");

    //will be called in login page
    public static By dismissAdBtn = MobileBy.id("com_ad4screen_sdk_popup_secondary_button");

    public SignUp(MobileDriver<MobileElement> mobile) {
        this.mobile = mobile;
    }

    public SignUp fillRegistrationForm(String firstName, String lastName, String emailAddress, String password) {
        //to deal with the alert occasionally pop up
//        while (ElementActions.isElementDisplayed(mobile, dismissAdBtn)) {
//            dismissAd();
            new TouchActions(mobile).performElementAction()
                    .typeAppend(first_name, firstName)
                    .typeAppend(last_name, lastName)
//                  .click(SignUp.dismissAdBtn)
                    .typeAppend(email_field, emailAddress)
                    .typeAppend(password_field, password)
                    .click(male_checkbox)
                    .click(terms)
                    .click(login_button);
//            break;
//        }

        return this;
    }

    public void dismissAd() {
        new TouchActions(mobile)
        		.tap(dismissAdBtn)
        		.performElementAction();
    }
}
