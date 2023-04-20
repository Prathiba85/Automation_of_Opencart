package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;// import  org.apache.logging.log4j.Logger;
	public ResourceBundle rb;
	
	@BeforeMethod
	@Parameters ("browser")
	public void setup(String br)
	{
		rb=ResourceBundle.getBundle("config");//Load config.properties file
		logger =LogManager.getLogger(this.getClass());// This is for logging 
	
		if (br.equals("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("excludeSwitches",new String[]{"enable-autoamtion"});
			//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		}
		if(br.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		if(br.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
		}
	
	@AfterMethod
	public void tear_down()
	{
		driver.quit();
	}
	
	//Java.lang dependency has a predefined class random string utilize that has method randomAlphabetic
	public String randomeString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
		
	}
	public String randomeNumber()
	{
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return generatedString2;
		
	}

	public String randomAlphaNumeric()
	{
		String str = RandomStringUtils.randomAlphabetic(6);
		String num = RandomStringUtils.randomNumeric(2);
		return (str+num);
		
	}
	public String captureScreen(String tname) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}

		return destination;
	}
	
	
}
