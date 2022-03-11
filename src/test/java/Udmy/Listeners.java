package Udmy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReportNG;
import resources.base;

public class Listeners extends base implements ITestListener {
	ExtentReports ext =ExtentReportNG.config();
	
	ExtentTest tst;
	//ThreadLocal <ExtentTest>exttest =  new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		 tst = ext.createTest(result.getMethod().getMethodName());
	//	 exttest.set(tst); 
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		tst.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		tst.fail(result.getThrowable());
		WebDriver driver = null;
	String tstmthd=	result.getMethod().getMethodName();
	try {
	driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		try {
			getscrnshot(tstmthd, driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		ext.flush();
	}

}
