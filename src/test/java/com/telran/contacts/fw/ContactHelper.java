package com.telran.contacts.fw;

import com.telran.contacts.models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends HelperBase{
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public boolean isContactCreated(String text) {
        List<WebElement> contacts = wd.findElements(By.cssSelector("h2"));
        for (WebElement el : contacts) {
            if (el.getText().contains(text)) ;
            return true;
        }
        return false;
    }

    public void addContact() {
        click(By.xpath("//a[contains(text(),'ADD')]"));
        FillContactForm(new Contact().setVorname("Tom").setName("Rast").setPhone("35 456").setEmail("rast@fdg.fg").setAddress("New-York").setDescriprion("Manager"));
        clickWithAction(By.cssSelector(".add_form__2rsm2 button"));
        pause(2000);
    }

    public void addEmptyContact() {
        click(By.xpath("//a[contains(text(),'ADD')]"));
        FillContactForm(new Contact().setVorname("").setName("").setPhone("").setEmail("").setAddress("").setDescriprion(""));
        clickWithAction(By.cssSelector(".add_form__2rsm2 button"));
        pause(2000);
    }

    public void FillContactForm(Contact contact) {
        int i = (int) (System.currentTimeMillis()) / 1000;
        type(By.cssSelector("input:nth-child(1)"), contact.getVorname());
        type(By.cssSelector("input:nth-child(2)"), contact.getName());
        type(By.cssSelector("input:nth-child(3)"), contact.getPhone() + i);
        type(By.cssSelector("input:nth-child(4)"), i + contact.getEmail());
        type(By.cssSelector("input:nth-child(5)"), contact.getAddress());
        type(By.cssSelector("input:nth-child(6)"), contact.getDescriprion());
    }

    public int sizeOfContacts() {
        if (isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))) {
            return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }
        return 0;
    }

    public void removeContact() {
        if (!isContactListEmpty()) {
            click(By.cssSelector(".contact-item_card__2SOIM"));
            click(By.xpath("//button[contains(., 'Remove')]"));
        }
    }

    public boolean isContactListEmpty() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();
    }

}
