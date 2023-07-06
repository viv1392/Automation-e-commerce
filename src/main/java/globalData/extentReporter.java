package globalData;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReporter {
	static ExtentReports extent;
	ExtentTest test;
	public static ExtentReports extentSparkReports() {
	String path = System.getProperty("user.dir") + "\\extentreport1\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Web Automation Results");
	reporter.config().setDocumentTitle("Test Results");
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("tester", "Vivek Pandey");
	return extent;
	}

}
