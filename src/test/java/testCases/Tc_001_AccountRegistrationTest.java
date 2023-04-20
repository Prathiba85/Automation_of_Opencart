package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.BasePage;
import pageObjects.HomePage;
import testBase.BaseClass;


public class Tc_001_AccountRegistrationTest extends BaseClass {
	@Test
	void test_account_Registration()
	{
		logger.debug("****** Debug Account Creation *******");
		logger.info("*********Starting TC_001_AccountRegistrationTest********** ");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My account link  ");
		hp.clickRegister();
		logger.info("Clicked on Register  link  ");
		AccountRegistrationPage repage = new AccountRegistrationPage(driver);
		logger.info("Providing customer data");
		repage.setFirstName(randomeString().toUpperCase());
		repage.setLastName(randomeString().toUpperCase());
		//repage.setEmail(randomAlphaNumeric()+"@gmail.com");
		repage.setTelephone(randomeNumber());
		String password = randomAlphaNumeric()+"@";
		repage.setPassword(password);
		repage.setConfirmPassword(password);
		repage.checkAgree();
		repage.clickContinue();
		logger.info("Clicked on continue ");
		String confmsg = repage.getConfirmationMsg();
		logger.info("Validating expected message");
		Assert.assertEquals(confmsg,"Your Account Has Been Created!","not getting expected mesage");
		}catch(Exception e)
		{
			Assert.fail();
			logger.error("Test Failed and Exception caught");
		}
		logger.info("Finished account creation");
		}
	
		
		
	}
	
	

