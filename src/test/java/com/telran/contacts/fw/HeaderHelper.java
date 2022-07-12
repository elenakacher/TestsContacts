package com.telran.contacts.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderHelper extends HelperBase{

    public HeaderHelper(WebDriver wd) {
        super(wd);
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.xpath("//a[contains(., 'LOGIN')]"));
    }

    public void clickOnSignOutButton() {
        click(By.xpath("//button[contains(.,'Sign Out')]"));
    }

    public boolean IsSignOutButtonPresent() {
        return isElementPresent(By.xpath("//button[contains(.,'Sign Out')]"));
    }

}
