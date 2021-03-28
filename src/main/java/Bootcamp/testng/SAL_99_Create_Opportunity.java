package Bootcamp.testng;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SAL_99_Create_Opportunity extends Base_class {
@Test
public void createOppurtunity() throws InterruptedException{
	Thread.sleep(9000);
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	WebElement s = driver.findElementByXPath("//div[@class='slds-icon-waffle']");
	executor.executeScript("arguments[0].click();",s);
	Thread.sleep(3000);

	driver.findElementByXPath("//button[@class='slds-button']").click();
	Thread.sleep(9000);
	WebElement path = driver.findElementByXPath("//p[text()='Sales']");
	executor.executeScript("arguments[0].click()",
			path);
	Thread.sleep(7000);
	WebElement scroll = driver.findElementByXPath("//span[@title='Key Deals - Recent Opportunities']");
	executor.executeScript("arguments[0].scrollIntoView()", scroll);
	scroll.click();
	Thread.sleep(4000);
	driver.findElementByXPath("//span[text()='View All Key Deals']").click();
	Thread.sleep(4000);
	
	driver.findElementByXPath("(//span[text()='Opportunities']/parent::a)/following-sibling::one-app-nav-bar-item-dropdown//one-app-nav-bar-menu-button").click();
	Thread.sleep(5000);
	
	WebElement click = driver.findElementByXPath("//span[text()='All Opportunities']");
	executor.executeScript("arguments[0].click();",click);
	Thread.sleep(4000);
	
	driver.findElementByXPath("//div[@title='New']").click();
	Thread.sleep(4000);
	
	WebElement opptext = driver.findElementByXPath("//input[@name='Name']");
	opptext.click();
	opptext.sendKeys("SRM Steels");	
	Thread.sleep(4000);
	String enteredtext = opptext.getAttribute("value");
	driver.findElementByXPath("(//label[text()='Type'])/parent::lightning-combobox//input").click();
	Thread.sleep(3000);
	driver.findElementByXPath("//span[@title='New Customer']").click();
	Thread.sleep(5000);
	WebElement crl = driver.findElementByXPath("(//label[text()='Lead Source']/parent::lightning-combobox)//lightning-base-combobox");
	executor.executeScript("arguments[0].scrollIntoView()",crl);
	
	Thread.sleep(5000);
	crl.click();
	Thread.sleep(5000);
	driver.findElementByXPath("//span[@title='Partner Referral']").click();
	Thread.sleep(5000);
	WebElement crlup = driver.findElementByXPath("//input[@name='Amount']");
	executor.executeScript("arguments[0].scrollIntoView()",crlup);
	Thread.sleep(1000);
	driver.findElementByXPath("//input[@name='Amount']").sendKeys("75000");
	Thread.sleep(3000);
	driver.findElementByXPath("//input[@name='CloseDate']").click();
	Thread.sleep(3000);
	driver.findElementByXPath("//button[@title='Next Month']").click();
	Thread.sleep(4000);
	driver.findElementByXPath("//span[text()='20']").click();
	Thread.sleep(4000);
	driver.findElementByXPath("//label[text()='Stage']/parent::lightning-combobox//div").click();
	Thread.sleep(4000);
	driver.findElementByXPath("//span[@title='Needs Analysis']").click();
	Thread.sleep(5000);
	driver.findElementByXPath("//label[text()='Primary Campaign Source']/parent::lightning-grouped-combobox//div").click();
	Thread.sleep(5000);
	driver.findElementByXPath("//span[text()='BootCamp by Karthik']").click();
	Thread.sleep(3000);
	driver.findElementByXPath("//button[text()='Save']").click();
	Thread.sleep(2000);
	WebElement verify = driver.findElementByXPath("//div[contains(@class,'hyphenate')]");
	String tobeverified = verify.getText();
	System.out.println(tobeverified);
	if(tobeverified.contains(enteredtext))
	{
		System.out.println("The entered text matches");
		
	}else
	{System.out.println("Entered text not matched");
	}
	
}
}
/*Login to https://login.salesforce.com
2. Click on the toggle menu button from the left corner
3. Click View All and click Sales from App Launcher
4. Click on the Content tab 
5. Click View All Key Deals in Key Deals 
6. Click the dropdown from Opportunities and select All Opportunities
7. Click on New
8. Give Opportunity Name as SRM Steels
9. Select Type as New Customer and Lead Source as Partner Referral
10. Give Amount as 75000 and Select Close Date as Next month 20th day 
11. Select Stage as Needs Analysis
12. Click in Primary Campaign  Source and Select the first option
13. Click Save and Verify the SRM Steels opportunity is created"
*/


