package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() {
		
		logger.info("*** Starting TC001_AccountRegistrationTest ***");
		logger.info("Testing ----");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicking Register");
			hp.clickRegister();
			logger.info("*** Click on Register Link ***");
			
			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
			logger.info("Filling Registration form ");

			regpage.setFirstName(randomeString().toUpperCase());
			regpage.setLastName(randomeString().toUpperCase());
			regpage.setEmail(randomeString()+"@gmail.com");
			regpage.setPhone(randomeNumber());
			
			String password = randomeAlphaNumeric();
			regpage.setPassword(password);
			regpage.setConfirmPassword(password);
			
			regpage.setPrivacyPolicy();
			regpage.clickContinue();
			
			logger.info("Validating success message");
			String confmsg = regpage.getConfirmationMsg();
			if (confmsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test Failed..");
				logger.debug("Debug logs.. ");
				Assert.assertTrue(false);
			}
				
			//Assert.assertEquals(confmsg, "Your Account Has Been Created!!");
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
		logger.info("Finished Testing ");	
	}
	
}
