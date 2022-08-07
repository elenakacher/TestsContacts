package com.telran.contacts.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    UserHelper user;
    ContactHelper contact;
    HeaderHelper header;

    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public UserHelper getUser() {
        return user;
    }

    public ContactHelper getContact() {
        return contact;
    }

    public HeaderHelper getHeader() {
        return header;
    }

    public void init() {
        if (browser.equals(BrowserType.FIREFOX)) {
        wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        }
        wd.get("https://contacts-app-tobbymarshall815.vercel.app");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        user = new UserHelper(wd);
        contact = new ContactHelper(wd);
        header = new HeaderHelper(wd);
    }

    public boolean isComponentFormPresent(){
        return wd.findElements(By.cssSelector("div:nth-child(2)>div>div")).size()>0;
    }

    public void stop() {
        wd.quit();
    }
}