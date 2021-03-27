package Bootcamp;




import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


public class TC001 {
@Test	
public static void main() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--disable-notifications");
	
	ChromeDriver driver= new ChromeDriver(options);
	driver.get("https://login.salesforce.com");
	driver.manage().window().maximize();
	driver.findElementById("username").sendKeys("mercury.bootcamp@testleaf.com");
	driver.findElementById("password").sendKeys("Bootcamp$123");
	driver.findElementById("Login").click();
	
	driver.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);
    
	driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
	Thread.sleep(3000);
	driver.findElementByXPath("//button[@class='slds-button']").click();
	
	
	//driver.findElementByXPath("(//p[@class='slds-truncate'])[1]").click();
	
	driver.findElementByXPath("//p[text()='Sales']").click();
	
	WebElement element=driver.findElementByXPath("//span[text()='Opportunities']");
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript("arguments[0].click();",element);
		
	driver.findElementByXPath("//div[text()='New']").click();
	Thread.sleep(4000);
	WebElement namet = driver.findElementByXPath("(//input[@name='Name']");
	executor.executeScript("arguments[0].click();",namet);
	WebElement name = driver.findElementByXPath("((//div[@class='uiInput uiInputText uiInput--default uiInput--input'])/input)[1]");
	name.sendKeys("Saleforce Automation by Arunvengat");
	String text = name.getText();

	driver.findElementByXPath("//a[@class='datePicker-openIcon display']").click();
	driver.findElementByXPath("//span[text()='7']").click();
	
	driver.findElementByXPath("//a[@class='select']").click();
	driver.findElementByXPath("//a[@title='Needs Analysis']").click();
	driver.findElementByXPath("(//div[@class='button-container-inner slds-float_right']//span)[3]").click();
	String text2 = driver.findElementByXPath("//span[contains(@class,'toastMessage ')]").getText();
	System.out.println(text2);
	if(text.contains(text2)) {
		System.out.println("Text present");
	}else {
		System.out.println("Not present");}
		
	}}

