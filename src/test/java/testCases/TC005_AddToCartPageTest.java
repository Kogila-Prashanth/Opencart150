package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC005_AddToCartPageTest extends BaseClass {
	@Test (groups={"Master"})
	public void verify_addToCart() throws InterruptedException {
		logger.info(" starting TC005_AddToCartPageTest ");
		try 
		{
			HomePage hp=new HomePage(driver);
			hp.enterProductName("iPhone");
			hp.ClickSearch();

			SearchPage sp=new SearchPage(driver);
			if(sp.isProductExist("iPhone"))
			{
				sp.selectProduct("iPhone");
				sp.setQuantity("2");
				sp.addToCart();
            }
			String confmsg = sp.getcheckConfMsg();
			if(confmsg.equals("Success: You have added iPhone to your shopping cart!"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
			
//			Assert.assertEquals(sp.checkConfMsg(),true);

		}catch (Exception e)
		{
			Assert.fail();
		}
		
		logger.info(" Finished TC005_AddTOCartPageTest ");

	}
	

}
