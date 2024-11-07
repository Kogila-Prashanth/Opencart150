package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//span[@id='cart-total']")
	WebElement Cartbtn;
	@FindBy(xpath="//strong[normalize-space()='View Cart']")
	WebElement viewcartbtn;
    @FindBy(xpath="//body[1]/div[2]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]")
    WebElement totalPrice;
    @FindBy(xpath="//a[@class='btn btn-primary']")
    WebElement checkout;
	public void clickItemsToNavigateToCart() {

    Cartbtn.click();
		
	}

	public void clickViewCart() {
	
		viewcartbtn.click();
		
	}

	public String getTotalPrice() {
		String totprice=totalPrice.getText();
		return totprice;
	}

	public void clickOnCheckout() {
		
		checkout.click();
	}

}
