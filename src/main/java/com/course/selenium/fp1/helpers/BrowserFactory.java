package com.course.selenium.fp1.helpers;

import io.cucumber.java.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    private static final String URL = "https://mystore-testlab.coderslab.pl";

    private static final String userName = "random@random.com";

    private static final String userPassword = "RandomPass,.";

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static String getUserName(){
        return userName;
    }

    public static String getUserPassword(){
        return userPassword;
    }

    public static WebDriver getDriver(){
        return driverThreadLocal.get();
    }

    @Before
    public void setUp(){
        driverThreadLocal.set(new FirefoxDriver());
//        driverThreadLocal.set(new ChromeDriver());
        WebDriver driver = driverThreadLocal.get();
        driver.get(URL);
    }

//    @After
//    public void tearDown(){
//        if(driverThreadLocal.get() != null){
//            driverThreadLocal.get().quit();
//        }
//    }
}
