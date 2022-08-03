package com.telran.contacts.tests;

import com.telran.contacts.models.User;
import org.openqa.selenium.By;
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

    @Test
    public void loginUserNegativeTest() {
        app.getUser().click(By.xpath("//a[contains(., 'LOGIN')]"));
        app.getUser().fillLoginRegistrationForm(new User().setEmail("sascha@gmail.com").setPassword("23"));
        app.getUser().click(By.xpath("//button[contains(.,'Login')]"));
        Assert.assertTrue(app.getUser().isAllertPresent());
        Assert.assertTrue(app.getUser().isErrorPresent());
    }
}
