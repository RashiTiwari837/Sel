package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	static ExtentReports ext;
	public static ExtentReports config() {
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation report");
		reporter.config().setDocumentTitle("report");
		
		 ext = new ExtentReports();
		 ext.attachReporter(reporter);
		 ext.setSystemInfo("QA","Rashi");
		return ext;
	}
}
