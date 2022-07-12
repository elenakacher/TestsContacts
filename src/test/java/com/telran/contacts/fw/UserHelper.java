package com.telran.contacts.fw;

import com.telran.contacts.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UserHelper extends HelperBase{

    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void registration() {
        click(By.xpath("//a[contains(., 'LOGIN')]"));
        Assert.assertTrue(isElementPresent(By.cssSelector(".login_login__3EHKB")));
        fillLoginRegistrationForm(new User().setEmail("sascha@gmail.com").setPassword("K7100596c_"));
        // click on the button Registration
        click(By.xpath("//button[contains(.,'Registration')]"));
    }

    public void fillLoginRegistrationForm(User user) {
        type(By.cssSelector("[placeholder='Email']"), user.getEmail());
        type(By.cssSelector("[placeholder='Password']"), user.getPassword());
    }

    public void login() {
        click(By.xpath("//a[contains(., 'LOGIN')]"));
        fillLoginRegistrationForm(new User().setEmail("sascha@gmail.com").setPassword("K7100596c_"));
        click(By.xpath("//button[contains(.,'Login')]"));
    }
}
