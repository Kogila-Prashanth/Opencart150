package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	@Test(groups={"Regression","sanity","Master"})
	public void verify_account_registration()
	{
		logger.info(" *** starting TC001_AccountRegistrationTest ***");
		try
		{

			HomePage hp= new HomePage(driver);
			hp.clickMyAccount();
			logger.info(" clicked on MyAccount Link ");
			hp.clickRegister();
			logger.info(" Clicked on Register Link ");
			AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
			logger.info(" Providing Customer details");
			regPage.setFirstName(randomString().toUpperCase());
			regPage.setLastName(randomString().toUpperCase());
			regPage.setEmail(randomString()+"@gmail.com");
			regPage.setTelephone(randomNumber());
			String password=randomAlphanumeric();
			regPage.setPassword(password);
			regPage.setConfirmPassword(password);
			regPage.setPrivacyPolicy();
			regPage.clickContinue();
			logger.info("Validating expected message ");
			String confmsg=regPage.getConfirmationMsg();
			if (confmsg.equals("Your Account Has Been Created!"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Test Failed");
				logger.debug("Debug logs");
				Assert.assertTrue(false);
			}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*** Finished TC001_AccountReegistrationTest ***");

	}

}
