package Utility;

import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReportManager {
	public static ExtentReports extentReport ;
	public static ExtentTest extentTest ;
	
	public static void createReport(String name) {
		Date d = new Date();
		String s = d.getTime()+"";
		extentReport = new ExtentReports(System.getProperty("user.dir")+"/target/data-output/register_report_"+name+s+".html");
	}
	
	public static void startTest(String testName) {
		extentTest = extentReport.startTest(testName);
	}

}
