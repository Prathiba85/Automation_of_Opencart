package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	@Test	(groups = {"Sanity","Master"})
public void test_login()
{
	
	try {
	logger.info("***********Tc_002_Starting Login test ************* ");
	HomePage hp = new HomePage(driver);
	hp.clickMyAccount();
	logger.info("Clicked on My account ");
	hp.clickLogin();

	LoginPage lp = new LoginPage(driver);
	lp.setEmail(rb.getString("email"));
	lp.setPassword(rb.getString("password"));
	lp.clickLogin();
	logger.info("Clicked on Login ");
	MyAccountPage macc = new MyAccountPage(driver);
	
	boolean targetpage = macc.isMyAccountPageExists();
	
	Assert.assertEquals(targetpage, true);
	}
	catch (Exception e)
	{
		Assert.fail();
	}
	logger.info("***********Tc_002Finished Login test  ************* ");
}

}
