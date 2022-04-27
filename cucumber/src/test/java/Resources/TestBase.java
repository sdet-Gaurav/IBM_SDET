package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	
	public static WebDriver driver;
	static Properties prop;
	public  WebDriverWait wait;
	static Select select;
	
	public static void init()
	{
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\002OC3744\\GauravKumar\\Workspace_cucumber\\cucumber\\Drivers\\chromedriver.exe");
		System.out.println("driver has initialized");
	}
	
	public static void tearDown()
	{
		driver.quit();
		System.out.println("driver session has ended");
	}
	
	public static String readDataFromProp(String key) throws IOException
	{
		FileInputStream fs=new FileInputStream("C:\\Users\\002OC3744\\GauravKumar\\Workspace_cucumber\\cucumber\\ObjectRepository\\Selenium_Web_Elements.properties");
		prop=new Properties();
		prop.load(fs);
		String value=prop.getProperty(key);
		return value;
	}
	
	public static void selectFromDropdown(String address, String visibleText)
	{
	WebElement e=driver.findElement(By.xpath(address));	
		select=new Select(e);
		  select.selectByVisibleText(visibleText);
		 
		
	}
	
	public static String getText(String address) {
	
		String text=driver.findElement(By.xpath(address)).getText();
		return text.trim();	
	}
	
	public static StringBuilder getRandomString(StringBuilder value) {
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMmmss");  
	    Date date = new Date();  
	    return value.append(formatter.format(date));
	    
	}
	
	

}
