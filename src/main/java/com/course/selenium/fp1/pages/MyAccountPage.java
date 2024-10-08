package com.course.selenium.fp1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    final WebDriver driver;

    @FindBy(id = "addresses-link")
    WebElement addressesLink;

    public MyAccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToAddresses(){
        addressesLink.click();
    }
}
