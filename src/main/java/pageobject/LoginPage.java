package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By email = By.id("user_email");
	public WebElement getemail() {
		return driver.findElement(email);
	}
	
	By pass = By.id("user_password");
	public WebElement getpas() {
		return driver.findElement(pass);
	}
	
	By login = By.xpath("//input[@name='commit']");
	public WebElement log() {
		return driver.findElement(login);
	}
	
	By fpass = By.cssSelector(".link-below-button");
	public forgotpass fpass() {
		driver.findElement(fpass).click();
		return new forgotpass(driver);
		
		}
}
