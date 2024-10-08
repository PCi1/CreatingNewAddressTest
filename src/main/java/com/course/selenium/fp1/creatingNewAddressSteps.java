package com.course.selenium.fp1;

import com.course.selenium.fp1.helpers.BrowserFactory;
import com.course.selenium.fp1.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class creatingNewAddressSteps {
    private final WebDriver driver = BrowserFactory.getDriver();
    HomePage homePage;
    AuthPage authPage;
    MyAccountPage myAccountPage;
    AddressesPage addressesPage;
    NewAddressFormPage newAddressFormPage;

    @Given("The user is on the login page")
    public void theUserIsOnTheLoginPage() {
        homePage = new HomePage(driver);
        homePage.clickSignIn();

        authPage = new AuthPage(driver);
    }

    @And("The user logs in with correct credentials")
    public void theUserLogsInWithCorrectCredentials() {
        authPage.typeEmailIntoLogIn(BrowserFactory.getUserName());
        authPage.typePasswordIntoLogIn(BrowserFactory.getUserPassword());
        authPage.clickSignInButton();

        myAccountPage = new MyAccountPage(driver);
    }

    @When("The user clicks on Addresses")
    public void theUserClicksOnAddresses() {
        myAccountPage.goToAddresses();

        addressesPage = new AddressesPage(driver);
    }

    @And("The user clicks on Create new address")
    public void theUserClicksOnCreateNewAddress() {
        addressesPage.createNewAddressButton();

        newAddressFormPage = new NewAddressFormPage(driver);
    }

    @And("The user fills out the form with {string}, {string}, {string}, {string}, {string}, {string}")
    public void theUserFillsOutTheFormWith(String alias, String address, String city, String postCode, String country, String phone) {
        newAddressFormPage.typeAliasIntoForm(alias);
        newAddressFormPage.typeAddressIntoForm(address);
        newAddressFormPage.typeCityIntoForm(city);
        newAddressFormPage.typePostcodeIntoForm(postCode);
        newAddressFormPage.selectCountryInForm(country);
        newAddressFormPage.typePhoneIntoForm(phone);

    }

    @And("The user clicks on Save")
    public void theUserClicksOnSave() {
        newAddressFormPage.saveForm();

        addressesPage = new AddressesPage(driver);
    }

    @Then("New address is added to the account, The page shows message {string}")
    public void newAddressIsAddedToTheAccountThePageShowsMessage(String errorMsg) {
        Assert.assertEquals(errorMsg, addressesPage.getTextSuccessBanner());
    }




    @And("{string}, {string}, {string}, {string}, {string}, {string} are correct")
    public void areCorrect(String alias, String address, String city, String postCode, String country, String phone) {
//        Assert.assertTrue(addressesPage.getAddress(alias).contains(address, city, postCode,country, phone));
        Assert.assertEquals("Imię Nazwisko"+"\n"+ address+"\n"+city+"\n"+postCode+"\n"+country+"\n"+phone,addressesPage.getAddress(alias));
    }

}
