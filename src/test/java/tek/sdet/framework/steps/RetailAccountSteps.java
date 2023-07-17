package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class RetailAccountSteps extends CommonUtility {
	POMFactory factory = new POMFactory();

	// Update profile ----------------------------
	@When("User click on Account option")
	public void userClickOnAccountOption() {
		click(factory.homePage().accountOption);
		logger.info("user clicked on Account option");
	 
	}
	@When("User update Name {string} and Phone {string}")
	public void userUpdateNameAndPhone(String nameValue, String phoneValue) {
		clearTextUsingSendKeys(factory.accountPage().nameInput);
		sendText(factory.accountPage().nameInput, nameValue);
		clearTextUsingSendKeys(factory.accountPage().phoneInput);
		sendText(factory.accountPage().phoneInput, phoneValue);
		logger.info("user updated the name and the phone value");

	}
	@When("User click on Update button")
	public void userClickOnUpdateButton() {
		click(factory.accountPage().personalUpdateButton);
		logger.info("user clicked on update button");
	    
	}
	@Then("user profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		waitTillPresence(factory.accountPage().personalInfoUpdatedSuccessMessage);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().personalInfoUpdatedSuccessMessage));
		logger.info("user profile information updated");
	}
	
	// add payment method --------------------------------------------------------------
	
	@When("User click on Add a payment method link")
	public void userClickOnAddAPaymentMethodLink() {
		click(factory.accountPage().addPaymentMethodLink);
		logger.info("user clicked on payment method link successfully");
	  
	}
	@When("User fill Debit or credit card information")
	public void userFillDebitOrCreditCardInformation(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		sendText(factory.accountPage().cardNumberInputField, data.get(0).get("cardNumber"));
		sendText(factory.accountPage().nameOnCardInputField, data.get(0).get("nameOnCard"));
		selectByVisibleText(factory.accountPage().expirationMonthInputField, data.get(0).get("expirationMonth"));
		selectByVisibleText(factory.accountPage().expirationYearInputField, data.get(0).get("expirationYear"));
		sendText(factory.accountPage().securityCodeInputField, data.get(0).get("securityCode"));
		logger.info("user entered car number, name, expiration month and year and security code successfully");
		
	   
	}
	@When("User click on Add your card button")
	public void userClickOnAddYourCardButton() {
		click(factory.accountPage().addYourCardBttn);
		logger.info("user clicked on add your card button successfully");
	   
	}
	@Then("a message should be displayed {string}")
	public void aMessageShouldBeDisplayed(String expectedMssge) {
		if(expectedMssge.contains("Payment Method")) {
			waitTillPresence(factory.accountPage().PaymentMethodAddeddSuccessMessage);
			Assert.assertEquals(expectedMssge, factory.accountPage().PaymentMethodAddeddSuccessMessage.getText());
			logger.info(expectedMssge + " is displayed");
		}else if(expectedMssge.contains("Address")) {
			waitTillPresence(factory.accountPage().addressAddedSuccessfullyMssg);
			Assert.assertEquals(expectedMssge, factory.accountPage().addressAddedSuccessfullyMssg.getText());
			logger.info(expectedMssge + " is displayed");
		}else if(expectedMssge.contains("Address Upated")) {
			waitTillPresence(factory.accountPage().addressUpdateSuccessMssg);
			Assert.assertEquals(expectedMssge, factory.accountPage().addressUpdateSuccessMssg.getText());
			logger.info(expectedMssge + " is displayed");
		}else if(expectedMssge.contains("Payment Method updated Successfully")) {
			waitTillPresence(factory.accountPage().paymentMethodUpdateSuccessMessage);
			Assert.assertEquals(expectedMssge, factory.accountPage().paymentMethodUpdateSuccessMessage.getText());
			logger.info("Payment method updated mssg was verified successfully");
		}else if(expectedMssge.contains("Order Placed")) {
			waitTillPresence(factory.orderPage().orderPlacedSuccessfullyMssg);
			Assert.assertEquals(expectedMssge, factory.orderPage().orderPlacedSuccessfullyMssg.getText());
			logger.info(expectedMssge + " message was verified successfully");
		}else if(expectedMssge.contains("Return was successful")) {
			waitTillPresence(factory.orderPage().returnSuccessMssg);
			//Assert.assertEquals(expectedMssge, factory.orderPage().returnSuccessMssg.getText());
			Assert.assertTrue(isElementDisplayed(factory.orderPage().returnSuccessMssg.getText()));
			logger.info(expectedMssge + " is displayed");
		}
	    
	}
	
	private boolean isElementDisplayed(String text) {
		// TODO Auto-generated method stub
		return false;
	}
	// Edit payment method -------------------------------------------------------------------------
	@When("user select the card ending with {string}")
	public void userSelectTheCardEndingWith(String string) {
		 List<WebElement> cards = factory.accountPage().cardEndingNumber;
		 for(WebElement card : cards) {
			 if(card.getText().contains(string)) {
				 System.out.println(card.getText());
				 click(card);
				 logger.info(string + " is selected");
				 break;
			 }
		 }
	}

	@When("User click on Edit option of card section")
	public void userClickOnEditOptionOfCardSection() {
		click(factory.accountPage().editCardBttn);
		logger.info("user clicked on edit card button successfully");
	 
	}
	@When("user edit information with below data")
	public void userEditInformationWithBelowData(DataTable dataTable) throws InterruptedException{
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for(Map<String, String> table : data) {
	    	clearTextUsingSendKeys(factory.accountPage().cardNumberInputField, table.get("cardNumber"));
	    	clearTextUsingSendKeys(factory.accountPage().nameOnCardInputField, table.get("nameOnCard"));
	    	selectByVisibleText(factory.accountPage().expirationMonthInputField, table.get("expirationMonth"));
	    	selectByVisibleText(factory.accountPage().expirationYearInputField, table.get("expirationYear"));
	    	clearTextUsingSendKeys(factory.accountPage().securityCodeInputField, table.get("securityCode"));
	    	logger.info("User entered the new inforamtion successfully");
		}
		
		}
		
	
	@When("user click on Update Your Card button")
	public void userClickOnUpdateYourCardButton() {
		click(factory.accountPage().updateYourCardBttn);
		logger.info("user clicked on update button successfully");
		
	   
	}
	
	
	
	
	// remove payment method 
	
	@When("User click on remove option of card section")
	public void userClickOnRemoveOptionOfCardSection() {
		click(factory.accountPage().removeCardBttn);
		logger.info("Remove button was clicked successfully");
	   
	}
	@Then("payment details should be removed")
	public void paymentDetailsShouldBeRemoved() {
		logger.info("card was removed successfully");
		
	   
	}
	
	//Add Address ----------------------------------------------------------------------------------

	@When("User click on Add address option")
	public void userClickOnAddAddressOption() {
		click(factory.accountPage().addAddressLink);
		logger.info("user clicked on address button successfully");
	    
	}
	@When("user fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for(Map<String, String> row : data) {
			selectByVisibleText(factory.accountPage().countryDropdown, row.get("country"));
			clearTextUsingSendKeys(factory.accountPage().addressNameInputField);
			sendText(factory.accountPage().addressNameInputField, row.get("fullName"));
			clearTextUsingSendKeys(factory.accountPage().addressPhoneNumberInputField);
			sendText(factory.accountPage().addressPhoneNumberInputField, row.get("phoneNumber"));
			clearTextUsingSendKeys(factory.accountPage().addressStreetInputField);
			sendText(factory.accountPage().addressStreetInputField, row.get("streetAddress"));
			clearTextUsingSendKeys(factory.accountPage().addressApartmentInputField);
			sendText(factory.accountPage().addressApartmentInputField, row.get("apt"));
			clearTextUsingSendKeys(factory.accountPage().addressCityInputField);
			sendText(factory.accountPage().addressCityInputField, row.get("city"));
			selectByVisibleText(factory.accountPage().addressStateInputField, row.get("state"));
			clearTextUsingSendKeys(factory.accountPage().addressZipCodeInputField);
			sendText(factory.accountPage().addressZipCodeInputField, row.get("zipCode"));
			logger.info("user entered address details successfully");
				
		}
	}
	@When("User click Add Your Address button")
	public void userClickAddYourAddressButton() {
		click(factory.accountPage().addressAddAddressBttn);
		logger.info("user clicked on add address successfully");
	   
	}
	
	// Edit Address section ----------------------------------------------------------
	
	@When("User click on edit address option")
	public void userClickOnEditAddressOption() {
	   click(factory.accountPage().editAddressOption);
	   logger.info("user clicked on edit address button successfully");
	}
	@When("User click update Your Address button")
	public void userClickUpdateYourAddressButton() {
	    click(factory.accountPage().updateAddressBttn);
	    logger.info("user clicked on update address button successfully");
	    
	}  
	// remove Address section -------------------------------------------------
	@When("User click on remove option of Address section")
	public void userClickOnRemoveOptionOfAddressSection() {
		click(factory.accountPage().removeAddressBttn);
		logger.info("user clicked on remove button successfully");
	       
	}
	@Then("Address details should be removed")
	public void addressDetailsShouldBeRemoved() {
		logger.info("address is removed successfully");
	       
	}

	
	    
	}


