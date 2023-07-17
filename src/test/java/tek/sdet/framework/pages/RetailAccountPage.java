package tek.sdet.framework.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailAccountPage extends BaseSetup {

	public RetailAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(id = "profileImage")
	public WebElement profileImage;
	
	@FindBy(id = "nameInput")
	public WebElement nameInput;

	@FindBy(id = "personalPhoneInput")
	public WebElement phoneInput;
	
	@FindBy(id = "personalUpdateBtn")
	public WebElement personalUpdateButton;
	
	@FindBy(xpath = "//div[text()='Personal Information Updated Successfully']")
	public WebElement personalInfoUpdatedSuccessMessage;
	
	// Locators for add payment method -----------------------------------------------------------------
	
	@FindBy(xpath = "//img[@alt='add payment method']")
	public WebElement addPaymentMethodLink;
	
	@FindBy(id = "cardNumberInput")
	public WebElement cardNumberInputField;
	
	@FindBy(id = "nameOnCardInput")
	public WebElement nameOnCardInputField;
	
	@FindBy(id = "expirationMonthInput")
	public WebElement expirationMonthInputField;
	
	@FindBy(id = "expirationYearInput")
	public WebElement expirationYearInputField;
	
	@FindBy(id = "securityCodeInput")
	public WebElement securityCodeInputField;
	
	@FindBy(id = "paymentSubmitBtn")
	public WebElement addYourCardBttn;
	
	@FindBy(xpath = "//div[text()='Payment Method added sucessfully']")
	public WebElement PaymentMethodAddeddSuccessMessage;
	
	
	// Locators for editing payment methods----------------------------------------------------
	@FindBy(xpath = "//p[@class='account__payment__sub-text']")
	public List<WebElement> cardEndingNumber;
	
	//@FindBy(xpath = "//button[text()='Edit']")
	@FindBy(xpath = "//div[@class='account__payment']//button[text()='Edit']")
	public WebElement editCardBttn;
	
	@FindBy(id = "paymentSubmitBtn")
	public WebElement updateYourCardBttn;
	
	@FindBy(xpath = "//div[text()='Payment Method updated Successfully']")
	public WebElement paymentMethodUpdateSuccessMessage;
	
	
	// Locators for Removing payment method
	
	@FindBy(xpath = "//button[text()='remove']")
	public WebElement removeCardBttn;
	
	// Locators for Adding Address----------------------------------------------------------------------
	@FindBy(xpath = "//div[@class='account__address-new-wrapper']")
	public WebElement addAddressLink;
	
	@FindBy(id = "countryDropdown")
	public WebElement countryDropdown;
	
	@FindBy(id = "fullNameInput")
	public WebElement addressNameInputField;
	
	@FindBy(id = "phoneNumberInput")
	public WebElement addressPhoneNumberInputField;
	
	@FindBy(id = "streetInput")
	public WebElement addressStreetInputField;
	
	@FindBy(id = "apartmentInput")
	public WebElement addressApartmentInputField;
	
	@FindBy(id = "cityInput")
	public WebElement addressCityInputField;
	
	@FindBy(xpath = "//select[@name='state']")
	public WebElement addressStateInputField;
	
	@FindBy(id = "zipCodeInput")
	public WebElement addressZipCodeInputField;
	
	@FindBy(id = "addressBtn")
	public WebElement addressAddAddressBttn;
	
	@FindBy(xpath = "//div[text()='Address Added Successfully']")
	public WebElement addressAddedSuccessfullyMssg;
	
	
	//Locators for edit address -------------------------------------------------
	
	@FindBy(xpath = "//button[text()='Edit']")
	public WebElement editAddressOption;
	
	@FindBy(id = "addressBtn")
	public WebElement updateAddressBttn;
	
	@FindBy(xpath = "//div[text()='Address Updated Successfully']")
	public WebElement addressUpdateSuccessMssg;
	
	
	// Locators for remove address ---------------------------------------
	
	@FindBy(xpath = "//button[text()='Remove']")
	public WebElement removeAddressBttn;
	
	
	
	
}

