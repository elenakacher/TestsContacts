package com.telran.contacts.utils;

import com.telran.contacts.models.Contact;
import com.telran.contacts.models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

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

}
