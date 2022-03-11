package Udmy;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;
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
import resources.base;

public class Validatetitile  extends base{
	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver driver;
//	public  Homepage(WebDriver driver) {
//		this.driver=driver;
//	}
	@BeforeMethod
	public void ititialize() throws IOException {
		driver=	initializeDriver();
		
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("navigated to url");
		driver.manage().window().maximize();		
	}
	@SuppressWarnings("deprecation")
	@Test
	public void basepagenavigation() throws IOException {
	Landingpage lnd = new Landingpage(driver);
	String txt =lnd.gettxt().getText();
	Assert.assertEquals( "FEATURED COUR ES",txt);
	
	}
	@SuppressWarnings("deprecation")
	@Test
	public void navigatn() {
		Landingpage lnd2 = new Landingpage(driver);
		lnd2.getnav();
		Assert.assertTrue(lnd2.getnav().isDisplayed());
		log.info("naigation passed");
	}
//	@Test
//	public void corse() {
//		Landingpage lnd3 = new Landingpage(driver);
//	List<WebElement>a = lnd3.course().stream().filter(s->s.getText()
//			.contains("selenium")).collect(Collectors.toList());
//
//	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
