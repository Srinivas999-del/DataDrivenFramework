package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups={"Regression", "Master"})
	public void verify_account_registration() {
		
		logger.info("***Starting TC001_AccountRegistrationTest **** ");  //log4j
		
		try //here using try catch block, suppose failed any step(handle) to display the message
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked my account link");
		
		hp.clickRegister();
		logger.info("Clicked my Register link");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details");
		regpage.setFirstName(randomeString().toUpperCase()); //randomly generated first name
		regpage.setLastName(randomeString().toUpperCase());  //randomly generated last name
		regpage.setEmail(randomeString()+"@gmail.com"); //randomly generated the email
		regpage.setTelephone(randomeNumber());
		
		String password=randomeAlphaNumeric();
		
		regpage.setPasswrod(password);
		regpage.setConfirmPassword(password);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		String confmsg=regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e) {
			logger.error("Test failed..");
			logger.debug("Debug logs...");
			Assert.fail();
			
		}
		logger.info("****Finished TC001_AccountRegistrationTest****");
	}
		
}
