package com.course.selenium.fp1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddressesPage {

    final WebDriver driver;

    @FindBy(xpath = "//span[text()='Create new address']")
    WebElement createNewAddressButton;

    @FindBy(xpath = "//article[contains(@class,'alert alert-success')]")
    WebElement newAddressSuccessBanner;

    public AddressesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createNewAddressButton(){
        createNewAddressButton.click();
    }

    public String getTextSuccessBanner(){
        return newAddressSuccessBanner.getText();
    }

    public String getAddress(String alias){
        WebElement element = driver.findElement(By.xpath("//h4[text()='"+alias+"']/../address"));
        return element.getText();
    }
}
