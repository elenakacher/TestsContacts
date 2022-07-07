package com.telran.contacts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    // precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.header.isLoginLinkPresent()){
            app.header.clickOnSignOutButton();
        }
    }

    @Test
    public void registrationPositiveTest(){
        // click on the link LOGIN
        app.getUser().registration();
        // assert the button Sign out displayed
        Assert.assertTrue(app.header.IsSignOutButtonPresent());
    }
}
