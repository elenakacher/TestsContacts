package com.telran.contacts.fw;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Alert;

public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }

    public boolean isElementPresent2(By by){
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException exception){
            return false;
        }
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void clickWithAction(By save) {
        Actions actions = new Actions(wd);
        WebElement element = wd.findElement(save);

        actions.moveToElement(element).perform();
        element.click();
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void isAllertActive(){
        Alert alert = wd.switchTo().alert();
        String allertText = wd.switchTo().alert().getText();
        System.out.println(allertText);
        alert.accept();
    }
}
