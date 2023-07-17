package tek.sdet.framework.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class RetailOrderSteps extends CommonUtility{
	POMFactory factory = new POMFactory();
	
	@When("User change the category to {string}")
	public void userChangeTheCategoryTo(String smartHome) {
		selectByVisibleText(factory.orderPage().allDepartmentDropdown, smartHome);
		logger.info("user selected smort home option successfully");
	    
	}
	@When("User search for an item {string}")
	public void userSearchForAnItem(String kasaOutdoorSmartPlug) {
		sendText(factory.orderPage().searchInputField, kasaOutdoorSmartPlug);
		logger.info("item name was entered successfully");
	   
	}
	@When("User click on Search icon")
	public void userClickOnSearchIcon() {
		click(factory.orderPage().searchBttn);
		logger.info("search button was clicked successfully");
	    
	}
	@When("User click on item")
	public void userClickOnItem() {
		click(factory.orderPage().KasaOutdoorSmartPlugItem);
		logger.info("user clicked on item successfully");
	    
	}
	@When("User select quantity {string}")
	public void userSelectQuantity(String itemQty) {
		selectByVisibleText(factory.orderPage().productQtyDropdown, itemQty);
		logger.info("Item quantity was selected successfully");
	    
	}
	@When("User click add to Cart button")
	public void userClickAddToCartButton() {
		click(factory.orderPage().addToCartBttn);
		logger.info("add to cart button was clicked successfully");
	   
	}
	@Then("the cart icon quantity should change to {string}")
	public void theCartIconQuantityShouldChangeTo(String itemQtyInTheCart) {
		Assert.assertEquals(itemQtyInTheCart, factory.orderPage().cartQtyField.getText());
		logger.info(itemQtyInTheCart + " quantity was displayed in the cart");;
		
	    
	}
	// place Order With Shipping And Payment---------------------------------------
	@When("User search for an item Apex Legends {string}")
	public void userSearchForAnItemApexLegends(String apexLegends) {
		sendText(factory.orderPage().searchInputField, apexLegends);
		logger.info(apexLegends + " entered successfully");
	   
	}
	@When("User click on item Apex Legends")
	public void userClickOnItemApexLegends() {
		click(factory.orderPage().apexLegendsItem);
		logger.info("user clicked on apex legend item");
	}
	@When("User select Apex Quantity quantity {string}")
	public void userSelectApexQuantityQuantity(String itemQty) {
		selectByVisibleText(factory.orderPage().productQtyDropdown, itemQty);
		logger.info(itemQty + " quantity was selected successfully");
	}
	@Then("the cart icon quantity Apex Legends should change to {string}")
	public void theCartIconQuantityApexLegendsShouldChangeTo(String expectedQty) {
		Assert.assertEquals(expectedQty, factory.orderPage().cartQtyField.getText());
		logger.info(expectedQty + " quantity was validated successfully");
		
	}
	@Then("User click on Cart option")
	public void userClickOnCartOption() {
		click(factory.orderPage().cartBttn);
		logger.info("car button was clicked successfully");
		
	    
	}
	@Then("User click on Proceed to Checkout button")
	public void userClickOnProceedToCheckoutButton() {
		click(factory.orderPage().proceedToCheckoutBttn);
		logger.info("Proceed to checkout button was clicked successfully");
	   
	}
	@Then("User click on Place Your Order")
	public void userClickOnPlaceYourOrder() {
		click(factory.orderPage().placeorderBttn);
		logger.info("Place your order button was clicked successfully");
	    
	}
	
	// Cancel Order ---------------------------------------------------------
	@When("User click on Orders section")
	public void userClickOnOrdersSection() {
		click(factory.orderPage().orderLinkField);
		logger.info("Order link was clicked successfully");
	   
	}
	@When("User click on first order in the list")
	public void userClickOnFirstOrderInTheList() {
		List<WebElement> listOfOrders = factory.orderPage().ListOfOrder;
		for(int i=0; i < listOfOrders.size(); i++) {
			if(factory.orderPage().orderDetailDisplay.getText().equalsIgnoreCase("Hide Details")) {
				if(factory.orderPage().cancelBtn.isDisplayed()) {
					break;
				}
			} else if(factory.orderPage().orderDetailDisplay.getText().equalsIgnoreCase("Show Details")) {
				click(factory.orderPage().orderDetailDisplay);
				if(factory.orderPage().cancelBtn.isDisplayed()) {
					break;
			}
		 }
			
		}
	   
	}
	@When("User click on Cancel the Order button")
	public void userClickOnCancelTheOrderButton() {
		click(factory.orderPage().cancelBtn);
		logger.info("Cancel the order button was clicked successfully");
	   
	}
	@When("User select the cancelation Reason {string}")
	public void userSelectTheCancelationReason(String cancelalationReason) {
		selectByVisibleText(factory.orderPage().cancellationReason, cancelalationReason);
		logger.info(cancelalationReason + " reason was selected successfully");
	  
	}
	@When("User click on Cancel Order button")
	public void userClickOnCancelOrderButton() {
		click(factory.orderPage().cancelSubmitBttn);
		logger.info("Cancel submit button was clicked successfully");
	    
	}
	@Then("a cancelation message should be displayed {string}")
	public void aCancelationMessageShouldBeDisplayed(String cancellationMssage) {
		Assert.assertTrue(isElementDisplayed(factory.orderPage().yourOrderCancelledMssg));
		//Assert.assertEquals(cancellationMssage, factory.orderPage().yourOrderCancelledMssg);
		logger.info(cancellationMssage + " was verified successfully");
	    
	}
	//Return order section ----------------------------------------------------------------------------
	@When("User click on first order in list")
	public void userClickOnFirstOrderInList() {
		List<WebElement> listOfOrders = factory.orderPage().ListOfOrder;
		for(int i=0; i < listOfOrders.size(); i++) {
			if(factory.orderPage().orderDetailDisplay.getText().equalsIgnoreCase("Hide Details")) {
				if(factory.orderPage().cancelBtn.isDisplayed()) {
					break;
				}
			} else if(factory.orderPage().orderDetailDisplay.getText().equalsIgnoreCase("Show Details")) {
				click(factory.orderPage().orderDetailDisplay);
				if(factory.orderPage().cancelBtn.isDisplayed()) {
					break;
			}
		 }
			
		}
	}
	   
	@When("User click on Return Items button")
	public void userClickOnReturnItemsButton() {
		click(factory.orderPage().returnBttnField);
		logger.info("user clicked on return button successfully");
	   
	}
	@When("User select the Return Reason {string}")
	public void userSelectTheReturnReason(String itemDamaged) {
		selectByVisibleText(factory.orderPage().returnBttnReason, itemDamaged);
		logger.info("user selected the reason for returning the item");
		
	}
	@When("User select the drop off service {string}")
	public void userSelectTheDropOffService(String fedEx) {
		selectByVisibleText(factory.orderPage().dropOffInput, fedEx);
		logger.info("user selected drop off option successfully");
	    
	}
	@When("User click on Return Order button")
	public void userClickOnReturnOrderButton() {
		click(factory.orderPage().returnOrderSubmitBtn);
	    
	}
	
	// Write Review Section ------------------------------------------------
	@When("User click on Review button")
	public void userClickOnReviewButton() {
	  click(factory.orderPage().reviewBtn);
	  logger.info("review button was clicked successfully");
	}
	@When("User write Review headline {string} and {string}")
	public void userWriteReviewHeadlineAnd(String headlineText, String reviewText) {
		sendText(factory.orderPage().headlineInput, headlineText);
		sendText(factory.orderPage().descriptionInput, reviewText);
		logger.info("user entered headline and description in review area successfully");
	    
	}
	@When("User click Add your Review button")
	public void userClickAddYourReviewButton() {
	   click(factory.orderPage().reviewSubmitBtn);
	   logger.info("user clicked add your review button successfully");
	}
	@Then("a review message should be displayed {string}")
	public void aReviewMessageShouldBeDisplayed(String reviewAddedMssg) {
		Assert.assertEquals(reviewAddedMssg, factory.orderPage().reviewAddedSuccessMssg.getText());
		Assert.assertTrue(isElementDisplayed(factory.orderPage().reviewAddedSuccessMssg));
	}
	}



