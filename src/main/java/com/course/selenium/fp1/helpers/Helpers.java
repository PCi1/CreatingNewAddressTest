package com.course.selenium.fp1.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helpers {

    public static void fieldFiller(WebDriver driver, WebElement element, String text){
        element.click();
        element.clear();
        element.sendKeys(text);
    }
}
