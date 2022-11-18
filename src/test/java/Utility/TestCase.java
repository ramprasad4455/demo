package Utility;

import java.io.InputStream;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import PO.PO_NOP_Commerce;


public class TestCase {
	WebDriver driver ;
	JSONObject nopcommerce ;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		InputStream datais = null ;
		try {
			String fileName = "data/nopcommerce.json";
			datais = getClass().getClassLoader().getResourceAsStream(fileName);
			JSONTokener tokener = new JSONTokener(datais);
			nopcommerce = new JSONObject(tokener);
			
			ExtentReportManager.createReport("registration");
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			if(datais != null) {
				datais.close();
			}
		}
	}
	
	
	@BeforeMethod
	@Parameters({"browser","url"})
	public void setup(String browser ,String url) throws InterruptedException {
		driver = BrowserManager.getDriver(browser);
		Thread.sleep(1000);
		driver.get(url);
		Thread.sleep(1000);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		ExtentReportManager.startTest("Registration_TestCase");
	}
	
	
	@Test(description = "Testing nopcommerce for valid data")
	public void test_validData() {
		String fName = nopcommerce.getJSONObject("validData").getString("firstName");
		String lName = nopcommerce.getJSONObject("validData").getString("lastName");
		String email = nopcommerce.getJSONObject("validData").getString("email");
		String cEmail = nopcommerce.getJSONObject("validData").getString("confirmEmail");
		String userName = nopcommerce.getJSONObject("validData").getString("username");
		String password = nopcommerce.getJSONObject("validData").getString("password");
		String confirmPassword = nopcommerce.getJSONObject("validData").getString("confirmPassword");
		String result = nopcommerce.getJSONObject("validData").getString("result");
		
		PO_NOP_Commerce obj = PageFactory.initElements( driver , PO_NOP_Commerce.class);
		obj.validData(fName, lName, email, cEmail, userName, password, confirmPassword , result);
	
	System.out.println("Done :"+1);
	}
	
	/*
	@Test(description = "Testing nopcommerce for valid data")
	public void test_Number() {
		String fName = nopcommerce.getJSONObject("onlyNumber").getString("firstName");
		String lName = nopcommerce.getJSONObject("onlyNumber").getString("lastName");
		String email = nopcommerce.getJSONObject("onlyNumber").getString("email");
		String cEmail = nopcommerce.getJSONObject("onlyNumber").getString("confirmEmail");
		String userName = nopcommerce.getJSONObject("onlyNumber").getString("username");
		String password = nopcommerce.getJSONObject("onlyNumber").getString("password");
		String confirmPassword = nopcommerce.getJSONObject("onlyNumber").getString("confirmPassword");
	    
		
		PO_NOP_Commerce obj = PageFactory.initElements( driver , PO_NOP_Commerce.class);
		obj.number(fName, lName, email, cEmail, userName, password, confirmPassword);
			System.out.println("Done :"+2);
	}
	
	@Test(description = "Testing nopcommerce for valid data")
	public void test_symbol() {
		String fName = nopcommerce.getJSONObject("onlyNumber").getString("firstName");
		String lName = nopcommerce.getJSONObject("onlyNumber").getString("lastName");
		String email = nopcommerce.getJSONObject("onlyNumber").getString("email");
		String cEmail = nopcommerce.getJSONObject("onlyNumber").getString("confirmEmail");
		String userName = nopcommerce.getJSONObject("onlyNumber").getString("username");
		String password = nopcommerce.getJSONObject("onlyNumber").getString("password");
		String confirmPassword = nopcommerce.getJSONObject("onlyNumber").getString("confirmPassword");
	    
		
		PO_NOP_Commerce obj = PageFactory.initElements( driver , PO_NOP_Commerce.class);
		obj.symbol(fName, lName, email, cEmail, userName, password, confirmPassword);
		
		System.out.println("Done :"+3);
	}
	
	
	
	@Test(description = "Testing nopcommerce for invalid fistName and lastName")
	public void test_invalidName() {
		String fName = nopcommerce.getJSONObject("invalidData").getString("firstName");
		String lName = nopcommerce.getJSONObject("invalidData").getString("lastName");
		String email = nopcommerce.getJSONObject("validData").getString("email");
		String cEmail = nopcommerce.getJSONObject("validData").getString("confirmEmail");
		String userName = nopcommerce.getJSONObject("validData").getString("username");
		String password = nopcommerce.getJSONObject("validData").getString("password");
		String confirmPassword = nopcommerce.getJSONObject("validData").getString("confirmPassword");
	    
		PO_NOP_Commerce obj = PageFactory.initElements( driver , PO_NOP_Commerce.class);
		obj.invalidName(fName, lName, email, cEmail, userName, password, confirmPassword);
			System.out.println("Done :"+4);
	}
	
	

	@Test(description = "Testing nopcommerce for invalid email")
	public void test_email() {
		String fName = nopcommerce.getJSONObject("validData").getString("firstName");
		String lName = nopcommerce.getJSONObject("validData").getString("lastName");
		String email = nopcommerce.getJSONObject("invalidData").getString("email");
		String cEmail = nopcommerce.getJSONObject("invalidData").getString("confirmEmail");
		String userName = nopcommerce.getJSONObject("validData").getString("username");
		String password = nopcommerce.getJSONObject("validData").getString("password");
		String confirmPassword = nopcommerce.getJSONObject("validData").getString("confirmPassword");
	   
		
		PO_NOP_Commerce obj = PageFactory.initElements( driver , PO_NOP_Commerce.class);
		obj.invalidEmail(fName, lName, email, cEmail, userName, password, confirmPassword);
			System.out.println("Done :"+5);
	}
	@Test(description = "Testing nopcommerce for valid data")
	public void combine() {
		String fName = nopcommerce.getJSONObject("combineNumberSymbol").getString("firstName");
		String lName = nopcommerce.getJSONObject("combineNumberSymbol").getString("lastName");
		String email = nopcommerce.getJSONObject("combineNumberSymbol").getString("email");
		String cEmail = nopcommerce.getJSONObject("combineNumberSymbol").getString("confirmEmail");
		String userName = nopcommerce.getJSONObject("combineNumberSymbol").getString("username");
		String password = nopcommerce.getJSONObject("combineNumberSymbol").getString("password");
		String confirmPassword = nopcommerce.getJSONObject("onlyNumber").getString("confirmPassword");
	    
		
		PO_NOP_Commerce obj = PageFactory.initElements( driver , PO_NOP_Commerce.class);
		obj.combine(fName, lName, email, cEmail, userName, password, confirmPassword);
			System.out.println("Done :"+6);
	}
	
	*/
	
	@Test(description = "Testing nopcommerce for invalid fistName and lastName")
	public void test_invalid() {
		String fName = nopcommerce.getJSONObject("invalidData").getString("firstName");
		String lName = nopcommerce.getJSONObject("invalidData").getString("lastName");
		String email = nopcommerce.getJSONObject("invalidData").getString("email");
		String cEmail = nopcommerce.getJSONObject("invalidData").getString("confirmEmail");
		String userName = nopcommerce.getJSONObject("invalidData").getString("username");
		String password = nopcommerce.getJSONObject("invalidData").getString("password");
		String confirmPassword = nopcommerce.getJSONObject("invalidData").getString("confirmPassword");
		String result = nopcommerce.getJSONObject("validData").getString("result");
		
		PO_NOP_Commerce obj = PageFactory.initElements( driver , PO_NOP_Commerce.class);
		obj.invalid(fName, lName, email, cEmail, userName, password, confirmPassword ,result);
			System.out.println("Done :"+7);
	}
	
	
	
	/*
//	@Test(testName = "Valid Data",description = "Testing NOP commerce website")
//	public void test_registration_with_valid_data() {
//		PO_NOP_Commerce obj = new PO_NOP_Commerce(driver);
//		PageFactory.initElements(driver, obj);
//		obj.validData("ram", "shinde", "ram@gmail.com", "ram@gmail.com", "ram4442", "ram@112233", "ram@112233");
//	}
  
 */
	
	@AfterMethod
	public void StopTest() {
		ExtentReportManager.extentReport.endTest(ExtentReportManager.extentTest);
	}
	
	@AfterClass
	public void stopReport() {
		ExtentReportManager.extentReport.flush();
	}
	
}
