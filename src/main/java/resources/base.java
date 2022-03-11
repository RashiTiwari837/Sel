package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public WebDriver driver ;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		 prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\rashi\\workspace\\sel\\src\\main\\java\\data.properties");
		prop.load(fis);
		//mvn to select browser
	String names =System.getProperty("browser");
	//	String names = prop.getProperty("browser");
		if(names.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","target\\chromedriver.exe");
			ChromeOptions opt = new ChromeOptions();
		//	opt.addArguments("--headless");
			driver = new ChromeDriver();
			
		System.out.println(names);
		}
		else if (names.equals("firefox")) {
			
				System.setProperty("webdriver.gecko.driver","target\\geckodriver.exe");
				driver = new FirefoxDriver();
		}
		else if (names.equals("edge")) {
			
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
		return driver;
	}
	public void getscrnshot(String tesrCasename, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	String destfile = System.getProperty("user.dir")+"\\reports\\"+"tesrCasename"+".png";
	FileUtils.copyFile(source,new File(destfile));
			
			
			
			
			
	}
	
}
