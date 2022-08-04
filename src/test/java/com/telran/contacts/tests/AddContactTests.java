package com.telran.contacts.tests;

import com.telran.contacts.models.Contact;
import com.telran.contacts.utils.DataProviders;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AddContactTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if(!app.getHeader().isLoginLinkPresent()){
            app.getHeader().clickOnSignOutButton();
        }
        else app.getUser().login();
    }

    @Test
    public void addContactPositiveTest() {
        app.getContact().addContact();
        Assert.assertTrue(app.getContact().isContactCreated("Tom"));
    }

    @Test
    public void addContactNegativeTest() {
        app.getContact().addEmptyContact();
        Assert.assertTrue(app.getContact().isContactListEmpty());
    }

      @Test(dataProvider = "addNewContact", dataProviderClass = DataProviders.class, enabled = false)
    public void addContactPositiveTestFromDataProvider(String name, String vName,
                                                       String phone, String email,
                                                       String address, String description) {
        app.getContact().click(By.xpath("//a[contains(text(),'ADD')]"));
        app.getContact().FillContactForm(new Contact()
                .setName(name)
                .setVorname(vName)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDescriprion(description));
        app.getContact().clickWithAction(By.cssSelector(".add_form__2rsm2 button"));
    }

    @Test(dataProvider = "addNewContactFromCSV", dataProviderClass = DataProviders.class, enabled = false)
    public void addContactPositiveTestFromCSV(Contact contact) {
        app.getContact().click(By.xpath("//a[contains(text(),'ADD')]"));
        app.getContact().FillContactForm(contact);
        app.getContact().clickWithAction(By.cssSelector(".add_form__2rsm2 button"));
    }

    @Test(dataProvider = "addWrongContactFromCSV", dataProviderClass = DataProviders.class, enabled = false)
    public void addContactNegativeTestFromCSV(Contact contact) {
        app.getContact().click(By.xpath("//a[contains(text(),'ADD')]"));
        app.getContact().FillContactForm(contact);
        app.getContact().clickWithAction(By.cssSelector(".add_form__2rsm2 button"));
        Assert.assertTrue(app.getContact().isContactListEmpty());
    }
    @AfterMethod
    public void postCondition(){
        app.getContact().removeContact();
    }
}
