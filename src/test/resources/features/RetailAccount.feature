Feature: Retail Account

  Background: 
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'testuser@test.us' and password 'Tek@12345'
    And User click on login button
    And User should be logged into Account

  @updateProfile
  Scenario: Verify User can update Profile Information
    When User click on Account option
    And User update Name 'Dragons' and Phone '202-101-9900'
    And User click on Update button
    Then user profile information should be updated

  @addPaymentMethod
  Scenario: Verify User can add a payment method
    When User click on Account option
    And User click on Add a payment method link
    And User fill Debit or credit card information
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 3722334492739999 | Johnson    |              12 |           2029 |          799 |
    And User click on Add your card button
    Then a message should be displayed 'Payment Method added sucessfully'

  @editPaymentMethod
  Scenario: Verify User can edit Debit or Credit card
    When User click on Account option
    And user select the card ending with '9999'
    And User click on Edit option of card section
    And user edit information with below data
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 3722334492757777 | Mary       |               8 |           2028 |          777 |
    And user click on Update Your Card button
    Then a message should be displayed 'Payment Method updated Successfully'

  @removePaymentMethod
  Scenario: Verify User can remove Debit or Credit card
    When User click on Account option
    And user select the card ending with '7898'
    And User click on remove option of card section
    Then payment details should be removed

  @addNewAddress
  Scenario: Verify User can add an Address
    When User click on Account option
    And User click on Add address option
    And user fill new address form with below information
      | country       | fullName   | phoneNumber  | streetAddress    | apt | city     | state    | zipCode |
      | United States | John Mayer | 212-343-7788 | 630 Third Avenue | 20B | New York | New York |   10016 |
    And User click Add Your Address button
    Then a message should be displayed 'Address Added Successfully'

  @editAddress
  Scenario: Verify User can edit an Address added on account
    When User click on Account option
    And User click on edit address option
    And user fill new address form with below information
      | country 				 | fullName 				| phoneNumber 			 | streetAddress 		 | apt   | city  			 | state      | zipCode |
      | United Kingdom   | Boris Johnson    | 212-333-7788       | Holingbury Place  | 5A 	| Manchester	 | Manchester | 11388 |
    And User click update Your Address button
    Then a message should be displayed 'Address Updated Successfully'

  @removeAddress
  Scenario: Verify User can remove Address from Account
    When User click on Account option
    And User click on remove option of Address section
    Then Address details should be removed
