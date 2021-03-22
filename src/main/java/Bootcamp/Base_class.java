package Bootcamp;


import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class Base_class{
	public RemoteWebDriver driver;
	public static ChromeOptions options;
	public static String file; 
@Parameters({"url","username","password","browser"})	
@BeforeMethod
public void login(String url,String uname,String pwd,String browser) throws InterruptedException {
	if(browser.equals("chrome")) {
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	options=new ChromeOptions();
	options.addArguments("--disable-notifications");
	driver= new ChromeDriver(options);
	}
	if(browser.equals("FF"))
	{
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		FirefoxOptions options=new FirefoxOptions();
		options.addPreference("dom.push.enabled", false);
		driver= new FirefoxDriver();
	}
	driver.get(url);
	driver.manage().window().maximize();
	driver.findElementById("username").sendKeys(uname);
	driver.findElementById("password").sendKeys(pwd);
	driver.findElementById("Login").click();
	Thread.sleep(4000);

}

@AfterMethod
public void logout() throws InterruptedException
{
	driver.close();
}


@DataProvider(name="inputdata")
public Object[][] excel() throws IOException {
	Object[][] exdata = excel_read.main(file);
	return exdata;
}
}

