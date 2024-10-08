package com.course.selenium.fp1.pages;

import com.course.selenium.fp1.helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.fp1.helpers.Helpers.fieldFiller;

public class NewAddressFormPage {
    final WebDriver driver;

    @FindBy(id = "field-alias")
    WebElement fieldAlias;

    @FindBy(id = "field-address1")
    WebElement fieldAddress1;

    @FindBy(id = "field-city")
    WebElement fieldCity;

    @FindBy(id = "field-postcode")
    WebElement fieldPostcode;

    @FindBy(id = "field-id_country")
    WebElement fieldIdCountry;

    @FindBy(id = "field-phone")
    WebElement fieldPhone;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveButton;

    public NewAddressFormPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void typeAliasIntoForm(String alias){
        fieldFiller(driver, fieldAlias, alias);
    }

    public void typeAddressIntoForm(String address){
        fieldFiller(driver, fieldAddress1, address);
    }

    public void typeCityIntoForm(String city){
        fieldFiller(driver, fieldCity, city);
    }

    public void typePostcodeIntoForm(String postCode){
        fieldFiller(driver, fieldPostcode, postCode);
    }

    public void selectCountryInForm(String country){
    }

    public void typePhoneIntoForm(String phone){
        fieldFiller(driver, fieldPhone, phone);
    }
    public void saveForm(){
        saveButton.click();
    }
}
