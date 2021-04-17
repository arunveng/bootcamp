package Bootcamp.PageObjectModel.baseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import Bootcamp.excel_read;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;

public class Base_class extends AbstractTestNGCucumberTests{
	public  RemoteWebDriver driver;
	public  static ChromeOptions options;
    //public static JavascriptExecutor js;
    public String file;
    
    private static ThreadLocal<RemoteWebDriver> thread = new ThreadLocal<RemoteWebDriver>();
    
    public void setDriver(RemoteWebDriver driver) {
    	thread.set(driver);
    }
    public RemoteWebDriver getDriver() {
    	return thread.get();
    }
  
   
    @Parameters({"url","username","password","browser"})	
    @Before
    public void login(String url,String uname,String pwd,String browser) throws InterruptedException {
	if(browser.equals("chrome")) {
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	options=new ChromeOptions();
	options.addArguments("--disable-notifications");
	driver= new ChromeDriver(options);
	
	}
	else if(browser.equals("FF"))
	{
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		FirefoxOptions options=new FirefoxOptions();
		options.addPreference("dom.push.enabled", false);
		driver= new FirefoxDriver();
	}
	setDriver(driver);
	//js =(JavascriptExecutor) getDriver();
	getDriver().get(url);
	getDriver().manage().window().maximize();
	getDriver().manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	getDriver().findElementById("username").sendKeys(uname);
	getDriver().findElementById("password").sendKeys(pwd);
	getDriver().findElementById("Login").click();
	Thread.sleep(4000);

}

    
@After
public void logout() throws InterruptedException
{
	//getDriver().close();
}
@DataProvider(name="inputdata",parallel=true)
public Object[][] excel() throws IOException {
	Object[][] exdata = excel_read.main(file);
	return exdata;
}

}
