package Bootcamp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TC002 {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--disable-notifications");
	
	ChromeDriver driver= new ChromeDriver(options);
	driver.get("https://login.salesforce.com");
	driver.manage().window().maximize();
	driver.findElementById("username").sendKeys("mercury.bootcamp@testleaf.com");
	driver.findElementById("password").sendKeys("Bootcamp$123");
	driver.findElementById("Login").click();
    driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
    
	driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
	
	driver.findElementByXPath("//button[@class='slds-button']").click();
	
	
	//driver.findElementByXPath("(//p[@class='slds-truncate'])[1]").click();
	
	driver.findElementByXPath("//p[text()='Sales']").click();
	
	WebElement element=driver.findElementByXPath("//span[text()='Opportunities']");
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript("arguments[0].click();",element);
	
	driver.findElementByXPath("//input[@name='Opportunity-search-input']").click();
	WebElement search = driver.findElementByXPath("//input[@name='Opportunity-search-input']");
	search.sendKeys("Salesforce Automation by Arun vengat");
	//search.click();
	driver.findElementByXPath("(//div[@class='slds-grid'])[1]").click();
	
	Thread.sleep(3000);
	driver.findElementByXPath("(//table//*[@data-key='down']/parent::lightning-primitive-icon)[1]").click();
	Thread.sleep(3000);
	driver.findElementByXPath("//a[@title='Edit']").click();
	Thread.sleep(3000);
	/*driver.findElementByXPath("//a[@class='datePicker-openIcon display']").click();
	Thread.sleep(3000);
	driver.findElementByXPath("(//span[text()='22'])[1]").click();
	Thread.sleep(3000);
	driver.findElementByXPath("(//a[@class='select'])[2]").click();
	Thread.sleep(3000);
	driver.findElementByXPath("//a[@title='Perception Analysis']").click();
	Thread.sleep(3000);*/
	WebElement element1=driver.findElementByXPath("(//a[@class='select'])[4]");
	JavascriptExecutor executor1 = (JavascriptExecutor) driver;
	executor1.executeScript("arguments[0].scrollIntoView();",element1);
	Thread.sleep(3000);
	
	driver.findElementByXPath("(//a[@class='select'])[4]").click();
	Thread.sleep(3000);
	driver.findElementByXPath("//a[@title='In progress']").click();
	Thread.sleep(3000);
	driver.findElementByXPath("//textarea[@class=' textarea']").click();
	
	driver.findElementByXPath("//textarea[@class=' textarea']").sendKeys("Salesforce");
	
	driver.findElementByXPath("(//span[text()='Save'])[2]").click();
	
	WebElement text = driver.findElementByXPath("//span[text()='Perception Analysis']");
	String verify = text.getText();
	if(verify.contentEquals("Perception Analysis")) {
		System.out.println("Text Matches");
		System.out.println(verify);
	}
	else {
		System.out.println("Text doesnot match");
	}}
	
	
		
}

