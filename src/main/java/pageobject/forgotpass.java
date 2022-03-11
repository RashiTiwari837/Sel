package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class forgotpass {
public WebDriver driver;

public forgotpass(WebDriver driver){
	this.driver=driver;
}

	
	private By id = By.id("user_email");
	private By inst = By.name("commit");
	
	
	public WebElement id() {
	return	driver.findElement(id);
	}
	public WebElement inst() { 	
	return	 driver.findElement(inst);
	}
		
	}

