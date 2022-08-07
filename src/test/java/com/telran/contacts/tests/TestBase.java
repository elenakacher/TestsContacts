package com.telran.contacts.tests;

import com.telran.contacts.fw.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    protected ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void setUp(){
        app.init();
    }

    @AfterMethod(enabled = true)
    public void TearDown(){
        app.stop();
    }

    @BeforeMethod
    public void startTest(Method m, Object[] p){
        logger.info("Test start " + m.getName().toString() + " with Data: " + Arrays.asList(p));
    }

    @AfterMethod
    public void stopTest(ITestResult result){
        if (result.isSuccess()){
            logger.info(" PASSED: test Method " + result.getMethod().getMethodName());
        }else {
            logger.error("FAILED: Test Method " + result.getMethod().getMethodName() + " " + "screenshots: " + app.getUser().takeScreenshot());
        }
    }
}
