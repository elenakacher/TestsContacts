package com.telran.contacts.tests;

import com.telran.contacts.models.User;
import com.telran.contacts.utils.DataProviders;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    // precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getHeader().isLoginLinkPresent()){
            app.getHeader().clickOnSignOutButton();
        }
    }

    @Test
    public void registrationPositiveTest(){
        // click on the link LOGIN
        app.getUser().registration();
        // assert the button Sign out displayed
        Assert.assertTrue(app.getHeader().IsSignOutButtonPresent());
    }

    @Test(dataProvider = "newUserRegistrationWithInvalidEmail", dataProviderClass = DataProviders.class)
    public void negativeRegistrationTestWithInvalidEmail(User user) {
        app.getUser().click(By.xpath("//a[contains(., 'LOGIN')]"));
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().click(By.xpath("//button[contains(text(),'Registration')]"));
        Assert.assertTrue(app.getUser().isAllertPresent());
        Assert.assertTrue(app.getContact().isElementPresent(By.xpath("//div[contains(text(),'Registration failed with code 400')]")));
    }
}
