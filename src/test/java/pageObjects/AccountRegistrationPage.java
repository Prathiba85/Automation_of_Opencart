package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	
	}
	
	//Elements
	@FindBy(xpath="//input[@name='firstname']")WebElement txt_firstname;
	@FindBy(xpath="//input[@name='lastname']")WebElement txt_lastname;
	@FindBy(xpath="//input[@name='email']")WebElement txt_email;


	@FindBy(name = "telephone")WebElement txtTelephone;
	@FindBy(xpath="//input[@name='password']")WebElement txt_password;
	@FindBy(name = "confirm")WebElement txtConfirmPassword;


	@FindBy(xpath="//input[@name='agree']")WebElement chk_agree;
	@FindBy(xpath="//input[@value='Continue']")WebElement btn_continue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")WebElement msgConfirmation;
	
	//Action Methods
	public void setFirstName(String fname)
	{
		txt_firstname.sendKeys(fname);
	}
	public void setLastName(String lname)
	{
		txt_lastname.sendKeys(lname);
	}
	public void setEmail(String email)
	{
		txt_email.sendKeys(email);
	}
	public void setTelephone(String tel) {
		txtTelephone.sendKeys(tel);

	}

	public void setPassword(String password)
	{
		txt_password.sendKeys(password);
	}
	public void setConfirmPassword(String pwd) {
		txtConfirmPassword.sendKeys(pwd);

	}

	public void checkAgree ()
	{
		chk_agree.click();
	}
	
	public void clickContinue()
	{
		btn_continue.click();
	}
	
	public String getConfirmationMsg()
	{
		try {
			return msgConfirmation.getText() ;
		}catch(Exception e)
		{
			return (e.getMessage());
		}
	
		
	}

}
