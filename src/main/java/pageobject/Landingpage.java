package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landingpage {
	
	public WebDriver driver;
	
	public Landingpage(WebDriver driver) {
		this.driver=driver;
	}
	By signin = By.cssSelector("a[href='https://rahulshettyacademy.com/sign_in/']");
	
	public LoginPage getlogin() {
		 driver.findElement(signin).click();
		 LoginPage lgn = new LoginPage(driver);
		 return  lgn;
	}
	By nav = By.cssSelector(".nav.navbar-nav.navbar-right");
	public WebElement getnav() {
		return driver.findElement(nav);
	}
	By txt = By.cssSelector("div[class='text-center'] h2");
	public WebElement gettxt() {
		return driver.findElement(txt);
	}
	
	
	
//	By course = By.xpath("//li/div[@class='item']");
//	public List<WebElement> course() {
//		return driver.findElements(course);
//	}
	
	
	
	
}
