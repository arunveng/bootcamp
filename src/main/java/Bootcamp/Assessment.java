package Bootcamp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assessment {
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
	Thread.sleep(2000);
	driver.findElementByXPath("//button[@class='slds-button']").click();
	Thread.sleep(2000);
	
	
	driver.findElementByXPath("//p[text()='Service Console']").click();
	Thread.sleep(8000);
	driver.findElementByXPath("//button[@title='Show Navigation Menu']").click();
	Thread.sleep(2000);
	driver.findElementByXPath("//span[text()='Home']").click();
	JavascriptExecutor js=(JavascriptExecutor) driver;
	WebElement closed = driver.findElementByXPath("(//span[@class='metricAmount uiOutputText'])[1]");
	js.executeScript("arguments[0].click()", closed);
	String closedtext = closed.getText();
	System.out.println(closedtext);
	Thread.sleep(3000);
	WebElement open = driver.findElementByXPath("(//span[@class='metricAmount uiOutputText'])[2]");
	js.executeScript("arguments[0].click()", open);
	String opentext = open.getText();
	System.out.println(opentext);
	Thread.sleep(3000);
	String ct=closedtext.replaceAll("\\D", "");
	String ot=opentext.replaceAll("\\D", "");
	
	 
	System.out.println(ct);
	System.out.println(ot);
	
	int closedval=Integer.parseInt(ct);
	int openval=Integer.parseInt(ot);
	int Goal;
	Goal=closedval+openval;
	
	System.out.println(Goal);
	Thread.sleep(3000);
	
	
	
	WebElement edit = driver.findElementByXPath("//button[@title='Edit Goal']");
	js.executeScript("arguments[0].click()",edit);
	
	Thread.sleep(2000);
	driver.findElementByXPath("//input[@aria-describedby='currencyCode']").click();
	WebElement elemt=driver.findElementByXPath("//input[@aria-describedby='currencyCode']");
	
	elemt.clear();
	if(Goal<10000) {
	       elemt.sendKeys("10000");
 
	}  else {
		elemt.sendKeys(String.valueOf(Goal));
	}    
	Thread.sleep(2000);
	driver.findElementByXPath("//span[text()='Save']").click();
	Thread.sleep(1000);
	driver.findElementByXPath("//button[@title='Show Navigation Menu']").click();
	Thread.sleep(1000);
	driver.findElementByXPath("//span[text()='Dashboards']").click();
	Thread.sleep(3000);
	driver.findElementByXPath("//div[@title='New Dashboard']").click();
	WebElement frame = driver.findElementByXPath("//iframe[@title='dashboard']");
	driver.switchTo().frame(frame);
	Thread.sleep(3000);
	
	WebElement id = driver.findElementById("dashboardNameInput");
	js.executeScript("arguments[0].click()",id);
	Thread.sleep(1000);
	//js.executeScript("arguments[0].value='Arun Vengat_Workout'",id);
	id.sendKeys("Arun Vengat_Workout");
	
	WebElement textbox = driver.findElementById("dashboardNameInput");
	String input = textbox.getAttribute("value");
	System.out.println(input);
	driver.findElementById("dashboardDescriptionInput").sendKeys("Testing");
	driver.findElementById("submitBtn").click();
	Thread.sleep(3000);
	driver.switchTo().frame(frame);
	Thread.sleep(3000);
	driver.findElementByXPath("//button[@class='slds-button doneEditing']").click();
	Thread.sleep(1000);
	
	WebElement verify = driver.findElementByXPath("//span[@class='slds-page-header__title slds-truncate']");
	String textOnDashbrd = verify.getText();
	if(textOnDashbrd.contentEquals(input))
	{System.out.println("Text Matched!!");}
	else
	{System.out.println("Text doesnt Matches!!");}
	
	driver.findElementByXPath("//button[text()='Subscribe']").click();
}	


	
}	
	


