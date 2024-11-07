package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC004_SearchProductTest extends  BaseClass{
	@Test(groups= {"Master"})
	public void verify_productSearch() throws InterruptedException
	{
		logger.info(" Starting TC004_SearchProductTest ");
		try
		{

			HomePage hp =new HomePage(driver);
			// hm.enterProductName ("iphone");
			hp.enterProductName("mac");
			hp.ClickSearch();

			SearchPage sp =new SearchPage(driver);
			sp.isProductExist("MacBook");

			Assert.assertEquals(sp.isProductExist("MacBook"),true);
		}
		catch(Exception e)
		{
			Assert.fail();
		}

		logger.info(" Finshed TC004_SearchProductTest ");
	}

}
