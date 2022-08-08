package com.telran.contacts.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @Test
    public void openHomePagetest(){
        System.out.println("Site Opened!");
        app.isComponentFormPresent();
    }

    @Test
    public void PhonebookTest(){
        Assert.assertTrue(app.getHeader().isElementPresent(By.xpath("//h1[contains(text(),'PHONEBOOK')]")));
    }

    @Test
    public void HomeTest(){
        Assert.assertTrue(app.getHeader().isElementPresent(By.xpath("//a[contains(text(),'HOME')]")));
    }

    @Test
    public void AboutTest(){
        Assert.assertTrue(app.getHeader().isElementPresent(By.xpath("//a[contains(text(),'ABOUT')]")));
    }

    @Test
    public void LoginTest(){
        Assert.assertTrue(app.getHeader().isElementPresent(By.xpath("//a[contains(text(),'LOGIN')]")));
    }

}
