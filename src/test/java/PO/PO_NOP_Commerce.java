package PO;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentReportManager;
import junit.framework.Assert;

public class PO_NOP_Commerce {
	WebDriver driver ;
	public PO_NOP_Commerce(WebDriver driver) {
		this.driver = driver ;
	}
	
	@FindBy(how = How.XPATH , using = "//input[@id = 'FirstName']")
	WebElement firstName ;
	@FindBy(how = How.XPATH , using = "//input[@id = 'LastName']")
	WebElement lastName ;
	@FindBy(how = How.XPATH , using = "//input[@id = 'Email']")
	WebElement email ;
	@FindBy(how = How.XPATH , using = "//input[@id = 'ConfirmEmail']")
	WebElement confirmEmail ;
	@FindBy(how = How.XPATH , using = "//input[@id = 'Username']")
	WebElement userName ;
	
	@FindBy(how = How.XPATH , using = "//input[@id = 'check-availability-button']")
	WebElement button;
	
	@FindBy(how = How.XPATH , using = "//select[@id = 'CountryId']")
	WebElement country;
	
	@FindBy(how = How.XPATH , using = "//select[@id = 'TimeZoneId']")
	WebElement timeZone;
	
	@FindBy(how = How.XPATH , using = "//input[@id = 'Password']")
	WebElement password;
	
	@FindBy(how = How.XPATH , using = "//input[@id = 'ConfirmPassword']")
	WebElement ConfirmPassword;
	
	@FindBy(how = How.XPATH , using = "//select[@id = 'Details_CompanyIndustryId']")
	WebElement myCompanyPrimarily;
	
	
	@FindBy(how = How.XPATH , using = "//input[@id = 'register-button']")
	WebElement register;
	
	@FindBy(how = How.XPATH , using = "(//div[@class='sub-title']/h2)[1]")
	WebElement title;
	
	@FindBy(how = How.XPATH , using = "//span[@id='FirstName-error'][1]")
	WebElement firstNameError;
	
	public void enterFirstName(String name) {
		firstName.sendKeys(name);
		ExtentReportManager.extentTest.log(LogStatus.INFO,"Enter first name  ", "first name : "+name);
	}
	public void enterLastName(String sirName) {
		lastName.sendKeys(sirName);
		ExtentReportManager.extentTest.log(LogStatus.INFO,"Enter last name  ", "last name : "+sirName);
	}
	public void enterEmail(String Email) {
		email.sendKeys(Email);
		ExtentReportManager.extentTest.log(LogStatus.INFO,"Enter email  ", "email : "+Email);
	}
	public void enterConfirmEmail(String cEmail) {
		confirmEmail.sendKeys(cEmail);
		ExtentReportManager.extentTest.log(LogStatus.INFO,"Enter confirm email  ", "confirm email : "+cEmail);
	}
	public void enterUserName(String userN) {
		userName.sendKeys(userN);
		ExtentReportManager.extentTest.log(LogStatus.INFO,"Enter username ", "username : "+userN);
	}
	public void checkUserNameAvailable() {
		button.click();
		ExtentReportManager.extentTest.log(LogStatus.INFO,"click  button for username availability   ", "username availability");
	}
	
	public void country() {
		country.sendKeys("India");
		ExtentReportManager.extentTest.log(LogStatus.INFO,"Enter Country  ", "Country : "+"India");
	}
	
	public void timeZone() {
		timeZone.sendKeys("(UTC-12:00) International Date Line West");
		ExtentReportManager.extentTest.log(LogStatus.INFO,"Enter timezone  ", "timezone : "+"timezone");
	}
	
	public void password(String pass) {
		password.sendKeys(pass);
		ExtentReportManager.extentTest.log(LogStatus.INFO,"Enter password  ", "password : "+pass);;
	}
	public void confirmPassword(String pass) {
		ConfirmPassword.sendKeys(pass);
		ExtentReportManager.extentTest.log(LogStatus.INFO,"Enter confirm password ", "confirm password : "+pass);
	}
	public void myCompanyPrimarily() {
		myCompanyPrimarily.sendKeys("I am student");
		ExtentReportManager.extentTest.log(LogStatus.INFO,"Enter companyPrimarility  ", " companyPrimarility : "+"I am student");
	}
	public void register() {
		register.click();
		ExtentReportManager.extentTest.log(LogStatus.INFO,"Click on register button  ", " registration");
	}
	public void quit() {
		driver.quit();
		ExtentReportManager.extentTest.log(LogStatus.INFO,"Quit window", "quit");
	}
	public void validData(String firstName , String lastName , String email , String confirmEmail , String userName , String password , String confirmPassword , String result) {
		try {
			
			
			enterFirstName(firstName);
			
			enterLastName(lastName);
		
			enterEmail(email);
		
			enterConfirmEmail(confirmEmail);
			
			enterUserName(userName);
			
			checkUserNameAvailable();

			country();
	
			timeZone();

			password(password);
			
			confirmPassword(confirmPassword);
			
			myCompanyPrimarily();
		
			register();
		
			if(title.getText().toString().trim().equals(result)) {
				System.out.print("Pass");
				ExtentReportManager.extentTest.log(LogStatus.PASS,"Title :" , title.getText().toString());
			}
			else {
				System.out.print("Fail");
				ExtentReportManager.extentTest.log(LogStatus.FAIL,"Title :", "Not Found");
			}
		
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void invalid(String firstName , String lastName , String email , String confirmEmail , String userName , String password , String confirmPassword ,String result) {
try {
			
			
			enterFirstName(firstName);
			
			enterLastName(lastName);
		
			enterEmail(email);
		
			enterConfirmEmail(confirmEmail);
			
			enterUserName(userName);
			
			checkUserNameAvailable();

			country();
	
			timeZone();

			password(password);
			
			confirmPassword(confirmPassword);
			
			myCompanyPrimarily();
		
			register();
		
			
			if(title.getText().toString().trim().equals(result)) {
				System.out.print("Pass");
				ExtentReportManager.extentTest.log(LogStatus.PASS,"Title :" , title.getText().toString());
			}
			else {
				System.out.print("Fail");
				ExtentReportManager.extentTest.log(LogStatus.FAIL,"Title :", "Not Found");
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	
	
	public void number(String firstName , String lastName , String email , String confirmEmail , String userName , String password , String confirmPassword) {
try {
			
			
			enterFirstName(firstName);
			
			enterLastName(lastName);
		
			enterEmail(email);
		
			enterConfirmEmail(confirmEmail);
			
			enterUserName(userName);
			
			checkUserNameAvailable();

			country();
	
			timeZone();

			password(password);
			
			confirmPassword(confirmPassword);
			
			myCompanyPrimarily();
		
			register();
		
			quit();
		
			
			Assert.assertEquals(true,title.isDisplayed());
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void symbol(String firstName , String lastName , String email , String confirmEmail , String userName , String password , String confirmPassword) {
try {
			
			
			enterFirstName(firstName);
			
			enterLastName(lastName);
		
			enterEmail(email);
		
			enterConfirmEmail(confirmEmail);
			
			enterUserName(userName);
			
			checkUserNameAvailable();

			country();
	
			timeZone();

			password(password);
			
			confirmPassword(confirmPassword);
			
			myCompanyPrimarily();
		
			register();
		
			quit();
		
			
			Assert.assertEquals(true,title.isDisplayed());
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	

	public void invalidName(String firstName , String lastName , String email , String confirmEmail , String userName , String password , String confirmPassword) {
try {
			
			
			enterFirstName(firstName);
			
			enterLastName(lastName);
		
			enterEmail(email);
		
			enterConfirmEmail(confirmEmail);
			
			enterUserName(userName);
			
			checkUserNameAvailable();

			country();
	
			timeZone();

			password(password);
			
			confirmPassword(confirmPassword);
			
			myCompanyPrimarily();
		
			register();
		
			quit();
		
			
			Assert.assertEquals(true,title.isDisplayed());
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	public void invalidEmail(String firstName , String lastName , String email , String confirmEmail , String userName , String password , String confirmPassword ) {
try {
			
			
			enterFirstName(firstName);
			
			enterLastName(lastName);
		
			enterEmail(email);
		
			enterConfirmEmail(confirmEmail);
			
			enterUserName(userName);
			
			checkUserNameAvailable();

			country();
	
			timeZone();

			password(password);
			
			confirmPassword(confirmPassword);
			
			myCompanyPrimarily();
		
			register();
		
			quit();
		
			
			Assert.assertEquals(true,title.isDisplayed());
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void combine(String firstName , String lastName , String email , String confirmEmail , String userName , String password , String confirmPassword ) {
try {
			
			
			enterFirstName(firstName);
			
			enterLastName(lastName);
		
			enterEmail(email);
		
			enterConfirmEmail(confirmEmail);
			
			enterUserName(userName);
			
			checkUserNameAvailable();

			country();
	
			timeZone();

			password(password);
			
			confirmPassword(confirmPassword);
			
			myCompanyPrimarily();
		
			register();
		
			quit();
		
			
			Assert.assertEquals(true,title.isDisplayed());
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	public void invalidPasswordAndConfirmPassword(String firstName , String lastName , String email , String confirmEmail , String userName , String password , String confirmPassword) {
try {
			
			
			enterFirstName(firstName);
			
			enterLastName(lastName);
		
			enterEmail(email);
		
			enterConfirmEmail(confirmEmail);
			
			enterUserName(userName);
			
			checkUserNameAvailable();

			country();
	
			timeZone();

			password(password);
			
			confirmPassword(confirmPassword);
			
			myCompanyPrimarily();
		
			register();
		
			quit();
		
			
			Assert.assertEquals(true,title.isDisplayed());
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		}
		
	
}