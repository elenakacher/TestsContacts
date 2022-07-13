package com.telran.contacts.tests;

import com.telran.contacts.models.Contact;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


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

    @DataProvider
    public Iterator<Object[]> addNewContact(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Sandra", "Bulls", "234987 432", "San@df.er", "Stuttgard", "Freund"});
        list.add(new Object[]{"Alla", "Star", "23457 4562", "alla@gm.er", "Jena", "Manager"});
        list.add(new Object[]{"Peter", "Rock", "2342987 443", "peter@gm.ru", "Potzdam", "Bruder"});
        list.add(new Object[]{"Tom", "White", "34987 432", "tom@gm.uk", "Erfurt", "Chef"});
        list.add(new Object[]{"Ron", "Miller", "654332122", "ron@rt.us", "Gera", "Freund"});
        return list.iterator();
    }

    @Test(dataProvider = "addNewContact")
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

    @DataProvider
    public Iterator<Object[]> addNewContactFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/Contacts.csv")));

        String line = reader.readLine();

        while (line != null) {
            String[] arraySplit = line.split(",");
            list.add(new Object[]{new Contact()
                    .setName(arraySplit[0])
                    .setVorname(arraySplit[1])
                    .setPhone(arraySplit[2])
                    .setEmail(arraySplit[3])
                    .setAddress(arraySplit[4])
                    .setDescriprion(arraySplit[5])});
            line = reader.readLine();
        }
        return list.iterator();
    }
    @Test(dataProvider = "addNewContactFromCSV")
    public void addContactPositiveTestFromCSV(Contact contact) {
        app.getContact().click(By.xpath("//a[contains(text(),'ADD')]"));
        app.getContact().FillContactForm(contact);
        app.getContact().clickWithAction(By.cssSelector(".add_form__2rsm2 button"));
    }


    @AfterMethod
    public void postCondition(){
        app.getContact().removeContact();
    }
}
