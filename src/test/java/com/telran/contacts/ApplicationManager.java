package com.telran.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;

    UserHelper user;
    public UserHelper getUser() {
        return user;
    }

    ContactHelper contact;
    public ContactHelper getContact() {
        return contact;
    }

    HeaderHelper header;
    public HeaderHelper getHeader() {
        return header;
    }


    public void init() {
        wd = new ChromeDriver();
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