package com.telran.contacts;

import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

        @Test
        public void openHomePagetest(){
            System.out.println("Site Opened!");
            app.isComponentFormPresent();
        }
    }

