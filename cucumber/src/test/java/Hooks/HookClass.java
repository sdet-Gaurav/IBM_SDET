package Hooks;

import org.openqa.selenium.chrome.ChromeDriver;

import Resources.TestBase;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HookClass extends TestBase{
	
	@Before
	public static void init()
	{
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		System.out.println("driver has initialized");
	}
	@After
	public static void tearDown()
	{
		driver.quit();
		System.out.println("driver session has ended");
	}

}
