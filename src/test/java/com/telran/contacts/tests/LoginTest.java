package com.telran.contacts.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
       if(!app.getHeader().isLoginLinkPresent()){
           app.getHeader().clickOnSignOutButton();
       }
    }

    @Test
    public void loginUserPositiveTest() {
        app.getUser().login();
        //assert the button Sign Out
        Assert.assertTrue(app.getHeader().IsSignOutButtonPresent());
    }
}
