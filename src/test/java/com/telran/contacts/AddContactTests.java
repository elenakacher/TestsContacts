package com.telran.contacts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AddContactTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if(!app.header.isLoginLinkPresent()){
            app.header.clickOnSignOutButton();
        }
        else app.user.login();
    }

    @Test
    public void addContactPositiveTest() {
        app.getContact().addContact();
        Assert.assertTrue(app.contact.isContactCreated("Tom"));
    }

    @AfterMethod
    public void postCondition(){
        app.getContact().removeContact();
    }

}
