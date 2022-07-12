package com.telran.contacts.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class RemoveContactTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        } else {
            app.getUser().login();
            app.getContact().addContact();
        }
    }

    @Test
    public void removeContactTest() {
        app.getUser().pause(2000);
        int sizeBefore, sizeAfter;
        sizeBefore = app.getContact().sizeOfContacts();
        app.getContact().removeContact();
        app.getUser().pause(2000);
        sizeAfter = app.getContact().sizeOfContacts();
        System.out.println(sizeBefore + " " + sizeAfter);
        Assert.assertEquals(sizeAfter, sizeBefore-1);
    }
}
