package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {

	public CheckoutPage(WebDriver driver) {
		super(driver);

	}
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtfirstname;
	@FindBy(xpath="//input[@id='input-payment-lastname']")
	WebElement txtlastname;
	@FindBy(xpath="//input[@id='input-payment-company']")
	WebElement txtcompanyname;
	@FindBy(xpath="//input[@id='input-payment-address-1']")
	WebElement txtaddress1;
	@FindBy(xpath="//input[@id='input-payment-address-2']")
	WebElement txtaddress2;
	@FindBy(xpath="//input[@id='input-payment-city']")
	WebElement txtcity;
	@FindBy(xpath="//input[@id='input-payment-postcode']")
	WebElement txtpostcode;
	@FindBy(xpath="//select[@id='input-payment-country']")
	WebElement drpcountry;
	@FindBy(xpath="//select[@id='input-payment-zone']")
	WebElement drpstate;
	@FindBy(xpath="//input[@id='button-payment-address']")
	WebElement btncontinue;
	@FindBy(xpath="//input[@id='button-shipping-address']")
	WebElement btnContinue;
	@FindBy(xpath="//input[@id='button-shipping-method']")
	WebElement Btncontinue;
	@FindBy(xpath="//input[@name='agree']")
	WebElement chckterms;
	@FindBy(xpath="//input[@id='button-payment-method']")
	WebElement BtnContinue;
	@FindBy(xpath="//table[@class='table table-bordered table-hover']//td[@class='text-right'][normalize-space()='$106.00']")
	WebElement chcktotalprice;
	@FindBy(xpath="//input[@id='button-confirm']")
	WebElement btnconfrm;
	@FindBy(xpath="//h1[normalize-space()='Your order has been placed!']")
	WebElement confrmorde;
	@FindBy(xpath="//a[normalize-space()='Continue']")
	WebElement bttncontinue;

	public void setfirstName(String fstname) {
		txtfirstname.sendKeys(fstname);

	}

	public void setlastName(String lstname) {
		txtlastname.sendKeys(lstname);

	}

	public void setaddress1(String add1) {

		txtaddress1.sendKeys(add1);
	}

	public void setaddress2(String add2) {

		txtaddress2.sendKeys(add2);
	}

	public void setcity(String city) {

		txtcity.sendKeys(city);
	}

	public void setpin(String pincode) {
		txtpostcode.sendKeys(pincode);

	}

	public void setCountry(String country) {
		Select drpcuntry=new Select(drpcountry);
		drpcuntry.selectByVisibleText("India");


	}

	public void setState(String state) {

		Select drpstat=new Select(drpstate);
		drpstat.selectByVisibleText("Telangana");
	}

	public void clickOnContinueAfterBillingAddress() {
		btncontinue.click();

	}

	public void clickOnContinueAfterDeliveryAddress() {
		btnContinue.click();

	}

	public void setDeliveryMethodComment(String string) {


	}

	public void clickOnContinueAfterDeliveryMethod() {
		btnContinue.click();

	}

	public void selectTermsAndConditions() {

		chckterms.click();
	}

	public void clickOnContinueAfterPaymentMethod() {

		BtnContinue.click();
	}

	public String getTotalPriceBeforeConfOrder() {
		String totalprice=	chcktotalprice.getText();
		return totalprice;

	}
	public void clickonconfirm()
	{
		btnconfrm.click();
	}
	public String checkConfirmMsg()
	{
		try
		{
			return(confrmorde.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	public void clickoncontinue()
	{
		bttncontinue.click();

	}


}
