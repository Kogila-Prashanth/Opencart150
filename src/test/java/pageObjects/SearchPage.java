package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver)
	{
		super(driver);
	}
		
     @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
     WebElement msgConfirmation;
     @FindBy(xpath="//input[@id='input-quantity']")
     WebElement quantityInput;
     @FindBy(xpath="//button[@id='button-cart']")
     WebElement addToCartBtn;
	public boolean isProductExist(String productname)
	{
		List<WebElement> products=driver.findElements(By.xpath("//body/div[@id='product-search']/div[@class='row']/div[@id='content']/div"));
		for (WebElement product : products)
		{
			if(product.getText().contains(productname))
			{
				return true;

			}

		}
		return false;
	}
	public void selectProduct(String productname) {
		List<WebElement> products=driver.findElements(By.xpath("//div[@class='product-thumb']"));
		for (WebElement product : products)
		{
			if(product.getText().contains(productname))
			{
				product.click();
			}
		}


	}

	public void setQuantity(String quantity) {
		
		quantityInput.clear();
		quantityInput.sendKeys(quantity);
	}

	public void addToCart() {
		
		addToCartBtn.click();

	}
	public String getcheckConfMsg() {

			try
			{
				return(msgConfirmation.getText());
			}
			catch(Exception e)
			{
				return (e.getMessage());
			}
		}


}
