package Udmy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageobject.Landingpage;
import pageobject.LoginPage;
import pageobject.forgotpass;
import resources.base;

public class Homepage  extends base{
	WebDriver driver;
//	public  Homepage(WebDriver driver) {
//		this.driver=driver;
//	}
	@BeforeMethod
	public void ititialize() throws IOException {
		driver=	initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
	}
	@SuppressWarnings("deprecation")
	@Test(dataProvider = "test")
	public void basepagenavigation(String uname, String pass) throws IOException, InterruptedException {
	
	Landingpage lnd = new Landingpage(driver);
//	String txt =lnd.gettxt().getText();
//	Assert.assertEquals(txt, "FEATURED COURSE");
	LoginPage lgn= lnd.getlogin();
//	LoginPage lgn = new LoginPage(driver);
	lgn.getemail().sendKeys(uname);
	lgn.getpas().sendKeys(pass);
	Thread.sleep(2000);
	lgn.log().click();
	
	forgotpass fp =lgn.fpass();
	fp.id().sendKeys("test@abc.com");
	fp.inst().click();

	
	}
	
	@DataProvider(name="test")
	public Object[][] getdata() {
		Object [][] data = new Object[2][2]; // how many set of data index from 1
		data[0][0] = "tet@gmail.com";
		data[0][1] = "pass";
		data[1][0] = "don@gmail";
		data[1][1] = "pass2";
				
		return data;
		
		
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
