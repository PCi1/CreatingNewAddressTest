Feature: Creating new address
  As a registered user
  I want to add new address to my account
  So i can use it while making purchase

  @done
  Scenario Outline: Successful creation of new address
    Given The user is on the login page
    And The user logs in with correct credentials
    When The user clicks on Addresses
    And The user clicks on Create new address
    And The user fills out the form with "<alias>", "<address>", "<city>", "<postCode>", "<country>", "<phone>"
    And The user clicks on Save
    Then New address is added to the account, The page shows message "Address successfully added!"
    And "<alias>", "<address>", "<city>", "<postCode>", "<country>", "<phone>" are correct
    Examples:
      | alias   | address       | city   | postCode | country        | phone      |
      | My home | streetName 14 | London | 1298     | United Kingdom | 0987654321 |
