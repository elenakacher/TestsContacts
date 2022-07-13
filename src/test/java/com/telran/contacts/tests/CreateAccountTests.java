package com.telran.contacts.tests;

import com.telran.contacts.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    //-----------------Homework----------------------------

    @DataProvider
    public Iterator<Object[]> newUserRegistrationWithInvalidEmail() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/RegFalschEmail.csv")));

        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new User()
                    .setEmail(split[0])
                    .setPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "newUserRegistrationWithInvalidEmail")
    public void negativeRegistrationTestWithInvalidEmail(User user) {
        app.getUser().click(By.xpath("//a[contains(., 'LOGIN')]"));
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().click(By.xpath("//button[contains(text(),'Registration')]"));
      // app.getUser().isAllertActive();
    }
}
