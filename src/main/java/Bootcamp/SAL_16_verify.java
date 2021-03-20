package Bootcamp;

import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class SAL_16_verify {
@Test
public static void main() throws InterruptedException, ParseException {
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--disable-notifications");
	
	ChromeDriver driver= new ChromeDriver(options);
	driver.get("https://login.salesforce.com");
	driver.manage().window().maximize();
	driver.findElementById("username").sendKeys("mercury.bootcamp@testleaf.com");
	driver.findElementById("password").sendKeys("Bootcamp$123");
	driver.findElementById("Login").click();
	Thread.sleep(10000);
	
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	WebElement s = driver.findElementByXPath("//div[@class='slds-icon-waffle']");
	executor.executeScript("arguments[0].click();",s);
	Thread.sleep(3000);
	
	driver.findElementByXPath("//button[@class='slds-button']").click();
	Thread.sleep(2000);
	
	WebElement scroll = driver.findElementByXPath("//p[text()='Legal Entities']");
	executor.executeScript("arguments[0].scrollIntoView();",scroll);
	Thread.sleep(1000);
	
	driver.findElementByXPath("//p[text()='Legal Entities']").click();
	Thread.sleep(3000);
	
	WebElement element = driver.findElementByXPath("//span[@title='Last Modified Date']");
	Actions act=new Actions(driver);
    Action dblclick = act.doubleClick(element).build();
    dblclick.perform();
    
    
    List<WebElement> trow = driver.findElementsByXPath("//table/tbody/tr/td[3]");
    JavascriptExecutor exe3=(JavascriptExecutor) driver;
	/*exe3.executeScript("arguments[0].scrollIntoView();", trow);
	System.out.println(trow.size());*/
String text = driver.findElementByXPath("//div[@aria-live='polite']/span[@class='countSortedByFilteredBy']").getText().replaceAll("\\D","");
 int tablecount = Integer.parseInt(text);
 System.out.println(tablecount);
 Thread.sleep(4000);
 
    List<Date> initlist = new ArrayList<Date>();
    SimpleDateFormat dateformater = new SimpleDateFormat("MM/dd/yyyy, hh:mm a");
    for(int i=1;i<=tablecount;i++) {
    	String dateAsText = driver.findElementByXPath("//table/tbody/tr["+i+"]/td[3]").getText();
    	//System.out.println(dateAsText);

    	Date convToDate = dateformater.parse(dateAsText);
    	initlist.add(convToDate);
    	Thread.sleep(5000);
    	//exe3.executeScript("arguments[0].scrollIntoView();",driver.findElementByXPath("//table/tbody/tr["+i+"]/td[3]"));
    	exe3.executeScript("arguments[0].scrollIntoView();",driver.findElementByXPath("//table[contains(@class,'slds-table forceRecordLayout')]//td/following::span[contains(@class,'uiOutputDateTime')]["+i+"]"));
    	
    }
   System.out.println(initlist);
   Collections.sort(initlist);
   System.out.println(initlist);
   
   dblclick.perform();
   Thread.sleep(3000);
   
   List<Date> sortedlist = new ArrayList<Date>();
   for(int i=1;i<=tablecount;i++) {
	String dateAsText = driver.findElementByXPath("//table/tbody/tr["+i+"]/td[3]").getText();
   		Date convToDate = dateformater.parse(dateAsText);
   	sortedlist.add(convToDate);
   	Thread.sleep(5000);
   	exe3.executeScript("arguments[0].scrollIntoView();",driver.findElementByXPath("//table[contains(@class,'slds-table forceRecordLayout')]//td/following::span[contains(@class,'uiOutputDateTime')]["+i+"]"));
   	}
    System.out.println("Verified list is"+sortedlist);
    
    if(initlist.equals(sortedlist)) {
    	
    	System.out.println("Legal Entities displayed in ascending order by Last Modified Date");
    	
    	
    }else {
    	System.out.println("Sorry!!Legal Entities are not displayed in ascending order by Last Modified Date");
    }
    
    driver.close();
}
}
