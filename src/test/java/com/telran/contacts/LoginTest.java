package com.telran.contacts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
       if(!app.header.isLoginLinkPresent()){
           app.header.clickOnSignOutButton();
       }
    }

    @Test
    public void loginUserPositiveTest() {
        app.user.login();
        //assert the button Sign Out
        Assert.assertTrue(app.header.IsSignOutButtonPresent());
    }
}
